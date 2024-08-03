package com.app.friendschat.ui.sticker_pack_detail

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.app.friendschat.R
import com.app.friendschat.data.model.Action
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.database.PackageDao
import com.app.friendschat.databinding.ActivityStickerPackDetailBepicRftBinding
import com.app.friendschat.dialog.DeleteBepicDialog
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.emoji.EmojiBepicActivityNew
import com.app.friendschat.utils.AssetUtils
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.custom_view.GridSpacingItemDecoration
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.app.friendschat.whatsapp.AddToWhatsappBepicActivity
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack_rft.view.ll_adding_to_telegram
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack_rft.view.ll_adding_to_whatsapp
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack_rft.view.ll_download
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack_rft.view.ll_share
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.reflect.KClass


class StickerPackDetailBepicActivityRft : AddToWhatsappBepicActivity<StickerPackDetailViewModel, ActivityStickerPackDetailBepicRftBinding>() {

    private var packageDaoBepicRft: PackageDao? = null

    override fun initView() {

        val stickerPackTitle = intent.getStringExtra(Constants.BUNDLE_SUGGESTION_STICKER_TITLE)
        val fromActivity = intent.getSerializableExtra(Constants.BUNDLE_FROM_ACTIVITY) as FromActivity

        when (fromActivity) {
            FromActivity.HOME, FromActivity.CREATE_EMOJI -> {
                binding.ivTrash.visibility = View.GONE
                binding.ivAddSticker.visibility = View.GONE

                EventTracking.logEvent(this@StickerPackDetailBepicActivityRft, EventTracking.EVENT_NAME_SUGGESTED_PACK_VIEW_LIST)
            }
            FromActivity.MY_CREATION -> {
                binding.ivTrash.visibility = View.VISIBLE
                binding.ivAddSticker.visibility = View.VISIBLE
                binding.ivTrash.tapAndCheckInternet {
                    val deleteDialog = DeleteBepicDialog(this@StickerPackDetailBepicActivityRft, getString(R.string.this_file_will_be_deleted_from_your_creation)) {
                        CoroutineScope(Dispatchers.Main).launch {
                            withContext(Dispatchers.IO) {
                                packageDaoBepicRft?.deletePackageByName(stickerPackTitle ?: "")
                            }
                            finish()

                            EventTracking.logEvent(this@StickerPackDetailBepicActivityRft, EventTracking.EVENT_NAME_CREATION_PACKAGE_DELETE)
                        }
                    }
                    deleteDialog.show()
                }
                binding.ivAddSticker.tapAndCheckInternet {
                    val bundle = Bundle()
                    bundle.putSerializable(Constants.BUNDLE_SAVE_ACTION, Action.CREATE_FROM_MY_CREATION)
                    showActivity(EmojiBepicActivityNew::class.java, bundle)

                    EventTracking.logEvent(this@StickerPackDetailBepicActivityRft, EventTracking.EVENT_NAME_CREATION_PACKAGE_VIEW_LIST_CREATE)
                }

                EventTracking.logEvent(this@StickerPackDetailBepicActivityRft, EventTracking.EVENT_NAME_CREATION_PACKAGE_VIEW_LIST)
            }
        }

        packageDaoBepicRft = AppDatabase.getInstance(this)?.packageNameDao()

        CoroutineScope(Dispatchers.Main).launch {
            val stickers = withContext(Dispatchers.IO) {
                when (fromActivity) {
                    FromActivity.HOME, FromActivity.CREATE_EMOJI -> AssetUtils.getStickerPackInfoByTitle(stickerPackTitle ?: "")?.stickers
                    FromActivity.MY_CREATION -> packageDaoBepicRft?.getPackageByName(stickerPackTitle ?: "")?.stickers
                }
            }?.toMutableList()

            if (stickers == null) {
                Toast.makeText(this@StickerPackDetailBepicActivityRft, "Sticker pack not found", Toast.LENGTH_SHORT).show()
                finish()
                return@launch
            }

            mViewModel.setPackageDao(packageDaoBepicRft)
            mViewModel.setPackageName(stickerPackTitle ?: "")
            mViewModel.setFromActivity(fromActivity)
            mViewModel.setStickers(stickers)

            binding.tvTitle.text = stickerPackTitle

            val size = stickers.size
            binding.tvNumberOfSticker.text = if (size > 1) {
                "$size ${getString(R.string.items)}"
            } else {
                "$size ${getString(R.string.item)}"
            }

            binding.ivBack.tapAndCheckInternet {
                finish()
            }

            val spanCount = 3
            val spacing = this@StickerPackDetailBepicActivityRft.resources.getDimension(R.dimen._7sdp).toInt()

            binding.rvSticker.layoutManager = GridLayoutManager(this@StickerPackDetailBepicActivityRft, spanCount)
            binding.rvSticker.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing))

