package com.app.friendschat.ui.emoji

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.app.friendschat.R
import com.app.friendschat.data.model.IconModel
import com.app.friendschat.databinding.ItemIconBinding
import com.app.friendschat.ui.base.BaseAdapter

class IconAdapter(
    var context: Context,
    var listIcon: MutableList<IconModel>,
    var onClickIcon: (IconModel, Int) -> Unit,
    var onShowAdsReward: (IconModel, Int) -> Unit
) : BaseAdapter<ItemIconBinding, IconModel>(listIcon) {
    override val layoutRes: Int
        get() = R.layout.item_icon

    override fun createVH(binding: ItemIconBinding): BaseVH = IconViewModel(binding)

    inner class IconViewModel(val binding: ItemIconBinding) : BaseVH(binding) {
        override fun onItemClickListener(position: Int, data: IconModel) {
//            if (position != 0 && (position + 1) % 3 == 0) {
//                //logic hiển thị ads
//                if (data.isShowAds) {
//                    onShowAdsReward.invoke(data, position)
//                }else{
//                    //ads đã được k cần xem ads
//                    onClickIcon.invoke(data, position)
//                    notifyItemChanged(position)
//                }
//            } else {
//                onClickIcon.invoke(data, position)
////            binding.rlIcon.setBackgroundDrawable(context.getDrawable(R.drawable.border_select_emoji))
//                notifyItemChanged(position)
//            }

            onClickIcon.invoke(data, position)
//            binding.rlIcon.setBackgroundDrawable(context.getDrawable(R.drawable.border_select_emoji))
            notifyItemChanged(position)
        }

        override fun bind(data: IconModel) {
            super.bind(data)
            binding.viewModel = data
//            binding.ivAds.visibility = View.GONE
//
//            if (position != 0 && (position+1) %3 == 0){
//                //logic hiển thị icon ads
//                if (data.isShowAds){
//                    binding.ivAds.visibility = View.VISIBLE
//                }else{
//                    binding.ivAds.visibility = View.GONE
//                }
//            }

            if (data.isSelect) {
                binding.rlIcon.setBackgroundDrawable(context.getDrawable(R.drawable.border_select_emoji))
            } else {
                binding.rlIcon.setBackgroundDrawable(context.getDrawable(R.drawable.bg_item_icon))
            }

            binding.pbIcon.visibility = View.VISIBLE

            Glide.with(context).load(data.path).listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

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

            })
                .into(binding.ivIcon)

        }
    }
}