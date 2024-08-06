package com.app.friendschat.ui.emoji

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
import com.app.friendschat.databinding.ActivityEmojiBepicNewRftBinding
import com.app.friendschat.dialog.AddingToPackageBepicDialog
import com.app.friendschat.dialog.ExitEmojiBepicDialog
import com.app.friendschat.dialog.LoadingBepicDialog
import com.app.friendschat.dialog.UnlockItemBepicDialog
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.FileUtils
import com.app.friendschat.utils.custom_sticker.DrawableSticker
import com.app.friendschat.utils.custom_sticker.Sticker
import com.app.friendschat.utils.custom_sticker.StickerView
import com.app.friendschat.utils.widget.convertPhotoAssetToDrawable
import com.app.friendschat.utils.widget.getCurrentTimeAsString
import com.app.friendschat.utils.widget.getNameEmojiCurrentTimeAsString
import com.app.friendschat.utils.widget.getNameUndoListCurrentTimeAsString
import com.app.friendschat.utils.widget.scalePhotoBitmap
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.reflect.KClass


class EmojiBepicActivityNew : BaseActivity<EmojiViewModel, ActivityEmojiBepicNewRftBinding>() {

    private var listHatBepicRft: MutableList<IconModel> = mutableListOf()
    private var listGlassBepicRft: MutableList<IconModel> = mutableListOf()
    private var listAccessoryBepicRft: MutableList<IconModel> = mutableListOf()
    private var listHairBepicRft: MutableList<IconModel> = mutableListOf()
    private lateinit var optionsAdapterBepicRft: OptionsAdapter
    private lateinit var pagerIconAdapterBepicRft: PagerIconAdapter
    private var listEyesBepicRft: MutableList<IconModel> = mutableListOf()
    private var listBrowBepicRft: MutableList<IconModel> = mutableListOf()
    private var listMouthBepicRft: MutableList<IconModel> = mutableListOf()
    private var listHandBepicRft: MutableList<IconModel> = mutableListOf()
    private var listNoseBepicRft: MutableList<IconModel> = mutableListOf()
    private var listBeardBepicRft: MutableList<IconModel> = mutableListOf()
    private lateinit var loadingDialogBepicRft: LoadingBepicDialog
    private var packageDaoBepicRft: PackageDao? = null
    private var emojiDaoBepicRft: EmojiDao? = null
    private var listOptionsBepicRft: MutableList<OptionsModel> = mutableListOf()
    private var listFaceBepicRft: MutableList<IconModel> = mutableListOf()

    override fun initView() {

        EventTracking.logEvent(this, EventTracking.EVENT_NAME_CREATE_EMOJI_VIEW)
        loadingDialogBepicRft = LoadingBepicDialog(this)
        packageDaoBepicRft = AppDatabase.getInstance(this)?.packageNameDao()
        emojiDaoBepicRft = AppDatabase.getInstance(this)?.emojiDao()

        disableCreateBepicRft()

        addDataBepicRft()

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
                    Log.d("checkSHowFlipHorizontal", "onStickerAdded")
                }

                override fun onStickerClicked(sticker: Sticker) {
                    Log.d(
                        "checkSHowFlipHorizontal",
                        "Horizontal: ${sticker.isFlippedHorizontally} , vertical: ${sticker.isFlippedVertically}"
                    )

                    showOptionBepicRft()

                    checkShowLockOrUnLockBepicRft(sticker)
                }

