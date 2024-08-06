package com.app.friendschat.ui.my_creation.created_package_fragment

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.friendschat.R
import com.app.friendschat.bottom_sheet.NewPackageBepicBts
import com.app.friendschat.bottom_sheet.SharingAndAddingStickerPackBepicBts
import com.app.friendschat.data.model.PackageModel
import com.app.friendschat.databinding.LayoutNewPackageItemCreatedPackageRftBinding
import com.app.friendschat.databinding.LayoutNormalItemCreatedPackageRftBinding
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class CreatedPackageAdapter(
    private val packages: MutableList<PackageModel>,
    private val createdPackageFragment: CreatedPackageBepicFragmentRft
): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return if (viewType == ViewType.NEW_PACKAGE.value) {
            val binding = DataBindingUtil.inflate<LayoutNewPackageItemCreatedPackageRftBinding>(LayoutInflater.from(parent.context), R.layout.layout_new_package_item_created_package_rft, parent, false)
            NewPackageViewHolder(binding)
        } else {
            val binding = DataBindingUtil.inflate<LayoutNormalItemCreatedPackageRftBinding>(LayoutInflater.from(parent.context), R.layout.layout_normal_item_created_package_rft, parent, false)
            NormalViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is NewPackageViewHolder) {
            holder.bind(createdPackageFragment)
        } else if (holder is NormalViewHolder) {
            holder.bind(packages[position - 1], createdPackageFragment)
        }
    }

    override fun getItemCount(): Int {
        return packages.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            ViewType.NEW_PACKAGE.value
        } else {
            ViewType.NORMAL.value
        }
    }

    private class NewPackageViewHolder(val binding: LayoutNewPackageItemCreatedPackageRftBinding): ViewHolder(binding.root) {
        fun bind(createdPackageFragment: CreatedPackageBepicFragmentRft) {
            binding.root.tapAndCheckInternet {
                val newPackageBottomSheet = NewPackageBepicBts {
                    createdPackageFragment.viewModel.refreshAdapterWithNewList()
                }
                newPackageBottomSheet.show(createdPackageFragment.requireActivity().supportFragmentManager, newPackageBottomSheet.tag)

                EventTracking.logEvent(createdPackageFragment.requireActivity(), EventTracking.EVENT_NAME_CREATION_PACKAGE_NEW_CLICK)
            }
        }
    }

    private class NormalViewHolder(val binding: LayoutNormalItemCreatedPackageRftBinding): ViewHolder(binding.root) {
        fun bind(packageModel: PackageModel, createdPackageFragment: CreatedPackageBepicFragmentRft) {
            binding.tvTitle.text = packageModel.packageName

            val numberOfSticker = packageModel.stickers.size
            binding.tvNumberOfSticker.text = if (numberOfSticker > 1) {
                "$numberOfSticker ${binding.root.context.getString(R.string.items)}"
            } else {
                "$numberOfSticker ${binding.root.context.getString(R.string.item)}"
            }

            binding.pbIcon.visibility = View.VISIBLE

            if (packageModel.stickers.isEmpty()) {
                binding.pbIcon.visibility = View.GONE
                binding.ivIcon.setImageResource(R.drawable.new_img_create)
            } else {
                Glide.with(binding.root.context)
                    .load(packageModel.stickers[0].url)
                    .listener(object : RequestListener<Drawable> {
                        override fun onResourceReady(
                            resource: Drawable,
                            model: Any,
                            target: Target<Drawable>?,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            binding.pbIcon.visibility = View.GONE
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
                    .into(binding.ivIcon)
            }

            binding.ivDots.tapAndCheckInternet {

                EventTracking.logEvent(createdPackageFragment.requireActivity(), EventTracking.EVENT_NAME_CREATION_PACKAGE_MORE_CLICK)

                if (packageModel.stickers.isEmpty()) {
                    Toast.makeText(createdPackageFragment.requireActivity(), createdPackageFragment.requireActivity().getString(R.string.there_is_no_item_in_this_folder), Toast.LENGTH_SHORT).show()
                    return@tapAndCheckInternet
                }

                createdPackageFragment.viewModel.loadStickers(createdPackageFragment.requireActivity(), packageModel.stickers)

                var bottomSheet: SharingAndAddingStickerPackBepicBts? = null
                bottomSheet = SharingAndAddingStickerPackBepicBts(
                    onClickAddToTelegram = {
                        createdPackageFragment.viewModel.addToTelegram(createdPackageFragment.requireActivity(), packageModel)
                    },
                    onClickAddToWhatsApp = {
                        createdPackageFragment.viewModel.addToWhatsapp(createdPackageFragment, packageModel)
                    },
                    onClickDownload = {
                        createdPackageFragment.viewModel.downloadImages(createdPackageFragment.requireActivity(), packageModel) {
                            bottomSheet?.dismiss()
                        }
                    },
                    onClickShare = {
                        createdPackageFragment.viewModel.shareImages(createdPackageFragment.requireActivity(), packageModel)
                    }
                )
                bottomSheet.show(createdPackageFragment.childFragmentManager,"SharingAndAddingStickerPack")
            }

            binding.root.tapAndCheckInternet {

                if (packageModel.stickers.isEmpty()) {
                    Toast.makeText(createdPackageFragment.requireActivity(), createdPackageFragment.requireActivity().getString(R.string.there_is_no_item_in_this_folder), Toast.LENGTH_SHORT).show()
                    return@tapAndCheckInternet
                }

                createdPackageFragment.viewModel.navigateToStickerPackDetail(createdPackageFragment, packageModel.packageName)
            }
        }
    }

    private enum class ViewType(val value: Int) {
        NEW_PACKAGE(0),
        NORMAL(1)
    }
}