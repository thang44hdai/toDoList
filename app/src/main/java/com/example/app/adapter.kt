package com.example.app

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class adapter(var ds: ArrayList<data>): RecyclerView.Adapter<adapter.data_holder>() {
    inner class data_holder(list : View) : RecyclerView.ViewHolder(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): data_holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return data_holder(view)
    }

    override fun getItemCount(): Int {
        return ds.size
    }

    override fun onBindViewHolder(holder: data_holder, position: Int) {
        holder.itemView.apply{
            val tvname = findViewById<TextView>(R.id.tvname)
            val tvdate = findViewById<TextView>(R.id.tvdate)
            val cbtick = findViewById<CheckBox>(R.id.cbtick)
            val rB = findViewById<RatingBar>(R.id.rB)
            tvname.text = ds[position].name
        }
    }

}