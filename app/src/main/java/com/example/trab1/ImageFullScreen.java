package com.example.trab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ImageFullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full_screen);

        ImageView imageView = findViewById(R.id.idImageViewImageFull);

        imageView.setImageResource(getIntent().getIntExtra("imageId", 0));
    }
}