package com.example.trab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    private Serializable musicsArrayList = new ArrayList<Musics>(){};

    private TextView nome;
    private ImageView capa;

    private int[] musica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        nome = findViewById(R.id.nome);
        capa = findViewById(R.id.capa);
        ;
        nome.setText(intent.getStringExtra("nome"));
        capa.setImageResource(intent.getIntExtra("capa", 0));


    }
}