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
import com.app.friendschat.databinding.ActivityMainBepicRftBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.home.HomeBepicFragmentRft
import com.app.friendschat.ui.my_creation.MyCreationBepicFragmentRft
import com.app.friendschat.ui.settings.SettingsBepicFragmentRft
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.printLog
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.iv_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.iv_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.iv_setting
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.linear_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.linear_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.linear_setting
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.relay_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.relay_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.relay_setting
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.tv_home
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.tv_my_creation
import kotlinx.android.synthetic.main.layout_bottom_nav_main_rft.view.tv_setting

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class MainBepicActivityRft : BaseActivity<MainViewModel, ActivityMainBepicRftBinding>(),
    NavController.OnDestinationChangedListener {
    private lateinit var currentFragmentBepicRft: BaseFragment<*, *>
    private val TAG = "MainActivity"

    private lateinit var navControllerBepicRft: NavController

    private var alertDialogBepicRft: AlertDialog? = null
    var actionEditDraftBepicRft: Action? = null

    // Color
    private var colorC9C9C9BepicRft = 0
    private var colorCC0C0CBepicRft = 0

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
            navControllerBepicRft = navHostFragment.navController


            //Permission
            alertDialogBepicRft = AlertDialog.Builder(this, R.style.AlertDialogCustom).create()
            alertDialogBepicRft?.setTitle(getString(R.string.Grant_Permission))
            alertDialogBepicRft?.setCancelable(false)
            alertDialogBepicRft?.setMessage(getString(R.string.Please_grant_all_permissions))
            alertDialogBepicRft?.setButton(
                -1, getString(R.string.Go_to_setting) as CharSequence
            ) { _, _ ->
//            AppOpenManager.getInstance().disableAppResume()
                alertDialogBepicRft?.dismiss()
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
            colorCC0C0CBepicRft = getColor(R.color.color_4E5BA6)
            colorC9C9C9BepicRft = getColor(R.color.color_A3A3A3)

            /* int fragment */
            if (intent.getSerializableExtra(Constants.BUNDLE_SUCCESS_ACTION) != null) {
                actionEditDraftBepicRft =
                    intent.getSerializableExtra(Constants.BUNDLE_SUCCESS_ACTION) as Action
                if (actionEditDraftBepicRft == Action.EDIT_DRAFT || actionEditDraftBepicRft == Action.CREATE_FROM_MY_CREATION) {
                    showMyCreationFragmentBepicRft()
                }
            } else {
//                binding.tvTitle.visibility = View.GONE
            }
        } catch (e: Exception) {

        }
    }

    override fun createViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_main_bepic_rft

    override fun bindViewModel() {
        /* Event bottom nav */
        navigateFragmentBepicRft()

        CoroutineScope(Dispatchers.Main).launch {
            mViewModel.createDraftPackageIfNotExist(this@MainBepicActivityRft)
            mViewModel.addDataIconModel(this@MainBepicActivityRft)
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

                    alertDialogBepicRft?.setOnShowListener {
                        alertDialogBepicRft?.getButton(AlertDialog.BUTTON_POSITIVE)
                            ?.setTextColor(resources.getColor(R.color.black))
                    }
                    alertDialogBepicRft?.show()
                }
            }
        }
    }

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {
        currentFragmentBepicRft = fragment
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
            HomeBepicFragmentRft::class -> HomeBepicFragmentRft()
            MyCreationBepicFragmentRft::class -> MyCreationBepicFragmentRft()
            SettingsBepicFragmentRft::class -> SettingsBepicFragmentRft()
            else -> {
                throw Resources.NotFoundException("Fragment not fount, please check again")
            }
        }
        currentFragmentBepicRft = instanceFragment
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
    private fun showSettingsFragmentBepicRft() {
        changeImageIconWhenTapBepicRft(
            drawableMeasureTwoBepic,
            drawableTrackerTwoBepic,
            drawableSettingOneBepic
        )

        changeTextColorWhenTapBepicRft(colorC9C9C9BepicRft, colorC9C9C9BepicRft, colorCC0C0CBepicRft)

        if (navControllerBepicRft.currentDestination?.id == R.id.settingsFragment) {

        } else {
            navControllerBepicRft.navigate(R.id.settingsFragment)
//            binding.tvTitle.text = getString(R.string.settings_nav_header_title)
        }
    }

    private fun showHomeFragmentBepicRft() {
        changeImageIconWhenTapBepicRft(
            drawableMeasureOneBepic,
            drawableTrackerTwoBepic,
            drawableSettingTwoBepic
        )

        changeTextColorWhenTapBepicRft(colorCC0C0CBepicRft, colorC9C9C9BepicRft, colorC9C9C9BepicRft)

        if (navControllerBepicRft.currentDestination?.id == R.id.homeFragment) {

        } else {
            navControllerBepicRft.navigate(R.id.homeFragment)
//            binding.tvTitle.visibility = View.GONE
        }
    }
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
    private fun changeImageIconWhenTapBepicRft(
        @DrawableRes image1: Int,
        @DrawableRes image2: Int,
        @DrawableRes image4: Int
    ) {
        binding.bottomNavMain.iv_home.setImageResource(image1)
        binding.bottomNavMain.iv_my_creation.setImageResource(image2)
        binding.bottomNavMain.iv_setting.setImageResource(image4)
    }




    private fun navigateFragmentBepicRft() {
        binding.bottomNavMain.linear_home.tapAndCheckInternet {
            showHomeFragmentBepicRft()
        }
        binding.bottomNavMain.linear_my_creation.tapAndCheckInternet {
            showMyCreationFragmentBepicRft()
            EventTracking.logEvent(this, EventTracking.EVENT_NAME_HOME_CREATION_CLICK)
        }
        binding.bottomNavMain.linear_setting.tapAndCheckInternet {
            showSettingsFragmentBepicRft()
            EventTracking.logEvent(this, EventTracking.EVENT_NAME_HOME_SETTING_CLICK)
        }
    }


    /* change color text bottom nav */
    private fun changeTextColorWhenTapBepicRft(color1: Int, color2: Int, color4: Int) {
        binding.bottomNavMain.tv_home.setTextColor(color1)
        binding.bottomNavMain.tv_my_creation.setTextColor(color2)
        binding.bottomNavMain.tv_setting.setTextColor(color4)
    }

    private fun showMyCreationFragmentBepicRft() {
        changeImageIconWhenTapBepicRft(
            drawableMeasureTwoBepic,
            drawableTrackerOneBepic,
            drawableSettingTwoBepic
        )

        changeTextColorWhenTapBepicRft(colorC9C9C9BepicRft, colorCC0C0CBepicRft, colorC9C9C9BepicRft)
        if (navControllerBepicRft.currentDestination?.id == R.id.myCreationFragment) {

        } else {
            navControllerBepicRft.navigate(R.id.myCreationFragment)
//            binding.tvTitle.text = getString(R.string.my_creation_nav_header_title)
        }
    }

}