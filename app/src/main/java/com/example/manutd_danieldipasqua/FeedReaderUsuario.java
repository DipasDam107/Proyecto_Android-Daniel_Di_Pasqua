package com.example.manutd_danieldipasqua;

import android.provider.BaseColumns;

/*Clase utilizada para registrar usuarios*/
public final class FeedReaderUsuario {

    private FeedReaderUsuario() {}
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuarios";
        public static final String COLUMN_NAME_USER = "usuario";
        public static final String COLUMN_NAME_PASS = "contra";
        public static final String COLUMN_NAME_NAME = "nombre";
        public static final String COLUMN_NAME_SURNAME = "apellido";
        public static final String COLUMN_NAME_EMAIL = "correo";
    }
}