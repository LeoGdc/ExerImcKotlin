package br.com.senai.imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

lateinit var nomeEditText: EditText
lateinit var alturaEditText: EditText
lateinit var pesoEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)


        calcular.setOnClickListener(){
            val nomeEditText = findViewById<EditText>(R.id.Nome)
            val alturaEditText = findViewById<EditText>(R.id.Altura)
            val pesoEditText = findViewById<EditText>(R.id.Peso)
            val resultadoTextView = findViewById<TextView>(R.id.resultado)

            if (validarCampos()) {
                val nome = nomeEditText.text.toString()
                val altura = alturaEditText.text.toString().toDouble()
                val peso = pesoEditText.text.toString().toDouble()
                var resultado = resultadoTextView.text

                val imc = calcularImc(altura, peso)

                if ( imc < 18.5 ) {
                    resultado = "$nome Seu imc é ${String.format("%.2f", imc)} \ne você está abaixo do peso."
                } else if ( imc < 25 ) {
                    resultado = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está no peso ideal. Parabéns!"
                } else if ( imc < 30 ) {
                    resultado = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está levemente acima do peso."
                } else if ( imc < 35 ) {
                    resultado = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está com obesidade grau I."
                } else if ( imc < 40 ) {
                    resultado = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está com obesidade grau II."
                } else {
                    resultado = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está com obesidade grau III. Cuidado!"

                }

            }

        }

  
        }
    }

    private fun validarCampos(): Boolean {
        var noError = true
        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("Digite seu nome!")
            noError = false
        }
        if (alturaEditText.text.isBlank()) {
            alturaEditText.setError("Digite sua altura!")
            noError = false
        }
        if (pesoEditText.text.isBlank()) {
            pesoEditText.setError("Digite seu peso!")
            noError = false
        }
        return noError
    }

