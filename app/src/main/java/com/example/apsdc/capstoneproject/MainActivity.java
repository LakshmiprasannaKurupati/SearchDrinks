package com.example.apsdc.capstoneproject;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imagesec);
        editText = findViewById(R.id.editmain);

    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo networkInfo: netInfo) {
            if (networkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                if (networkInfo.isConnected()) {
                    haveConnectedWifi = true;
                }
            } else if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (networkInfo.isConnected()) {
                    haveConnectedMobile = true;
                }
            }
        }
        return haveConnectedWifi || haveConnectedMobile;


    }


    public void search(View view) {
        if (editText.getText().toString().length() > 0) {
            if (haveNetworkConnection() == true) {
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("key",editText.getText().toString());
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "you don't have  connection", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Please enter any name...", Toast.LENGTH_SHORT).show();
        }
    }
}




