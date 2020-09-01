package com.example.appintent4tadsb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ouvinte do botão calcular
        btCalcular.setOnClickListener { v: View? ->

            var precoAlcool = txtPrecoAlcool.text.toString()
            var precoGasolina = txtPrecoGasolina.text.toString()

            if(precoAlcool.isNotEmpty() && precoGasolina.isNotEmpty()){
                var razao = precoAlcool.toDouble() / precoGasolina.toDouble()
                var intent = Intent(this,RespostaActivity::class.java)


                if(razao > 0.7){
                    //Toast.makeText(this,"Gasolina!",Toast.LENGTH_LONG).show()

                    //transitando de uma tela a outra usando intents
                    intent.putExtra("resposta","Gasolina!")


                }
                else if (razao < 0.7){
                    //Toast.makeText(this,"Álcool!",Toast.LENGTH_LONG).show()

                    //transitando de uma tela a outra usando intents
                    intent.putExtra("resposta","Álcool!")

                }
                else{
                    //Toast.makeText(this,"Tanto Faz!",Toast.LENGTH_LONG).show()
                    //transitando de uma tela a outra usando intents
                    intent.putExtra("resposta","Tanto faz!")

                }
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Todos os campos devem ser preenchidos",Toast.LENGTH_LONG).show()
            }

        }


    }
}