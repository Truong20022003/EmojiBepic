package com.app.friendschat.ui.emoji

import android.content.Context
import com.app.friendschat.R
import com.app.friendschat.data.model.OptionsModel
import com.app.friendschat.databinding.ItemOptionsBinding
import com.app.friendschat.ui.base.BaseAdapter

class OptionsAdapter(
    var context: Context,
    var listOptions: MutableList<OptionsModel>,
    var onClickItem: (OptionsModel, Int) -> Unit
) : BaseAdapter<ItemOptionsBinding, OptionsModel>(listOptions) {
    override val layoutRes: Int
        get() = R.layout.item_options

    override fun createVH(binding: ItemOptionsBinding): BaseVH = OptionsViewModel(binding)

    inner class OptionsViewModel(val binding: ItemOptionsBinding) : BaseVH(binding) {
        override fun onItemClickListener(position: Int, data: OptionsModel) {
            onClickItem.invoke(data, position)
        }

        override fun bind(data: OptionsModel) {
            super.bind(data)
            binding.viewModel = data

            if (data.isSelectPage){
                binding.tvOption.setTextColor(context.resources.getColor(R.color.color_095467))
                binding.ivOption.setImageDrawable(context.resources.getDrawable(data.photoOptionsSelect))
                binding.rlItem.setBackgroundResource(R.drawable.border_bg_item_options_select)
            }else{
                binding.tvOption.setTextColor(context.resources.getColor(R.color.color_0C111D))
                binding.ivOption.setImageDrawable(context.resources.getDrawable(data.photoOptionsUnSelect))
                binding.rlItem.setBackgroundResource(R.drawable.border_bg_item_options)
            }

            binding.tvOption.text = data.nameOptions

        }
    }
}