package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empregaeu4.databinding.ActivityTela3Binding

class Tela3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView5 = binding.textView5
        val pontoRecuperado = intent.getStringExtra("pontos")
        val recycler = binding.recycler
        val pontoInt = pontoRecuperado!!.toInt()
        textView5.text = pontoRecuperado

        val itemStore = ArrayList<ItensStore>()
        itemStore.add(ItensStore("Cupom Estádio", "2000") )
        itemStore.add(ItensStore("Voucher Academia", "1000") )
        itemStore.add(ItensStore("Desconto Imposto de Renda", "5000") )
        val adapter = ItensAdapter(applicationContext, itemStore)
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.adapter = adapter
    }

}