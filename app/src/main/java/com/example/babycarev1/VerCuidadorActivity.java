package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerCuidadorActivity extends AppCompatActivity {

    //TODO VER RESERVA, BORRAR RESERVA (ID CLICADO, DE LAS MOSTRADAS)

    protected LinearLayout layout1, layout2, layout3;
    protected TextView label1, label2, label3, label4, label5;
    protected ImageView imagen;
    protected Button boton1;
    protected DataBaseSQL db;
    private Bundle extras;
    private String paquete1;
    private int idUsuario, idCuidador;
    private ArrayList<String> datosCuidador = new ArrayList<>();
    private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cuidador);

        //REFERENCIAS Y BASE DE DATOS
        db = new DataBaseSQL(this);

        layout1 = (LinearLayout) findViewById(R.id.linearLayout1_verCuidador);
        layout2 = (LinearLayout) findViewById(R.id.linearLayout2_verCuidador);
        layout3 = (LinearLayout) findViewById(R.id.linearLayout3_verCuidador);
        imagen = (ImageView) findViewById(R.id.imagen1_verCuidador);
        label1 = (TextView) findViewById(R.id.label1_verCuidador);
        label2 = (TextView) findViewById(R.id.label2_verCuidador);
        label3 = (TextView) findViewById(R.id.label3_verCuidador);
        label4 = (TextView) findViewById(R.id.label4_verCuidador);
        label5 = (TextView) findViewById(R.id.label5_verCuidador);
        boton1 = (Button) findViewById(R.id.boton1_verCuidador);

        imagen.setImageResource(R.drawable.default_avatar_icon);

        //RECEPCION DE PAQUETES: IDs, datos del cuidador
        extras = getIntent().getExtras();
        if (extras != null)
        {
            idUsuario = extras.getInt("IDUSUARIO");
            idCuidador = extras.getInt("IDCUIDADOR");
            
            //EXTRACCION DE LOS DATOS DEL CUIDADOR PARA MOSTRAR EN EL PERFIL
            datosCuidador = db.consultarCuidador(idCuidador);

            label1.setText(datosCuidador.get(0) + " " + datosCuidador.get(1));
            label2.setText(datosCuidador.get(2));
            label3.setText("DESCRIPCION Y EXPERIENCIA: \n" + datosCuidador.get(3));
            label4.setText("DISPONIBILIDAD: \n" + datosCuidador.get(4));
            label5.setText("RESENAS: \n" + datosCuidador.get(6));
        }
        else
        {
            Toast.makeText(this, "Se produjo un error recibiendo la información del cuidador seleccionado.", Toast.LENGTH_SHORT).show();
        }

        //BOTON RESERVAR
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ENVIO DE PAQUETES A PANTALLA DE RESERVA
                pasarPantalla = new Intent(VerCuidadorActivity.this, ReservarActivity.class);
                pasarPantalla.putExtra("IDUSUARIO", idUsuario);
                pasarPantalla.putExtra("IDCUIDADOR", idCuidador);
                pasarPantalla.putExtra("NOMBRECUIDADOR", datosCuidador.get(0));
                startActivity(pasarPantalla);

            }
        });

        //BOTON VER RESERVAS, BORRAR RESERVA

    }
}