package com.example.manutd_danieldipasqua;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*Clase que extiende SQLiteOpenHelper, que va a realizar la conexión a la base de datos especificada*/
public class BDUnited extends SQLiteOpenHelper {
    public final static String NOME_BD = "dbunited.db";
    public final static int VERSION_BD = 1;

    public BDUnited (Context context) {
        super(context, NOME_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
