package com.example.empregaeu4

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItensViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val item: TextView = itemView!!.findViewById(R.id.item)
    val preco: TextView = itemView!!.findViewById(R.id.preco)
}