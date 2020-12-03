package com.example.danielfigueroa_parcial2;

public class Pregunta {

    String id;
    int nivel;
    String pregunta;

    public Pregunta (){

    }

    public Pregunta (String id, int nivel, String pregunta){

        this.id = id;
        this.nivel = nivel;
        this.pregunta = pregunta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
