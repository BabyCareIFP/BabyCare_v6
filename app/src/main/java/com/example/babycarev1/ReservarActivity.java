package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReservarActivity extends AppCompatActivity {

    protected DataBaseSQL db;
    protected TextView label1, label2, label3;
    protected EditText caja1, caja2;
    protected Button boton1;
    private Bundle extras;
    private int idUsuario, idCuidador;
    private String nombreCuidador, fechaAReservar, horaAReservar;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        //REFERENCIAS Y BASE DE DATOS
        db = new DataBaseSQL(this);
        label1 = (TextView) findViewById(R.id.label1_reservar);
        label2 = (TextView) findViewById(R.id.label2_reservar);
        label3 = (TextView) findViewById(R.id.label3_reservar);
        caja1 = (EditText) findViewById(R.id.caja1_reservar);
        caja2 = (EditText) findViewById(R.id.caja2_reservar);
        boton1 = (Button) findViewById(R.id.boton1_reservar);

        //RECEPCION DE PAQUETES
        extras = getIntent().getExtras();
        if (extras != null)
        {

            idUsuario = extras.getInt("IDUSUARIO");
            idCuidador = extras.getInt("IDCUIDADOR");
            nombreCuidador = extras.getString("NOMBRECUIDADOR");

        }
        else
        {
            Toast.makeText(this, "Se produjo un error recibiendo la información del cuidador seleccionado.", Toast.LENGTH_SHORT).show();
        }

        //ASIGNACION DE VALORES
        label1.setText(label1.getText() + nombreCuidador);
        fechaAReservar = caja1.getText().toString();
        horaAReservar = caja2.getText().toString();

        //BOTON SOLICITAR RESERVA
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pasarPantalla = new Intent(ReservarActivity.this, SolicitudEnviadaActivity.class);
                pasarPantalla.putExtra("FECHA", fechaAReservar);
                pasarPantalla.putExtra("HORA", horaAReservar);
                pasarPantalla.putExtra("IDUSUARIO", idUsuario);
                pasarPantalla.putExtra("IDCUIDADOR", idCuidador);
                startActivity(pasarPantalla);
                //IF disponible?
                    //INSERTARRESERVA(ID, ID, FECHA, HORA)

            }
        });
    }
}