package com.meow.testanime.VIewHolderAndAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meow.testanime.DBModels.CharDB;
import com.meow.testanime.R;
import com.meow.testanime.SelectListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharStarAdapter extends RecyclerView.Adapter<AnimeViewHolder> {

    private Context context;
    private List<CharDB> data;
    private SelectListener listener;

    public CharStarAdapter(Context context, List<CharDB> data, SelectListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimeViewHolder(LayoutInflater.from(context).inflate(R.layout.animeitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.animename.setText(data.get(position).getCharname());
        if (data.get(position).getImgurl() != null) Picasso.get().load(data.get(position).getImgurl()).into(holder.animeimage);

        holder.animecarditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnCharacterClicked(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
