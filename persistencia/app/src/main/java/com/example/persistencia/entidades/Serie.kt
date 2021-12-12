package com.example.persistencia.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Serie(
    @PrimaryKey(autoGenerate = true)   val idSerie: Int,
    @ColumnInfo(name="titulo")         var titulo: String,
    @ColumnInfo(name="fecha")          val fecha: String,
    @ColumnInfo(name="argumento")      val argumento: String,
    @ColumnInfo(name="poster")         val poster: String?)
