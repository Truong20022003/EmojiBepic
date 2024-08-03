package com.app.friendschat.ui.emoji

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class MyItemTouchHelperCallback(
    private val adapter: LayerEmojiAdapter
) : ItemTouchHelper.Callback(){
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlags)
    }
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        // Lấy vị trí hiện tại và vị trí mục tiêu
        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition

        adapter.onItemMove(fromPosition, toPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (shouldAllowSwipe(viewHolder.adapterPosition)) {
            // Thực hiện xóa mục
            adapter.onItemDismiss(viewHolder.adapterPosition)
        } else {
            // Nếu không cho phép xóa, thì gửi thông báo để cập nhật lại RecyclerView
            adapter.notifyItemChanged(viewHolder.adapterPosition)
        }
    }

    private fun shouldAllowSwipe(position: Int): Boolean {
        //return true nếu muốn cho phép vuốt, return false nếu không
        return false
    }
}