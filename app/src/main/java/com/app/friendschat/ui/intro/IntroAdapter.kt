package com.app.friendschat.ui.intro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.friendschat.R
import com.app.friendschat.data.model.IntroModel

class IntroAdapter (private val list: List<IntroModel>) : RecyclerView.Adapter<IntroAdapter.TutorialAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialAdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_intro, parent, false)
        return TutorialAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: TutorialAdapterHolder, position: Int) {
        val helpGuidModel = list[position]
        if(position == 0 || position == 1){
            holder.img_guide.setImageResource(helpGuidModel.photo)
            holder.tvTile.text = list[position].title
            holder.tvContent.text =  list[position].content
        }else{
            holder.img_guide.setImageResource(helpGuidModel.photo)
            holder.tvTile.text = list[position].title
            holder.tvContent.text =  list[position].content
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TutorialAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_guide: ImageView = itemView.findViewById(R.id.img_guide)
        val tvTile: TextView = itemView.findViewById(R.id.tvTile)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)
    }
}