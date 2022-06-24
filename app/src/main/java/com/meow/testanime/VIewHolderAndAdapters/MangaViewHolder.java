package com.meow.testanime.VIewHolderAndAdapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.meow.testanime.R;

import java.util.Objects;

public class MangaViewHolder extends RecyclerView.ViewHolder {
    ImageView animeimage;
    TextView animename;
    CardView animecarditem;


    public MangaViewHolder(@NonNull View itemView) {
        super(itemView);
        animeimage = itemView.findViewById(R.id.animeimage);
        animename = itemView.findViewById(R.id.animename);
        animecarditem = itemView.findViewById(R.id.animecard);
    }
}
