package com.example.empregaeu4

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItensAdapter(val context: Context, val itens: ArrayList<ItensStore>): RecyclerView.Adapter<ItensViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItensViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_de_itens, parent, false)
        val holder = ItensViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ItensViewHolder, position: Int) {
        val store = itens.get(position)
        holder.item.text = store.itemNome
        holder.preco.text = store.preco

    }

}