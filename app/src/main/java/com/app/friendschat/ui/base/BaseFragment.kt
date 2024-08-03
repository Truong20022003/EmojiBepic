package com.app.friendschat.ui.base

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.friendschat.R
import com.app.friendschat.data.scheduler.ISchedulerProvider
import com.app.friendschat.utils.printLog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> :
    Fragment(), IFragmentCallback {
    var TAG = "BaseFragment"

    @Inject
    lateinit var factory: ViewModelFactory

    @Inject
    lateinit var schedule: ISchedulerProvider
    private val disposable = CompositeDisposable()

    private lateinit var activity: Activity
    private lateinit var navigators: Navigators
    lateinit var viewModel: VM
    lateinit var binding: DB


    private val mProgressDialog: ProgressDialog by lazy {
        ProgressDialog(activity)
    }

    fun inject(
        factory: ViewModelFactory,
        schedule: ISchedulerProvider,
    ) {
        this.factory = factory
        this.schedule = schedule
    }

    private var mIsAttached: Boolean = false

    override fun getContext(): Context {
        return activity
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        TAG = javaClass.simpleName
        printLog("onAttach")
        mIsAttached = true
        if (context is Navigators) {
            context.fragmentRequestInject(this)
            activity = context as Activity
            navigators = context
            viewModel = ViewModelProvider(this, factory).get(createViewModel())
            viewModel.fragmentCallback = this
            viewModel.navigation = navigators
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        printLog("onCreateView")
        return onCreateViewInternal(inflater, container)
    }

    var isFirst = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printLog("onViewCreated")
        setupUI(view)
        navigators.fragmentRequestInject(this)
        initView()
        bindViewModel()
        trackingProgress()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupUI(view: View) {
        if (view !is EditText) {
            view.setOnTouchListener { _, _ ->
                hideSoftKeyboard()
                false
            }
        }
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                setupUI(innerView)
            }
        }
    }

    private fun hideSoftKeyboard() {
        activity.currentFocus?.let {
            val inputMethodManager =
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    private fun trackingProgress() {
        viewModel.progressBar
            .subscribeOn(schedule.io)
            .observeOn(schedule.ui)
            .subscribe {
                printLog("trackingProgress $it")
                if (it) {
                    showLoading()
                } else {
                    hideLoading()
                }
            }.addDisposable()
    }

    private fun onCreateViewInternal(inflater: LayoutInflater, container: ViewGroup?): View? {
        var rootView: View? = null
        val resId = getResourceLayout()
        if (resId > 0) {
            binding = DataBindingUtil.inflate(
                inflater,
                getResourceLayout(),
                container,
                false
            )
            binding.setVariable(BR.viewModel, viewModel)
            rootView = binding.root
        }

        return rootView
    }

    abstract fun createViewModel(): Class<VM>

    abstract fun getResourceLayout(): Int
    abstract fun initView()
    abstract fun bindViewModel()

    open fun isShowToolbar(): Boolean {
        return true
    }

    open fun isShowBack(): Boolean {
        return true
    }

    override fun showLoading() {
        if (!mProgressDialog.isShowing && userVisibleHint) {
            mProgressDialog.show()
        }

    }

    override fun hideLoading() {
        if (mProgressDialog.isShowing && !isDetached) {
            mProgressDialog.dismiss()
        }
    }

    override fun showActivity(act: Class<*>, bundle: Bundle?) {
        (requireActivity() as BaseActivity<*, *>).showActivity(act, bundle)
    }

    override fun showActivityWithResultCode(act: Class<*>, requestCode: Int, bundle: Bundle?) {
        (requireActivity() as BaseActivity<*, *>).addRequestCodeIfNotExist(requestCode)
        val intent = Intent(requireActivity(), act)
        bundle?.let {
            intent.putExtras(it)
        }
        startActivityForResult(intent, requestCode)
    }

    open fun showActionBar(): Boolean {
        return true
    }

    open fun onNavigationUp() {
    }

    fun replaceFragment(
        fragmentId: KClass<*>,
        bundle: Bundle? = null,
        addToBackStack: Boolean = true
    ) {
        navigators.switchFragment(fragmentId, bundle, addToBackStack)
    }


    class ProgressDialog constructor(context: Context) : Dialog(context) {
        init {
            setCancelable(false)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.progress_circle_rft)
            val window = window
            if (window != null) {
                getWindow()!!.setBackgroundDrawableResource(android.R.color.transparent)
            }
        }
    }

    private fun Disposable.addDisposable() {
        disposable.add(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.onDestroyView()
        disposable.clear()

    }

    override fun onDetach() {
        super.onDetach()
        mIsAttached = false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        (requireActivity() as BaseActivity<*, *>).handleReloadAdsByActivityResult(requestCode)
    }
}