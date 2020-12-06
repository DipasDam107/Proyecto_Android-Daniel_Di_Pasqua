package com.example.manutd_danieldipasqua;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

/*Clase que extiende dialogfragment. Se usa al especificar un registro incorrecto */
public class DialogoRegistro extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.errorRegistro)).setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(getString(R.string.registroIncorrecto))
                .setPositiveButton(getString(R.string.aceptarDDP), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }

}
