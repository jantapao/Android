package com.example.trab1;

import java.io.Serializable;

public class Musics implements Serializable {

    String nome;

    String tempo;
    int capaMusica;

    int somMusica;

    public Musics(String nome, String tempo, int capaMusica, int somMusica) {
        this.nome = nome;
        this.capaMusica = capaMusica;
        this.tempo = tempo;
        this.somMusica = somMusica;
    }

}
