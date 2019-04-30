package com.example.apsdc.capstoneproject;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    RecyclerView recyclerView;
    String dName;

    String uRL = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recyclemain);
        dName = getIntent().getStringExtra("key");
        Bundle bundle = new Bundle();
        bundle.putString("key1", dName);
        getSupportLoaderManager().initLoader(2, bundle, this);
    }

    @NonNull
    @Override
    public Loader onCreateLoader(int i, @Nullable Bundle bundle) {
        return new DrinksLoader(this, uRL+bundle.getString("key1"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader loader, String o) {
        if (o == null) {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        } else {
            ArrayList<CockTailModel> list = new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(o);
                JSONArray jsonArray = jsonObject.getJSONArray("drinks");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject image = jsonArray.getJSONObject(i);
                    String drinkThumb = image.optString("strDrinkThumb");
                    String ids = image.getString("idDrink");
                    String name=jsonArray.optString("name");
                    CockTailModel cockTailModel = new CockTailModel(drinkThumb, ids);
                    list.add(cockTailModel);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            recyclerView.setAdapter(new DrinksAdapter(this, list));

        }
    }
    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }
}

