package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    protected ImageView imagen1;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imagen1 =(ImageView) findViewById(R.id.imagen1_splash);

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {

                //CODIGO DE PASAR PANTALLA (NEW INTENT, FINISH, STARTACTIVITY())
                pasarPantalla = new Intent(SplashActivity.this, PrimeraActivity.class);
                finish();
                startActivity(pasarPantalla);

            }
        };

        Timer t = new Timer();
        t.schedule(tt, 3000);

    }
}