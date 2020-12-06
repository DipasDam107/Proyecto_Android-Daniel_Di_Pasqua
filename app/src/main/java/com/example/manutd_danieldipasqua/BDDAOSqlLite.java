package com.example.manutd_danieldipasqua;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/*Clase que se encargará de acceder a la base de datos y obtener o escribir los datos necesarios*/
public class BDDAOSqlLite {
    private BDUnited appbd;
    private Context context;

    BDDAOSqlLite(Context context){
        this.context=context;
        this.appbd= new BDUnited(this.context);
    }

    /*Obtiene el usuario para validar el inicio de sesion y lo devuelve. Si devuelve uno es que el usuario se ha validado correctamente, si devuelve nulo es que no existe y el inicio de sesión no es correcto*/
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

    /*Metodo que comprueba si ya existe un usuario con ese nombre o correo a la hora de registrar, en cuyo caso el registro es inválido.*/
    public boolean existeUsuario(String login, String correo) {
        Usuario resultado = null;
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String[] param = {login, correo};
        String consulta = "SELECT * FROM usuarios WHERE usuario LIKE(?) OR correo LIKE (?)";
        Cursor cursor = sqlLiteDB.rawQuery(consulta, param);

        return cursor.moveToFirst();
    }

    /*Se recibe los datos del usuario registrado y se inserta en la base de datos correspondiente*/
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


    /*Se obtienen los datos de la tabla resultados, y se devuelven en forma de arraylist de resultado a la funcion que invoca este metodo*/
    public ArrayList<Resultado> getResultados(){
        ArrayList<Resultado> resultados = new ArrayList<>();
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String consulta = "SELECT rival, campo, competicion, resultado, fecha FROM resultados ORDER BY fecha DESC";
        Cursor cursor = sqlLiteDB.rawQuery(consulta,null);
        while (cursor.moveToNext())
            resultados.add(new Resultado(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));

        return resultados;
    }

    /*Se obtienen las noticias de la base de datos y se devuelven en formato de arraylist de noticia a la funcion que invoca este metodo*/
    public ArrayList<Noticia> getUltimasNoticias(){
        ArrayList<Noticia> noticias = new ArrayList<>();
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String consulta = "SELECT titulo, cuerpo, autor, fechahora FROM noticias ORDER BY fechahora DESC LIMIT 4";
        Cursor cursor = sqlLiteDB.rawQuery(consulta,null);
        while(cursor.moveToNext())
            noticias.add(new Noticia(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));

        return noticias;
    }

    /*Se obtiene los jugadores en plantilla de la base de datos y se retorna un arraylist de jugadores a quien invoque*/
    public ArrayList<Jugador> getPlantilla(){

        ArrayList<Jugador> jugadores = new ArrayList<>();
        SQLiteDatabase sqlLiteDB = appbd.getWritableDatabase();
        String consulta = "SELECT nombre, apellido, posicion, demarcacion,rol,descripcion,numero,nacionalidad FROM jugadores";
        Cursor cursor = sqlLiteDB.rawQuery(consulta,null);
        while(cursor.moveToNext())
            jugadores.add(new Jugador(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7)));

        return jugadores;
    }

    /*Obtiene la clasificación en base de datos y devuelve el arraylist de equipos a quien lo invoque*/
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
