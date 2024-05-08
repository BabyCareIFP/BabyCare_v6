package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    //TODO enviar paquetes Intent o crear objeto y clase Usuario

    //ELEMENTOS INTERFAZ
    protected TextView label1, label2;
    protected LinearLayout layout1;
    protected EditText caja1, caja2, caja3, caja4, caja5, caja6, caja7, caja8, caja9, caja10, caja11, caja12;
    protected RadioGroup radio1;
    protected RadioButton radioHombre, radioMujer, radioOtros;
    protected Button boton1, boton2;
    protected DataBaseSQL db;
    private Intent pasarPantalla;

    //TODO meter esto en la siguiente pantalla, la de escoger si cuidador o no
    /*private ArrayList<String> tiposUsuario = new ArrayList<String>();
    private ArrayAdapter<String> adaptador;
    spinner1 = (Spinner) findViewById(R.id.spinner1_registro);
    tiposUsuario.add("Padre / madre / tutor");
    tiposUsuario.add("Cuidador/a / canguro");
    adaptador = new ArrayAdapter<String>(RegistroActivity.this, android.R.layout.simple_list_item_1, tiposUsuario);
    spinner1.setAdapter(adaptador);*/

    //VARIABLES DE LOS CAMPOS
    private String nombre, apellidos, dni, telefono, fechaDeNacimiento, sexo, nombreUsuario, contrasenia, correoElectronico, nacionalidad, direccion;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_registro);
        label2 = (TextView) findViewById(R.id.label2_registro);
        caja1 = (EditText) findViewById(R.id.caja1_registro);
        caja2 = (EditText) findViewById(R.id.caja2_registro);
        caja3 = (EditText) findViewById(R.id.caja3_registro);
        caja4 = (EditText) findViewById(R.id.caja4_registro);
        caja5 = (EditText) findViewById(R.id.caja5_registro);
        caja6 = (EditText) findViewById(R.id.caja6_registro);
        caja7 = (EditText) findViewById(R.id.caja7_registro);
        caja8 = (EditText) findViewById(R.id.caja8_registro);
        caja9 = (EditText) findViewById(R.id.caja9_registro);
        caja10 = (EditText) findViewById(R.id.caja10_registro);
        caja11 = (EditText) findViewById(R.id.caja11_registro);
        caja12 = (EditText) findViewById(R.id.caja12_registro);
        radio1 = (RadioGroup) findViewById(R.id.radio1_registro);
        radioHombre = (RadioButton) findViewById(R.id.radioHombre_registro);
        radioMujer = (RadioButton) findViewById(R.id.radioMujer_registro);
        radioOtros = (RadioButton) findViewById(R.id.radioOtros_registro);

        boton1 = (Button) findViewById(R.id.boton1_registro);
        boton2 = (Button) findViewById(R.id.boton2_registro);

        //BOTON REGISTRO LLEVANDO AL PRINTACTIVITY
        /*boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(RegistroActivity.this, PrintActivity.class);
                startActivity(pasarPantalla);
            }
        });*/

        //BOTON REGISTRO: Al pulsar el boton se asignaran los campos a variables y se insertaran los datos en la tabla usuarios
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                    nombre = caja1.getText().toString();
                    apellidos = caja2.getText().toString();
                    dni = caja3.getText().toString();
                    telefono = caja4.getText().toString();
                    fechaDeNacimiento = caja5.getText().toString();
                    nombreUsuario = caja9.getText().toString();
                    contrasenia = caja11.getText().toString();
                    correoElectronico = caja10.getText().toString();
                    nacionalidad = caja7.getText().toString();
                    direccion = caja6.getText().toString();
                    if(radioMujer.isChecked())
                    {
                        sexo = "Mujer";
                    }
                    else if(radioHombre.isChecked())
                    {
                        sexo = "Hombre";
                    }
                    else if(radioOtros.isChecked())
                    {
                        sexo = caja8.getText().toString();
                    }
                    try {

                        db.insertarPerfil(nombre, apellidos, dni, telefono, fechaDeNacimiento, sexo, nombreUsuario, contrasenia, correoElectronico, nacionalidad, direccion);

                        //Llegados a este punto, si ha conseguido pasar los datos a variables y a la tabla, te lleva al login al login
                        pasarPantalla = new Intent(RegistroActivity.this, LogInActivity.class);
                        finish();
                        startActivity(pasarPantalla);

                    } catch (Exception e) {
                        Toast.makeText(RegistroActivity.this, "Hubo un problema con el registro del usuario", Toast.LENGTH_SHORT).show();
                    }

               }
               catch (Exception e)
               {
                   Toast.makeText(RegistroActivity.this, "Algo fue mal con la toma de datos", Toast.LENGTH_SHORT).show();
               }
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(RegistroActivity.this, Ayuda3Activity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}