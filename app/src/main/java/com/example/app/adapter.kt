package com.example.app

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView

class adapter(var ds: ArrayList<data>): RecyclerView.Adapter<adapter.holder>() {
    inner class holder(list : View) : RecyclerView.ViewHolder(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return holder(view)
    }

    override fun getItemCount(): Int {
        return ds.size
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.itemView.apply {

        }
    }

}