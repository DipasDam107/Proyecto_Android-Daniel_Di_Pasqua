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

public class registroMenu extends AppCompatActivity {

    private Button registrar;
    private Button volver;
    private EditText nombre;
    private EditText apellido;
    private EditText usuario;
    private EditText contra;
    private EditText correo;

    BDDAOSqlLite usrDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_registro);

        usrDAO = new BDDAOSqlLite(this);

        registrar = (Button) findViewById(R.id.registrarseButton);
        volver = (Button) findViewById(R.id.volverButton);
        nombre = (EditText) findViewById(R.id.nombreEditText);
        apellido = (EditText) findViewById(R.id.apellidoEditText);
        correo = (EditText) findViewById(R.id.correoEditText);
        contra = (EditText) findViewById(R.id.contraRegistroEditText);
        usuario = (EditText) findViewById(R.id.nomUsuarioEditText);

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

    private void registrar(){
        if(Comprobaciones.comprobarTexto(nombre.getText().toString()))
            if(Comprobaciones.comprobarTexto(apellido.getText().toString()))
                if(Comprobaciones.comprobarTexto(usuario.getText().toString()))
                    if(Comprobaciones.comprobarTexto(contra.getText().toString()))
                        if(Comprobaciones.comprobarCorreo(correo.getText().toString())){

                            if(!usrDAO.existeUsuario(usuario.getText().toString(), correo.getText().toString())){
                                usrDAO.setUsuario(usuario.getText().toString(), contra.getText().toString(), nombre.getText().toString(), apellido.getText().toString(), correo.getText().toString());
                                Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_LONG).show();
                                finish();
                            }
                            else{

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

    private void registraUsuario(String usuarioReg, String contraseniaReg, String correoReg, String nombreReg, String apellidoReg){


    }
}
