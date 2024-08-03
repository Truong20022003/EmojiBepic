package com.app.friendschat.ui.policy

import android.os.Bundle
import android.webkit.WebSettings
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivityPolicyBepicRftBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.utils.Constants
import kotlin.reflect.KClass

class PolicyBepicActivityRft : BaseActivity<PolicyViewModel, ActivityPolicyBepicRftBinding>() {

    override fun initView() {
        val webSettingBepic: WebSettings = binding.viewPolicy.settings
        webSettingBepic.javaScriptEnabled = true

        binding.viewPolicy.loadUrl(Constants.PRIVACY_POLICY)
    }

    override fun createViewModel(): Class<PolicyViewModel> = PolicyViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_policy_bepic_rft

    override fun bindViewModel() {

    }

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }
}