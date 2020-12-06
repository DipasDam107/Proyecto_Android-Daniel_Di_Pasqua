package com.example.manutd_danieldipasqua;

/*Clase utilizada para construir el arraylist de equipos de la clasificacion*/
public class EquipoClasificacion{

    String equipo, siglas;
    int pjugado, pganado, pempatado, pperdido, gfavor,gcontra, dgoles, pts;

    public EquipoClasificacion(String equipo, int pjugado, int pganado, int pempatado, int pperdido, int gfavor, int gcontra, int dgoles, int pts, String siglas) {
        this.equipo = equipo;
        this.siglas = siglas;
        this.pjugado = pjugado;
        this.pganado = pganado;
        this.pempatado = pempatado;
        this.pperdido = pperdido;
        this.gfavor = gfavor;
        this.gcontra = gcontra;
        this.dgoles = dgoles;
        this.pts = pts;
    }

    public int getPempatado() {
        return pempatado;
    }

    public void setPempatado(int pempatado) {
        this.pempatado = pempatado;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getPjugado() {
        return pjugado;
    }

    public void setPjugado(int pjugado) {
        this.pjugado = pjugado;
    }

    public int getPganado() {
        return pganado;
    }

    public void setPganado(int pganado) {
        this.pganado = pganado;
    }

    public int getPperdido() {
        return pperdido;
    }

    public void setPperdido(int pperdido) {
        this.pperdido = pperdido;
    }

    public int getGfavor() {
        return gfavor;
    }

    public void setGfavor(int gfavor) {
        this.gfavor = gfavor;
    }

    public int getGcontra() {
        return gcontra;
    }

    public void setGcontra(int gcontra) {
        this.gcontra = gcontra;
    }

    public int getDgoles() {
        return dgoles;
    }

    public void setDgoles(int dgoles) {
        this.dgoles = dgoles;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
}
