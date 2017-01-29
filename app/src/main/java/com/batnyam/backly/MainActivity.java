package com.batnyam.backly;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button refresh = (Button) findViewById(R.id.refresh_button);
        final Button setButton = (Button) findViewById(R.id.setButton);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        try {
            String imageUrl = new UnsplashAPI().execute().get();
            new SetImageFromUrl(imageView).execute(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }


        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                try {
                    wallpaperManager.setBitmap(bitmap);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String imageUrl = new UnsplashAPI().execute().get();
                    new SetImageFromUrl(imageView).execute(imageUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }






}