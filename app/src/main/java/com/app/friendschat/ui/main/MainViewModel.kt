package com.app.friendschat.ui.main

import androidx.lifecycle.MutableLiveData
import com.app.friendschat.data.model.EmojiModel
import com.app.friendschat.data.model.PackageModel
import com.app.friendschat.data.model.RepoModel
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.database.EmojiDao
import com.app.friendschat.database.PackageDao
import com.app.friendschat.ui.base.BaseViewModel
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.widget.addDataIconToDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel : BaseViewModel() {
    val listRepo = MutableLiveData<MutableList<RepoModel>>(mutableListOf())

    private var packageDao: PackageDao? = null
    private var emojiDao: EmojiDao? = null
    suspend fun createDraftPackageIfNotExist(activity: MainBepicActivity) = withContext(Dispatchers.IO) {
        // create draft package if it is not exist
        packageDao = AppDatabase.getInstance(activity)?.packageNameDao()
        if (packageDao?.isDraftExisted() == false) {
            packageDao?.insertPackage(
                PackageModel(
                    packageName = "Draft",
                    stickers = mutableListOf(),
                    isDraft = true
                )
            )
        }
    }

    suspend fun addDataIconModel(activity: MainBepicActivity) = withContext(Dispatchers.IO){
        emojiDao = AppDatabase.getInstance(activity)?.emojiDao()
        if (emojiDao?.isEmojiExisted() == false) {
            addDataIconToDataBase(activity, Constants.FACE, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.EYES, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.BROW, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.MOUTH, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.HAND, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.NOSE, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.BEARD, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.HAT, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(activity, Constants.GLASS, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })

            addDataIconToDataBase(
                activity,
                Constants.ACCESSORIES,
                action = { pos,folderName, nameIcon ->
                    emojiDao?.insertEmoji(
                        EmojiModel(
                            "file:///android_asset/$folderName/$nameIcon",
                            folderName,
                            pos
                        )
                    )
                })

            addDataIconToDataBase(activity, Constants.HAIR, action = { pos,folderName, nameIcon ->
                emojiDao?.insertEmoji(
                    EmojiModel(
                        "file:///android_asset/$folderName/$nameIcon",
                        folderName,
                        pos
                    )
                )
            })
        }
    }
}