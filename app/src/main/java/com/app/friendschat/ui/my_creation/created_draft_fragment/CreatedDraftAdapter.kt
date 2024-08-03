package com.app.friendschat.ui.my_creation.created_draft_fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.app.friendschat.R
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.databinding.LayoutItemCreatedDraftBinding
import com.app.friendschat.dialog.DeleteBepicDialog
import com.app.friendschat.ui.emoji_edit.EditEmojiBepicActivity
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet

class CreatedDraftAdapter(
    val createdDraftFragment: CreatedDraftBepicFragment,
    val stickers: MutableList<StickerModel>
) : RecyclerView.Adapter<CreatedDraftAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutItemCreatedDraftBinding.inflate(
            createdDraftFragment.requireActivity().layoutInflater,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = if (stickers.size > 0) stickers.size else 1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (stickers.size > 0) {
            holder.bind(createdDraftFragment, stickers[position])
        } else {
            holder.bindDefault()
        }
    }

    class ViewHolder(val binding: LayoutItemCreatedDraftBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(createdDraftFragment: CreatedDraftBepicFragment, sticker: StickerModel) {
            binding.progressBar.visibility = View.VISIBLE
            Glide.with(createdDraftFragment.requireActivity())
                .load(sticker.url)
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
                .into(binding.imgSticker)

            binding.imgDelete.tapAndCheckInternet {
                val deleteDialog = DeleteBepicDialog(
                    createdDraftFragment.requireActivity(),
                    createdDraftFragment.getString(R.string.this_file_will_be_deleted_on_your_device)
                ) {
                    createdDraftFragment.viewModel.deleteStickerFromDraft(sticker)

                    EventTracking.logEvent(createdDraftFragment.requireActivity(), EventTracking.EVENT_NAME_CREATION_DRAFT_DELETE_CLICK)
                }
                deleteDialog.show()
            }

            binding.imgEdit.tapAndCheckInternet {


                val bundle = Bundle()
                bundle.putInt(Constants.BUNDLE_EDIT_POS_EMOJI, position)
                bundle.putString(Constants.BUNDLE_EDIT_JSON_UNDO_LIST, sticker.jsonUndoList)
                bundle.putString(Constants.BUNDLE_EDIT_JSON_EMOJI, sticker.jsonSticker)
//                Constants.jsonUndoList = sticker.jsonUndoList.toString()
//                Constants.jsonSticker = sticker.jsonSticker.toString()
                createdDraftFragment.showActivity(EditEmojiBepicActivity::class.java, bundle)

                EventTracking.logEvent(createdDraftFragment.requireActivity(), EventTracking.EVENT_NAME_CREATION_DRAFT_EDIT_CLICK)
            }
        }

        fun bindDefault() {
            binding.progressBar.visibility = View.GONE
            binding.imgSticker.setImageResource(R.drawable.new_img_create)
            binding.imgDelete.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    binding.root.context.getString(R.string.this_is_a_sample_file),
                    Toast.LENGTH_SHORT
                ).show()
            }
            binding.imgEdit.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    binding.root.context.getString(R.string.this_is_a_sample_file),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}