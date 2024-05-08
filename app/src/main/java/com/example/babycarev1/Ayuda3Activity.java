package com.example.babycarev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ayuda3Activity extends AppCompatActivity {
    protected Button boton1;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda3);

        boton1 = (Button) findViewById(R.id.boton1_ayuda3);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(Ayuda3Activity.this, RegistroActivity.class);
                startActivity(pasarPantalla);
            }
        });

    }
}