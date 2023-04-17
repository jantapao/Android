package com.example.trab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GalleryAdapter extends ArrayAdapter<GalleryModel> {
    public GalleryAdapter(@NonNull Context context, ArrayList<GalleryModel> galleryModelArraylist) {
        super(context, 0, galleryModelArraylist);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);

        GalleryModel galeryModel = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.idImageViewGallery);

        imageView.setImageResource(galeryModel.getImageId());

        return listItemView;
    }
}
