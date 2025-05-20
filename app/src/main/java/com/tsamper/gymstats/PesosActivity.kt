package com.tsamper.gymstats

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri
import org.w3c.dom.Text

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
        val trapecios: EditText = findViewById(R.id.trapeciosNumber)
        val remoT: EditText = findViewById(R.id.remoTNumber)
        val pesoMuerto: EditText = findViewById(R.id.pesoMuertoNumber)
        //Pecho
        val pressBanca: EditText = findViewById(R.id.pressBancaNumber)
        val pressBancaMancuernas: EditText = findViewById(R.id.pressBancaMancuernasNumber)
        val pressBancaMancuernasInclinado: EditText = findViewById(R.id.pressBancaMancuernasInclinadoNumber)
        val pechoInferiorMancuernas: EditText = findViewById(R.id.pechoInferiorMancuernasNumber)
        val pechoInferiorPolea: EditText = findViewById(R.id.pechoInferiorPoleaNumber)
        val aperturasPecho: EditText = findViewById(R.id.aperturasPechoNumber)
        //Biceps
        val curlMaquina: EditText = findViewById(R.id.curlMaquinaNumber)
        val curlInclinado: EditText = findViewById(R.id.curlInclinadoNumber)
        val curlBarra: EditText = findViewById(R.id.curlBarraNumber)
        val curlMartillo: EditText = findViewById(R.id.curlMartilloNumber)
        //Triceps
        val pressFrances: EditText = findViewById(R.id.pressFrancesNumber)
        val poleaAbajo: EditText = findViewById(R.id.poleaAbajoTriNumber)
        val fondosTriceps: EditText = findViewById(R.id.fondosTricepsNumber)
        //Hombro
        val pressMilitar: EditText = findViewById(R.id.pressMilitarNumber)
        val aperturasHombro: EditText = findViewById(R.id.aperturasHombroNumber)
        val hombroPosterior: EditText = findViewById(R.id.hombroPosteriorNumber)
        //Pierna
        val gemelo: EditText = findViewById(R.id.gemeloNumber)
        val extensionCuadriceps: EditText = findViewById(R.id.extensionCuadricepsNumber)
        val jaca: EditText = findViewById(R.id.jacaNumber)
        val prensa: EditText = findViewById(R.id.prensaNumber)
        val prensaAductor: EditText = findViewById(R.id.prensaAductorNumber)
        val gluteo: EditText = findViewById(R.id.gluteoNumber)
        val isquios: EditText = findViewById(R.id.isquiosNumber)

        val remoDorsalText: TextView = findViewById(R.id.remoDorsalText)
        val remoEspaldaAltaText: TextView = findViewById(R.id.remoEspaldaAltaText)
        val jalonText: TextView = findViewById(R.id.jalonText)
        val jalonDorsalesText: TextView = findViewById(R.id.jalonDorsalesText)
        val trapeciosText: TextView = findViewById(R.id.trapeciosText)
        val remoTText: TextView = findViewById(R.id.remoTText)
        val pesoMuertoText: TextView = findViewById(R.id.pesoMuertoText)
        val pressBancaText: TextView = findViewById(R.id.pressBancaText)
        val pressBancaMancuernasText: TextView = findViewById(R.id.pressBancaMancuernasText)
        val pressBancaMancuernasInclinadoText: TextView = findViewById(R.id.pressBancaMancuernasInclinadoText)
        val pechoInferiorMancuernasText: TextView = findViewById(R.id.pechoInferiorMancuernasText)
        val aperturasPechoText: TextView = findViewById(R.id.aperturasPechoText)
        val curlMaquinaText: TextView = findViewById(R.id.curlMaquinaText)
        val curlInclinadoText: TextView = findViewById(R.id.curlInclinadoText)
        val curlBarraText: TextView = findViewById(R.id.curlBarraText)
        val curlMartilloText: TextView = findViewById(R.id.curlMartilloText)
        val fondosTricepsText: TextView = findViewById(R.id.fondosTricepsText)
        val hombroPosteriorText: TextView = findViewById(R.id.hombroPosteriorText)
        val gemeloText: TextView = findViewById(R.id.gemeloText)
        val extensionCuadricepsText: TextView = findViewById(R.id.extensionCuadricepsText)
        val jacaText: TextView = findViewById(R.id.jacaText)
        val prensaText: TextView = findViewById(R.id.prensaText)
        val prensaAductorText: TextView = findViewById(R.id.prensaAductorText)
        val gluteoText: TextView = findViewById(R.id.gluteoText)
        val isquiosText: TextView = findViewById(R.id.isquiosText)

        remoDorsal.setText(prefs.getInt("remoDorsal", 0).toString())
        remoAlta.setText(prefs.getInt("remoAlta", 0).toString())
        jalon.setText(prefs.getInt("jalon", 0).toString())
        jalonDorsales.setText(prefs.getInt("jalonDorsales", 0).toString())
        trapecios.setText(prefs.getInt("trapecios", 0).toString())
        remoT.setText(prefs.getInt("remoT", 0).toString())
        pesoMuerto.setText(prefs.getInt("pesoMuerto", 0).toString())
        pressBanca.setText(prefs.getInt("pressBanca", 0).toString())
        pressBancaMancuernas.setText(prefs.getInt("pressBancaMancuernas", 0).toString())
        pressBancaMancuernasInclinado.setText(prefs.getInt("pressBancaMancuernasInclinado", 0).toString())
        pechoInferiorMancuernas.setText(prefs.getInt("pechoInferiorMancuernas", 0).toString())
        pechoInferiorPolea.setText(prefs.getInt("pechoInferiorPolea", 0).toString())
        aperturasPecho.setText(prefs.getInt("aperturasPecho", 0).toString())
        curlMaquina.setText(prefs.getInt("curlMaquina", 0).toString())
        curlInclinado.setText(prefs.getInt("curlInclinado", 0).toString())
        curlBarra.setText(prefs.getInt("curlBarra", 0).toString())
        curlMartillo.setText(prefs.getInt("curlMartillo", 0).toString())
        pressFrances.setText(prefs.getInt("pressFrances", 0).toString())
        poleaAbajo.setText(prefs.getInt("poleaAbajo", 0).toString())
        fondosTriceps.setText(prefs.getInt("fondosTriceps", 0).toString())
        pressMilitar.setText(prefs.getInt("pressMilitar", 0).toString())
        aperturasHombro.setText(prefs.getInt("aperturasHombro", 0).toString())
        hombroPosterior.setText(prefs.getInt("hombroPosterior", 0).toString())
        gemelo.setText(prefs.getInt("gemelo", 0).toString())
        extensionCuadriceps.setText(prefs.getInt("extensionCuadriceps", 0).toString())
        jaca.setText(prefs.getInt("jaca", 0).toString())
        prensa.setText(prefs.getInt("prensa", 0).toString())
        prensaAductor.setText(prefs.getInt("prensaAductor", 0).toString())
        gluteo.setText(prefs.getInt("gluteo", 0).toString())
        isquios.setText(prefs.getInt("isquios", 0).toString())

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
        pesoMuertoText.setOnClickListener{
            abrirVideo("3EhkrUEEPOg", 2)
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
        curlMaquinaText.setOnClickListener{
            abrirVideo("lj0Ue9U0Rg8", 2)
        }
        curlMartilloText.setOnClickListener{
            abrirVideo("T0txYgZGKWU", 2)
        }



        val botonEnviar: Button = findViewById(R.id.button)
        botonEnviar.setOnClickListener {
            Toast.makeText(this, "Pesos actualizados", Toast.LENGTH_SHORT).show()
            with(prefs.edit()) {
                putInt("remoDorsal", remoDorsal.text.toString().toInt())
                putInt("remoAlta", remoAlta.text.toString().toInt())
                putInt("jalon", jalon.text.toString().toInt())
                putInt("jalonDorsales", jalonDorsales.text.toString().toInt())
                putInt("trapecios", trapecios.text.toString().toInt())
                putInt("remoT", remoT.text.toString().toInt())
                putInt("pesoMuerto", pesoMuerto.text.toString().toInt())
                putInt("pressBanca", pressBanca.text.toString().toInt())
                putInt("pressBancaMancuernas", pressBancaMancuernas.text.toString().toInt())
                putInt("pressBancaMancuernasInclinado", pressBancaMancuernasInclinado.text.toString().toInt())
                putInt("pechoInferiorMancuernas", pechoInferiorMancuernas.text.toString().toInt())
                putInt("pechoInferiorPolea", pechoInferiorPolea.text.toString().toInt())
                putInt("aperturasPecho", aperturasPecho.text.toString().toInt())
                putInt("curlMaquina", curlMaquina.text.toString().toInt())
                putInt("curlInclinado", curlInclinado.text.toString().toInt())
                putInt("curlBarra", curlBarra.text.toString().toInt())
                putInt("curlMartillo", curlMartillo.text.toString().toInt())
                putInt("pressFrances", pressFrances.text.toString().toInt())
                putInt("poleaAbajo", poleaAbajo.text.toString().toInt())
                putInt("fondosTriceps", fondosTriceps.text.toString().toInt())
                putInt("pressMilitar", pressMilitar.text.toString().toInt())
                putInt("aperturasHombro", aperturasHombro.text.toString().toInt())
                putInt("hombroPosterior", hombroPosterior.text.toString().toInt())
                putInt("gemelo", gemelo.text.toString().toInt())
                putInt("extensionCuadriceps", extensionCuadriceps.text.toString().toInt())
                putInt("jaca", jaca.text.toString().toInt())
                putInt("prensa", prensa.text.toString().toInt())
                putInt("prensaAductor", prensaAductor.text.toString().toInt())
                putInt("gluteo", gluteo.text.toString().toInt())
                putInt("isquios", isquios.text.toString().toInt())
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