                override fun onStickerDeleted(sticker: Sticker) {
                    Log.d("checkSHowFlipHorizontal", "onStickerDeleted")

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
                                pagerIconAdapterBepicRft.notifyDataSetChanged()
                            }

                        }
                    }

                }

                override fun onStickerDragFinished(sticker: Sticker) {
                    Log.d(
                        "checkSHowFlipHorizontal",
                        "onStickerDragFinished: maxtrix= " + sticker.matrix + ",angle= " + sticker.currentAngle
                    )
                }

                override fun onStickerTouchedDown(sticker: Sticker) {
                    showOptionBepicRft()
                    Log.d("checkSHowFlipHorizontal", "onStickerTouchedDown")
                }

                override fun onStickerZoomFinished(sticker: Sticker) {
                    Log.d("checkSHowFlipHorizontal", "onStickerZoomFinished")
                }

                override fun onStickerFlipped(sticker: Sticker) {
                    Log.d("checkSHowFlipHorizontal", "onStickerFlipped")
                }

                override fun onStickerDoubleTapped(sticker: Sticker) {
                    Log.d("checkSHowFlipHorizontal", "onStickerDoubleTapped")
                }

                override fun onStickerHideOptionIcon() {
                    hideOptionBepicRft()
                }

                override fun onUndoDeleteSticker(stickers: MutableList<Sticker>) {
                    //khi undo lại trạng thái trước nếu sticker bị mất đi -> cần bỏ select
                    //xóa dữ liệu icon đã chọn
                    updateNotificationIconBepicRft(listOptionsBepicRft, stickers, pagerIconAdapterBepicRft, false)

                }

                override fun onUndoUpdateSticker(stickers: MutableList<Sticker>) {
                    //khi undo lại trạng thái trước nếu có thêm sticker xuất hiện -> cần select thêm icon
                    //select dữ liệu icon được thêm
                    updateNotificationIconBepicRft(listOptionsBepicRft, stickers, pagerIconAdapterBepicRft, true)
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
                            pagerIconAdapterBepicRft.notifyDataSetChanged()
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
                            pagerIconAdapterBepicRft.updateNotifyMoveIcon(sticker.posSelect)
                        }

                    }
                }

            }

        pagerIconAdapterBepicRft = PagerIconAdapter(
            this@EmojiBepicActivityNew,
            listOptionsBepicRft,
            onClickItem = { iconModel, i, pager ->
                logEventClickIconBepicRft(i, pager)

                if (binding.stickerView.stickerCount > Constants.COUNT_EMOJI) {
                    //số lượng emoji có trong list nhiều hơn 50 items -> thông báo k add được nữa
                    Toast.makeText(
                        this,
                        getString(R.string.more_than_50_items_at_once),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    //số lượng emoji có trong list nhỏ hơn 50 items -> add emoji
                    addStickerBepicRft(iconModel, i, pager)
                }
            },
            onShowAdsReward = { iconModel, i, pager ->
                logEventClickIconBepicRft(i, pager)

//                if (AdsUtils.shouldShowAdsReward(this@EmojiNewScreenActivity)) {
//                    showDialogUnlockItemsNew(iconModel, i, pager)
//                } else {
//                    addStickerNew(iconModel, i, pager)
//                }
                addStickerBepicRft(iconModel, i, pager)
            }
        )

        //end
        binding.vpIcon.isUserInputEnabled = false
        binding.vpIcon.adapter = pagerIconAdapterBepicRft

        binding.rvOptions.apply {
            optionsAdapterBepicRft = OptionsAdapter(
                this@EmojiBepicActivityNew,
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

    override fun createViewModel(): Class<EmojiViewModel> = EmojiViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_emoji_bepic_new_rft

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {}

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {}

    override fun bindViewModel() {
        hideOptionBepicRft()
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

        binding.tvCreate.tapAndCheckInternet {

            EventTracking.logEvent(this, EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_CLICK)

            hideOptionBepicRft()
            loadingDialogBepicRft.show() // Hiển thị quá trình tải

            lifecycleScope.launch {
                try {
                    // Xử lý khi nút được nhấn

                    //lưu dữ liệu tạo
                    withContext(Dispatchers.Default) {
                        try {
                            //convert list emoji to json
                            mViewModel.convertListEmojiToJson(binding.stickerView.stickers)

                            //convert list of list to json
                            mViewModel.convertListOfListToJson(binding.stickerView.undoList)
                            val jsonUndoList = mViewModel.getCurrentJson()
                            dataStore.setJsonUndoListSticker(jsonUndoList, this@EmojiBepicActivityNew)
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
                        FileUtils.saveStickerToCacheDir(this@EmojiBepicActivityNew, scaledBitmap, nameFile)
                    }

                    //save json to file txt
                    val fileUndoListTxt: String? = FileUtils.saveStringToTxtCache(
                        this@EmojiBepicActivityNew, mViewModel.getCurrentJson(),
                        getNameUndoListCurrentTimeAsString()
                    )

                    val fileEmojiTxt: String? = FileUtils.saveStringToTxtCache(
                        this@EmojiBepicActivityNew, mViewModel.getEmojiJson(),
                        getNameEmojiCurrentTimeAsString()
                    )
                    //end

                    // Ẩn quá trình tải khi đã xử lý xong
                    loadingDialogBepicRft.dismiss()

                    // Chỉ hiển thị AddingToPackageDialog khi stickerUrl khả dụng

                    val action =
                        intent.getSerializableExtra(Constants.BUNDLE_SAVE_ACTION) as Action?

                    stickerUrl?.let { it1 ->
                        AddingToPackageBepicDialog(
                            this@EmojiBepicActivityNew,
                            FromActivity.CREATE_EMOJI,
                            StickerModel(
                                it1,
                                fileUndoListTxt,
                                fileEmojiTxt,
                                binding.stickerView.stickerCount
                            ),
                            action ?: Action.CREATE
                        ).show()
                    }
                } catch (e: Exception) {
                    // Xử lý các ngoại lệ nếu có
                    e.printStackTrace()
                }
            }

        }

        binding.rlRecent.tapAndCheckInternet {
            //
            CoroutineScope(Dispatchers.Main).launch {
                dataStore.jsonUndoListSticker.collect {
                    mViewModel.convertJsonToListOfList(this@EmojiBepicActivityNew, it)
                    Log.d("DataStore", "bindViewModel: $it")
                }
            }
            //

            val listUndo = mViewModel.getUndoList()
            for (i in 0 until listUndo.size) {
                for (j in 0 until listUndo[i].size) {
                    Log.d(
                        "ItemStickerUndoList",
                        "$i, $j : matrix : ${listUndo[i][j].matrix.toString()}"
                    )
                }
            }
//            mDataBinding.stickerView.recentSticker(listUndo as List<MutableList<Sticker>>?)
        }


    }

    override fun onBackPressed() {
        if (binding.stickerView.stickerCount > 0) {
            showDialogQuitBepicRft()
        } else {
            finish()
        }
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

    private fun clickLockStickerBepicRft() {
        if (binding.stickerView.isLockCurrent) {
            binding.stickerView.setLockedCurrent(false)
            binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_unlock_emoji))
        } else {
            binding.stickerView.setLockedCurrent(true)
            binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_lock_emoji))
        }
    }
    private fun checkShowLockOrUnLockBepicRft(sticker: Sticker) {
        //check show lock emoji select
        try {
            if (sticker.isLock) {
                binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_lock_emoji))
            } else {
                binding.ivLockEmoji.setImageDrawable(resources.getDrawable(R.drawable.ic_unlock_emoji))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun logEventClickIconBepicRft(i: Int, pager: Int){
        val bundle = Bundle()
        bundle.putString("category", listOptionsBepicRft[pager].nameEvent)
        bundle.putString("item_id", listOptionsBepicRft[pager].listIcon[i].path)
        EventTracking.logEvent(
            this,
            EventTracking.EVENT_NAME_CREATE_EMOJI_CATEGORY_CHOOSE_ITEM,

            )
    }
    private fun enableCreateBepicRft() {
        binding.tvCreate.isEnabled = true
        binding.tvCreate.alpha = 1f
    }
    private fun addDataBepicRft() {
        lifecycleScope.launch {
            withContext(Dispatchers.Default) {
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
            }
            //set default page
            listOptionsBepicRft[0].isSelectPage = true
            if (optionsAdapterBepicRft != null){
                optionsAdapterBepicRft.notifyDataSetChanged()
            }
        }
    }
    private fun showOptionBepicRft() {
        binding.rlLock.visibility = View.VISIBLE
//        mDataBinding.rlDelete.visibility = View.VISIBLE
    }
    private fun hideOptionBepicRft() {
        binding.rlLock.visibility = View.GONE
//        mDataBinding.rlDelete.visibility = View.GONE
    }
    private fun showDialogUnlockItemsBepicRft(iconModel: IconModel, pos: Int, pager: Int) {
        val unlockItemDialog = UnlockItemBepicDialog(
            this,
            onWatchVideoBepic = {
                addStickerBepicRft(iconModel, pos, pager)
                iconModel.isShowAds = false
                emojiDaoBepicRft?.updateUnLockShowAds(iconModel.idEmoji)
                pagerIconAdapterBepicRft.notifyDataSetChanged()
            }
        )
        unlockItemDialog.show()
    }
    private fun addStickerBepicRft(iconModel: IconModel, i: Int, pager: Int) {
        val drawable = convertPhotoAssetToDrawable(this@EmojiBepicActivityNew, iconModel.path)
        val drawableSticker = DrawableSticker(drawable, iconModel.path)
        //lưu lại vị trí và pager đã chọn
        drawableSticker.pagerSelect = pager
        drawableSticker.posSelect = i

        binding.stickerView.addSticker(drawableSticker)

        //set select icon
        iconModel.isSelect = true

        Log.d("PagerShapeEmoji", "Pos. pager: $pager , pos: $i")

//                val stickerFaceOld = mDataBinding.stickerView.stickerFace
//                if (pager == 0) { // TH đang chọn face
//                    if (stickerFaceOld == null) { //nếu chưa có face nào được add -> thêm mới
//                        mDataBinding.stickerView.addSticker(drawableSticker)
//                    } else { //nếu đã có face -> replace
//                        mDataBinding.stickerView.replaceSticker(stickerFaceOld, drawableSticker)
//                    }
//                }else{ //Th chọn các pager khác
//                    mDataBinding.stickerView.addSticker(drawableSticker)
//                }
    }
    private fun showDialogQuitBepicRft() {
        val dialogExitEmoji: ExitEmojiBepicDialog = ExitEmojiBepicDialog(
            this@EmojiBepicActivityNew,
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
                        FileUtils.saveStickerToCacheDir(this@EmojiBepicActivityNew, scaledBitmap, nameFile)
                    }

                    //save json to file txt
                    val fileUndoListTxt: String? = FileUtils.saveStringToTxtCache(
                        this@EmojiBepicActivityNew, mViewModel.getCurrentJson(),
                        getNameUndoListCurrentTimeAsString()
                    )

                    val fileEmojiTxt: String? = FileUtils.saveStringToTxtCache(
                        this@EmojiBepicActivityNew, mViewModel.getEmojiJson(),
                        getNameEmojiCurrentTimeAsString()
                    )
                    //end

                    val sticker: StickerModel? = stickerUrl?.let { it1 ->
                        StickerModel(
                            it1,
                            fileUndoListTxt,
                            fileEmojiTxt,
                            binding.stickerView.stickerCount
                        )
                    }

                    if (sticker != null) {
                        packageDaoBepicRft?.saveToDraft(sticker)
                    }
                    loadingDialogBepicRft.dismiss()
                    finish()
                }
            }
        )
        dialogExitEmoji.show()
    }

    private fun disableCreateBepicRft() {
        binding.tvCreate.isEnabled = false
        binding.tvCreate.alpha = 0.3f
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

}