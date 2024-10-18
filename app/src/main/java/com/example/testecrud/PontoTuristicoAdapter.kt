package com.example.testecrud

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class PontoTuristicoAdapter(private val pontos: List<PontoTuristico>) :
    Adapter<PontoTuristicoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTextView: TextView = itemView.findViewById(R.id.textViewNomeData)
        val descricaoTextView: TextView = itemView.findViewById(R.id.textViewDescData)
        val fotoImageView: ImageView = itemView.findViewById(R.id.ivFotoItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pontos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ponto = pontos[position]
        holder.nomeTextView.text = ponto.name
        holder.descricaoTextView.text = ponto.description
        val bitmap = ponto.photo?.let { BitmapFactory.decodeByteArray(ponto.photo, 0, it.size) }
        holder.fotoImageView.setImageBitmap(bitmap)
    }
}