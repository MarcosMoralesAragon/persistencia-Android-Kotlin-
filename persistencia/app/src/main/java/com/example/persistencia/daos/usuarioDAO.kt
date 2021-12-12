package com.example.persistencia.daos

import androidx.room.*
import com.example.persistencia.entidades.Usuario

@Dao
interface usuarioDAO {

    @Query("SELECT * FROM usuario WHERE uid = :uid")
    fun obtenerUsuario(uid:String): Usuario

    @Insert
    fun insertarUsuario(vararg usuario: Usuario)

    @Update
    fun actualizarUsuario(usuario: Usuario)

    @Delete
    fun borrarUsuario(usuario: Usuario)
}