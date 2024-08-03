package com.app.friendschat.ui.emoji

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.friendschat.R
import com.app.friendschat.data.model.IconModel
import com.app.friendschat.data.model.OptionsModel

class PagerIconAdapter(
    var context: Context,
    var listPager: MutableList<OptionsModel>,
    var onClickItem: (IconModel, Int, Int) -> Unit,
    var onShowAdsReward: (IconModel, Int, Int) -> Unit
): RecyclerView.Adapter<PagerIconAdapter.ViewHolder>() {

    private lateinit var iconAdapter: IconAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pager_icon, parent,false))
    }

    override fun getItemCount(): Int {
        return listPager.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listPager[position].listIcon
        holder.rvIcon.apply {
            iconAdapter = IconAdapter(
                context,
                data,
                onClickIcon = { iconModel, i ->
                    onClickItem.invoke(iconModel,i, position)
                },
                onShowAdsReward = { iconModel, i ->
                    onShowAdsReward.invoke(iconModel,i,position)
                }
            )
            adapter = iconAdapter
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvIcon: RecyclerView = itemView.findViewById(R.id.rv_icon);
    }
    public fun updateNotifyMoveIcon(pos:Int){
        iconAdapter.notifyItemChanged(pos)
    }
    public fun updateNotifyDeleteIcon(pos:Int){
        iconAdapter.notifyItemInserted(pos)
    }
}