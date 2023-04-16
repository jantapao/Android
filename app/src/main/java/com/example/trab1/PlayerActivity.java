package com.example.trab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    private Serializable musicsArrayList = new ArrayList<Musics>(){};

    private TextView nome;
    private ImageView capa;

    private FloatingActionButton play;

    private int musica;

    private ProgressBar progressBar;

    private MediaPlayer mediaplayer = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        play = findViewById(R.id.playButton);
        nome = findViewById(R.id.nome);
        capa = findViewById(R.id.capa);
        musica = intent.getIntExtra("som", 0);

        nome.setText(intent.getStringExtra("nome"));
        capa.setImageResource(intent.getIntExtra("capa", 0));

        mediaplayer = MediaPlayer.create(this, musica);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaplayer.isPlaying()){
                    mediaplayer.pause();
                    play.setImageResource(R.drawable.baseline_play_arrow_24);
                }
                else {
                    mediaplayer.start();
                    play.setImageResource(R.drawable.baseline_pause_24);
                }
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaplayer.release();
    }
}