package com.batnyam.backly;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by batnyam on 12/20/16.
 */
public class SetImageFromUrl extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;
    private Bitmap bitmap;

    public SetImageFromUrl(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String url = params[0];
        try {
            InputStream inputStream = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap s) {
        imageView.setImageBitmap(s);
    }
}
