package com.app.friendschat.bottom_sheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.friendschat.R
import com.app.friendschat.adapter.PackageAdapter
import com.app.friendschat.data.model.Action
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.PackageAdapterItem
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.database.PackageDao
import com.app.friendschat.listener.SuccessfullyListener
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.success.SuccessNewScreenActivityRft
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.custom_view.VerticalSpaceItemDecoration
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val STICKER_TO_SAVE_BEPIC = "stickerToSave"
private const val FROM_ACTIVITY_BEPIC = "fromActivity"
private const val ACTION_BEPIC = "action"
private const val POSITION_IN_DRAFT_BEPIC = "positionInDraft"
private const val SHOULD_SHOW_DAFT_PACKAGE_BEPIC = "shouldShowDaftPackage"
private const val ON_SAVE_SUCCESSFULLY = "onSaveSuccessfully"

class SaveToPackageBepciBts : BottomSheetDialogFragment() {

    var successfullyListenerBepic: SuccessfullyListener? = null
    private var successfullyListener: SuccessfullyListener? = null

    private lateinit var llNewPackBepic: LinearLayout
    private lateinit var rlSaveBepic: RelativeLayout
    private lateinit var rvPackageBepic: RecyclerView

    private var packageDaoBepic: PackageDao? = null
    private var packageListBepic = mutableListOf<PackageAdapterItem>()
    private var packageAdapterBepic: PackageAdapter? = null

    private var stickerToSaveBepic: StickerModel? = null
    private var fromActivityBepic: FromActivity? = null
    private var actionBepic: Action = Action.SAVE_TO_PACKAGE
    private var positionInDraftBepic: Int = -1
    private var shouldShowDaftPackageBepic: Boolean = true

    private val maxVisibleItemsBepic = 4
    private var itemHeightBepic: Int = 100
    private var spaceBetweenItemsBepic = 100

