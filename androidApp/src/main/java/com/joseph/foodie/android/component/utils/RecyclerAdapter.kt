package com.joseph.foodie.android.component

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter<T:View>(
    private val viewClass : Class<T>,
    private val callback: ((T,Int)->Unit)) :
    RecyclerView.Adapter<ItemViewHolder<T>>() {
    private var list:List<Any> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<T> {
        val constructor  = viewClass.getConstructor(Context::class.java)
        val view  = constructor.newInstance(parent.context)
        return ItemViewHolder(view)
    }

    override  fun  onBindViewHolder(holder: ItemViewHolder<T>, position: Int) {
        callback(holder.itemView as T, position)
    }

    fun swapItems(newItems: List<Any>) {
        if (newItems == null) return
        list = newItems
        // Force the RecyclerView to refresh
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class ItemViewHolder<T:View>(itemView: T) : RecyclerView.ViewHolder(itemView)
