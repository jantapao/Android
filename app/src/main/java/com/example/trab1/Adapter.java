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

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<Musics> musicsArrayList;

    public Adapter(Context context, ArrayList<Musics> musicsArrayList, RecyclerViewInterface recyclerViewInterface) {

        this.context = context;
        this.musicsArrayList = musicsArrayList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_musicas, parent, false);

        return new MyViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Musics musics = musicsArrayList.get(position);
        holder.nomeMusica.setText(musics.nome);
        holder.capaMusica.setImageResource(musics.capaMusica);
        holder.tempo.setText(musics.tempo);
    }

    @Override
    public int getItemCount() {
        return musicsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView capaMusica;
        TextView nomeMusica, tempo;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            capaMusica = itemView.findViewById(R.id.capaMusica);
            nomeMusica = itemView.findViewById(R.id.nomeMusica);
            tempo = itemView.findViewById(R.id.tempo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

}
