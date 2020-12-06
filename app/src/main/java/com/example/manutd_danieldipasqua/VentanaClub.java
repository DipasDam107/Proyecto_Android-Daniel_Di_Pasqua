package com.example.manutd_danieldipasqua;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*Clase de la ventana de Club. La info de esta ventana no proviene de BD, si no de recurso String
* Por ello, lo unico relevante es la declaración del listener del botón salir
* */
public class VentanaClub extends AppCompatActivity {

    private Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club);

        volver = (Button) findViewById(R.id.volverClubButton);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
