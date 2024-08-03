package com.app.friendschat.ui.emoji

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.app.friendschat.R
import com.app.friendschat.utils.custom_sticker.Sticker
import com.app.friendschat.utils.custom_sticker.StickerView
import com.app.friendschat.utils.widget.tapAndCheckInternet

class LayerEmojiAdapter(
    private var context: Context,
    private val stickerView: StickerView,
    private var listLayer: ArrayList<Sticker>,
    private var onClickLayer: (Sticker, Int) -> Unit
) : RecyclerView.Adapter<LayerEmojiAdapter.LayerViewHolder>() {

    private var selectItemPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LayerViewHolder {
        return LayerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_layer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LayerViewHolder, position: Int) {
        val model = listLayer[position]

        holder.tvName.text = "${context.resources.getText(R.string.Layer)} ${position + 1}"

        if (model.isHide) {
            //sticker đang bị ẩn
            holder.ivShowLayer.setImageDrawable(context.resources.getDrawable(R.drawable.ic_hide_layer))
        } else {
            //sticker đang được hiển thị
            holder.ivShowLayer.setImageDrawable(context.resources.getDrawable(R.drawable.ic_show_layer))
        }

        holder.pbLoading.visibility = View.VISIBLE
        Glide.with(context).load(model.drawable).listener(object : RequestListener<Drawable> {
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
                holder.pbLoading.visibility = View.GONE
                return false
            }

        }).into(holder.ivLayer)

        holder.ivShowLayer.tapAndCheckInternet {
            if (model.isHide) {
                //sticker đang bị ẩn -> cần mở show
                holder.ivShowLayer.setImageDrawable(context.resources.getDrawable(R.drawable.ic_show_layer))
            } else {
                //sticker đang được hiển thị -> ẩn
                holder.ivShowLayer.setImageDrawable(context.resources.getDrawable(R.drawable.ic_hide_layer))
            }
            stickerView.hideOrShowSticker(model, position)
        }

        holder.itemView.tapAndCheckInternet {
            val clickPosition = holder.adapterPosition
            if (clickPosition != RecyclerView.NO_POSITION) {
                selectItemPosition = clickPosition
                notifyDataSetChanged()
                onClickLayer.invoke(model, position)
            }
        }
        holder.itemView.setBackgroundColor(
            if (position == selectItemPosition) context.resources.getColor(R.color.color_DCE7FF)
            else context.resources.getColor(R.color.white)
        )
    }

    override fun getItemCount(): Int {
        return listLayer.size
    }

    class LayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivShowLayer: ImageView = itemView.findViewById(R.id.iv_show_layer)
        val ivLayer: ImageView = itemView.findViewById(R.id.iv_layer)
        val pbLoading: ProgressBar = itemView.findViewById(R.id.pb_loading)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val ivSwap: ImageView = itemView.findViewById(R.id.iv_swap)

    }
    fun onItemMove(fromPosition: Int, toPosition: Int) {
        stickerView.swapLayers(fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    fun onItemDismiss(position: Int) {
        listLayer.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setListData(newListSTicker: ArrayList<Sticker>){
        listLayer = newListSTicker
        notifyDataSetChanged()
    }
}