            val adapter = StickerAdapter(this@StickerPackDetailBepicActivityRft, stickers)

            binding.rvSticker.adapter = adapter

            mViewModel.setAdapter(adapter)

            binding.layoutSharingAndAddingStickerPack.ll_share.tapAndCheckInternet {

                // prevent user click too fast
                binding.layoutSharingAndAddingStickerPack.ll_share.isClickable = false

                mViewModel.shareImages(this@StickerPackDetailBepicActivityRft)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_share.isClickable = true
                }, 1000)
            }

            binding.layoutSharingAndAddingStickerPack.ll_download.tapAndCheckInternet {
                binding.layoutSharingAndAddingStickerPack.ll_download.isClickable = false

                mViewModel.downloadImages(this@StickerPackDetailBepicActivityRft)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_download.isClickable = true
                }, 1000)
            }

            binding.layoutSharingAndAddingStickerPack.ll_adding_to_telegram.tapAndCheckInternet {
                binding.layoutSharingAndAddingStickerPack.ll_adding_to_telegram.isClickable = false

                mViewModel.addToTelegram(this@StickerPackDetailBepicActivityRft)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_adding_to_telegram.isClickable = true
                }, 1000)
            }

            binding.layoutSharingAndAddingStickerPack.ll_adding_to_whatsapp.tapAndCheckInternet {
                binding.layoutSharingAndAddingStickerPack.ll_adding_to_whatsapp.isClickable = false

                mViewModel.addToWhatsapp(this@StickerPackDetailBepicActivityRft)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_adding_to_whatsapp.isClickable = true
                }, 1000)
            }

            mViewModel.loadStickers(this@StickerPackDetailBepicActivityRft)

            mViewModel.stickers.observe(this@StickerPackDetailBepicActivityRft) {

                Log.d("CHECK_BUG", "stickerUrls.observe: ${it.size}")

                if (it.size == 0) {
                    finish()
                    return@observe
                }

                updateNumberOfStickerTextViewBepicRft()

                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun createViewModel(): Class<StickerPackDetailViewModel> =
        StickerPackDetailViewModel::class.java

    override fun getContentView() = R.layout.activity_sticker_pack_detail_bepic_rft

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    override fun bindViewModel() {
    }
    private fun updateNumberOfStickerTextViewBepicRft() {
        val size = mViewModel.stickers.value?.size ?: 0

        when (mViewModel.getFromActivity()) {
            FromActivity.HOME, FromActivity.CREATE_EMOJI -> {
                binding.tvNumberOfSticker.text = if (size > 1) {
                    "$size ${getString(R.string.stickers)}"
                } else {
                    "$size ${getString(R.string.sticker)}"
                }
            }
            FromActivity.MY_CREATION -> {
                binding.tvNumberOfSticker.text = if (size > 1) {
                    "$size ${getString(R.string.items)}"
                } else {
                    "$size ${getString(R.string.item)}"
                }
            }
        }
    }
    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }



}