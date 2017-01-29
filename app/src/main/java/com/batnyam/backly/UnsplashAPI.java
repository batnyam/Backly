package com.batnyam.backly;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;

/**
 * Created by batnyam on 12/17/16.
 */
public class UnsplashAPI extends AsyncTask<String, Void, String> {
    // Constructor Function

    @Override
    protected String doInBackground(String... params) {
        String image_url = null;

        try {
            String mainURL = "https://api.unsplash.com/photos/random?client_id=d2326752245eb781ebd153606e21f9a50ff10990030d5bf872a17927d5c3acae";
            URL callURL = new URL(mainURL);
            URLConnection urlConnection = callURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //String data;
            JSONParser jsonParser = new JSONParser();
            String data = null;
            while ((data = in.readLine()) != null) {
                image_url = jsonParser.getData(data);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("url", image_url);
        return image_url;
    }
}
