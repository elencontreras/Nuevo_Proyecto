package com.example.soporte.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private Bundle b;
    private String aux, nomb, apell;
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

        // aux = "Hola "+nomb+" "+apell+" ¡Bienvenido a esta aplicación!";

        //Acceder a los recursos
        res =this.getResources();

        //Para que pueda ser en ingles
        aux= res.getString(R.string.parte_saludo)+" "+nomb+" "+apell+" "+res.getString(R.string.parte_saludo2);

        saludo.setText(aux);

    }
}
