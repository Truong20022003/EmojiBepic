package com.app.friendschat.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.app.friendschat.data.model.PackageModel
import com.app.friendschat.data.model.StickerModel

@Dao
interface PackageDao {
    @Insert
    suspend fun insertPackage(packageName: PackageModel)

    @Query("SELECT COUNT(*) FROM PackageModel WHERE package_name = :packageName")
    suspend fun isPackageNameExisted(packageName: String): Boolean

    suspend fun isDraftExisted(): Boolean {
        return getAllDrafts().isNotEmpty()
    }

    @Update
    suspend fun updatePackage(packageModel: PackageModel)

    @Delete
    suspend fun deletePackage(packageModel: PackageModel)

    @Query("SELECT * FROM PackageModel")
    suspend fun getAllPackages(): List<PackageModel>

    suspend fun getAllPackagesWithoutDraft(): List<PackageModel> {
        return getAllPackages().filter { !it.isDraft }
    }

    @Query("SELECT * FROM PackageModel WHERE is_draft = 1")
    suspend fun getAllDrafts(): List<PackageModel>

    @Query("UPDATE PackageModel SET sticker_urls = :stickers WHERE id = :packageId")
    suspend fun updateStickerList(packageId: Int, stickers: List<StickerModel>)

    @Query("SELECT * FROM PackageModel WHERE id = :packageId")
    suspend fun getPackageById(packageId: Int): PackageModel?

    suspend fun getPackageByName(packageName: String): PackageModel? {
        return getAllPackages().find { it.packageName == packageName }
    }

    suspend fun deletePackageByName(packageName: String) {
        val packageModel = getPackageByName(packageName)
        packageModel?.let {
            deletePackage(it)
        }
    }

    suspend fun getDraftPackage(): PackageModel {
        // create draft if not existed
        if (!isDraftExisted()) {
            val draft = PackageModel(
                packageName = "Draft",
                stickers = listOf(),
                isDraft = true
            )
            insertPackage(draft)
        }

        return getAllDrafts()[0]
    }

    suspend fun saveToDraft(stickerModel: StickerModel) {

        val draft = getDraftPackage()

        val stickers = draft.stickers.toMutableList()
        stickers.add(stickerModel)

        val newDraft = draft.copy(stickers = stickers)

        updatePackage(newDraft)
    }

    suspend fun replaceStickerInDraft(position: Int, newSticker: StickerModel) {
        val draft = getDraftPackage()

        val stickers = draft.stickers.toMutableList()

        if (stickers.size <= position) {
            return
        }

        stickers[position] = newSticker

        val newDraft = draft.copy(stickers = stickers)

        updatePackage(newDraft)
    }

    suspend fun deleteStickerFromDraft(position: Int) {
        val draft = getDraftPackage()

        val stickers = draft.stickers.toMutableList()

        if (stickers.size <= position) {
            return
        }

        stickers.removeAt(position)

        val newDraft = draft.copy(stickers = stickers)

        updatePackage(newDraft)
    }
}