package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CrearCuidadoresActivity extends AppCompatActivity {
    protected TextView label1;
    protected EditText caja1, caja2, caja3, caja4, caja5, caja6, caja7, caja8, caja9;
    protected Button boton1, boton2;
    protected DataBaseSQL db;

    private String nombre, apellidos, telefono, fechaNacimiento, sexo, experiencia, disponibilidad, puntuacion, resenias;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuidadores);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_cuidadores);
        caja1 = (EditText) findViewById(R.id.caja1_cuidadores);
        caja2 = (EditText) findViewById(R.id.caja2_cuidadores);
        caja3 = (EditText) findViewById(R.id.caja3_cuidadores);
        caja4 = (EditText) findViewById(R.id.caja4_cuidadores);
        caja5 = (EditText) findViewById(R.id.caja5_cuidadores);
        caja6 = (EditText) findViewById(R.id.caja6_cuidadores);
        caja7 = (EditText) findViewById(R.id.caja7_cuidadores);
        caja8 = (EditText) findViewById(R.id.caja8_cuidadores);
        caja9 = (EditText) findViewById(R.id.caja9_cuidadores);
        boton1 = (Button) findViewById(R.id.boton1_cuidadores);
        boton2 = (Button) findViewById(R.id.boton2_cuidadores);

        //BOTON1 INSERTAR CUIDADOR
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    nombre = caja1.getText().toString();
                    apellidos = caja2.getText().toString();
                    telefono = caja3.getText().toString();
                    fechaNacimiento = caja4.getText().toString();
                    sexo = caja5.getText().toString();
                    experiencia = caja6.getText().toString();
                    disponibilidad = caja7.getText().toString();
                    puntuacion = caja8.getText().toString();
                    resenias = caja9.getText().toString();

                    try {
                        db.insertarCuidador(nombre, apellidos, telefono, fechaNacimiento, sexo, experiencia, disponibilidad, puntuacion, resenias);
                        Toast.makeText(CrearCuidadoresActivity.this, "Insertado bien", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(CrearCuidadoresActivity.this, "No se pudo insertar", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(CrearCuidadoresActivity.this, "no se pudo, haber estudiao", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //BOTON2 VER CUIDADORES - ELIMINADO
        /*boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(CrearCuidadoresActivity.this, VerCuidadoresActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });*/


    }
}