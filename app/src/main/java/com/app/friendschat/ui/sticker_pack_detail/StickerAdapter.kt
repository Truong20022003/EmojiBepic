package com.app.friendschat.ui.sticker_pack_detail

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.databinding.LayoutStickerItemBinding
import com.app.friendschat.dialog.AddingToPackageBepicDialog
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet

class StickerAdapter(
    private val activity: StickerPackDetailBepicActivity,
    private val list: MutableList<StickerModel>
) : RecyclerView.Adapter<StickerAdapter.StickerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerViewHolder {
        val binding = LayoutStickerItemBinding.inflate(activity.layoutInflater, parent, false)
        return StickerViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: StickerViewHolder, position: Int) {
        holder.bind(position, activity, list[position])
    }

    class StickerViewHolder(val binding: LayoutStickerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, activity: StickerPackDetailBepicActivity, sticker: StickerModel) {
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
                            activityBepic = activity,
                            fromActivityBepic = activity.mViewModel.getFromActivity(),
                            stickerBepic = sticker,
                            shouldShowDaftPackageBepic = false
                        )
                        addingToPackageDialog.show()

                        EventTracking.logEvent(activity, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM)
                    }
                    FromActivity.MY_CREATION -> {
                        addingToPackageDialog = AddingToPackageBepicDialog(
                            activityBepic = activity,
                            fromActivityBepic = activity.mViewModel.getFromActivity(),
                            stickerBepic = sticker,
                            shouldShowDaftPackageBepic = false,
                            onDeleteBepic = {
                                activity.mViewModel.deleteImageFromPackage(activity, position) {
                                    addingToPackageDialog?.dismiss()
                                }
                            },
                            onAddToPackageSuccessfullyBepic = {
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