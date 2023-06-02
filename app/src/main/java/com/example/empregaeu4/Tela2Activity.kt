package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empregaeu4.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val pontosUser = binding.pontosUsuario
        val pontosUserString = pontosUser.text.toString()
        val pontosUserInt = pontosUserString.toInt()
        val usuarioNome = binding.tvUsuarioNome
        val nome = intent.getStringExtra("nome")
        val btStore = binding.btStore
        val btRegister = binding.btRegister
        usuarioNome.text = nome


        btStore.setOnClickListener {
                val intent2 = Intent(this, ListaLojaActivity::class.java)
                val pontos = pontosUserString
                intent2.putExtra("pontos", pontos)
                startActivity(intent2)
            }

        btRegister.setOnClickListener {
            val intent3 = Intent(this, CadastroItemActivity::class.java)
            startActivity(intent3)
        }
        //setContentView(R.layout.activity_tela2)
    }
}