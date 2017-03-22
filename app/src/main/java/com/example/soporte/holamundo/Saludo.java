package com.example.soporte.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private Bundle b;
    private String aux, nomb, apell, genero, estadoCivil;
    private Resources res; //Objeto para acceder a los recursos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        saludo = (TextView)findViewById(R.id.txtSaludo);

        //Capturar capsula
        b = getIntent().getExtras();

        //Obtener los datos de la capsula
        nomb = b.getString("Nombre");
        apell = b.getString("Apellido");
        genero = b.getString("Genero");
        estadoCivil = b.getString("EstadoCivil");



        //Acceder a los recursos
        res =this.getResources();

        //Para que pueda ser en ingles
        aux = res.getString(R.string.parte_saludo)+" "+nomb+" "+apell+" "+res.getString(R.string.parte_saludo2);
        aux = aux+"\n\n"+res.getString(R.string.datos);
        aux = aux+"\n\n"+res.getString(R.string.nombre)+": "+nomb;
        aux = aux+"\n\n"+res.getString(R.string.apellido)+": "+apell;
        aux = aux+"\n\n"+res.getString(R.string.genero)+": "+genero;
        aux = aux+"\n\n"+res.getString(R.string.estadoCivil)+": "+estadoCivil;
        saludo.setText(aux);

    }
}
