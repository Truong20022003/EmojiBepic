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
import com.app.friendschat.databinding.ActivityStickerPackDetailBepicBinding
import com.app.friendschat.dialog.DeleteBepicDialog
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.emoji.EmojiBepicActivity
import com.app.friendschat.utils.AssetUtils
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.custom_view.GridSpacingItemDecoration
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.app.friendschat.whatsapp.AddToWhatsappBepicActivity
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack.view.ll_adding_to_telegram
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack.view.ll_adding_to_whatsapp
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack.view.ll_download
import kotlinx.android.synthetic.main.layout_sharing_and_adding_sticker_pack.view.ll_share
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.reflect.KClass


class StickerPackDetailBepicActivity : AddToWhatsappBepicActivity<StickerPackDetailViewModel, ActivityStickerPackDetailBepicBinding>() {

    private var packageDaoBepic: PackageDao? = null

    override fun initView() {

        val stickerPackTitle = intent.getStringExtra(Constants.BUNDLE_SUGGESTION_STICKER_TITLE)
        val fromActivity = intent.getSerializableExtra(Constants.BUNDLE_FROM_ACTIVITY) as FromActivity

        when (fromActivity) {
            FromActivity.HOME, FromActivity.CREATE_EMOJI -> {
                binding.ivTrash.visibility = View.GONE
                binding.ivAddSticker.visibility = View.GONE

                EventTracking.logEvent(this@StickerPackDetailBepicActivity, EventTracking.EVENT_NAME_SUGGESTED_PACK_VIEW_LIST)
            }
            FromActivity.MY_CREATION -> {
                binding.ivTrash.visibility = View.VISIBLE
                binding.ivAddSticker.visibility = View.VISIBLE
                binding.ivTrash.tapAndCheckInternet {
                    val deleteDialog = DeleteBepicDialog(this@StickerPackDetailBepicActivity, getString(R.string.this_file_will_be_deleted_from_your_creation)) {
                        CoroutineScope(Dispatchers.Main).launch {
                            withContext(Dispatchers.IO) {
                                packageDaoBepic?.deletePackageByName(stickerPackTitle ?: "")
                            }
                            finish()

                            EventTracking.logEvent(this@StickerPackDetailBepicActivity, EventTracking.EVENT_NAME_CREATION_PACKAGE_DELETE)
                        }
                    }
                    deleteDialog.show()
                }
                binding.ivAddSticker.tapAndCheckInternet {
                    val bundle = Bundle()
                    bundle.putSerializable(Constants.BUNDLE_SAVE_ACTION, Action.CREATE_FROM_MY_CREATION)
                    showActivity(EmojiBepicActivity::class.java, bundle)

                    EventTracking.logEvent(this@StickerPackDetailBepicActivity, EventTracking.EVENT_NAME_CREATION_PACKAGE_VIEW_LIST_CREATE)
                }

                EventTracking.logEvent(this@StickerPackDetailBepicActivity, EventTracking.EVENT_NAME_CREATION_PACKAGE_VIEW_LIST)
            }
        }

        packageDaoBepic = AppDatabase.getInstance(this)?.packageNameDao()

        CoroutineScope(Dispatchers.Main).launch {
            val stickers = withContext(Dispatchers.IO) {
                when (fromActivity) {
                    FromActivity.HOME, FromActivity.CREATE_EMOJI -> AssetUtils.getStickerPackInfoByTitle(stickerPackTitle ?: "")?.stickers
                    FromActivity.MY_CREATION -> packageDaoBepic?.getPackageByName(stickerPackTitle ?: "")?.stickers
                }
            }?.toMutableList()

            if (stickers == null) {
                Toast.makeText(this@StickerPackDetailBepicActivity, "Sticker pack not found", Toast.LENGTH_SHORT).show()
                finish()
                return@launch
            }

            mViewModel.setPackageDao(packageDaoBepic)
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
            val spacing = this@StickerPackDetailBepicActivity.resources.getDimension(R.dimen._7sdp).toInt()

            binding.rvSticker.layoutManager = GridLayoutManager(this@StickerPackDetailBepicActivity, spanCount)
            binding.rvSticker.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing))

            val adapter = StickerAdapter(this@StickerPackDetailBepicActivity, stickers)

            binding.rvSticker.adapter = adapter

            mViewModel.setAdapter(adapter)

            binding.layoutSharingAndAddingStickerPack.ll_share.tapAndCheckInternet {

                // prevent user click too fast
                binding.layoutSharingAndAddingStickerPack.ll_share.isClickable = false

                mViewModel.shareImages(this@StickerPackDetailBepicActivity)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_share.isClickable = true
                }, 1000)
            }

            binding.layoutSharingAndAddingStickerPack.ll_download.tapAndCheckInternet {
                binding.layoutSharingAndAddingStickerPack.ll_download.isClickable = false

                mViewModel.downloadImages(this@StickerPackDetailBepicActivity)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_download.isClickable = true
                }, 1000)
            }

            binding.layoutSharingAndAddingStickerPack.ll_adding_to_telegram.tapAndCheckInternet {
                binding.layoutSharingAndAddingStickerPack.ll_adding_to_telegram.isClickable = false

                mViewModel.addToTelegram(this@StickerPackDetailBepicActivity)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_adding_to_telegram.isClickable = true
                }, 1000)
            }

            binding.layoutSharingAndAddingStickerPack.ll_adding_to_whatsapp.tapAndCheckInternet {
                binding.layoutSharingAndAddingStickerPack.ll_adding_to_whatsapp.isClickable = false

                mViewModel.addToWhatsapp(this@StickerPackDetailBepicActivity)

                Handler().postDelayed({
                    binding.layoutSharingAndAddingStickerPack.ll_adding_to_whatsapp.isClickable = true
                }, 1000)
            }

            mViewModel.loadStickers(this@StickerPackDetailBepicActivity)

            mViewModel.stickers.observe(this@StickerPackDetailBepicActivity) {

                Log.d("CHECK_BUG", "stickerUrls.observe: ${it.size}")

                if (it.size == 0) {
                    finish()
                    return@observe
                }

                updateNumberOfStickerTextViewBepic()

                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun createViewModel(): Class<StickerPackDetailViewModel> =
        StickerPackDetailViewModel::class.java

    override fun getContentView() = R.layout.activity_sticker_pack_detail_bepic

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    override fun bindViewModel() {
    }

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    private fun updateNumberOfStickerTextViewBepic() {
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

}