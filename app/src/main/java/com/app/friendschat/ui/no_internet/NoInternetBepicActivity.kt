package com.app.friendschat.ui.no_internet

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivityNoInternetBepicBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.splash.SplashBepicActivity
import com.app.friendschat.utils.CheckInternet
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import kotlin.reflect.KClass

class NoInternetBepicActivity: BaseActivity<NoInternetViewModel, ActivityNoInternetBepicBinding>() {
    private var strNoInterNetBepic = ""

    override fun initView() {

        if (intent.getStringExtra(Constants.BUNDLE_SPLASH_NO_INTERNET) != null){
            strNoInterNetBepic = intent.getStringExtra(Constants.BUNDLE_SPLASH_NO_INTERNET)!!
        }

        EventTracking.logEvent(this, EventTracking.EVENT_NAME_NO_INTERNET_VIEW)

        binding.rlTryAgain.setOnClickListener {
            if (CheckInternet.haveNetworkConnection(this)) {
                finish()
                overridePendingTransition(0, 0)
            } else {
                navigateToWifiSettingBepic()
            }
        }
    }

    override fun getContentView(): Int = R.layout.activity_no_internet_bepic

    override fun onResume() {
        super.onResume()
        if (CheckInternet.haveNetworkConnection(this)) {
            if (strNoInterNetBepic != ""){
                val intent = Intent(this, SplashBepicActivity::class.java)
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

    override fun onBackPressed() {

    }

    private fun navigateToWifiSettingBepic() {
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        startActivity(intent)
    }

}