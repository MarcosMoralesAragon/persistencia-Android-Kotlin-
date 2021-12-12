package com.example.persistencia

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persistencia.daos.serieDAO
import com.example.persistencia.daos.usuarioDAO
import com.example.persistencia.entidades.Serie
import com.example.persistencia.entidades.Usuario


@Database(entities = arrayOf(Usuario::class, Serie::class), version=2)
abstract class AppDataBase: RoomDatabase() {

    abstract fun usuarioDao():usuarioDAO
    abstract fun serieDao():serieDAO

    companion object{ // Como una clase estatica

        @Volatile
        private var instancia: AppDataBase? = null

        fun getAppDatabase(context: Context):AppDataBase{

            return instancia?: synchronized(this){
                Room.databaseBuilder(context, AppDataBase::class.java, "basededatos")
                    .allowMainThreadQueries()
                    .build()
                    .also { instancia = it }
            }
        }
    }

}

