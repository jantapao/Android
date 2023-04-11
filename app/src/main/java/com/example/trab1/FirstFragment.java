package com.example.trab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trab1.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;
    private ArrayList<Musics> musicsArrayList;
    private String[] musicsNome;
    private int[] capaMusica;
    private String[] duracaoMusica;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentFirstBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        dataInitialize();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        Adapter adapter = new Adapter(getContext(), musicsArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void dataInitialize() {

        musicsArrayList = new ArrayList<>();
        musicsNome = new String[]{
                getString(R.string.musica_1),
                getString(R.string.musica_2),
                getString(R.string.musica_3),
                getString(R.string.musica_4),
                getString(R.string.musica_5),
                getString(R.string.musica_6),
                getString(R.string.musica_7)
        };

        capaMusica = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g
        };
        
        duracaoMusica = new String[]{
                getString(R.string.time_1),
                getString(R.string.time_2),
                getString(R.string.time_3),
                getString(R.string.time_4),
                getString(R.string.time_5),
                getString(R.string.time_6),
                getString(R.string.time_7)

        };

        for (int i=0; i< musicsNome.length; i++){
            Musics music = new Musics(musicsNome[i], capaMusica[i]);
            musicsArrayList.add(music);
        }

        

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}