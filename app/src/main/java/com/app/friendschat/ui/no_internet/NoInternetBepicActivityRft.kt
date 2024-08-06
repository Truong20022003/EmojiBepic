package com.app.friendschat.ui.no_internet

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivityNoInternetBepicRftBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.splash.SplashBepicActivityRft
import com.app.friendschat.utils.CheckInternet
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import kotlin.reflect.KClass

class NoInternetBepicActivityRft: BaseActivity<NoInternetViewModel, ActivityNoInternetBepicRftBinding>() {
    private var strNoInterNetBepicRft = ""

    override fun initView() {

        if (intent.getStringExtra(Constants.BUNDLE_SPLASH_NO_INTERNET) != null){
            strNoInterNetBepicRft = intent.getStringExtra(Constants.BUNDLE_SPLASH_NO_INTERNET)!!
        }

        EventTracking.logEvent(this, EventTracking.EVENT_NAME_NO_INTERNET_VIEW)

        binding.rlTryAgain.setOnClickListener {
            if (CheckInternet.haveNetworkConnection(this)) {
                finish()
                overridePendingTransition(0, 0)
            } else {
                navigateToWifiSettingBepicRft()
            }
        }
    }

    override fun getContentView(): Int = R.layout.activity_no_internet_bepic_rft

    override fun onResume() {
        super.onResume()
        if (CheckInternet.haveNetworkConnection(this)) {
            if (strNoInterNetBepicRft != ""){
                val intent = Intent(this, SplashBepicActivityRft::class.java)
                startActivity(intent)
                finish()
                overridePendingTransition(0, 0)
            }else {
                finish()
                overridePendingTransition(0, 0)
            }
        }
    }

    override fun createViewModel(): Class<NoInternetViewModel> = NoInternetViewModel::class.java

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun bindViewModel() {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }
    private fun navigateToWifiSettingBepicRft() {
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        startActivity(intent)
    }
    override fun onBackPressed() {

    }



}