package com.example.manutd_danieldipasqua;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.manutd_danieldipasqua.databinding.MenuPrincipalBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuPrincipal extends AppCompatActivity {

    TextView bienvenida;
    TextView ultimaHora;
    ImageButton club;
    ImageButton plantilla;
    ImageButton resultados;
    BDDAOSqlLite usrDAO;
    TextView primNoticia;
    TextView segNoticia;
    TextView terNoticia;
    TextView cuarNoticia;
    TextView cSesion;
    TextView ultiRes;
    MenuPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        binding = DataBindingUtil.setContentView(this,R.layout.menu_principal);

        usrDAO = new BDDAOSqlLite(this);

        cSesion = (TextView) findViewById(R.id.cerrarSesionMenuPrincipalTextView);
        bienvenida = (TextView) findViewById(R.id.usuarioMenuPrincipalTextView);
        ultimaHora = (TextView) findViewById(R.id.ultimoResultadoMenuPrincipal);
        club = (ImageButton) findViewById(R.id.clubMenuPrincipalButton);
        plantilla = (ImageButton) findViewById(R.id.plantillaMenuPrincipalButton);
        resultados = (ImageButton) findViewById(R.id.resultadosMenuPrincipalButton);
        primNoticia = (TextView) findViewById(R.id.primeraNoticia);
        segNoticia = (TextView) findViewById(R.id.segundaNoticia);
        terNoticia = (TextView) findViewById(R.id.terceraNoticia);
        cuarNoticia = (TextView) findViewById(R.id.cuartaNoticia);
        ultiRes = (TextView) findViewById(R.id.ultimoResultadoMenuPrincipal);

        Usuario usu = (Usuario) getIntent().getSerializableExtra("Usuario");

        bienvenida.setText(getString(R.string.bienvenido) + " " + usu.getNombre());
        ultimaHora.setSelected(true);

        ultiRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirResultados();
            }
        });

        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VentanaClub.class);
                startActivity(i);
            }
        });

        plantilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VentanaPlantilla.class);
                startActivity(i);
            }
        });

        resultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               abrirResultados();
            }
        });

        cSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        ultimasNoticias();
        cargarClasificacion();
        getResultados();
    }



    private void abrirResultados(){
        Intent i = new Intent(getApplicationContext(), VentanaResultados.class);
        startActivity(i);
    }

    private void getResultados(){
        Resultado res = usrDAO.getResultados().get(0);
        binding.setPartidoUltimo(res);

    }
    private void ultimasNoticias(){
        ArrayList<Noticia> noticias = usrDAO.getUltimasNoticias();

        if(noticias.size() >=1){
            primNoticia.setText(noticias.get(0).titulo);
            primNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VentanaNoticias.class);
                i.putExtra("Noticia",noticias.get(0));
                startActivity(i);
            }
            });
        }
        else
            primNoticia.setText("");

        if(noticias.size() >=2){
            segNoticia.setText(noticias.get(1).titulo);
            segNoticia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), VentanaNoticias.class);
                    i.putExtra("Noticia",noticias.get(1));
                    startActivity(i);
                }
            });
        }
        else
            segNoticia.setText("");

        if(noticias.size() >=3){
            terNoticia.setText(noticias.get(2).titulo);
            terNoticia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), VentanaNoticias.class);
                    i.putExtra("Noticia",noticias.get(2));
                    startActivity(i);
                }
            });
        }
        else
            terNoticia.setText("");


        if(noticias.size() == 4){
            cuarNoticia.setText(noticias.get(3).titulo);
            cuarNoticia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), VentanaNoticias.class);
                    i.putExtra("Noticia",noticias.get(3));
                    startActivity(i);
                }
            });
        }
        else
            cuarNoticia.setText("");



    }

    private void cargarClasificacion(){
        ArrayList<EquipoClasificacion> clasi = usrDAO.getClasificacion();
        binding.setClasificacion(clasi);

    }

    public void abroClasificacion(View view) {
        Intent i = new Intent(getApplicationContext(), VentanaClasificacion.class);
        startActivity(i);
    }
}
