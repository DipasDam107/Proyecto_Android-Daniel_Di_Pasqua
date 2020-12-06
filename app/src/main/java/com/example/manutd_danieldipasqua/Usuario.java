package com.example.manutd_danieldipasqua;

import java.io.Serializable;

/*Clase usuario que permite almacenar el usuario que se conecta a la app*/
public class Usuario implements Serializable {
    String nombre, apellido, usuario, contra, correo;

    public Usuario(String usuario, String contra,String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contra = contra;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }




}
