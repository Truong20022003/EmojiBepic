package com.app.friendschat.ui.base

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import com.app.friendschat.App
import com.app.friendschat.R
import com.app.friendschat.data.scheduler.ISchedulerProvider
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.DataStorePreferences
import com.app.friendschat.utils.printLog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject


abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> :
    AppCompatActivity(), Navigators {

    private var isBannerLoaded = false
    private var shouldHideNative = false

    private val requestCodes = mutableListOf<Int>().apply {
        add(Constants.REQUEST_CODE_NEW_ACTIVITY)
    }

    private var nativeRemoteConfig: String? = null

    @Inject
    lateinit var factory: ViewModelFactory

    @Inject
    lateinit var schedulerProvider: ISchedulerProvider

    lateinit var dataStore: DataStorePreferences

    fun inject(
        factory: ViewModelFactory,
        schedulerProvider: ISchedulerProvider
    ) {
        this.factory = factory
        this.schedulerProvider = schedulerProvider
    }

    private val mDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    abstract fun createViewModel(): Class<VM>
    abstract fun getContentView(): Int
    abstract fun initView()
    abstract fun bindViewModel()

    lateinit var mViewModel: VM
    lateinit var binding: DB

    private val mProgressDialog: ProgressDialog by lazy {
        ProgressDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as? App)?.requestInject(this)
        // set status bar
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            val window = window
//            if (window != null) {
//                @SuppressLint("UseCompatLoadingForDrawables") val background: Drawable =
//                    resources.getDrawable(R.drawable.bg_status_bar)
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                window.statusBarColor = resources.getColor(android.R.color.transparent)
//                window.setBackgroundDrawable(background)
//            }
//        }
        super.onCreate(savedInstanceState)
        fullScreen(window)
        com.app.friendschat.utils.SystemUtil.setLocale(this)
        binding = DataBindingUtil.setContentView(this, getContentView())
        mViewModel = ViewModelProviders.of(this, factory).get(createViewModel())
        binding.setVariable(BR.viewModel, mViewModel)
        dataStore = DataStorePreferences(this)
        initView()
        bindViewModel()

        val flags =
            (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.decorView.systemUiVisibility = flags

        // padding bottom with the value of status bar
        binding.root.setPadding(
            binding.root.paddingLeft,
            binding.root.paddingTop + getStatusBarHeight(),
            binding.root.paddingRight,
            binding.root.paddingBottom
        )

        // set status bar light
        val controller = WindowCompat.getInsetsController(window, window.decorView)
        controller.isAppearanceLightStatusBars = true

        Log.d("CHECK_ACTIVITY", "onCreate: " + javaClass.simpleName)
    }

    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility =
                (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }

    private fun trackingProgress() {
        mViewModel.progressBar
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe {
                if (it) {
                    showLoading()
                } else {
                    hideLoading()
                }
            }.addDisposable()
    }

    private fun showLoading() {
        if (!mProgressDialog.isShowing && !isFinishing) {
            printLog("showLoading")
            mProgressDialog.show()
        }
    }

    private fun hideLoading() {
        if (mProgressDialog.isShowing && !isFinishing) {
            printLog("hideProgress")
            mProgressDialog.dismiss()
        }
    }

    override fun showActivity(activity: Class<*>, bundle: Bundle?) {
        val intent = Intent(this, activity)
        intent.putExtras(bundle ?: Bundle())
        startActivityWithDefaultRequestCode(intent)
    }

    override fun showActivityWithResultCode(activity: Class<*>, requestCode: Int, bundle: Bundle?) {

        addRequestCodeIfNotExist(requestCode)

        val intent = Intent(this, activity)
        intent.putExtras(bundle ?: Bundle())
        startActivityForResult(intent, requestCode)
    }

    override fun fragmentRequestInject(fragment: BaseFragment<*, *>) {
        fragment.inject(factory, schedulerProvider)
    }

    private fun Disposable.addDisposable() {
        mDisposable.add(this)
    }

    class ProgressDialog constructor(context: Context) : Dialog(context) {
        init {
            setCancelable(false)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.progress_circle)
            val window = window
            if (window != null) {
                getWindow()!!.setBackgroundDrawableResource(android.R.color.transparent)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        try {
            val nativeContainer = findViewById<View>(R.id.native_ad_view)
            if (nativeContainer != null && shouldHideNative) {
                nativeContainer.visibility = View.GONE
            }
        }catch (e: Exception){}

//        if (checkUMP() && SharePrefRemote.get_config(this, SharePrefRemote.appopen_resume)) {
//            AppOpenManager.getInstance().enableAppResumeWithActivity(javaClass)
//        } else {
//            AppOpenManager.getInstance().disableAppResumeWithActivity(javaClass)
//        }
    }

    fun addRequestCodeIfNotExist(requestCode: Int) {
        if (!requestCodes.contains(requestCode)) {
            requestCodes.add(requestCode)
        }
    }

    open fun startActivityWithDefaultRequestCode(intent: Intent?) {
        startActivityForResult(intent!!, Constants.REQUEST_CODE_NEW_ACTIVITY)
    }

    override fun onStart() {
        super.onStart()

    }

//    open fun checkUMP(): Boolean {
//        return AdsConsentManager.getConsentResult(this)
//    }

    fun handleReloadAdsByActivityResult(requestCode: Int) {


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        handleReloadAdsByActivityResult(requestCode)
    }


    private fun fullScreen(window: Window) {
        val windowInsetsController: WindowInsetsControllerCompat? =
            if (Build.VERSION.SDK_INT >= 30) {
                ViewCompat.getWindowInsetsController(window.decorView)
            } else {
                WindowInsetsControllerCompat(window, getWindow().decorView.rootView)
            }
        if (windowInsetsController == null) {
            return
        }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
        windowInsetsController.hide(WindowInsetsCompat.Type.systemGestures())
    }
}