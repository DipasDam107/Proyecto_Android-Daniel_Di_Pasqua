package com.example.manutd_danieldipasqua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.manutd_danieldipasqua.databinding.VentanaClasificacionBinding;

import java.util.ArrayList;

public class VentanaClasificacion extends AppCompatActivity {

    Button volver;
    VentanaClasificacionBinding binding;
    BDDAOSqlLite usrDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_clasificacion);
        volver = findViewById(R.id.volverClasificacionButton);
        binding =DataBindingUtil.setContentView(this,R.layout.ventana_clasificacion);
        usrDAO = new BDDAOSqlLite(this);

        ArrayList <EquipoClasificacion> clasi = usrDAO.getClasificacion();
        binding.setClasificacion(clasi);


    }

    public void volverButton(View view) {
        finish();
    }
}