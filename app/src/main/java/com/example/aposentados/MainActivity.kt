package com.example.aposentados

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentView(R.layout.activity_main)

        val spSexo = findViewById<Spinner>(R.id.Sp_Sexo)
        val idade = findViewById<EditText>(R.id.Ed_Text_Idade)
        val botaoCalcular = findViewById<Button>(R.id.botao_calcular)
        val resultado = findViewById<TextView>(R.id.text_Resultado)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino")
        )
        spSexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino"))

        spSexo.adapter = adapter

        botaoCalcular.setOnClickListener{
            val spS = spSexo.selectedItem as String
            val ida = idade.text.toString().toInt()
            var result = 0

            if (spS == "Masculino"){
                result = 65 - ida
            }else{
                result = 62 - ida
            }

            resultado.text = "Faltam $result anos para sua aposentadoria!"
        }
    }
}