package com.example.manutd_danieldipasqua;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comprobaciones {

    /*Comprobación que se asegura de que no se ha introducido un String vacío*/
    public static boolean comprobarTexto(String texto){
        if(texto.length() > 0)
            return true;
        else
            return false;
    }

    /*Comprueba que el correo tiene formato adecuado*/
    public static boolean comprobarCorreo(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
