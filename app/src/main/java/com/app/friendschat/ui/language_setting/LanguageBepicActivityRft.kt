package com.app.friendschat.ui.language_setting

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivityLanguageBepicRftBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.main.MainBepicActivityRft
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlin.reflect.KClass

class LanguageBepicActivityRft : BaseActivity<LanguageViewModel, ActivityLanguageBepicRftBinding>() {

    private var langDeviceBepic = "en"
    private var codeLangBepic = "en"
    private lateinit var languageAdapterBepic: LanguageAdapter

    override fun initView() {
        Log.e("vvvvvvvvvvvvvvvvvvvvv", "initView: ", )

        val linearLayoutManager = LinearLayoutManager(this)
        languageAdapterBepic =
            LanguageAdapter(this, mutableListOf(), onClickItem = { model, pos ->
                mViewModel.setSelectedLanguage(model)
            })
        binding.rvLanguage.layoutManager = linearLayoutManager
        binding.rvLanguage.adapter = languageAdapterBepic


        mViewModel.languages.observe(this) { list ->
            languageAdapterBepic.updateData(list)
        }

        mViewModel.langDevice.observe(this) { langDevice ->
            this.langDeviceBepic = langDevice
        }

        mViewModel.codeLang.observe(this) { codeLang ->
            this.codeLangBepic = codeLang
        }

        mViewModel.first(this)



        mViewModel.selectedLanguage.observe(this) { selectedLanguage ->
            languageAdapterBepic.setSelectedLanguage(selectedLanguage)
        }

        binding.tvSelect.tapAndCheckInternet {
            com.app.friendschat.utils.SystemUtil.saveLocale(baseContext, codeLangBepic)
            com.app.friendschat.rate.SharePrefUtils.language2(baseContext)
            showActivity(MainBepicActivityRft::class.java)
            finishAffinity()
        }

        binding.ivBack.tapAndCheckInternet {
            onBackPressed()
        }
    }

    override fun createViewModel(): Class<LanguageViewModel> =
        LanguageViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_language_bepic_rft

    override fun bindViewModel() {

    }

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {
    }

    override fun onBackPressed() {
        finish()
    }

}