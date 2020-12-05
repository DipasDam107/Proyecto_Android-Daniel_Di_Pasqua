package com.example.manutd_danieldipasqua;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;


public class DialogoLogin extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.sesionNoIniciadaDDP)).setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(getString(R.string.loginIncorrectoDDP))
                .setPositiveButton(getString(R.string.aceptarDDP), new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}