    companion object {
        @JvmStatic
        fun newInstance(
            stickerToSave: StickerModel,
            fromActivity: FromActivity,
            action: Action,
            positionInDraft: Int,
            shouldShowDaftPackage: Boolean,
        ) =
            SaveToPackageBepciBts().apply {
                arguments = Bundle().apply {
                    putSerializable(STICKER_TO_SAVE_BEPIC, stickerToSave)
                    putSerializable(FROM_ACTIVITY_BEPIC, fromActivity)
                    putSerializable(ACTION_BEPIC, action)
                    putInt(POSITION_IN_DRAFT_BEPIC, positionInDraft)
                    putBoolean(SHOULD_SHOW_DAFT_PACKAGE_BEPIC, shouldShowDaftPackage)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stickerToSaveBepic = it.getSerializable(STICKER_TO_SAVE_BEPIC) as StickerModel
            fromActivityBepic = it.getSerializable(FROM_ACTIVITY_BEPIC) as FromActivity
            actionBepic = it.getSerializable(ACTION_BEPIC) as Action
            positionInDraftBepic = it.getInt(POSITION_IN_DRAFT_BEPIC)
            shouldShowDaftPackageBepic = it.getBoolean(SHOULD_SHOW_DAFT_PACKAGE_BEPIC)
        }
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        itemHeightBepic = requireActivity().resources.getDimension(R.dimen._35sdp).toInt()
        spaceBetweenItemsBepic = requireActivity().resources.getDimension(R.dimen._10sdp).toInt()

        val contentView = View.inflate(context, R.layout.layout_save_to_package_bottom_sheet_rft, null)

        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(resources.getColor(android.R.color.transparent))

        connectToDatabaseBepic()
        initViewBepic(dialog)
        setupRecycleViewBepic()

        llNewPackBepic.tapAndCheckInternet {
            val newPackageBottomSheet = NewPackageBepicBts {
                CoroutineScope(Dispatchers.Main).launch {
                    packageListBepic = fetchAllPackages()
                    packageAdapterBepic?.refreshWithNewList(packageListBepic)

                    calculateRecyclerViewHeightBepic()
                }
            }
            newPackageBottomSheet.show(
                requireActivity().supportFragmentManager,
                newPackageBottomSheet.tag
            )

            if (fromActivityBepic == FromActivity.CREATE_EMOJI || actionBepic != Action.EDIT_DRAFT) {
                EventTracking.logEvent(
                    requireActivity(),
                    EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_NEW_PACK_CLICK
                )
            }
        }

        rlSaveBepic.tapAndCheckInternet {
            try {
                CoroutineScope(Dispatchers.Main).launch {
                    saveToSelectedPackages {
                        successfullyListener?.onSaveSuccessfully()
                        dismiss()
                        navigateToSuccessScreenBepic()

                    }
                }
            } catch (e: Exception){

            }
        }
    }

    private suspend fun fetchAllPackages(): MutableList<PackageAdapterItem> =
        withContext(Dispatchers.IO) {
            return@withContext if (shouldShowDaftPackageBepic) {
                (packageDaoBepic?.getAllPackages()?.map {
                    PackageAdapterItem(it)
                }?.toMutableList() ?: mutableListOf())
            } else {
                packageDaoBepic?.getAllPackagesWithoutDraft()?.map {
                    PackageAdapterItem(it)
                }?.toMutableList() ?: mutableListOf()
            }
        }

    private suspend fun saveToSelectedPackages(onSuccess: () -> Unit = {}) {
        val selectedPackageList = packageListBepic.filter {
            it.isSelected
        }

        if (selectedPackageList.isEmpty()) {
            Toast.makeText(
                requireActivity(),
                requireActivity().getString(R.string.please_select_at_least_one_package),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        var isDraftSelected = false

        selectedPackageList.forEach {
            if (it.packageModel.isDraft) {
                isDraftSelected = true
            }

            if (actionBepic == Action.EDIT_DRAFT && it.packageModel.isDraft && positionInDraftBepic > -1) {
                // update sticker in draft
                stickerToSaveBepic?.let { it1 ->
                    packageDaoBepic?.replaceStickerInDraft(
                        positionInDraftBepic,
                        it1
                    )
                }
            } else {
                // save sticker to package
                saveToPackage(it.packageModel.id)
            }
        }

        if (actionBepic == Action.EDIT_DRAFT && !isDraftSelected && positionInDraftBepic > -1) {
            // delete sticker from draft
            packageDaoBepic?.deleteStickerFromDraft(positionInDraftBepic)
        }

        if (fromActivityBepic == FromActivity.CREATE_EMOJI) {

            val savedToPackageNames = selectedPackageList.map {
                it.packageModel.packageName
            }.toTypedArray()

            val bundle = Bundle()
            bundle.putString("name_source", savedToPackageNames.joinToString(", "))
            stickerToSaveBepic?.let { bundle.putInt("items_quantity", it.numberOfLayers) }

            if (actionBepic == Action.EDIT_DRAFT) {
                EventTracking.logEvent(
                    requireActivity(),
                    EventTracking.EVENT_NAME_EDIT_EMOJI_SAVE_CLICK,

                    )
            } else {
                EventTracking.logEvent(
                    requireActivity(),
                    EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_SAVE_CLICK,

                    )
            }
        }

        onSuccess()
    }

    private suspend fun saveToPackage(packageId: Int) = withContext(Dispatchers.IO) {
        val packageModel = packageDaoBepic?.getPackageById(packageId)
        packageModel?.let {
            val newStickers = it.stickers.toMutableList()
            if (stickerToSaveBepic != null) {
                newStickers.add(stickerToSaveBepic!!)
            }
            packageDaoBepic?.updateStickerList(packageId, newStickers)
        }
    }

    private fun connectToDatabaseBepic() {
        packageDaoBepic = AppDatabase.getInstance(requireActivity())?.packageNameDao()
    }

    private fun initViewBepic(dialog: Dialog) {
        llNewPackBepic = dialog.findViewById(R.id.ll_new_pack)
        rlSaveBepic = dialog.findViewById(R.id.rl_save)
        rvPackageBepic = dialog.findViewById(R.id.rv_package)
    }

    private fun setupRecycleViewBepic() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                packageListBepic = fetchAllPackages()
                packageAdapterBepic = PackageAdapter(requireActivity(), packageListBepic)
                rvPackageBepic.addItemDecoration(VerticalSpaceItemDecoration(spaceBetweenItemsBepic))
                rvPackageBepic.layoutManager = LinearLayoutManager(requireActivity())
                rvPackageBepic.adapter = packageAdapterBepic

                calculateRecyclerViewHeightBepic()
            } catch (e: Exception){

            }
        }
    }

    private fun calculateRecyclerViewHeightBepic() {
        val totalItems: Int = packageListBepic.size

        if (totalItems == 0) {
            return
        }

        val recyclerViewHeight = if (totalItems < maxVisibleItemsBepic) {
            totalItems * itemHeightBepic + (totalItems - 1) * spaceBetweenItemsBepic
        } else {
            maxVisibleItemsBepic * itemHeightBepic + (maxVisibleItemsBepic - 1) * spaceBetweenItemsBepic
        }
        val layoutParams: ViewGroup.LayoutParams = rvPackageBepic.layoutParams
        layoutParams.height = recyclerViewHeight
        rvPackageBepic.layoutParams = layoutParams
    }

    private fun navigateToSuccessScreenBepic() {
        val bundle = Bundle()
        bundle.putSerializable(Constants.BUNDLE_SAVE_ACTION, actionBepic)
        if (actionBepic == Action.CREATE) {
            bundle.putString(
                Constants.BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY,
                requireActivity().getString(R.string.create_more_emoji)
            )
        } else {
            bundle.putString(
                Constants.BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY,
                this@SaveToPackageBepciBts.requireActivity()
                    .getString(R.string.explore_more_stickers)
            )
        }
        (this@SaveToPackageBepciBts.requireActivity() as BaseActivity<*, *>).showActivity(
            SuccessNewScreenActivityRft::class.java,
            bundle
        )
    }
}