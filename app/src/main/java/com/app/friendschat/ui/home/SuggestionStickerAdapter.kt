package com.app.friendschat.ui.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.friendschat.R
import com.app.friendschat.bottom_sheet.SharingAndAddingStickerPackBepicBts
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.StickerPackInfo
import com.app.friendschat.databinding.FragmentHomeBepicRftBinding
import com.app.friendschat.databinding.LayoutSuggestionItemRftBinding
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.sticker_pack_detail.StickerPackDetailBepicActivityRft
import com.app.friendschat.utils.AssetUtils
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class SuggestionStickerAdapter(
    private val fragment: BaseFragment<HomeViewModel, FragmentHomeBepicRftBinding>,
) : RecyclerView.Adapter<SuggestionStickerAdapter.SuggestionStickerViewHolder>() {

    private val list = AssetUtils.stickerPacksInfo.map { it.copy() }.toMutableList()
    private val listTemp = AssetUtils.stickerPacksInfo.map { it.copy() }

    fun filter(text: String): Int {
        val temp = ArrayList<StickerPackInfo>()
        for (d in listTemp) {
            if (d.title.lowercase().startsWith(text.lowercase())) {
                temp.add(d)
            }
        }
        list.clear()
        list.addAll(temp)
        notifyDataSetChanged()

        return temp.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionStickerViewHolder {
        val binding: LayoutSuggestionItemRftBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_suggestion_item_rft, parent, false)
        return SuggestionStickerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SuggestionStickerViewHolder, position: Int) {
        holder.bind(fragment, list[position])
    }

    class SuggestionStickerViewHolder(val binding: LayoutSuggestionItemRftBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(fragment: BaseFragment<HomeViewModel, FragmentHomeBepicRftBinding>, data: StickerPackInfo) {
            binding.tvTitle.text = data.title

            val size = data.stickers.size
            binding.tvNumberOfSticker.text = if (size > 1) {
                "$size ${fragment.requireActivity().getString(R.string.stickers)}"
            } else {
                "$size ${fragment.requireActivity().getString(R.string.sticker)}"
            }

            binding.pbIcon.visibility = View.VISIBLE
            Glide.with(fragment.requireActivity()).load(data.iconUrl)
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

            if (data.stickers.isNotEmpty()) {
                binding.pb1.visibility = View.VISIBLE
                Glide.with(fragment.requireActivity()).load(data.stickers[0].url)
                    .listener(object : RequestListener<Drawable> {
                        override fun onResourceReady(
                            resource: Drawable,
                            model: Any,
                            target: Target<Drawable>?,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            binding.pb1.visibility = View.GONE
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
                    .into(binding.ivImage1)
            }

            if (data.stickers.size > 1) {
                binding.pb2.visibility = View.VISIBLE
                Glide.with(fragment.requireActivity()).load(data.stickers[1].url)
                    .listener(object : RequestListener<Drawable> {
                        override fun onResourceReady(
                            resource: Drawable,
                            model: Any,
                            target: Target<Drawable>?,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            binding.pb2.visibility = View.GONE
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
                    .into(binding.ivImage2)
            }

            if (data.stickers.size > 2) {
                binding.pb3.visibility = View.VISIBLE
                Glide.with(fragment.requireActivity()).load(data.stickers[2].url)
                    .listener(object : RequestListener<Drawable> {
                        override fun onResourceReady(
                            resource: Drawable,
                            model: Any,
                            target: Target<Drawable>?,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            binding.pb3.visibility = View.GONE
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
                    .into(binding.ivImage3)
            }

            binding.ivDots.tapAndCheckInternet {
                showBottomSheet(fragment, data)
                EventTracking.logEvent(fragment.requireActivity(), EventTracking.EVENT_NAME_SUGGESTED_PACKAGE_MORE_CLICK)
            }

            binding.root.tapAndCheckInternet {
                val bundle = Bundle()
                bundle.putString(Constants.BUNDLE_SUGGESTION_STICKER_TITLE, data.title)
                bundle.putSerializable(Constants.BUNDLE_FROM_ACTIVITY, FromActivity.HOME)
                fragment.showActivity(StickerPackDetailBepicActivityRft::class.java, bundle)

//                    AdsUtils.loadInterSuggest(fragment.requireActivity())

                val bundleEvent = Bundle()
                bundleEvent.putString("package_name", data.title)
                EventTracking.logEvent(fragment.requireActivity(), EventTracking.EVENT_NAME_HOME_SUGGESTED_PACKAGE_CLICK)
            }
        }

        private fun showBottomSheet(fragment: BaseFragment<HomeViewModel, FragmentHomeBepicRftBinding>, data: StickerPackInfo) {

            fragment.viewModel.loadStickers(fragment.requireActivity(), data)

            var bottomSheet: SharingAndAddingStickerPackBepicBts? = null
            bottomSheet = SharingAndAddingStickerPackBepicBts(
                onClickAddToTelegram = {
                    fragment.viewModel.addToTelegram(fragment.requireActivity())
                },
                onClickAddToWhatsApp = {
                    fragment.viewModel.addToWhatsapp(fragment as HomeBepicFragmentRft, data)
                },
                onClickDownload = {
                    fragment.viewModel.downloadImages(fragment.requireActivity()) {
                        bottomSheet?.dismiss()
                    }
                },
                onClickShare = {
                    fragment.viewModel.shareImages(fragment.requireActivity())
                }
            )
            bottomSheet.show(fragment.childFragmentManager,"SharingAndAddingStickerPack")
        }
    }
}