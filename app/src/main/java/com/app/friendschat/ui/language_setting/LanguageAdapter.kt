package com.app.friendschat.ui.language_setting

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.app.friendschat.R
import com.app.friendschat.data.model.LanguageModel
import com.app.friendschat.utils.widget.tapAndCheckInternet

class LanguageAdapter(
    var context: Context,
    var list: List<LanguageModel>,
    var onClickItem: (LanguageModel, Int) -> Unit
) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_language_start, parent, false)
        )
    }

    fun updateData(newList: List<LanguageModel>) {
        list = newList
        notifyDataSetChanged()
    }

    fun setSelectedLanguage(selectedLanguage: LanguageModel) {
        for (data in list) {
            data.select = data == selectedLanguage
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data, context)

        Glide.with(context).load(data.photo).into(holder.ivAvatar)

        holder.itemView.tapAndCheckInternet {
            onClickItem.invoke(data, position)
        }

        if (data.select) {
            holder.rlBG.setBackgroundResource(R.drawable.border_select_language)
            holder.tvTitle.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            holder.tvTitle.setTextColor(Color.parseColor("#424242"))
            holder.rlBG.setBackgroundResource(R.drawable.border_not_select_language)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAvatar: ImageView = itemView.findViewById(R.id.iv_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_name)
        val rlBG: View = itemView.findViewById(R.id.rl_item)

        fun bind(serverModel: LanguageModel, context: Context) {
            tvTitle.text = serverModel.name
            if (serverModel.select) {
                rlBG.setBackgroundResource(R.drawable.border_select_language)
            } else {
                rlBG.setBackgroundResource(R.drawable.border_not_select_language)
            }
        }
    }

    fun setSelectLanguage(code: String) {
        for (data in list) {
            data.select = data.code == code
        }
        notifyDataSetChanged()
    }
}