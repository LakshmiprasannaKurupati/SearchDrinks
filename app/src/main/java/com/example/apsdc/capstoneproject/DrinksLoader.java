package com.example.apsdc.capstoneproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class DrinksLoader extends AsyncTaskLoader {
    String url;
    public DrinksLoader(Context context, String s) {
        super(context);
        this.url=s;

    }

    @Nullable
    @Override
    public Object loadInBackground() {
        try {
            URL url1=new URL(url);
            HttpURLConnection connection= (HttpURLConnection) url1.openConnection();
            InputStream inputStream=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            StringBuilder builder=new StringBuilder();
            while ((line=reader.readLine())!=null)
            {
                builder.append(line+"\n");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
