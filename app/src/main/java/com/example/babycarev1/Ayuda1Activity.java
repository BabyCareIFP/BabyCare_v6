package com.example.babycarev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ayuda1Activity extends AppCompatActivity {
 protected Button boton1;
        private Intent pasarPantalla;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ayuda1);
       boton1 = (Button) findViewById(R.id.boton1_ayuda1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla =new Intent(Ayuda1Activity.this, PrimeraActivity.class);
                startActivity(pasarPantalla);
            }
        });

    }
}