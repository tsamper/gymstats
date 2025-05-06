package com.tsamper.gymstats

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val remoDorsal: EditText = findViewById(R.id.remoDorsalesNumber)
        val remoAlta: EditText = findViewById(R.id.remoAltaNumber)
        val polea: EditText = findViewById(R.id.poleaNumber)
        val pressBanca: EditText = findViewById(R.id.pressBancaNumber)
        val aperturasPecho: EditText = findViewById(R.id.aperturasPechoNumber)
        val curlBiceps: EditText = findViewById(R.id.curlBicepsNumber)
        val curlMartillo: EditText = findViewById(R.id.curlMartilloNumber)
        val pressMilitar: EditText = findViewById(R.id.pressMilitarNumber)
        val gemelo: EditText = findViewById(R.id.gemeloNumber)

        remoDorsal.setText(prefs.getInt("remoDorsal", 0).toString())
        remoAlta.setText(prefs.getInt("remoAlta", 0).toString())
        polea.setText(prefs.getInt("polea", 0).toString())
        pressBanca.setText(prefs.getInt("pressBanca", 0).toString())
        aperturasPecho.setText(prefs.getInt("aperturasPecho", 0).toString())
        curlBiceps.setText(prefs.getInt("curlBiceps", 0).toString())
        curlMartillo.setText(prefs.getInt("curlMartillo", 0).toString())
        pressMilitar.setText(prefs.getInt("pressMilitar", 0).toString())
        gemelo.setText(prefs.getInt("gemelo", 0).toString())

        val botonEnviar: Button = findViewById(R.id.button)
        botonEnviar.setOnClickListener {
            with(prefs.edit()) {
                putInt("remoDorsal", remoDorsal.text.toString().toInt())
                putInt("remoAlta", remoAlta.text.toString().toInt())
                putInt("polea", polea.text.toString().toInt())
                putInt("pressBanca", pressBanca.text.toString().toInt())
                putInt("aperturasPecho", aperturasPecho.text.toString().toInt())
                putInt("curlBiceps", curlBiceps.text.toString().toInt())
                putInt("curlMartillo", curlMartillo.text.toString().toInt())
                putInt("pressMilitar", pressMilitar.text.toString().toInt())
                putInt("gemelo", gemelo.text.toString().toInt())
                apply()
            }
        }
    }
}