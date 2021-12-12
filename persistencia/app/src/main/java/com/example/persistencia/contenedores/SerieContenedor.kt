package com.example.persistencia.contenedores

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.persistencia.R
import com.example.persistencia.databinding.ListaSeriesItemBinding
import com.example.persistencia.entidades.Serie

//Metodo 1 : tradicional con vista
//class serieContenedor( val view: View):RecyclerView.ViewHolder(view){

// val poster: ImageView
// val titulo: TextView
// val argumento: TextView

//  init {
//  poster    = view.findViewById(R.id.imagenSerie)
//    titulo    = view.findViewById(R.id.tituloSerie)
//    argumento = view.findViewById(R.id.descripcionSerie)
//  }
//}

//Metodo 2: Vinculacion de vistas
class serieContenedor(val binding: ListaSeriesItemBinding,
                      val lambda :(Serie) -> Unit): RecyclerView.ViewHolder(binding.root){


    fun bindSerie(serie: Serie) {
        binding.tituloSerie.text = serie.titulo
        binding.descripcionSerie.text = serie.argumento
        // Mostrar el poster
        Glide.with(binding.root).load(serie.poster).into(binding.imagenSerie)

        binding.root.setOnClickListener { lambda(serie) }

        // Al realizar pulsación larga en el contenedor
        /** binding.root.setOnLongClickListener {
            val pop = PopupMenu(binding.root.context, it)
            pop.inflate(R.menu.menu_lista)
            pop.setOnMenuItemClickListener{}
            pop.show()
        }
         **/
    }

}