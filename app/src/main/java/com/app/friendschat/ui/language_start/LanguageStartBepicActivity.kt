package com.app.friendschat.ui.language_start

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivityLanguageStartBepicBinding
import com.app.friendschat.rate.SharePrefUtils
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.intro.IntroBepicActivity
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.SystemUtil
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlin.reflect.KClass

class LanguageStartBepicActivity : BaseActivity<LanguageStartViewModel, ActivityLanguageStartBepicBinding>() {

    private lateinit var languageStartAdapterBepic: LanguageStartAdapter

    private var codeLangBepic = "en"
    private var langDeviceBepic = "en"

    override fun initView() {

        EventTracking.logEvent(this, EventTracking.EVENT_NAME_LANGUAGE_FO_OPEN)

        val linearLayoutManager = LinearLayoutManager(this)
        languageStartAdapterBepic =
            LanguageStartAdapter(this, mutableListOf(), onClickItem = { model, pos ->
                mViewModel.setSelectedLanguage(model)

                EventTracking.logEvent(this, EventTracking.EVENT_NAME_LANGUAGE_FO_SAVE_CLICK)
            })
        binding.rvLanguage.layoutManager = linearLayoutManager
        binding.rvLanguage.adapter = languageStartAdapterBepic


        mViewModel.languages.observe(this) { list ->
            languageStartAdapterBepic.updateData(list)
        }

        mViewModel.langDevice.observe(this) { langDevice ->
            this.langDeviceBepic = langDevice
        }

        mViewModel.codeLang.observe(this) { codeLang ->
            this.codeLangBepic = codeLang
        }

        mViewModel.first(this)



        mViewModel.selectedLanguage.observe(this) { selectedLanguage ->
            languageStartAdapterBepic.setSelectedLanguage(selectedLanguage)
        }

        binding.tvSelect.tapAndCheckInternet {
            SystemUtil.saveLocale(baseContext, codeLangBepic)
            SharePrefUtils.language2(baseContext)
            showActivity(IntroBepicActivity::class.java)
            finishAffinity()
        }
    }

    override fun createViewModel(): Class<LanguageStartViewModel> =
        LanguageStartViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_language_start_bepic

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