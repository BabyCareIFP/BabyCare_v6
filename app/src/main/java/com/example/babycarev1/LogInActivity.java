package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LogInActivity extends AppCompatActivity {

    //TODO boton de login

    protected ImageView imagen1;
    protected TextView label1, label2, label3;
    protected EditText caja1, caja2;
    protected Button boton1, boton4;
    protected DataBaseSQL db;
    private Intent pasarPantalla;
    private String correoIntroducido;
    private String contraseniaIntroducida;
    private int idUsuario;
    private ArrayList<String> datosUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        db = new DataBaseSQL(this);
        imagen1 = (ImageView) findViewById(R.id.imagen1_login);
        label1 = (TextView) findViewById(R.id.label1_login);
        label2 = (TextView) findViewById(R.id.label2_login);
        label3 = (TextView) findViewById(R.id.label3_login);
        caja1 = (EditText) findViewById(R.id.caja1_login);
        caja2 = (EditText) findViewById(R.id.caja2_login);
        boton1 = (Button) findViewById(R.id.boton1_login);
        boton4 = (Button) findViewById(R.id.boton4_login);

        //BOTON LOGIN LLEVANDO AL PRINTACTIVITY
        /*boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(LogInActivity.this, PrintActivity.class);
                startActivity(pasarPantalla);
            }
        });*/

        //BOTON LOGIN
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (caja1.getText().toString().equals(""))
                {
                    Toast.makeText(LogInActivity.this, "Introduzca un correo electrónico", Toast.LENGTH_SHORT).show();
                }
                else if (caja2.getText().toString().equals(""))
                {
                    Toast.makeText(LogInActivity.this, "Introduzca una contraseña", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {

                        correoIntroducido = caja1.getText().toString();
                        contraseniaIntroducida = caja2.getText().toString();
                        if (db.contraseniaCorrecta(correoIntroducido, contraseniaIntroducida))
                        {
                            idUsuario = Integer.parseInt(db.consultarUsuario(correoIntroducido).get(0));

                            Toast.makeText(LogInActivity.this, "Login correcto", Toast.LENGTH_SHORT).show();
                            pasarPantalla = new Intent(LogInActivity.this, VerCuidadoresActivity.class);
                            pasarPantalla.putExtra("IDUSUARIO", idUsuario);
                            finish();
                            startActivity(pasarPantalla);
                        }
                        else {
                            Toast.makeText(LogInActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(LogInActivity.this, "Error al recoger los datos introducido", Toast.LENGTH_SHORT).show();;
                    }

                }



            }
        });

        //BOTON AYUDA
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(LogInActivity.this,Ayuda2Activity.class);
                startActivity(pasarPantalla);
            }
        });
    }



}