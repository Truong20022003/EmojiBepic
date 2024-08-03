package com.app.friendschat.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.friendschat.data.scheduler.ISchedulerProvider
import com.app.friendschat.ui.emoji.EmojiViewModel
import com.app.friendschat.ui.emoji_edit.EditEmojiViewModel
import com.app.friendschat.ui.home.HomeViewModel
import com.app.friendschat.ui.intro.IntroViewModel
import com.app.friendschat.ui.language_setting.LanguageViewModel
import com.app.friendschat.ui.language_start.LanguageStartViewModel
import com.app.friendschat.ui.main.MainViewModel
import com.app.friendschat.ui.my_creation.MyCreationViewModel
import com.app.friendschat.ui.my_creation.created_draft_fragment.CreatedDraftViewModel
import com.app.friendschat.ui.my_creation.created_package_fragment.CreatedPackageViewModel
import com.app.friendschat.ui.no_internet.NoInternetViewModel
import com.app.friendschat.ui.policy.PolicyViewModel
import com.app.friendschat.ui.settings.SettingsViewModel
import com.app.friendschat.ui.splash.SplashViewModel
import com.app.friendschat.ui.sticker_pack_detail.StickerPackDetailViewModel
import com.app.friendschat.ui.success.SuccessViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val mScheduler: ISchedulerProvider,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel() as T
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel() as T
            modelClass.isAssignableFrom(LanguageStartViewModel::class.java) -> LanguageStartViewModel() as T
            modelClass.isAssignableFrom(LanguageViewModel::class.java) -> LanguageViewModel() as T
            modelClass.isAssignableFrom(IntroViewModel::class.java) -> IntroViewModel() as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel() as T
            modelClass.isAssignableFrom(MyCreationViewModel::class.java) -> MyCreationViewModel() as T
            modelClass.isAssignableFrom(SettingsViewModel::class.java) -> SettingsViewModel() as T
            modelClass.isAssignableFrom(EmojiViewModel::class.java) -> EmojiViewModel() as T
            modelClass.isAssignableFrom(StickerPackDetailViewModel::class.java) -> StickerPackDetailViewModel() as T
            modelClass.isAssignableFrom(SuccessViewModel::class.java) -> SuccessViewModel() as T
            modelClass.isAssignableFrom(CreatedPackageViewModel::class.java) -> CreatedPackageViewModel() as T
            modelClass.isAssignableFrom(CreatedDraftViewModel::class.java) -> CreatedDraftViewModel() as T
            modelClass.isAssignableFrom(EditEmojiViewModel::class.java) -> EditEmojiViewModel() as T
            modelClass.isAssignableFrom(NoInternetViewModel::class.java) -> NoInternetViewModel() as T
            modelClass.isAssignableFrom(PolicyViewModel::class.java) -> PolicyViewModel() as T
            modelClass.isAssignableFrom(EmptyViewModel::class.java) -> EmptyViewModel() as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
        if (viewModel is BaseViewModel) {
            viewModel.initData(mScheduler)
        }
        return viewModel
    }
}