package com.example.persistencia

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.persistencia.adaptadores.serieAdaptador
import com.example.persistencia.daos.serieDAO
import com.example.persistencia.daos.usuarioDAO
import com.example.persistencia.databinding.ActivityMainBinding
import com.example.persistencia.entidades.Serie
import com.example.persistencia.entidades.Usuario

class MainActivity : AppCompatActivity() {

    private var db:AppDataBase? = null
    private var usuarioDao: usuarioDAO? = null
    private var serieDao: serieDAO? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuarioBuscado = db?.usuarioDao()?.obtenerUsuario("2")
        var usuario: Usuario;

        db = AppDataBase.getAppDatabase(this)
        var datos = db?.serieDao()?.obtenerSeries()
        var adaptador = serieAdaptador(datos!!){
            Toast.makeText(this,"Has pulsado el item : ${it.titulo}", Toast.LENGTH_LONG).show()
        }

        binding.rvSeries.apply {
           adapter = adaptador
           layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
        }

        with(binding){
            buttonAdd.setOnClickListener {
                val serie = Serie(titulo = "House", fecha = "2021/11/31", argumento = "Doctor de medicina que resuelve las cosas a su manera", poster = "https://www.themoviedb.org/t/p/w1280/lW7MvZ4m49IUj2UrUu4z0xVVl81.jpg", idSerie = 5)
                datos.add(serie);
                adaptador.notifyItemInserted(datos.size - 1)
            }
            buttonModify.setOnClickListener {
                datos[0].titulo="Fundacion Modificado"
                adaptador.notifyItemChanged(0)
            }
            buttonRemove.setOnClickListener {
                datos.removeAt(2)
                adaptador.notifyItemRemoved(2)
            }
        }
    }
    fun iniciarBaseDeDatos(){
        db?.serieDao()?.insertarSerie(
            Serie(1, "Fundación", "2021-11-11", "Basada en la fascinante obra de Isaac Asimov, Foundation gira en torno a un grupo de exiliados en el ocaso del Imperio Galáctico y su afán por salvar a la humanidad y reconstruir la civilización.", "https://www.themoviedb.org/t/p/w1280/iXU619XXLivE6Mj3dKxlfSQJebq.jpg"),
            Serie(2, "Peaky Blinders", "2021-11-11", "En Gran Bretaña, Reino Unido se recuperan de la desesperación de la Gran Guerra, las personas sobreviven a como pueden, y las bandas criminales proliferan en una nación sacudida económicamente. Es justamente aquí donde una familia de gánsteres irlandeses de origen nómada (a veces llamados gitanos o chatarreros) asentada en Birmingham (los Peaky Blinders) justo después de la Primera Guerra Mundial, dirigen un local de apuestas hípicas en la ciudad. Las acciones del ambicioso, respetado, temerario y peligroso jefe de la banda, Thomas Shelby, llaman la atención del Inspector jefe Chester Campbell, un detective de la Real Policía Irlandesa que es enviado por el mismo Winston Churchill desde Belfast donde había sido enviado a limpiar la ciudad del Ejército Republicano Irlandés (IRA), comunistas, pandillas y delincuentes comunes", "https://www.themoviedb.org/t/p/w1280/5mQlikvrHD0IGi1p35FEzLBErMp.jpg"),
            Serie(3, "The Good Doctor", "2017-10-25", "Un cirujano joven y autista que padece el síndrome del sabio empieza a trabajar en un hospital prestigioso. Allá tendrá que vencer el escepticismo con el que sus colegas lo reciben.", "https://www.themoviedb.org/t/p/w1280/elibbi9XfA4nJEsoJcOJBZ0LZn3.jpg"),
            Serie(4, "Ojo de halcon", "2021-11-24", "Ahora como un ex Vengador se encuentra en una misión simple: la de reunirse con su familia por Navidad. Pero no lo tendrá tan fácil cuando alguien del pasado de Barton amenaza con echar a perder mucho más que el espíritu navideño. Pero no se encontrará solo, ya que tendrá la ayuda de Kate Bishop, una arquera de 22 años que sueña con un día en convertirse en una super heroína que siempre ha soñado llegar a ser.", "https://www.themoviedb.org/t/p/w1280/ommKNzt6wmtz3mQS3e3rrDnISOM.jpg"))
    }
}