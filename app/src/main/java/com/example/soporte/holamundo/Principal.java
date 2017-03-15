package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    //Declaración de variables
    private EditText cajaNombre;
    private TextView cajaApellido;
    private Intent i; //Objeto que permite pasar de una actividad a otra.
    private Bundle b; //Objeto para capsular los datos- para pasar la información de una actividad a otra.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Capturar cajas
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido=(TextView)findViewById(R.id.txtApellido);

        //Crear Intent
        i= new Intent(this,Saludo.class);

        //Crear capsula
        b = new Bundle();
    }


    public void saludar(View v){

        String nomb, apell;



        //Capturar valores de las cajas
        nomb = cajaNombre.getText().toString();
        apell= cajaApellido.getText().toString();

        //Validar
        if (validar()) {

            b.putString("Nombre", nomb); //Encapsular los valores previamente tomados
            b.putString("Apellido", apell);

            i.putExtras(b); // Pasar al Intent los datos en forma encapsulada por el bundle

            startActivity(i); //Arrancar actividad del Intent
        }
    }

    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty()){
           // Toast.makeText(getApplicationContext(),"Digite por favor el nombre",Toast.LENGTH_SHORT).show();
            cajaNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()){
            //Toast.makeText(getApplicationContext(),"Digite por favor el apellido",Toast.LENGTH_SHORT).show();
            cajaApellido.setError(getResources().getString(R.string.error_2));

            return false;
        }
        return true;
    }
}















