package com.example.trab1;

import android.content.Context;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<Musics> musicsArrayList;

    public Adapter(Context context, ArrayList<Musics> musicsArrayList) {

        this.context = context;
        this.musicsArrayList = musicsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_musicas, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Musics musics = musicsArrayList.get(position);
        holder.nomeMusica.setText(musics.nome);
        holder.capaMusica.setImageResource(musics.capaMusica);
    }

    @Override
    public int getItemCount() {
        return musicsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView capaMusica;
        TextView nomeMusica, tempo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            capaMusica = itemView.findViewById(R.id.capaMusica);
            nomeMusica = itemView.findViewById(R.id.nomeMusica);
            tempo = itemView.findViewById(R.id.tempo);
        }
    }

}
