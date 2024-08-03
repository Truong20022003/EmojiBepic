package com.app.friendschat.ui.main

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.app.friendschat.R
import com.app.friendschat.data.model.Action
import com.app.friendschat.databinding.ActivityMainBepicBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.home.HomeBepicFragment
import com.app.friendschat.ui.my_creation.MyCreationBepicFragment
import com.app.friendschat.ui.settings.SettingsBepicFragment
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.printLog
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.iv_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.iv_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.iv_setting
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.linear_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.linear_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.linear_setting
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.relay_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.relay_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.relay_setting
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.tv_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.tv_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main.view.tv_setting
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class MainBepicActivity : BaseActivity<MainViewModel, ActivityMainBepicBinding>(),
    NavController.OnDestinationChangedListener {
    private lateinit var currentFragmentBepic: BaseFragment<*, *>
    private val TAG = "MainActivity"

    private lateinit var navControllerBepic: NavController

    private var alertDialogBepic: AlertDialog? = null
    var actionEditDraftBepic: Action? = null

    // Color
    private var colorC9C9C9Bepic = 0
    private var colorCC0C0CBepic = 0

    // Image Resource
    @DrawableRes
    private var drawableTrackerTwoBepic: Int = 0

    @DrawableRes
    private var drawableSettingOneBepic: Int = 0

    @DrawableRes
    private var drawableSettingTwoBepic: Int = 0

    @DrawableRes
    private var drawableMeasureOneBepic: Int = 0

    @DrawableRes
    private var drawableMeasureTwoBepic: Int = 0

    @DrawableRes
    private var drawableTrackerOneBepic: Int = 0

    override fun initView() {
        try {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
            navControllerBepic = navHostFragment.navController


            //Permission
            alertDialogBepic = AlertDialog.Builder(this, R.style.AlertDialogCustom).create()
            alertDialogBepic?.setTitle(getString(R.string.Grant_Permission))
            alertDialogBepic?.setCancelable(false)
            alertDialogBepic?.setMessage(getString(R.string.Please_grant_all_permissions))
            alertDialogBepic?.setButton(
                -1, getString(R.string.Go_to_setting) as CharSequence
            ) { _, _ ->
//            AppOpenManager.getInstance().disableAppResume()
                alertDialogBepic?.dismiss()
                val intent =
                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", applicationContext.packageName, null)
                intent.data = uri
                startActivity(intent)
            }

            /* image resource */
            drawableMeasureOneBepic = R.drawable.ic_home_select
            drawableMeasureTwoBepic = R.drawable.ic_home_unselect
            drawableTrackerOneBepic = R.drawable.ic_my_creation_select
            drawableTrackerTwoBepic = R.drawable.ic_my_creation
            drawableSettingOneBepic = R.drawable.ic_settings_select
            drawableSettingTwoBepic = R.drawable.ic_settings

            /* color text */
            colorCC0C0CBepic = getColor(R.color.color_4E5BA6)
            colorC9C9C9Bepic = getColor(R.color.color_A3A3A3)

            /* int fragment */
            if (intent.getSerializableExtra(Constants.BUNDLE_SUCCESS_ACTION) != null) {
                actionEditDraftBepic =
                    intent.getSerializableExtra(Constants.BUNDLE_SUCCESS_ACTION) as Action
                if (actionEditDraftBepic == Action.EDIT_DRAFT || actionEditDraftBepic == Action.CREATE_FROM_MY_CREATION) {
                    showMyCreationFragmentBepic()
                }
            } else {
//                binding.tvTitle.visibility = View.GONE
            }
        } catch (e: Exception) {

        }
    }

    override fun createViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_main_bepic

    override fun bindViewModel() {
        /* Event bottom nav */
        navigateFragmentBepic()

        CoroutineScope(Dispatchers.Main).launch {
            mViewModel.createDraftPackageIfNotExist(this@MainBepicActivity)
            mViewModel.addDataIconModel(this@MainBepicActivity)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty()) {
            var count = 0
            if (requestCode == 1111 || requestCode == 1112) {
                for (element in grantResults) {
                    if (element == -1) {
                        count++
                    }
                }
                if (count > 0) {
                    Toast.makeText(
                        baseContext,
                        getString(R.string.Permission_is_denied),
                        Toast.LENGTH_SHORT
                    ).show()

                    alertDialogBepic?.setOnShowListener {
                        alertDialogBepic?.getButton(AlertDialog.BUTTON_POSITIVE)
                            ?.setTextColor(resources.getColor(R.color.black))
                    }
                    alertDialogBepic?.show()
                }
            }
        }
    }

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {
        currentFragmentBepic = fragment
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        printLog("$controller - $destination")
    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {
        val instanceFragment = when (fragment) {
            HomeBepicFragment::class -> HomeBepicFragment()
            MyCreationBepicFragment::class -> MyCreationBepicFragment()
            SettingsBepicFragment::class -> SettingsBepicFragment()
            else -> {
                throw Resources.NotFoundException("Fragment not fount, please check again")
            }
        }
        currentFragmentBepic = instanceFragment
        bundle?.let {
            instanceFragment.arguments = it
        }
        val ft = supportFragmentManager.beginTransaction()
        val tag = instanceFragment.TAG
        ft.replace(R.id.main_container, instanceFragment, tag)
        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.commit()
    }

    override fun onBackPressed() {
        finishAffinity()
    }

    private fun navigateFragmentBepic() {
        binding.bottomNavMain.linear_home.tapAndCheckInternet {
            showHomeFragmentBepic()
        }
        binding.bottomNavMain.linear_my_creation.tapAndCheckInternet {
            showMyCreationFragmentBepic()
            EventTracking.logEvent(this, EventTracking.EVENT_NAME_HOME_CREATION_CLICK)
        }
        binding.bottomNavMain.linear_setting.tapAndCheckInternet {
            showSettingsFragmentBepic()
            EventTracking.logEvent(this, EventTracking.EVENT_NAME_HOME_SETTING_CLICK)
        }
    }

    /* change color text bottom nav */
    private fun changeTextColorWhenTapBepic(color1: Int, color2: Int, color4: Int) {
        binding.bottomNavMain.tv_home.setTextColor(color1)
        binding.bottomNavMain.tv_my_creation.setTextColor(color2)
        binding.bottomNavMain.tv_setting.setTextColor(color4)
    }

    /* change background bottom nav */
    private fun changeBackgroundWhenTap(
        bg1: Drawable,
        bg2: Drawable,
        bg4: Drawable
    ) {
        binding.bottomNavMain.relay_home.background = bg1
        binding.bottomNavMain.relay_my_creation.background = bg2
        binding.bottomNavMain.relay_setting.background = bg4
    }

    /* change image bottom nav */
    private fun changeImageIconWhenTapBepic(
        @DrawableRes image1: Int,
        @DrawableRes image2: Int,
        @DrawableRes image4: Int
    ) {
        binding.bottomNavMain.iv_home.setImageResource(image1)
        binding.bottomNavMain.iv_my_creation.setImageResource(image2)
        binding.bottomNavMain.iv_setting.setImageResource(image4)
    }

    private fun showHomeFragmentBepic() {
        changeImageIconWhenTapBepic(
            drawableMeasureOneBepic,
            drawableTrackerTwoBepic,
            drawableSettingTwoBepic
        )

        changeTextColorWhenTapBepic(colorCC0C0CBepic, colorC9C9C9Bepic, colorC9C9C9Bepic)

        if (navControllerBepic.currentDestination?.id == R.id.homeFragment) {

        } else {
            navControllerBepic.navigate(R.id.homeFragment)
//            binding.tvTitle.visibility = View.GONE
        }
    }

    private fun showMyCreationFragmentBepic() {
        changeImageIconWhenTapBepic(
            drawableMeasureTwoBepic,
            drawableTrackerOneBepic,
            drawableSettingTwoBepic
        )

        changeTextColorWhenTapBepic(colorC9C9C9Bepic, colorCC0C0CBepic, colorC9C9C9Bepic)
        if (navControllerBepic.currentDestination?.id == R.id.myCreationFragment) {

        } else {
            navControllerBepic.navigate(R.id.myCreationFragment)
//            binding.tvTitle.text = getString(R.string.my_creation_nav_header_title)
        }
    }

    private fun showSettingsFragmentBepic() {
        changeImageIconWhenTapBepic(
            drawableMeasureTwoBepic,
            drawableTrackerTwoBepic,
            drawableSettingOneBepic
        )

        changeTextColorWhenTapBepic(colorC9C9C9Bepic, colorC9C9C9Bepic, colorCC0C0CBepic)

        if (navControllerBepic.currentDestination?.id == R.id.settingsFragment) {

        } else {
            navControllerBepic.navigate(R.id.settingsFragment)
//            binding.tvTitle.text = getString(R.string.settings_nav_header_title)
        }
    }

}