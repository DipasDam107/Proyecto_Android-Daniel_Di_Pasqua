package com.example.manutd_danieldipasqua;

public class Jugador {
    String nombre, apellido, posicion, demarcacion, rol, descripcion, nacionalidad, rep;
    int numero;

    public Jugador(String nombre, String apellido, String posicion, String demarcacion, String rol, String descripcion, int numero, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.demarcacion = demarcacion;
        this.rol = rol;
        this.descripcion = descripcion;
        this.numero = numero;
        this.nacionalidad = nacionalidad;
        this.rep = numero + ". " + apellido;
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    @Override
    public String toString() {
        return rep;
    }
}
