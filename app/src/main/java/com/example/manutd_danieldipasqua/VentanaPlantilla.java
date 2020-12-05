package com.example.manutd_danieldipasqua;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.manutd_danieldipasqua.databinding.ActivityVentanaNoticiasBinding;
import com.example.manutd_danieldipasqua.databinding.PlantillaBinding;

import java.util.ArrayList;

public class VentanaPlantilla  extends AppCompatActivity {

    private Button volver;
    private Spinner jugadoresSpinner;
    private ArrayList<Jugador> jugadores;
    BDDAOSqlLite usrDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantilla);
        PlantillaBinding binding = DataBindingUtil.setContentView(this,R.layout.plantilla);

        volver = (Button) findViewById(R.id.volverPlantillaButton);
        jugadoresSpinner = (Spinner) findViewById(R.id.jugadoresSpinner);

        usrDAO = new BDDAOSqlLite(this);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getJugadores();
        rellenarSpinner();
        jugadoresSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Jugador seleccionado = (Jugador)parent.getItemAtPosition(position);
                binding.setSeleccionado(seleccionado);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }

    private void getJugadores(){
        jugadores = usrDAO.getPlantilla();
    }
    private void rellenarSpinner(){
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, jugadores);
        jugadoresSpinner.setAdapter(adapter);
    }


}
