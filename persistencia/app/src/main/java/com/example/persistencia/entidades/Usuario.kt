package com.example.persistencia.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(@PrimaryKey val uid:String,
                   @ColumnInfo(name="email") val email:String,
                   @ColumnInfo(name="nombre") val nombre:String,
                   @ColumnInfo(name="apellido") val ape:String,
                   @ColumnInfo(name="foto")  val foto:String?)