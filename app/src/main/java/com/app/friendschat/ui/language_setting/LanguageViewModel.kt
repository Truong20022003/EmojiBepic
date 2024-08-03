package com.app.friendschat.ui.language_setting

import android.content.Context
import android.content.res.Resources
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.friendschat.R
import com.app.friendschat.data.model.LanguageModel
import com.app.friendschat.ui.base.BaseViewModel
import java.util.Locale

class LanguageViewModel : BaseViewModel(){
    val languages = MutableLiveData<List<LanguageModel>>()
    val selectedLanguage = MutableLiveData<LanguageModel>()



    private val _langDevice = MutableLiveData<String>()
    val langDevice: LiveData<String>
        get() = _langDevice

    private val _codeLang = MutableLiveData<String>()
    val codeLang: LiveData<String>
        get() = _codeLang

    fun first(context: Context){

        var langDevice = "en"
        var codeLang = "en"

        var position = 0
        var isLangDefault = false
        val listLanguage = mutableListOf<LanguageModel>()

        listLanguage.add(LanguageModel("English", "en", false, R.drawable.flag_en))
        listLanguage.add(LanguageModel("Hindi", "hi", false, R.drawable.flag_hi))
        listLanguage.add(LanguageModel("Spanish", "es", false, R.drawable.flag_es))
        listLanguage.add(LanguageModel("French", "fr", false, R.drawable.flag_fr))
        listLanguage.add(LanguageModel("Portuguese", "pt", false, R.drawable.flag_pt))
        listLanguage.add(LanguageModel("Indonesian", "in", false, R.drawable.flag_in))
        listLanguage.add(LanguageModel("German", "de", false, R.drawable.flag_de))

        if (com.app.friendschat.rate.SharePrefUtils.language(context)) {
            val locale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Resources.getSystem().configuration.locales[0]
            } else {
                Resources.getSystem().configuration.locale
            }

            langDevice = locale.language

            for ((index, languageModel) in listLanguage.withIndex()) {
                if (languageModel.code.contains(langDevice.toLowerCase())) {
                    isLangDefault = true
                    position = index
                    break
                }
            }

            if (position > 0 && isLangDefault) {
                val languageModel = listLanguage[position]
                listLanguage.removeAt(position)
                listLanguage.add(0, languageModel)
            }


            var check = -1
            for (i in listLanguage.indices) {
                val languageModel = listLanguage[i]
                if (languageModel.code.contains(com.app.friendschat.utils.SystemUtil.getPreLanguage(context))) {
                    listLanguage[i].select = true
                    listLanguage.remove(languageModel)
                    listLanguage.add(0, languageModel)
                    check = i
                    break
                }
            }
            listLanguage[0].select = true
            codeLang = listLanguage[0].code
        } else {
            val locale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Resources.getSystem().configuration.locales[0]
            } else {
                Resources.getSystem().configuration.locale
            }

            langDevice = locale.language

            for ((index, languageModel) in listLanguage.withIndex()) {
                if (languageModel.code.contains(langDevice.toLowerCase())) {
                    isLangDefault = true
                    position = index
                    break
                }
            }

            if (position > 0 && isLangDefault) {
                val languageModel = listLanguage[position]
                listLanguage.removeAt(position)
                listLanguage.add(0, languageModel)
            }

            listLanguage[0].select = true
            codeLang = listLanguage[0].code

        }

        _langDevice.postValue(langDevice)
        _codeLang.postValue(codeLang)
        languages.postValue(listLanguage)
    }

    fun setSelectedLanguage(language: LanguageModel) {
        selectedLanguage.value = language
        _codeLang.postValue(language.code)
    }
}