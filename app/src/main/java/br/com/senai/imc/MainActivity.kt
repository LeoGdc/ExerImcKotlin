package br.com.senai.imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

lateinit var alturaEditText: EditText
lateinit var pesoEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calcular =findViewById<Button>(R.id.calcular)
            calcular.setOnClickListener(){
                val Peso = findViewById<EditText>(R.id.Peso).text.toString().toInt()
                val altura = findViewById<EditText>(R.id.Altura).text.toString().toDouble()
                val resultado = findViewById<TextView>(R.id.resultado)
                val imc =Peso/ (altura * altura)
                val imcString = String.format("%.2f", imc)

                if (imc<18.5){
                    resultado.text = "$imcString \n você está abaixo do peso."
                    resultado.setTextColor(Color.RED)
                    }else if(imc<25){
                    resultado.text ="$imcString \n você está no peso ideal."
                    resultado.setTextColor(Color.GREEN)
                    }else if(imc < 30){
                    resultado.text   = " $imcString \n você está levemente acima do peso."
                    resultado.setTextColor(Color.RED)
                    }else if (imc < 35){
                    resultado.text  ="$imcString \n você está com obesidade grau I."
                    resultado.setTextColor(Color.RED)
                    }else if (imc <40){
                    resultado.text  = "$imcString \n você está com obesidade grau II."
                    resultado.setTextColor(Color.RED)
                    }else {
                    resultado.text  = "$imcString \n você está com obesidade grau III."
                    resultado.setTextColor(Color.RED)
                    }
            }
     }
}
