package com.app.friendschat.ui.emoji_edit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.app.friendschat.R
import com.app.friendschat.bottom_sheet.LayerEmojiBepicBts
import com.app.friendschat.data.model.Action
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.IconModel
import com.app.friendschat.data.model.OptionsModel
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.database.EmojiDao
import com.app.friendschat.database.PackageDao
import com.app.friendschat.databinding.ActivityEditEmojiNewRftBinding
import com.app.friendschat.dialog.AddingToPackageBepicDialog
import com.app.friendschat.dialog.ExitEmojiBepicDialog
import com.app.friendschat.dialog.LoadingBepicDialog
import com.app.friendschat.dialog.UnlockItemBepicDialog
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.emoji.OptionsAdapter
import com.app.friendschat.ui.emoji.PagerIconAdapter
import com.app.friendschat.ui.main.MainBepicActivityRft
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.FileUtils
import com.app.friendschat.utils.custom_sticker.DrawableSticker
import com.app.friendschat.utils.custom_sticker.Sticker
import com.app.friendschat.utils.custom_sticker.StickerView
import com.app.friendschat.utils.widget.convertPhotoAssetToDrawable
import com.app.friendschat.utils.widget.getCurrentTimeAsString
import com.app.friendschat.utils.widget.scalePhotoBitmap
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.reflect.KClass

class EditEmojiBepicActivityRft : BaseActivity<EditEmojiViewModel, ActivityEditEmojiNewRftBinding>() {

    private lateinit var loadingDialogBepicRft: LoadingBepicDialog
    private lateinit var optionsAdapterBepicRft: OptionsAdapter
    private lateinit var pagerIconAdapterBepic: PagerIconAdapter

    private var packageDaoBepicRft: PackageDao? = null
    private var emojiDaoBepicRft: EmojiDao? = null

    private var posEmojiEditBepicRft: Int = 0
    private var jsonUndoListBepicRft: String = ""
    private var jsonEmojiBepicRft: String = ""

    private var listOptionsBepicRft: MutableList<OptionsModel> = mutableListOf()
    private var listFaceBepicRft: MutableList<IconModel> = mutableListOf()
    private var listEyesBepicRft: MutableList<IconModel> = mutableListOf()
    private var listBrowBepicRft: MutableList<IconModel> = mutableListOf()
    private var listMouthBepicRft: MutableList<IconModel> = mutableListOf()
    private var listHandBepicRft: MutableList<IconModel> = mutableListOf()
    private var listNoseBepicRft: MutableList<IconModel> = mutableListOf()
    private var listBeardBepicRft: MutableList<IconModel> = mutableListOf()
    private var listHatBepicRft: MutableList<IconModel> = mutableListOf()
    private var listGlassBepicRft: MutableList<IconModel> = mutableListOf()
    private var listAccessoryBepicRft: MutableList<IconModel> = mutableListOf()
    private var listHairBepicRft: MutableList<IconModel> = mutableListOf()

