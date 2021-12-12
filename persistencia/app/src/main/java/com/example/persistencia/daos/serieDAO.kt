package com.example.persistencia.daos

import androidx.room.*
import com.example.persistencia.entidades.Serie

@Dao
interface serieDAO {

    @Query("SELECT * FROM Serie;")
    fun obtenerSeries() : MutableList<Serie>

    @Insert
    fun insertarSerie(vararg serie: Serie)

    @Update
    fun actualizarSerie(vararg serie: Serie)

    @Delete
    fun borrarSerie(vararg serie: Serie)
}