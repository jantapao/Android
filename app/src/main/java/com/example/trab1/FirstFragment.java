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
                System.out.println(position);
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

                for (int i=0; i< musicsNome.length; i++){
                    System.out.println(musicsNome[i]);
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i]);
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

                for (int i=0; i< musicsNome.length; i++){
                    System.out.println(musicsNome[i]);
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i]);
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

                for (int i=0; i< musicsNome.length; i++){
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i]);
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

                for (int i=0; i< musicsNome.length; i++){
                    Musics music = new Musics(musicsNome[i], duracaoMusica[i], capaMusica[i]);
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

        Intent intent = new Intent(getActivity(), PlayerActivity.class);
        startActivity(intent);
    }
}