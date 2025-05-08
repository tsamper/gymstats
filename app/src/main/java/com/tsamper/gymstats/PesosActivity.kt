package com.tsamper.gymstats

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class PesosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pesos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val prefs = getSharedPreferences("MiAppPrefs", Context.MODE_PRIVATE)

        //Espalda
        val remoDorsal: EditText = findViewById(R.id.remoDorsalesNumber)
        val remoAlta: EditText = findViewById(R.id.remoAltaNumber)
        val jalon: EditText = findViewById(R.id.jalonNumber)
        val jalonDorsales: EditText = findViewById(R.id.jalonDorsalesNumber)
        //Pecho
        val pressBanca: EditText = findViewById(R.id.pressBancaNumber)
        val pressBancaMancuernas: EditText = findViewById(R.id.pressBancaMancuernasNumber)
        val aperturasPecho: EditText = findViewById(R.id.aperturasPechoNumber)
        //Biceps
        val curlBiceps: EditText = findViewById(R.id.curlBicepsNumber)
        val curlMartillo: EditText = findViewById(R.id.curlMartilloNumber)
        //Triceps
        val pressFrances: EditText = findViewById(R.id.pressFrancesNumber)
        val poleaAbajo: EditText = findViewById(R.id.poleaAbajoTriNumber)
        //Hombro
        val pressMilitar: EditText = findViewById(R.id.pressMilitarNumber)
        val aperturasHombro: EditText = findViewById(R.id.aperturasHombroNumber)
        //Pierna
        val gemelo: EditText = findViewById(R.id.gemeloNumber)

        val remoDorsalText: TextView = findViewById(R.id.remoDorsalText)
        val remoEspaldaAltaText: TextView = findViewById(R.id.remoEspaldaAltaText)
        val jalonText: TextView = findViewById(R.id.jalonText)
        val jalonDorsalesText: TextView = findViewById(R.id.jalonDorsalesText)
        val pressBancaText: TextView = findViewById(R.id.pressBancaText)
        val pressBancaMancuernasText: TextView = findViewById(R.id.pressBancaMancuernasText)
        val aperturasPechoText: TextView = findViewById(R.id.aperturasPechoText)

        remoDorsal.setText(prefs.getInt("remoDorsal", 0).toString())
        remoAlta.setText(prefs.getInt("remoAlta", 0).toString())
        jalon.setText(prefs.getInt("jalon", 0).toString())
        jalonDorsales.setText(prefs.getInt("jalonDorsales", 0).toString())
        pressBanca.setText(prefs.getInt("pressBanca", 0).toString())
        pressBancaMancuernas.setText(prefs.getInt("pressBancaMancuernas", 0).toString())
        aperturasPecho.setText(prefs.getInt("aperturasPecho", 0).toString())
        curlBiceps.setText(prefs.getInt("curlBiceps", 0).toString())
        curlMartillo.setText(prefs.getInt("curlMartillo", 0).toString())
        pressFrances.setText(prefs.getInt("pressFrances", 0).toString())
        poleaAbajo.setText(prefs.getInt("poleaAbajo", 0).toString())
        pressMilitar.setText(prefs.getInt("pressMilitar", 0).toString())
        aperturasHombro.setText(prefs.getInt("aperturasHombro", 0).toString())
        gemelo.setText(prefs.getInt("gemelo", 0).toString())

        remoDorsalText.setOnClickListener{
            abrirVideo("7AcBBZNSx-I", 2)
        }
        remoEspaldaAltaText.setOnClickListener{
            abrirVideo("sQ-APCL4g8o", 2)
        }
        jalonText.setOnClickListener{
            abrirVideo("W2x6zP9k7SM", 2)
        }
        jalonDorsalesText.setOnClickListener{
            abrirVideo("n6ESW0L-SLY", 2)
        }
        pressBancaText.setOnClickListener{
            abrirVideo("qmb-6KOXvJI", 2)
        }
        pressBancaMancuernasText.setOnClickListener{
            abrirVideo("48L0oQApm_0", 2)
        }
        aperturasPechoText.setOnClickListener{
            abrirVideo("QHrIO139sWc", 2)
        }



        val botonEnviar: Button = findViewById(R.id.button)
        botonEnviar.setOnClickListener {
            with(prefs.edit()) {
                putInt("remoDorsal", remoDorsal.text.toString().toInt())
                putInt("remoAlta", remoAlta.text.toString().toInt())
                putInt("jalon", jalon.text.toString().toInt())
                putInt("jalonDorsales", jalon.text.toString().toInt())
                putInt("pressBanca", pressBanca.text.toString().toInt())
                putInt("pressBancaMancuernas", pressBancaMancuernas.text.toString().toInt())
                putInt("aperturasPecho", aperturasPecho.text.toString().toInt())
                putInt("curlBiceps", curlBiceps.text.toString().toInt())
                putInt("curlMartillo", curlMartillo.text.toString().toInt())
                putInt("pressFrances", pressFrances.text.toString().toInt())
                putInt("poleaAbajo", poleaAbajo.text.toString().toInt())
                putInt("pressMilitar", pressMilitar.text.toString().toInt())
                putInt("aperturasHombro", aperturasHombro.text.toString().toInt())
                putInt("gemelo", gemelo.text.toString().toInt())
                apply()
            }
        }
    }


    fun abrirVideo(url: String, tipo: Int){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = ("vnd.youtube:" + url).toUri() // Solo abre en app de YouTube
        intent.setPackage("com.google.android.youtube")

        // Fallback: si no tiene la app de YouTube, abre en navegador
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            if (tipo == 1) {
                val webIntent = Intent(
                    Intent.ACTION_VIEW,
                    ("https://www.youtube.com/watch?v=" + url).toUri()
                )
                startActivity(webIntent)
            }else{
                val webIntent = Intent(
                    Intent.ACTION_VIEW,
                    ("https://www.youtube.com/shorts/"+url).toUri()
                )
                startActivity(webIntent)
            }

        }
    }
}