package com.example.manutd_danieldipasqua;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

/*Clase de la ventana de registro*/
public class registroMenu extends AppCompatActivity {

    /*Inicializo variables de los controles*/
    private Button registrar;
    private Button volver;
    private EditText nombre;
    private EditText apellido;
    private EditText usuario;
    private EditText contra;
    private EditText correo;

    /*Inicializo la clase de acceso a BD*/
    BDDAOSqlLite usrDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_registro);

        /* Instancio la clase de acceso a BD*/
        usrDAO = new BDDAOSqlLite(this);

        /*Meto controles en las variables respectivas*/
        registrar = (Button) findViewById(R.id.registrarseButton);
        volver = (Button) findViewById(R.id.volverButton);
        nombre = (EditText) findViewById(R.id.nombreEditText);
        apellido = (EditText) findViewById(R.id.apellidoEditText);
        correo = (EditText) findViewById(R.id.correoEditText);
        contra = (EditText) findViewById(R.id.contraRegistroEditText);
        usuario = (EditText) findViewById(R.id.nomUsuarioEditText);

        /*Declaro los listeners anónimos*/
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });

        correo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    registrar();
                    return true;
                }
                return false;
            }
        });
    }

    /*Esta funcion se llama dandole a OK desde el correo (ime action send) o bien dando al botón registrar*/
    private void registrar(){
        /*Realiza las comprobaciones de campos*/
        if(Comprobaciones.comprobarTexto(nombre.getText().toString()))
            if(Comprobaciones.comprobarTexto(apellido.getText().toString()))
                if(Comprobaciones.comprobarTexto(usuario.getText().toString()))
                    if(Comprobaciones.comprobarTexto(contra.getText().toString()))
                        if(Comprobaciones.comprobarCorreo(correo.getText().toString())){

                            /*Si los campos son válidos, comprueba si existe el usuario con ese correo o con ese nombre. En caso contrario llama a la funcióm que crea el usuario en la BD*/
                            if(!usrDAO.existeUsuario(usuario.getText().toString(), correo.getText().toString())){
                                usrDAO.setUsuario(usuario.getText().toString(), contra.getText().toString(), nombre.getText().toString(), apellido.getText().toString(), correo.getText().toString());
                                Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_LONG).show();
                                finish();
                            }
                            else{
                                /*En caso de que exista el usuario muestra una ventana de dialogo con el error*/
                                DialogoRegistro d= new DialogoRegistro();
                                d.setCancelable(false);
                                FragmentManager fm= this.getSupportFragmentManager();
                                d.show(fm,getString(R.string.errorRegistro));
                            }

                        }
                        else
                            Toast.makeText(getApplicationContext(), getString(R.string.errorCorreo), Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), getString(R.string.errorContra), Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), getString(R.string.errorUsuario), Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), getString(R.string.errorApellido), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), getString(R.string.errorNombre), Toast.LENGTH_LONG).show();


    }

}
