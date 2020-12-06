package com.example.manutd_danieldipasqua;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class VentanaResultados extends AppCompatActivity {

    private Button volver;
    private TableLayout resultadosTabla;
    BDDAOSqlLite usrDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultados);

        resultadosTabla = findViewById(R.id.tablaResultados);
        volver = (Button) findViewById(R.id.volverResultadosButton);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });


        usrDAO = new BDDAOSqlLite(this);
        rellenarResultados();

        }

        /*Clase que obtiene los resultados en BD, y por cada resultado crea una fila con los datos de dicho partido y la añade a la tabla existente*/
        private void rellenarResultados(){

            ArrayList <Resultado> resultados = usrDAO.getResultados();

            for(Resultado x: resultados){
                TableRow fila = new TableRow(getApplicationContext());
                TextView rival = new TextView(getApplicationContext());
                TextView campo = new TextView(getApplicationContext());
                TextView resultado = new TextView(getApplicationContext());
                TextView competicion = new TextView(getApplicationContext());


                TableLayout.LayoutParams parametros = new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);

                parametros.setMargins(0, 15, 0, 0);

                rival.setTextSize(11);
                rival.setTextColor(Color.parseColor("#FFFFFF"));
                rival.setText(x.getRival());
                rival.setGravity(Gravity.CENTER);

                campo.setTextSize(11);
                campo.setTextColor(Color.parseColor("#FFFFFF"));
                campo.setText(x.getCampo());
                campo.setGravity(Gravity.CENTER);

                resultado.setTextSize(11);
                resultado.setGravity(Gravity.CENTER);
                resultado.setTextColor(Color.parseColor("#FFFFFF"));
                resultado.setText(x.getResultado());

                competicion.setTextSize(11);
                competicion.setGravity(Gravity.CENTER);
                competicion.setTextColor(Color.parseColor("#FFFFFF"));
                competicion.setText(x.getCompeticion());


                fila.addView(rival);
                fila.addView(competicion);
                fila.addView(campo);
                fila.addView(resultado);

                fila.setLayoutParams(parametros);

                resultadosTabla.addView(fila,parametros);
        }

    }
}
