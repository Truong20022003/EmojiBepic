package com.app.friendschat.ui.my_creation.created_draft_fragment

import androidx.recyclerview.widget.GridLayoutManager
import com.app.friendschat.R
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.database.PackageDao
import com.app.friendschat.ui.base.BaseViewModel
import com.app.friendschat.utils.custom_view.GridSpacingItemDecoration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreatedDraftViewModel: BaseViewModel() {

    private var packageDao: PackageDao? = null

    private lateinit var stickers: MutableList<StickerModel>
    private lateinit var adapter: CreatedDraftAdapter

    fun loadPackagesFromDatabase(fragment: CreatedDraftBepicFragmentRft) {

        packageDao = AppDatabase.getInstance(fragment.requireActivity())?.packageNameDao()

        CoroutineScope(Dispatchers.Main).launch {
            val draft = withContext(Dispatchers.IO) {
                packageDao?.getAllDrafts()?.toMutableList() ?: mutableListOf()
            }

            if (draft.size > 0) {
                stickers = draft[0].stickers.toMutableList()
            } else {
                stickers = mutableListOf()
            }

            val spanCount = 2
            val spacing = fragment.resources.getDimension(R.dimen._13sdp).toInt()

            fragment.binding.rvCreatedDraft.layoutManager = GridLayoutManager(fragment.requireActivity(), spanCount)
            fragment.binding.rvCreatedDraft.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing))

            adapter = CreatedDraftAdapter(fragment, stickers)

            fragment.binding.rvCreatedDraft.adapter = adapter
        }
    }

    fun deleteStickerFromDraft(sticker: StickerModel) {
        CoroutineScope(Dispatchers.Main).launch {
            val draft = withContext(Dispatchers.IO) {
                packageDao?.getAllDrafts() ?: listOf()
            }

            if (draft.isNotEmpty()) {
                stickers.remove(sticker)
                val newDraft = draft[0].copy(stickers = stickers)
                withContext(Dispatchers.IO) {
                    packageDao?.updatePackage(newDraft)
                }
                adapter.notifyDataSetChanged()
            }
        }
    }
}