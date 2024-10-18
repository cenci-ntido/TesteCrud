package com.example.testecrud

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Lista : AppCompatActivity() {

    private lateinit var dbHandler: DBHandler
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista)

        // Inicializa o banco de dados
        dbHandler = DBHandler(this)

        // Carrega os pontos turísticos da base de dados
        val recyclerView = findViewById<RecyclerView>(R.id.recycleListaPontos)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = PontoTuristicoAdapter(carregarPontosTuristicos())
    }

    // Função para carregar os pontos turísticos cadastrados e exibi-los na TextView
    private fun carregarPontosTuristicos(): List<PontoTuristico> {
        return dbHandler.buscarPontosTuristicos()  // Busca todos os pontos
    }
}
