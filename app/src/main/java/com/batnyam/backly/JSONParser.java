package com.batnyam.backly;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * Created by batnyam on 12/19/16.
 */
public class JSONParser  {
    JSONObject jsonObject, thumb;
    String image;
    public String getData(String data) {
        try {
            jsonObject = new JSONObject(data);
            String jj = jsonObject.getString("urls");
            thumb = new JSONObject(jj);
            image = thumb.getString("regular");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }
}