    override fun initView() {

        EventTracking.logEvent(this, EventTracking.EVENT_NAME_EDIT_EMOJI_VIEW)

//        AdsUtils.loadAdsReward(this, "rewarded")
        loadingDialogBepicRft = LoadingBepicDialog(this)
        packageDaoBepicRft = AppDatabase.getInstance(this)?.packageNameDao()
        emojiDaoBepicRft = AppDatabase.getInstance(this)?.emojiDao()

        //set Data edit
        loadingDialogBepicRft.show()
        lifecycleScope.launch {
            withContext(Dispatchers.Default) {
                addDataBepicRft()

                posEmojiEditBepicRft = intent.getIntExtra(Constants.BUNDLE_EDIT_POS_EMOJI, 0)
                jsonUndoListBepicRft =
                    intent.getStringExtra(Constants.BUNDLE_EDIT_JSON_UNDO_LIST).toString()
                jsonEmojiBepicRft = intent.getStringExtra(Constants.BUNDLE_EDIT_JSON_EMOJI).toString()

                jsonUndoListBepicRft?.let {
                    val jsonUndo = FileUtils.readStringTxtFromCache(this@EditEmojiBepicActivityRft, it)
                    jsonUndo?.let { json ->
                        mViewModel.convertJsonToListOfList(
                            this@EditEmojiBepicActivityRft,
                            json
                        )
                    }
                }
                jsonEmojiBepicRft?.let {
                    val jsonEmoji = FileUtils.readStringTxtFromCache(this@EditEmojiBepicActivityRft, it)
                    jsonEmoji?.let { json ->
                        mViewModel.convertJsonToList(
                            this@EditEmojiBepicActivityRft,
                            json
                        )
                    }
                }

                for (i in 0 until mViewModel.getListStickers().size) {
                    Log.d(
                        "checkEditEmoji",
                        "$i: ${mViewModel.getListStickers()[i].matrix.toString()}"
                    )
                }

                //set Data emoji
                binding.stickerView.stickers = mViewModel.getListStickers()
                binding.stickerView.setListUndo(mViewModel.getListUndo() as List<MutableList<Sticker>>)

                //update select pager icon
                mViewModel.getListStickers().forEach { sticker ->
                    listOptionsBepicRft.forEach { optionsModel ->
                        if (optionsModel.id == sticker.pagerSelect) {
                            optionsModel.listIcon.forEach { iconModel ->
                                if (iconModel.id == sticker.posSelect) {
                                    iconModel.isSelect = true
                                }
                            }
                        }
                    }
                }

            }
            withContext(Dispatchers.Main) {
                pagerIconAdapterBepic.notifyDataSetChanged()
                loadingDialogBepicRft.dismiss()
            }
        }

        binding.stickerView.isLocked = false
        binding.stickerView.isConstrained = true
        binding.stickerView.onStickerOperationListener =
            object : StickerView.OnStickerOperationListener {
                override fun onStickerAdded(sticker: Sticker) {
                    showOptionBepicRft()

                    checkShowLockOrUnLockBepicRft(sticker)

                    if (binding.stickerView.stickerCount > 0) {
                        enableCreateBepicRft()
                    }
                }

                override fun onStickerClicked(sticker: Sticker) {
                    showOptionBepicRft()

                    checkShowLockOrUnLockBepicRft(sticker)
                }

                override fun onStickerDeleted(sticker: Sticker) {
                    if (binding.stickerView.stickerCount == 0) {
                        disableCreateBepicRft()
                    }
                    //xét TH sticker đã xóa có bị copy ra còn xuất hiện trong view không: count >0 vẫn còn
                    var count = 0
                    val listSticker = binding.stickerView.stickers
                    for (i in 0 until listSticker.size) {
                        if (listSticker[i].pagerSelect == sticker.pagerSelect && listSticker[i].posSelect == sticker.posSelect) {
                            count++
                        }
                    }

                    if (count == 0) {
                        //xóa dữ liệu icon đã chọn
                        lifecycleScope.launch(Dispatchers.Default) {
                            listOptionsBepicRft.forEach {
                                if (it.id == sticker.pagerSelect) {
                                    it.listIcon.forEach { icon ->
                                        if (icon.id == sticker.posSelect) {
                                            icon.isSelect = false
                                        }
                                    }
                                }
                            }
                            withContext(Dispatchers.Main) {
                                pagerIconAdapterBepic.notifyDataSetChanged()
                            }

                        }
                    }

                }

                override fun onStickerDragFinished(sticker: Sticker) {
                }

                override fun onStickerTouchedDown(sticker: Sticker) {
                    showOptionBepicRft()
                }

                override fun onStickerZoomFinished(sticker: Sticker) {
                }

                override fun onStickerFlipped(sticker: Sticker) {
                }

                override fun onStickerDoubleTapped(sticker: Sticker) {
                }

                override fun onStickerHideOptionIcon() {
                    hideOptionBepicRft()
                }

                override fun onUndoDeleteSticker(stickers: MutableList<Sticker>) {
                    //khi undo lại trạng thái trước nếu sticker bị mất đi -> cần bỏ select
                    //xóa dữ liệu icon đã chọn
                    updateNotificationIconBepicRft(listOptionsBepicRft, stickers, pagerIconAdapterBepic, false)
                }

                override fun onUndoUpdateSticker(stickers: MutableList<Sticker>) {
                    //khi undo lại trạng thái trước nếu có thêm sticker xuất hiện -> cần select thêm icon
                    //select dữ liệu icon được thêm
                    updateNotificationIconBepicRft(listOptionsBepicRft, stickers, pagerIconAdapterBepic, true)
                }

                override fun onUndoDeleteAll() {
                    if (binding.stickerView.stickerCount == 0) {
                        disableCreateBepicRft()
                    }
                    //Th undo lại hết sticker (k còn sticker nào)
                    lifecycleScope.launch(Dispatchers.Default) {
                        listOptionsBepicRft.forEach {
                            it.listIcon.forEach { icon ->
                                icon.isSelect = false
                            }
                        }
                        withContext(Dispatchers.Main) {
                            pagerIconAdapterBepic.notifyDataSetChanged()
                        }
                    }
                }

                override fun onReplaceSticker(sticker: Sticker) {
                    //xóa dữ liệu icon đã chọn khi replace icon face
                    lifecycleScope.launch(Dispatchers.Default) {
                        listOptionsBepicRft.forEach {
                            if (it.id == sticker.pagerSelect) {
                                it.listIcon.forEach { icon ->
                                    if (icon.id == sticker.posSelect) {
                                        icon.isSelect = false
                                    }
                                }
                            }
                        }
                        withContext(Dispatchers.Main) {
                            pagerIconAdapterBepic.updateNotifyMoveIcon(sticker.posSelect)
                        }

                    }
                }

            }

        pagerIconAdapterBepic = PagerIconAdapter(
            this@EditEmojiBepicActivityRft,
            listOptionsBepicRft,
            onClickItem = { iconModel, i, pager ->
                logEventClickIconBepicRft(i,pager)

                if (binding.stickerView.stickerCount > Constants.COUNT_EMOJI){
                    //số lượng emoji có trong list nhiều hơn 50 items -> thông báo k add được nữa
                    Toast.makeText(this,getString(R.string.more_than_50_items_at_once), Toast.LENGTH_SHORT).show()
                }else {
                    //số lượng emoji có trong list nhỏ hơn 50 items -> add emoji
                    addStickerBepicRft(iconModel, i, pager)
                }
            },
            onShowAdsReward = { iconModel, i, pager ->
                logEventClickIconBepicRft(i,pager)

//                if (AdsUtils.shouldShowAdsReward(this@EditEmojiNewScreenActivity)) {
//                    showDialogUnlockItemsNew(iconModel, i, pager)
//                } else {
//                    addStickerNew(iconModel, i, pager)
//                }
                addStickerBepicRft(iconModel, i, pager)
            }
        )
        //end
        binding.vpIcon.isUserInputEnabled = false
        binding.vpIcon.adapter = pagerIconAdapterBepic

        binding.rvOptions.apply {
            optionsAdapterBepicRft = OptionsAdapter(
                this@EditEmojiBepicActivityRft,
                listOptionsBepicRft,
                onClickItem = { model, pos ->
                    binding.vpIcon.setCurrentItem(pos, false)
                    Log.d("PagerShapeEmoji", "Pager. pos: $pos")

                    //remove all select -> set BG select
                    listOptionsBepicRft.forEach {
                        it.isSelectPage = false
                    }

                    //add select new
                    model.isSelectPage = true
                    optionsAdapterBepicRft.notifyDataSetChanged()
                }
            )

            adapter = optionsAdapterBepicRft
        }

    }

