package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerCuidadoresActivity extends AppCompatActivity {

    //TODO meter formula de la edad?
    //TODO implementar VerReservasActivity

    protected ScrollView scroll;
    protected LinearLayout layout;
    protected DataBaseSQL db;
    private ArrayList<Cuidador> listaCuidadores = new ArrayList<Cuidador>();
    private int idUsuarioSesionIniciada;
    private String idCuidador;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String fechaNacimiento;
    private String sexo;
    private String experiencia;
    private String disponibilidad;
    private String puntuacion;
    private String resenias;
    private String[] datosCuidador;
    private Intent pasarPantalla;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cuidadores);

        //REFERENCIAS Y BASE DE DATOS
        db = new DataBaseSQL(this);
        scroll = findViewById(R.id.scroll1_test);
        layout = findViewById(R.id.layout1_test);

        //RECEPCION DE PAQUETES
        extras = getIntent().getExtras();
        if (extras != null)
        {
            idUsuarioSesionIniciada = extras.getInt("IDUSUARIO");
        }
        else
        {
            Toast.makeText(this, "Se produjo un error recibiendo la información de la sesión iniciada.", Toast.LENGTH_SHORT).show();
        }

        //CREACION DEL ARRAY DE CUIDADORES
        for (String cuidadorTexto : db.consultarCuidadores())
        {
            //ASIGNACION DE DATOS DEL CUIDADOR
            datosCuidador = cuidadorTexto.split(".-");

            idCuidador = datosCuidador[0];
            nombre = datosCuidador[1];
            sexo = datosCuidador[2];
            experiencia = datosCuidador[3];
            disponibilidad = datosCuidador[4];
            puntuacion = datosCuidador[5];

            //CREACION DEL OBJETO CUIDADOR EN EL ARRAY DE CUIDADORES
            listaCuidadores.add(new Cuidador(Integer.parseInt(idCuidador), nombre, apellidos, telefono, fechaNacimiento, sexo, experiencia, disponibilidad, puntuacion, resenias));
        }

        //POR CADA CUIDADOR SE CREA UNA TARJETA
        for (Cuidador cuidador :  listaCuidadores)
        {

            //REFERENCIA AL XML EMPLEADO PARA CADA TARJETA PERFIL
            View previewCuidador = LayoutInflater.from(this).inflate(R.layout.item_cuidador, scroll, false);

            //REFERENCIAS A LOS ELEMENTOS DE LA TARJETA
            ImageView imagen1 = (ImageView) previewCuidador.findViewById(R.id.image1_cuidador);
            TextView label1 = previewCuidador.findViewById(R.id.label1_cuidador);
            TextView label2 = previewCuidador.findViewById(R.id.label2_cuidador);
            TextView label3 = previewCuidador.findViewById(R.id.label3_cuidador);
            LinearLayout layoutEstrellas = previewCuidador.findViewById(R.id.layout3_cuidador);

            //ESTRELLAS DE VALORACION
            int numEstrellas = Integer.parseInt(cuidador.getPuntuacion());
            for (int i=0; i<numEstrellas; i++)
            {
                ImageView imagenEstrella = new ImageView(this);
                imagenEstrella.setImageResource(R.drawable.android_star);

                //Sin asignar tamano eran demasiado grandes
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(64, 64);
                imagenEstrella.setLayoutParams(layoutParams);

                layoutEstrellas.addView(imagenEstrella);
            }

            imagen1.setImageResource(R.drawable.default_avatar_icon);
            label1.setText(cuidador.getNombre());
            label2.setText(cuidador.getExperiencia());
            label3.setText(cuidador.getDisponibilidad());

            layout.addView(previewCuidador);

            //CLICK EN LA TARJETA PERFIL
            previewCuidador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idCuidador = Integer.toString(cuidador.getIdCuidador());

                    //LLEVA A SU PERFIL
                    pasarPantalla = new Intent(VerCuidadoresActivity.this, VerCuidadorActivity.class);
                    pasarPantalla.putExtra("IDCUIDADOR", cuidador.getIdCuidador());
                    pasarPantalla.putExtra("IDUSUARIO", idUsuarioSesionIniciada);
                    startActivity(pasarPantalla);

                }
            });
        }
    }

    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_start, menu);
        return true;
    }

    //BOTONES MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        switch (item.getItemId()) {
            case R.id.item_verReservas_start:

                pasarPantalla = new Intent(VerCuidadoresActivity.this, VerReservasActivity.class);
                pasarPantalla.putExtra("IDUSUARIO", idUsuarioSesionIniciada);
                startActivity(pasarPantalla);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}