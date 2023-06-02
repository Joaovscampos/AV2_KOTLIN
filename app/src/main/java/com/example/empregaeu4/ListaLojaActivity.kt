package com.example.empregaeu4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ListaLojaActivity : AppCompatActivity() {

    private lateinit var lojaRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var itemList: ArrayList<ItemModelo>
    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_loja)


        lojaRecyclerView = findViewById(R.id.listaItemLoja)
        lojaRecyclerView.layoutManager = LinearLayoutManager(this)
        lojaRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

         itemList = arrayListOf<ItemModelo>()

        getItensData()
    }

    private fun getItensData() {

        lojaRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Loja")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot){
                itemList.clear()
                if(snapshot.exists()){
                    for (lojaSnap in snapshot.children){
                        val lojaData = lojaSnap.getValue(ItemModelo::class.java)
                        itemList.add(lojaData!!)
                    }
                    val mAdapter = StoreAdapter(itemList)
                    lojaRecyclerView.adapter = mAdapter

                    lojaRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError){
                TODO("not yet implemented")
            }
        })

    }
}