package com.example.empregaeu4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoreAdapter(private val itemList: ArrayList<ItemModelo>) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.loja_list_item, parent, false)
        return ViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.tvItemName.text = currentItem.itemNome
        holder.tvItemPreco.text = currentItem.itemPreco
    }

    override fun getItemCount(): Int {
        return itemList.size
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvItemName : TextView = itemView.findViewById(R.id.tvItemName)
        val tvItemPreco : TextView = itemView.findViewById(R.id.tvItemPreco)
    }
}