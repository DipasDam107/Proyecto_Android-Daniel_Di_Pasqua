package com.example.manutd_danieldipasqua;

import android.provider.BaseColumns;

public final class FeedReaderUsuario {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderUsuario() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuarios";
        public static final String COLUMN_NAME_USER = "usuario";
        public static final String COLUMN_NAME_PASS = "contra";
        public static final String COLUMN_NAME_NAME = "nombre";
        public static final String COLUMN_NAME_SURNAME = "apellido";
        public static final String COLUMN_NAME_EMAIL = "correo";
    }
}