package com.example.trab1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView galleryGridView = view.findViewById(R.id.idGridViewGallery);

        ArrayList<GalleryModel> galleryModelArrayList = new ArrayList<>();

        galleryModelArrayList.add(new GalleryModel(R.drawable.e1));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e2));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e3));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e4));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e5));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e6));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e7));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e8));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e9));
        galleryModelArrayList.add(new GalleryModel(R.drawable.e10));

        galleryModelArrayList.add(new GalleryModel(R.drawable.s1));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s2));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s3));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s4));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s5));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s6));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s7));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s8));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s9));
        galleryModelArrayList.add(new GalleryModel(R.drawable.s10));

        galleryModelArrayList.add(new GalleryModel(R.drawable.p1));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p2));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p3));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p4));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p5));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p6));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p7));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p8));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p9));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p10));

        GalleryAdapter adapter = new GalleryAdapter(view.getContext(), galleryModelArrayList);

        galleryGridView.setAdapter(adapter);
    }
}