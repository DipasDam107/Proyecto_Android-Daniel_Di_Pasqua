package com.example.manutd_danieldipasqua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    BDDAOSqlLite usrDAO;

    private Button registrar;
    private Button login;
    private EditText usuario;
    private EditText contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        copiarBD();
        usrDAO = new BDDAOSqlLite(this);

        /* Botones */
        registrar = (Button)findViewById(R.id.registroButton);
        login = (Button)findViewById(R.id.loginButton);
        usuario =(EditText) findViewById(R.id.usuarioEditText);
        contra  = (EditText)findViewById(R.id.contraEditText);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, registroMenu.class);
                startActivity(i);
                contra.setText("");
                usuario.setText("");
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaSesion();
            }
        });

        contra.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    iniciaSesion();
                    return true;
                }
                return false;
            }
        });

    }

    private void iniciaSesion(){
        if(Comprobaciones.comprobarTexto(usuario.getText().toString()))
            if(Comprobaciones.comprobarTexto(contra.getText().toString()))
            {
                Usuario usr = usrDAO.getUsuario(usuario.getText().toString(), contra.getText().toString());

                if(usr != null){
                    Toast.makeText(getApplicationContext(), "Iniciando Sesion...", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, MenuPrincipal.class);
                    i.putExtra("Usuario", usr);
                    startActivity(i);
                    finish();
                }
                else{
                    DialogoLogin d= new DialogoLogin();
                    d.setCancelable(false);
                    FragmentManager fm= this.getSupportFragmentManager();
                    d.show(fm,getString(R.string.errorLogin));
                }

            }
            else
                Toast.makeText(getApplicationContext(), getString(R.string.errorContra), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), getString(R.string.errorUsuario), Toast.LENGTH_LONG).show();
    }

    private void copiarBD() {
        String bddestino = "/data/data/" + getPackageName() + "/databases/"
                + BDUnited.NOME_BD;

        File file = new File(bddestino);

        if (file.exists())
            return;



        String pathbd = "/data/data/" + getPackageName()
                + "/databases/";
        File filepathdb = new File(pathbd);
        filepathdb.mkdirs();


        InputStream inputstream;
        try {
            inputstream = getAssets().open(BDUnited.NOME_BD);
            OutputStream outputstream = new FileOutputStream(bddestino);


            int tamread;
            byte[] buffer = new byte[2048];


            while ((tamread = inputstream.read(buffer)) > 0) {
                outputstream.write(buffer, 0, tamread);
            }


            inputstream.close();
            outputstream.flush();
            outputstream.close();
            Toast.makeText(getApplicationContext(), "BD Copiada", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}