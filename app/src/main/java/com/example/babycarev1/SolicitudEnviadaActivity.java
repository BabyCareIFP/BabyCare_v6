package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SolicitudEnviadaActivity extends AppCompatActivity {

    protected DataBaseSQL db;
    private Bundle extras;
    private Intent pasarPantalla;
    protected Button boton1;
    protected TextView label1;
    private int idUsuario, idCuidador;
    private String nombreCuidador, fechaAReservar, horaAReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_enviada);

        //REFERENCIAS Y BASE DE DATOS
        db = new DataBaseSQL(this);
        label1 = (TextView) findViewById(R.id.label1_solicitudEnviada);
        boton1 = (Button) findViewById(R.id.boton1_solicitudEnviada);

        //RECEPCION DE PAQUETES
        extras = getIntent().getExtras();
        if (extras != null)
        {

            idUsuario = extras.getInt("IDUSUARIO");
            idCuidador = extras.getInt("IDCUIDADOR");
            nombreCuidador = extras.getString("NOMBRECUIDADOR");
            fechaAReservar = extras.getString("FECHA");
            horaAReservar = extras.getString("HORA");

        }
        else
        {
            Toast.makeText(this, "Se produjo un error recibiendo la información de la reserva.", Toast.LENGTH_SHORT).show();
        }

        //TEXTO INFORMATIVO
        label1.setText("Tu solicitud de reserva a " + nombreCuidador + " ha sido enviada.\n"
        + "Espera la confirmación de " + nombreCuidador + ". ");

        //BOTON VOLVER A INICIO
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pasarPantalla = new Intent(SolicitudEnviadaActivity.this, VerCuidadoresActivity.class);
                pasarPantalla.putExtra("IDUSUARIO", idUsuario);
                finish();
                startActivity(pasarPantalla);

            }
        });


    }
}