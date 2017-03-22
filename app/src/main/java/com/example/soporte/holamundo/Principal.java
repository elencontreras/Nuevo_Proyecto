package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    //Declaración de variables
    private EditText cajaNombre;
    private TextView cajaApellido;
    private Spinner comboGenero;
    private RadioButton r1, r2,r3;

    private ArrayAdapter<String> adapter; //Permite editar el combobox. Darle valores
    private String[] opciones;
    private Intent i; //Objeto que permite pasar de una actividad a otra.
    private Bundle b; //Objeto para capsular los datos- para pasar la información de una actividad a otra.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Capturar datos
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido=(TextView)findViewById(R.id.txtApellido);
        comboGenero = (Spinner)findViewById(R.id.cmbGenero);
        r1 = (RadioButton)findViewById(R.id.r1) ;
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);

        //Crear Intent
        i= new Intent(this,Saludo.class);

        //Crear capsula
        b = new Bundle();

        opciones = this.getResources().getStringArray(R.array.generos);
        //Crear adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones);
        comboGenero.setAdapter(adapter); //Asignar adaptador.
    }


    public void saludar(View v){

        String nomb, apell, genero, estadoCivil="";



        //Capturar valores de las cajas
        nomb = cajaNombre.getText().toString();
        apell= cajaApellido.getText().toString();

        //Capturar Genero
        genero = comboGenero.getSelectedItem().toString();

        //Capturar Estado Civil
        if (r1.isChecked()) estadoCivil =getResources().getString(R.string.soltero);
        if (r2.isChecked()) estadoCivil = getResources().getString(R.string.casado);
        if (r3.isChecked()) estadoCivil =getResources().getString(R.string.divorciado);

        //Validar
        if (validar()) {

            b.putString("Nombre", nomb); //Encapsular los valores previamente tomados
            b.putString("Apellido", apell);
            b.putString("Genero", genero);
            b.putString("EstadoCivil",estadoCivil);

            i.putExtras(b); // Pasar al Intent los datos en forma encapsulada por el bundle

            startActivity(i); //Arrancar actividad del Intent
        }
    }

    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()){

            cajaApellido.setError(getResources().getString(R.string.error_2));

            return false;
        }
        return true;
    }

    public void borrar(View v){
        cajaNombre.setText("");
        cajaNombre.requestFocus();
        cajaApellido.setText("");
        comboGenero.setSelection(0);
        r1.setChecked(true);



    }
}















