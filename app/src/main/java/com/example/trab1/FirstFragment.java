package com.example.trab1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trab1.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements RecyclerViewInterface{

    private FragmentFirstBinding binding;
    private ArrayList<Musics> musicsArrayList = new ArrayList<Musics>(){};
    private String[] musicsNome;
    private int[] capaMusica;

    private int[] somMusica;
    private String[] duracaoMusica;
    private RecyclerView recyclerView;
    private MediaPlayer mediaPlayer;

    private Spinner generos;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        Adapter adapter = new Adapter(getContext(), musicsArrayList, this);
        recyclerView.setAdapter(adapter);


        generos = view.findViewById(R.id.Spinner1);
        ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(getContext().getApplicationContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.tipos));

        generos.setAdapter(spinadapter);
        generos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dataInitialize(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                dataInitialize(3);
            }
        });


    }

    private void dataInitialize(int opcao) {

        switch (opcao){
            case 0:
                musicsArrayList = new ArrayList<>();
                musicsNome = getResources().getStringArray(R.array.todos);

                capaMusica = new int[]{
                        R.drawable.s1,
                        R.drawable.s2,
                        R.drawable.s3,
                        R.drawable.s4,
                        R.drawable.s5,
                        R.drawable.s6,
                        R.drawable.s7,
                        R.drawable.s8,
                        R.drawable.s9,
                        R.drawable.s10,
                        R.drawable.e1,
                        R.drawable.e2,
                        R.drawable.e3,
                        R.drawable.e4,
                        R.drawable.e5,
                        R.drawable.e6,
                        R.drawable.e7,
                        R.drawable.e8,
                        R.drawable.e9,
                        R.drawable.e10,
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6,
                        R.drawable.p7,
                        R.drawable.p8,
                        R.drawable.p9,
                        R.drawable.p10,
                };

                duracaoMusica = getResources().getStringArray(R.array.duracao_todos);


                somMusica = new int[]{
                        R.raw.s1,
                        R.raw.s2,
                        R.raw.s3,
                        R.raw.s4,
                        R.raw.s5,
                        R.raw.s6,
                        R.raw.s7,
                        R.raw.s8,
                        R.raw.s9,
                        R.raw.s10,
                        R.raw.p1,
                        R.raw.p2,
                        R.raw.p3,
                        R.raw.p4,
                        R.raw.p5,
                        R.raw.p6,
                        R.raw.p7,
                        R.raw.p8,
                        R.raw.p9,
                        R.raw.p10,
                        R.raw.p1,
                        R.raw.p2,
                        R.raw.p3,
                        R.raw.p4,
                        R.raw.p5,
                        R.raw.p6,
                        R.raw.p7,
                        R.raw.p8,
                        R.raw.p9,
                        R.raw.p10,
                };

                for (int i=0; i< musicsNome.length; i++){
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i], somMusica[i]);
                    musicsArrayList.add(music);
                }
                Adapter adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;

            case 1:
                musicsArrayList = new ArrayList<>();
                musicsNome = getResources().getStringArray(R.array.sertanejos);

                capaMusica = new int[]{
                        R.drawable.s1,
                        R.drawable.s2,
                        R.drawable.s3,
                        R.drawable.s4,
                        R.drawable.s5,
                        R.drawable.s6,
                        R.drawable.s7,
                        R.drawable.s8,
                        R.drawable.s9,
                        R.drawable.s10,
                };

                duracaoMusica = getResources().getStringArray(R.array.duracao_sertanejo);

                somMusica = new int[]{
                        R.raw.s1,
                        R.raw.s2,
                        R.raw.s3,
                        R.raw.s4,
                        R.raw.s5,
                        R.raw.s6,
                        R.raw.s7,
                        R.raw.s8,
                        R.raw.s9,
                        R.raw.s10,
                };

                for (int i=0; i< musicsNome.length; i++){
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i], somMusica[i]);
                    musicsArrayList.add(music);
                }
                adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;
            case 2:
                musicsArrayList = new ArrayList<>();
                musicsNome = getResources().getStringArray(R.array.eletronicas);

                capaMusica = new int[]{
                        R.drawable.e1,
                        R.drawable.e2,
                        R.drawable.e3,
                        R.drawable.e4,
                        R.drawable.e5,
                        R.drawable.e6,
                        R.drawable.e7,
                        R.drawable.e8,
                        R.drawable.e9,
                        R.drawable.e10,
                };

                duracaoMusica = getResources().getStringArray(R.array.duracao_eletronicas);

                somMusica = new int[]{
                        R.raw.e1,
                        R.raw.e2,
                        R.raw.e3,
                        R.raw.e4,
                        R.raw.e5,
                        R.raw.e6,
                        R.raw.e7,
                        R.raw.e8,
                        R.raw.e9,
                        R.raw.e10,
                };

                for (int i=0; i< musicsNome.length; i++){
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i],somMusica[i]);
                    musicsArrayList.add(music);
                }
                adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;
            case 3:
                musicsArrayList = new ArrayList<>();
                musicsNome = getResources().getStringArray(R.array.pagodes);

                capaMusica = new int[]{
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6,
                        R.drawable.p7,
                        R.drawable.p8,
                        R.drawable.p9,
                        R.drawable.p10,
                };

                duracaoMusica = getResources().getStringArray(R.array.duracao_pagodes);

                somMusica = new int[]{
                        R.raw.p1,
                        R.raw.p2,
                        R.raw.p3,
                        R.raw.p4,
                        R.raw.p5,
                        R.raw.p6,
                        R.raw.p7,
                        R.raw.p8,
                        R.raw.p9,
                        R.raw.p10,
                };

                for (int i=0; i< musicsNome.length; i++){
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i],somMusica[i]);
                    musicsArrayList.add(music);
                }
                adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(int position) {

        ArrayList<Musics> music = musicsArrayList;
        Intent intent = new Intent(getActivity(), PlayerActivity.class);
        intent.putExtra("nome", music.get(position).nome);
        intent.putExtra("capa", music.get(position).capaMusica);
        intent.putExtra("som", music.get(position).somMusica);
        startActivity(intent);
    }
}