    override fun createViewModel(): Class<EditEmojiViewModel> = EditEmojiViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_edit_emoji_new_rft

    override fun bindViewModel() {
        binding.ivBack.tapAndCheckInternet {
            hideOptionBepicRft()
            onBackPressed()
        }

        binding.ivFlipHorizontal.tapAndCheckInternet {
            if (binding.stickerView.stickerCount > 0) {
                binding.stickerView.flipCurrentSticker(StickerView.FLIP_HORIZONTALLY)
            }
        }

        binding.ivFlipVertical.tapAndCheckInternet {
            if (binding.stickerView.stickerCount > 0) {
                binding.stickerView.flipCurrentSticker(StickerView.FLIP_VERTICALLY)
            }
        }

        binding.rlEmoji.tapAndCheckInternet {
            binding.stickerView.hideSelect()
        }

        binding.rlDelete.tapAndCheckInternet {
            binding.stickerView.removeCurrentSticker()
        }

        binding.rlLock.tapAndCheckInternet {
            clickLockStickerBepicRft()
        }

        binding.ivRefresh.tapAndCheckInternet {
            binding.stickerView.undo()
            hideOptionBepicRft()
        }

        binding.ivMore.tapAndCheckInternet {
            hideOptionBepicRft()
//            val popupMenuCustom = PopupMenuCustom(
//                this,
//                R.layout.layout_more_emoji,
//                object : PopupMenuCustom.PopupMenuCustomOnClickListener {
//                    override fun onClick(menuItemId: Int) {
//                        when (menuItemId) {
//                            R.id.ll_layer -> {
            showBottomSheetLayerBepicRft()
//                            }
//                        }
//                    }
//
//                }
//            )
//            popupMenuCustom.showAbove(mDataBinding.ivMore)
        }

        binding.tvDone.tapAndCheckInternet {

            EventTracking.logEvent(this, EventTracking.EVENT_NAME_EDIT_EMOJI_DONE_CLICK)

            hideOptionBepicRft()
            loadingDialogBepicRft.show() // Hiển thị quá trình tải

            lifecycleScope.launch {
                try {
                    withContext(Dispatchers.Default) {
                        try {
                            //convert list emoji to json
                            mViewModel.convertListEmojiToJson(binding.stickerView.stickers)

                            //convert list of list to json
                            mViewModel.convertListOfListToJson(binding.stickerView.undoList)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            Log.e(
                                "DataStoreExample",
                                "Error during setJsonUndoListSticker: ${e.message}"
                            )
                        }
                    }

                    val bitmapSticker = withContext(Dispatchers.Default) {
                        binding.stickerView.createBitmap()
                    }

                    // scale to 512x512
//                    val scaledBitmap = Bitmap.createScaledBitmap(bitmapSticker, 512, 512, false)
                    val scaledBitmap = scalePhotoBitmap(bitmapSticker)

                    val nameFile = getCurrentTimeAsString()
                    val stickerUrl: String? = withContext(Dispatchers.IO) {
                        FileUtils.saveStickerToCacheDir(
                            this@EditEmojiBepicActivityRft,
                            scaledBitmap,
                            nameFile
                        )
                    }

                    //update json to file txt
                    val fileUndoListTxt: String? = FileUtils.updateStringTxtToCache(
                        this@EditEmojiBepicActivityRft,
                        jsonUndoListBepicRft,
                        mViewModel.getJsonUndoList()
                    )

                    val fileEmojiTxt: String? = FileUtils.updateStringTxtToCache(
                        this@EditEmojiBepicActivityRft,
                        jsonEmojiBepicRft,
                        mViewModel.getEmojiJson()
                    )
                    //end

                    // Ẩn quá trình tải khi đã xử lý xong
                    loadingDialogBepicRft.dismiss()

                    // Chỉ hiển thị AddingToPackageDialog khi stickerUrl khả dụng
                    stickerUrl?.let { it1 ->
                        AddingToPackageBepicDialog(
                            this@EditEmojiBepicActivityRft,
                            FromActivity.CREATE_EMOJI,
                            StickerModel(
                                it1,
                                fileUndoListTxt,
                                fileEmojiTxt,
                                binding.stickerView.stickerCount
                            ),
                            Action.EDIT_DRAFT,
                            posEmojiEditBepicRft
                        ).show()
                    }
                } catch (e: Exception) {
                    // Xử lý các ngoại lệ nếu có
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (binding.stickerView.stickerCount > 0) {
            showDialogConfirmExitBepicRft()
        } else {
            finish()
        }
    }

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    private fun showBottomSheetLayerBepicRft() {
        binding.stickerView.unSelectStickerCurrent()

        val layerEmojiBottomSheet = LayerEmojiBepicBts(
            this,
            binding.stickerView,
            binding.stickerView.stickers as ArrayList<Sticker>,
            onClose = {

            },
            onUndoLayer = {
                hideOptionBepicRft()
            }
        )
        layerEmojiBottomSheet.show(supportFragmentManager, "LayerEmojiBottomSheet")
    }

    private fun showDialogConfirmExitBepicRft() {
        val dialogExit = ExitEmojiBepicDialog(
            this@EditEmojiBepicActivityRft,
            onQuitBepic = {
                finish()
            },
            onSaveDaftBepic = {
                loadingDialogBepicRft.show()
                lifecycleScope.launch {
                    val bitmapSticker = withContext(Dispatchers.Default) {
                        binding.stickerView.createBitmap()
                    }
                    withContext(Dispatchers.Default) {
                        try {
                            //convert list emoji to json
                            mViewModel.convertListEmojiToJson(binding.stickerView.stickers)

                            //convert list of list to json
                            mViewModel.convertListOfListToJson(binding.stickerView.undoList)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            Log.e(
                                "DataStoreExample",
                                "Error during setJsonUndoListSticker: ${e.message}"
                            )
                        }
                    }

                    // scale to 512x512
//                    val scaledBitmap = Bitmap.createScaledBitmap(bitmapSticker, 512, 512, false)
                    val scaledBitmap = scalePhotoBitmap(bitmapSticker)

                    val nameFile = getCurrentTimeAsString()
                    val stickerUrl: String? = withContext(Dispatchers.IO) {
                        FileUtils.saveStickerToCacheDir(
                            this@EditEmojiBepicActivityRft,
                            scaledBitmap,
                            nameFile
                        )
                    }

                    //update json to file txt
                    val fileUndoListTxt: String? = FileUtils.updateStringTxtToCache(
                        this@EditEmojiBepicActivityRft,
                        jsonUndoListBepicRft,
                        mViewModel.getJsonUndoList()
                    )

                    val fileEmojiTxt: String? = FileUtils.updateStringTxtToCache(
                        this@EditEmojiBepicActivityRft,
                        jsonEmojiBepicRft,
                        mViewModel.getEmojiJson()
                    )
                    //end

                    val stickerUpdate: StickerModel? = stickerUrl?.let { it1 ->
                        StickerModel(
                            it1,
                            fileUndoListTxt,
                            fileEmojiTxt,
                            binding.stickerView.stickerCount
                        )
                    }

                    if (stickerUpdate != null) {
                        packageDaoBepicRft?.replaceStickerInDraft(posEmojiEditBepicRft, stickerUpdate)
                    }
                    loadingDialogBepicRft.dismiss()
                    showActivity(MainBepicActivityRft::class.java)
                    finish()
                }
            }
        )
        dialogExit.show()
    }

    private fun updateNotificationIconBepicRft(
        options: MutableList<OptionsModel>,
        result: List<Sticker>,
        adapter: PagerIconAdapter,
        isSelect: Boolean
    ) {
        lifecycleScope.launch(Dispatchers.Default) {
            options.forEach {
                result.forEach { model ->
                    if (it.id == model.pagerSelect) {
                        it.listIcon.forEach { icon ->
                            if (icon.id == model.posSelect) {
                                icon.isSelect = isSelect
                            }
                        }
                    }
                }
            }
            withContext(Dispatchers.Main) {
                adapter.notifyDataSetChanged()
            }
        }
    }




    private fun showDialogUnlockItemsBepic(iconModel: IconModel, pos: Int, pager: Int) {
        val unlockItemDialog = UnlockItemBepicDialog(
            this,
            onWatchVideoBepic = {
                addStickerBepicRft(iconModel, pos, pager)
                iconModel.isShowAds = false
                emojiDaoBepicRft?.updateUnLockShowAds(iconModel.idEmoji)
                pagerIconAdapterBepic.notifyDataSetChanged()
            }
        )
        unlockItemDialog.show()
    }

    private suspend fun addDataBepicRft() {
        emojiDaoBepicRft?.getAllEmoji()?.forEach { model ->
            when (model.folderName) {
                Constants.FACE -> listFaceBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.EYES -> listEyesBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.BROW -> listBrowBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.MOUTH -> listMouthBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.HAND -> listHandBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.NOSE -> listNoseBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.BEARD -> listBeardBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.HAT -> listHatBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.GLASS -> listGlassBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )

                Constants.ACCESSORIES -> listAccessoryBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false, model.iShowAds,
                        model.id
                    )
                )

                Constants.HAIR -> listHairBepicRft.add(
                    IconModel(
                        model.position,
                        model.path,
                        false,
                        model.iShowAds,
                        model.id
                    )
                )
            }
        }
        listOptionsBepicRft.add(
            OptionsModel(
                0,
                R.drawable.ic_face,
                R.drawable.ic_face_select,
                Constants.FACE,
                getString(R.string.face),
                listFaceBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                1,
                R.drawable.ic_eyes,
                R.drawable.ic_eyes_select,
                Constants.EYES,
                getString(R.string.eyes),
                listEyesBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                2,
                R.drawable.ic_brow,
                R.drawable.ic_brow_select,
                Constants.BROW,
                getString(R.string.brow),
                listBrowBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                3,
                R.drawable.ic_mouth,
                R.drawable.ic_mouth_select,
                Constants.MOUTH,
                getString(R.string.mouth),
                listMouthBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                4,
                R.drawable.ic_hand,
                R.drawable.ic_hand_select,
                Constants.HAND,
                getString(R.string.hand),
                listHandBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                5,
                R.drawable.ic_nose,
                R.drawable.ic_nose_select,
                Constants.NOSE,
                getString(R.string.nose),
                listNoseBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                6,
                R.drawable.ic_beard,
                R.drawable.ic_beard_select,
                Constants.BEARD,
                getString(R.string.beard),
                listBeardBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                7,
                R.drawable.ic_hat,
                R.drawable.ic_hat_select,
                Constants.HAT,
                getString(R.string.hat),
                listHatBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                8,
                R.drawable.ic_glass,
                R.drawable.ic_glass_select,
                Constants.GLASS,
                getString(R.string.glass),
                listGlassBepicRft,
                false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                9,
                R.drawable.ic_accessory,
                R.drawable.ic_accessory_select,
                Constants.ACCESSORIES,
                getString(R.string.accessory),
                listAccessoryBepicRft, false
            )
        )
        listOptionsBepicRft.add(
            OptionsModel(
                10,
                R.drawable.ic_hair,
                R.drawable.ic_hair_select,
                Constants.HAIR,
                getString(R.string.hair),
                listHairBepicRft,
                false
            )
        )
        //set default page
        listOptionsBepicRft[0].isSelectPage = true
    }


