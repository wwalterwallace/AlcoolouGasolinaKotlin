package com.example.alcoolougasolinakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View){

        //Recuparar Valores digitados
        //val precoAlcool = findViewById<EditText>(R.id.editPrecoAlcool);
        val precoAlcool  = editPrecoAlcool.text.toString();
        val precoGasolina = editPrecoGasolina.text.toString();

        //Validar Campos
        val validaCampos = validarCampos(precoAlcool,precoGasolina);

        if (validaCampos){
            calcularMelhorPreco (precoAlcool, precoGasolina)
        }else {
            textoResultado.setText("Preencha os preços primeiro !")
        }

    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()
        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7){
            textoResultado.text = "Abasteça com Gasolina"
        }else {
            textoResultado.text = "Abasteça com Alcool"
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean{
        var camposValidados: Boolean = true;
        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados;

    }

}
