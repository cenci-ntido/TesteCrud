package com.example.testecrud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testecrud.R
import com.example.testecrud.DBHandler

class Lista : AppCompatActivity() {

    private lateinit var dbHandler: DBHandler
    private lateinit var textListaPontos: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista)

        // Inicializa os elementos da interface
        btnVoltar = findViewById(R.id.btVoltar)
        textListaPontos = findViewById(R.id.tVPontosTuristicos)

        // Inicializa o banco de dados
        dbHandler = DBHandler(this)

        // Carrega os pontos turísticos da base de dados
        carregarPontosTuristicos()

        // Define a ação para o botão "Voltar"
        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    // Função para carregar os pontos turísticos cadastrados e exibi-los na TextView
    private fun carregarPontosTuristicos() {
        val pontosTuristicos = dbHandler.buscarPontosTuristicos()  // Busca todos os pontos
        val builder = StringBuilder()

        // Itera sobre os pontos turísticos e monta a string a ser exibida
        for (ponto in pontosTuristicos) {
            builder.append("Nome: ${ponto.name}\n")
            builder.append("Descrição: ${ponto.description}\n")
            builder.append("Latitude: ${ponto.latitude}\n")
            builder.append("Longitude: ${ponto.longitude}\n")
            builder.append("---------------\n")
        }

        // Verifica se existem pontos turísticos cadastrados
        if (builder.isEmpty()) {
            builder.append("Atenção: Nenhum ponto turístico registrado!")
        }

        // Exibe os pontos turísticos na TextView
        textListaPontos.text = builder.toString()
    }
}
