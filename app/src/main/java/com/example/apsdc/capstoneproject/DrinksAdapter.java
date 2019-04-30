package com.example.apsdc.capstoneproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder> {
    SecondActivity secondActivity;
    ArrayList<CockTailModel> cockTailModels;
    public DrinksAdapter(SecondActivity secondActivity, ArrayList<CockTailModel> list) {
        this.secondActivity=secondActivity;
        this.cockTailModels=list;
    }

    @NonNull
    @Override
    public DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DrinksViewHolder(LayoutInflater
                .from(secondActivity).inflate(R.layout.recycle,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksViewHolder drinksViewHolder, int i) {
        Picasso.with(secondActivity)
                .load(cockTailModels.get(i).getDrinkThumb())
                .placeholder(R.drawable.ic_launcher_background).into(drinksViewHolder.imageView);
    drinksViewHolder.textView.setText(cockTailModels.get(i).getIds());

    }

    @Override
    public int getItemCount() {
        return cockTailModels.size();
    }

    public class DrinksViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public DrinksViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagesec);
            textView=itemView.findViewById(R.id.recycle_coctail);
        }
    }
}
