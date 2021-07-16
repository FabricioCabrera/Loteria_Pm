package com.example.juegoadivinar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText num1;
    private EditText ncomprobacion;
    private Button bnComprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.txtnumero1);
        ncomprobacion = findViewById(R.id.txtnumerocomprobar);

        bnComprobar = findViewById(R.id.bnComprobar);
        bnComprobar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == bnComprobar) {
            if (num1.getText().toString().isEmpty()) {
                num1.setError("Escribe un número límite");
                num1.requestFocus();
            } else if (ncomprobacion.getText().toString().isEmpty()) {
                ncomprobacion.setError("Escribe un número a combrobar");
                ncomprobacion.requestFocus();
            } else {
                int num2 = Integer.parseInt(ncomprobacion.getText().toString());
                int nlim = Integer.parseInt(num1.getText().toString());
                if (num2 > nlim) {
                    ncomprobacion.setError("El número a comprobar no es correcto");
                    ncomprobacion.requestFocus();
                } else {
                    //metodo para cambiar de ventana
                    Intent intent = new Intent(this, Comprobacion.class);
                    //envio los datos a la segunda actividad
                    intent.putExtra("dato1", num1.getText().toString());
                    intent.putExtra("dato2", ncomprobacion.getText().toString());
                    startActivity(intent);
                }
            }
        }
    }
}