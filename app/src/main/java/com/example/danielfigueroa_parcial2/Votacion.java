package com.example.danielfigueroa_parcial2;

public class Votacion {

    String idPregunta;
    int numeros;


    public Votacion() {

    }

    public Votacion(String idPregunta, int numeros) {

        this.idPregunta = idPregunta;
        this.numeros = numeros;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getNumeros() {
        return numeros;
    }

    public void setNumeros(int numeros) {
        this.numeros = numeros;
    }
}


