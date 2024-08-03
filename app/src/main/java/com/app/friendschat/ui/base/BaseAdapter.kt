package com.app.friendschat.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.app.friendschat.utils.widget.tapAndCheckInternet

abstract class BaseAdapter<DB : ViewDataBinding, M>(var listData: MutableList<M>) :
    RecyclerView.Adapter<BaseAdapter<DB, M>.BaseVH>() {

    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected abstract fun createVH(binding: DB): BaseVH

    protected lateinit var recyclerView: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {
        val binding: DB = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), layoutRes, parent, false
        )
        return createVH(binding)
    }

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    fun addList(newList: MutableList<M>) {
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    fun insertList(fromIdx: Int, insertedList: MutableList<M>) {
        listData.addAll(fromIdx, insertedList)
        notifyItemRangeInserted(fromIdx, insertedList.size)
    }

    abstract inner class BaseVH(private val binding: DB) : RecyclerView.ViewHolder(binding.root) {
        init {

            binding.root.tapAndCheckInternet {
                try {
                    if (adapterPosition >= 0) {
                        onItemClickListener(adapterPosition, listData[adapterPosition])
                    }
                } catch (e:Exception){

                }
            }
        }

        open fun onItemClickListener(position: Int, data: M) = Unit

        open fun bind(data: M) {
            binding.setVariable(BR.model, data)
            binding.executePendingBindings()
        }
    }
}