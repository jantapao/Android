package com.example.trab1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GalleryAdapter extends ArrayAdapter<GalleryModel> {
    public GalleryAdapter(@NonNull Context context, ArrayList<GalleryModel> galleryModelArraylist) {
        super(context, 0, galleryModelArraylist);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null)
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);

        GalleryModel galeryModel = getItem(position);
        ImageView imageView = itemView.findViewById(R.id.idImageViewGallery);

        imageView.setImageResource(galeryModel.getImageId());

        /**
         * A View finalItemView foi criada pois a itemView era utilizada dentro da classe,
         * o que impossibilita a utlização da mesma no OnClickListener(), uma vez que ela
         * demanda uma View que não será modificada posteriormente no código
         */
        View finalItemView = itemView;

        imageView.setOnClickListener(view -> {
            Intent imageFullScreen = new Intent(finalItemView.getContext(), ImageFullScreen.class);
            imageFullScreen.putExtra("imageId", galeryModel.getImageId());
            finalItemView.getContext().startActivity(imageFullScreen);
        });

        return itemView;
    }
}
