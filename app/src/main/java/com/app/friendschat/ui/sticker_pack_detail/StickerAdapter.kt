package com.app.friendschat.ui.sticker_pack_detail

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.databinding.LayoutStickerItemRftBinding
import com.app.friendschat.dialog.AddingToPackageBepicDialog
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class StickerAdapter(
    private val activity: StickerPackDetailBepicActivityRft,
    private val list: MutableList<StickerModel>
) : RecyclerView.Adapter<StickerAdapter.StickerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerViewHolder {
        val binding = LayoutStickerItemRftBinding.inflate(activity.layoutInflater, parent, false)
        return StickerViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: StickerViewHolder, position: Int) {
        holder.bind(position, activity, list[position])
    }

    class StickerViewHolder(val binding: LayoutStickerItemRftBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, activity: StickerPackDetailBepicActivityRft, sticker: StickerModel) {
            binding.progressBar.visibility = View.VISIBLE
            Glide.with(activity).load(sticker.url)
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: Target<Drawable>?,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.d("CHECK_BUG", e.toString())
                        return false
                    }
                })
                .into(binding.ivSticker)

            binding.ivSticker.tapAndCheckInternet {
                var addingToPackageDialog: AddingToPackageBepicDialog? = null
                when (activity.mViewModel.getFromActivity()) {
                    FromActivity.HOME, FromActivity.CREATE_EMOJI -> {
                        addingToPackageDialog = AddingToPackageBepicDialog(
                            activityBepicRft = activity,
                            fromActivityBepicRft = activity.mViewModel.getFromActivity(),
                            stickerBepicRft = sticker,
                            shouldShowDaftPackageBepicRft = false
                        )
                        addingToPackageDialog.show()

                        EventTracking.logEvent(activity, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM)
                    }
                    FromActivity.MY_CREATION -> {
                        addingToPackageDialog = AddingToPackageBepicDialog(
                            activityBepicRft = activity,
                            fromActivityBepicRft = activity.mViewModel.getFromActivity(),
                            stickerBepicRft = sticker,
                            shouldShowDaftPackageBepicRft = false,
                            onDeleteBepicRft = {
                                activity.mViewModel.deleteImageFromPackage(activity, position) {
                                    addingToPackageDialog?.dismiss()
                                }
                            },
                            onAddToPackageSuccessfullyBepicRft = {
                                activity.mViewModel.refreshStickersIfNeeded(activity)
                            }
                        )
                        addingToPackageDialog.show()
                    }
                }
            }
        }
    }
}