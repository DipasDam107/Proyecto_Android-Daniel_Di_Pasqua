package com.example.manutd_danieldipasqua;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/*Clase de la ventana de Splash que aparece al iniciar la aplicación*/
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            /*Una vez el tiempo se acabe (5Segs) se ejecuta lo que está dentro de run, llamando al siguiente activity (Login de usuario) y cierra este*/
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
    }
