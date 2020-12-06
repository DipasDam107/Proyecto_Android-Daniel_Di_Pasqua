package com.example.manutd_danieldipasqua;

import java.io.Serializable;

/*Clase noticia que se encarga de almacenar los datos de las noticias en base de datos*/
public class Noticia implements Serializable {
    String titulo, cuerpo, autor, fecha;

    public Noticia(String titulo, String cuerpo, String autor, String fecha) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutorFecha(){
        return "Autor: " +  this.autor + "\r\nFecha: " + this.fecha;
    }
}
