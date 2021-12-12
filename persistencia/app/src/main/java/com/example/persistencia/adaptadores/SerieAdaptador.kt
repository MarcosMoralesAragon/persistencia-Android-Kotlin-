package com.example.persistencia.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.persistencia.R
import com.example.persistencia.entidades.Serie
import com.example.persistencia.contenedores.serieContenedor
import com.example.persistencia.databinding.ListaSeriesItemBinding


class serieAdaptador(val coleccion:List<Serie>,
                     val lambda :(Serie) -> Unit):RecyclerView.Adapter<serieContenedor>() {
    override fun getItemCount(): Int = coleccion.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): serieContenedor { // devuelve el contenedor vacio

        // Metodo 1
        // val layout = LayoutInflater.from(parent.context).inflate(R.layout.lista_series_item, parent, false)
        // return serieContenedor(layout)

        // Metodo 2
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListaSeriesItemBinding.inflate(inflater, parent, false)
        return serieContenedor(binding, lambda)

    }

    override fun onBindViewHolder(holder: serieContenedor, position: Int) {
        holder.bindSerie(coleccion[position])

    }
    // fun insertar(serie : List<Serie>){
    // }
}