    private fun showOptionBepicRft() {
        binding.rlLock.visibility = View.VISIBLE
    }


    private fun hideOptionBepicRft() {
        binding.rlLock.visibility = View.GONE
    }



    private fun logEventClickIconBepicRft(i: Int, pager: Int){
        val bundle = Bundle()
        bundle.putString("category",listOptionsBepicRft[pager].nameOptions)
        bundle.putString("item_id", listOptionsBepicRft[pager].listIcon[i].path)
        EventTracking.logEvent(this, EventTracking.EVENT_NAME_CREATE_EMOJI_CATEGORY_CHOOSE_ITEM)
    }
    private fun checkShowLockOrUnLockBepicRft(sticker: Sticker) {
        //check show lock emoji select
        if (sticker.isLock) {
            binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_lock_emoji))
        } else {
            binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_unlock_emoji))
        }
    }

    private fun enableCreateBepicRft() {
        binding.tvDone.isEnabled = true
        binding.tvDone.alpha = 1f
    }
    private fun clickLockStickerBepicRft() {
        if (binding.stickerView.isLockCurrent) {
            binding.stickerView.setLockedCurrent(false)
            binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_unlock_emoji))
        } else {
            binding.stickerView.setLockedCurrent(true)
            binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_lock_emoji))
        }
    }

    private fun disableCreateBepicRft() {
        binding.tvDone.isEnabled = false
        binding.tvDone.alpha = 0.3f
    }

    private fun addStickerBepicRft(iconModel: IconModel, i: Int, pager: Int){
        val drawable =
            convertPhotoAssetToDrawable(this@EditEmojiBepicActivityRft, iconModel.path)
        val drawableSticker: DrawableSticker = DrawableSticker(drawable, iconModel.path)
        //lưu lại vị trí và pager đã chọn
        drawableSticker.pagerSelect = pager
        drawableSticker.posSelect = i

        binding.stickerView.addSticker(drawableSticker)
        //set select icon
        iconModel.isSelect = true
    }
}