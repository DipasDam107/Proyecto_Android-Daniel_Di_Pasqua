package com.example.manutd_danieldipasqua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.manutd_danieldipasqua.databinding.ActivityVentanaNoticiasBinding;

/*Clase de la ventana noticias*/
public class VentanaNoticias extends AppCompatActivity {

    private Button volver;
    private Noticia noticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_noticias);
        ActivityVentanaNoticiasBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_ventana_noticias);

        /*Recibe la noticia desde el menu principal y la indica como bindeada. De esta manera se imprime su contenido en pantalla*/
        noticia = (Noticia) getIntent().getSerializableExtra("Noticia");
        binding.setNoticia(noticia);

        volver = (Button) findViewById(R.id.volverNoticiaButton);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}