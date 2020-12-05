package com.example.manutd_danieldipasqua;

public class Resultado {
    private String rival, campo, competicion, resultado;

    public Resultado(String rival, String campo, String competicion, String resultado) {
        this.rival = rival;
        this.campo = campo;
        this.competicion = competicion;
        this.resultado = resultado;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getUltimoResultado(){
        if(this.campo.equals("Old Trafford"))
            return "Ultima Hora: Manchester United " + resultado + " " + rival + " (Final del Partido)";
        else
            return "Ultima Hora: " + rival + " " + resultado + " Manchester United (Final del Partido)";

    }
}
