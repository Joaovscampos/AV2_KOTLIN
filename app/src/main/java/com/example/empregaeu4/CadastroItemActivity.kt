package com.example.empregaeu4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.databinding.ActivityCadastroItemBinding
import com.example.empregaeu4.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroItemActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCadastroItemBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edItemRegister = binding.edItemRegister
        var edRegisterPreco = binding.edRegisterPreco
        var btCadastrar = binding.btRegisterItem

        dbRef = FirebaseDatabase.getInstance().getReference("Loja")

        btCadastrar.setOnClickListener{
            val itemNome = edItemRegister.text.toString()
            val itemPreco = edRegisterPreco.text.toString()

            if(itemNome.isEmpty()){
                edItemRegister.error = "Por favor insira um nome para o item"
            }else if (itemPreco.isEmpty()){
                edRegisterPreco.error = "Por favor insira um preço para o item"
            }else{
                val itemId = dbRef.push().key!!
                val loja = ItemModelo(itemId, itemNome, itemPreco)

                dbRef.child(itemId).setValue(loja)
                    .addOnCompleteListener {
                        Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show()

                        edItemRegister.text.clear()
                        edRegisterPreco.text.clear()
                    }.addOnFailureListener { err ->
                        Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                    }
            }



        }
    }
}