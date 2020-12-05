package com.example.manutd_danieldipasqua;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BDDAOSqlLite {
    private BDUnited appbd;
    private Context context;

    BDDAOSqlLite(Context context){
        this.context=context;
        this.appbd= new BDUnited(this.context);
    }

    public Usuario getUsuario(String login, String password) {
        Usuario resultado = null;
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String[] param = {login, login, password};
        String consulta = "SELECT * FROM usuarios WHERE (usuario LIKE(?) OR correo LIKE (?)) AND contra LIKE (?)";
        Cursor cursor = sqlLiteDB.rawQuery(consulta, param);

        if (cursor.moveToFirst()) {
            resultado = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        }
        return resultado;
    }

    public boolean existeUsuario(String login, String correo) {
        Usuario resultado = null;
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String[] param = {login, correo};
        String consulta = "SELECT * FROM usuarios WHERE usuario LIKE(?) OR correo LIKE (?)";
        Cursor cursor = sqlLiteDB.rawQuery(consulta, param);

        return cursor.moveToFirst();
    }

    public void setUsuario(String usuarioReg, String contraseniaReg,  String nombreReg, String apellidoReg, String correoReg) {
        SQLiteDatabase sqlliteDB = appbd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedReaderUsuario.FeedEntry.COLUMN_NAME_USER, usuarioReg);
        values.put(FeedReaderUsuario.FeedEntry.COLUMN_NAME_PASS, contraseniaReg);
        values.put(FeedReaderUsuario.FeedEntry.COLUMN_NAME_NAME, nombreReg);
        values.put(FeedReaderUsuario.FeedEntry.COLUMN_NAME_SURNAME, apellidoReg);
        values.put(FeedReaderUsuario.FeedEntry.COLUMN_NAME_EMAIL, correoReg);

        sqlliteDB.insert(FeedReaderUsuario.FeedEntry.TABLE_NAME,null, values);
    }


    public ArrayList<Resultado> getResultados(){
        ArrayList<Resultado> resultados = new ArrayList<>();
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String consulta = "SELECT rival, campo, competicion, resultado, fecha FROM resultados ORDER BY fecha DESC";
        Cursor cursor = sqlLiteDB.rawQuery(consulta,null);
        while (cursor.moveToNext())
            resultados.add(new Resultado(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));

        return resultados;
    }

    public ArrayList<Noticia> getUltimasNoticias(){
        ArrayList<Noticia> noticias = new ArrayList<>();
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String consulta = "SELECT titulo, cuerpo, autor, fechahora FROM noticias ORDER BY fechahora DESC LIMIT 4";
        Cursor cursor = sqlLiteDB.rawQuery(consulta,null);
        while(cursor.moveToNext())
            noticias.add(new Noticia(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));

        return noticias;
    }

    public ArrayList<Jugador> getPlantilla(){

        ArrayList<Jugador> jugadores = new ArrayList<>();
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String consulta = "SELECT nombre, apellido, posicion, demarcacion,rol,descripcion,numero,nacionalidad FROM jugadores";
        Cursor cursor = sqlLiteDB.rawQuery(consulta,null);
        while(cursor.moveToNext())
            jugadores.add(new Jugador(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7)));

        return jugadores;
    }

    public ArrayList<EquipoClasificacion> getClasificacion(){
        ArrayList<EquipoClasificacion> clasi = new ArrayList<>();
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String consulta = "SELECT equipo, pj, pg, pe, pp, gf, gc, dg, pts, siglas FROM Clasificacion ORDER BY pts DESC, dg DESC";
        Cursor cursor = sqlLiteDB.rawQuery(consulta,null);
        while(cursor.moveToNext())
            clasi.add(new EquipoClasificacion(cursor.getString(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5),cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getString(9)));

        return clasi;

    }
}
