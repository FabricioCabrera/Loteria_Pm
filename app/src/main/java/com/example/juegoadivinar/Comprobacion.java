package com.example.juegoadivinar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Comprobacion extends AppCompatActivity {
    private TextView resultado;
    String num1,numeroComprobacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprobacion);
        resultado = findViewById(R.id.txtresultado);

        //obtego los valores de la primera actividad
        num1 = getIntent().getStringExtra("dato1");
        numeroComprobacion = getIntent().getStringExtra("dato2");

        Comprobar();

    }

    //metodo para generar el numero aleatorio
    public int numeroAleatorio(int num){
        return (int) (Math.random() * num);
    }


    //convierto los datos a enteros


    //metodo para comprobar si adivino el numero
    @SuppressLint("SetTextI18n")
    public void Comprobar(){
        int Ncomprobacion = Integer.parseInt(numeroComprobacion);
        int NLimite = Integer.parseInt(num1);
        int ramdom = numeroAleatorio(NLimite);
        if (Ncomprobacion == ramdom){
            resultado.setText("!!BOOYAH GANASTES!!");
            Toast.makeText(this,"!!BOOYAH GANASTES!!", Toast.LENGTH_LONG).show();

        }else{
            resultado.setText("Perdistes. \nEl numero aleatorio era: " + ramdom);
        }
    }

    //metodo para volver a intentar
    public void IntertarNuevo(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}