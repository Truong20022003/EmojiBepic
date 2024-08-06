package com.app.friendschat.ui.language_start

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivityLanguageStartBepicRftBinding
import com.app.friendschat.rate.SharePrefUtils
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.intro.IntroBepicActivityRft
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.SystemUtil
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlin.reflect.KClass

class LanguageStartBepicActivityRft : BaseActivity<LanguageStartViewModel, ActivityLanguageStartBepicRftBinding>() {

    private lateinit var languageStartAdapterBepicRft: LanguageStartAdapter

    private var codeLangBepicRft = "en"
    private var langDeviceBepicRft = "en"

    override fun initView() {

        EventTracking.logEvent(this, EventTracking.EVENT_NAME_LANGUAGE_FO_OPEN)

        val linearLayoutManager = LinearLayoutManager(this)
        languageStartAdapterBepicRft =
            LanguageStartAdapter(this, mutableListOf(), onClickItem = { model, pos ->
                mViewModel.setSelectedLanguage(model)

                EventTracking.logEvent(this, EventTracking.EVENT_NAME_LANGUAGE_FO_SAVE_CLICK)
            })
        binding.rvLanguage.layoutManager = linearLayoutManager
        binding.rvLanguage.adapter = languageStartAdapterBepicRft


        mViewModel.languages.observe(this) { list ->
            languageStartAdapterBepicRft.updateData(list)
        }

        mViewModel.langDevice.observe(this) { langDevice ->
            this.langDeviceBepicRft = langDevice
        }

        mViewModel.codeLang.observe(this) { codeLang ->
            this.codeLangBepicRft = codeLang
        }

        mViewModel.first(this)



        mViewModel.selectedLanguage.observe(this) { selectedLanguage ->
            languageStartAdapterBepicRft.setSelectedLanguage(selectedLanguage)
        }

        binding.tvSelect.tapAndCheckInternet {
            SystemUtil.saveLocale(baseContext, codeLangBepicRft)
            SharePrefUtils.language2(baseContext)
            showActivity(IntroBepicActivityRft::class.java)
            finishAffinity()
        }
    }

    override fun createViewModel(): Class<LanguageStartViewModel> =
        LanguageStartViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_language_start_bepic_rft

    override fun bindViewModel() {

    }

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}