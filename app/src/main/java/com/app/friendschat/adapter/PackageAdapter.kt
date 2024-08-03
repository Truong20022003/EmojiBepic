package com.app.friendschat.adapter

import android.app.Activity
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
import com.app.friendschat.R
import com.app.friendschat.data.model.PackageAdapterItem
import com.app.friendschat.databinding.LayoutPackageItemBinding
import com.app.friendschat.utils.widget.tapAndCheckInternet

class PackageAdapter(
    private val activity: Activity,
    val list: MutableList<PackageAdapterItem>,
) : RecyclerView.Adapter<PackageAdapter.ViewHolder>() {

    fun refreshWithNewList(newList: List<PackageAdapterItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutPackageItemBinding.inflate(activity.layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(activity, list[position])
    }

    class ViewHolder(val binding: LayoutPackageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: Activity, item: PackageAdapterItem) {
            binding.tvTitle.text = item.packageModel.packageName

            val size = item.packageModel.stickers.size
            binding.tvNumberOfSticker.text = if (size > 1) {
                "$size ${activity.getString(R.string.items)}"
            } else {
                "$size ${activity.getString(R.string.item)}"
            }

            if (item.isSelected) {
                binding.ivChecked.setImageResource(R.drawable.ic_checked)
            } else {
                binding.ivChecked.setImageResource(R.drawable.ic_unchecked)
            }

            binding.root.tapAndCheckInternet {
                item.isSelected = !item.isSelected
                if (item.isSelected) {
                    binding.ivChecked.setImageResource(R.drawable.ic_checked)
                } else {
                    binding.ivChecked.setImageResource(R.drawable.ic_unchecked)
                }
            }

            binding.progressBar.visibility = View.VISIBLE

            if (item.packageModel.stickers.isEmpty()) {
                binding.progressBar.visibility = View.GONE
                binding.ivSticker.setImageResource(R.drawable.new_img_create)
            } else {
                Glide.with(binding.root.context)
                    .load(item.packageModel.stickers[0].url)
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
            }
        }
    }
}