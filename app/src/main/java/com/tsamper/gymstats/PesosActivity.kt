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

        remoDorsal.setText(prefs.getFloat("remoDorsal", 0F).toString())
        remoAlta.setText(prefs.getFloat("remoAlta", 0F).toString())
        jalon.setText(prefs.getFloat("jalon", 0F).toString())
        jalonDorsales.setText(prefs.getFloat("jalonDorsales", 0F).toString())
        trapecios.setText(prefs.getFloat("trapecios", 0F).toString())
        remoT.setText(prefs.getFloat("remoT", 0F).toString())
        pesoMuerto.setText(prefs.getFloat("pesoMuerto", 0F).toString())
        pressBanca.setText(prefs.getFloat("pressBanca", 0F).toString())
        pressBancaMancuernas.setText(prefs.getFloat("pressBancaMancuernas", 0F).toString())
        pressBancaMancuernasInclinado.setText(prefs.getFloat("pressBancaMancuernasInclinado", 0F).toString())
        pechoInferiorMancuernas.setText(prefs.getFloat("pechoInferiorMancuernas", 0F).toString())
        pechoInferiorPolea.setText(prefs.getFloat("pechoInferiorPolea", 0F).toString())
        aperturasPecho.setText(prefs.getFloat("aperturasPecho", 0F).toString())
        curlMaquina.setText(prefs.getFloat("curlMaquina", 0F).toString())
        curlInclinado.setText(prefs.getFloat("curlInclinado", 0F).toString())
        curlBarra.setText(prefs.getFloat("curlBarra", 0F).toString())
        curlMartillo.setText(prefs.getFloat("curlMartillo", 0F).toString())
        pressFrances.setText(prefs.getFloat("pressFrances", 0F).toString())
        poleaAbajo.setText(prefs.getFloat("poleaAbajo", 0F).toString())
        fondosTriceps.setText(prefs.getFloat("fondosTriceps", 0F).toString())
        pressMilitar.setText(prefs.getFloat("pressMilitar", 0F).toString())
        aperturasHombro.setText(prefs.getFloat("aperturasHombro", 0F).toString())
        hombroPosterior.setText(prefs.getFloat("hombroPosterior", 0F).toString())
        gemelo.setText(prefs.getFloat("gemelo", 0F).toString())
        extensionCuadriceps.setText(prefs.getFloat("extensionCuadriceps", 0F).toString())
        jaca.setText(prefs.getFloat("jaca", 0F).toString())
        prensa.setText(prefs.getFloat("prensa", 0F).toString())
        prensaAductor.setText(prefs.getFloat("prensaAductor", 0F).toString())
        gluteo.setText(prefs.getFloat("gluteo", 0F).toString())
        isquios.setText(prefs.getFloat("isquios", 0F).toString())

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
                putFloat("remoDorsal", remoDorsal.text.toString().toFloat())
                putFloat("remoAlta", remoAlta.text.toString().toFloat())
                putFloat("jalon", jalon.text.toString().toFloat())
                putFloat("jalonDorsales", jalonDorsales.text.toString().toFloat())
                putFloat("trapecios", trapecios.text.toString().toFloat())
                putFloat("remoT", remoT.text.toString().toFloat())
                putFloat("pesoMuerto", pesoMuerto.text.toString().toFloat())
                putFloat("pressBanca", pressBanca.text.toString().toFloat())
                putFloat("pressBancaMancuernas", pressBancaMancuernas.text.toString().toFloat())
                putFloat("pressBancaMancuernasInclinado", pressBancaMancuernasInclinado.text.toString().toFloat())
                putFloat("pechoInferiorMancuernas", pechoInferiorMancuernas.text.toString().toFloat())
                putFloat("pechoInferiorPolea", pechoInferiorPolea.text.toString().toFloat())
                putFloat("aperturasPecho", aperturasPecho.text.toString().toFloat())
                putFloat("curlMaquina", curlMaquina.text.toString().toFloat())
                putFloat("curlInclinado", curlInclinado.text.toString().toFloat())
                putFloat("curlBarra", curlBarra.text.toString().toFloat())
                putFloat("curlMartillo", curlMartillo.text.toString().toFloat())
                putFloat("pressFrances", pressFrances.text.toString().toFloat())
                putFloat("poleaAbajo", poleaAbajo.text.toString().toFloat())
                putFloat("fondosTriceps", fondosTriceps.text.toString().toFloat())
                putFloat("pressMilitar", pressMilitar.text.toString().toFloat())
                putFloat("aperturasHombro", aperturasHombro.text.toString().toFloat())
                putFloat("hombroPosterior", hombroPosterior.text.toString().toFloat())
                putFloat("gemelo", gemelo.text.toString().toFloat())
                putFloat("extensionCuadriceps", extensionCuadriceps.text.toString().toFloat())
                putFloat("jaca", jaca.text.toString().toFloat())
                putFloat("prensa", prensa.text.toString().toFloat())
                putFloat("prensaAductor", prensaAductor.text.toString().toFloat())
                putFloat("gluteo", gluteo.text.toString().toFloat())
                putFloat("isquios", isquios.text.toString().toFloat())
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