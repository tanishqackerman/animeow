package com.meow.testanime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meow.testanime.Models.AnimeAPIResponse;
import com.meow.testanime.Models.Data;
import com.meow.testanime.Models.Images;
import com.meow.testanime.Models.Jpg;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeViewHolder> {

    private Context context;
    private List<Data> data;
    private SelectListener listener;

    public AnimeAdapter(Context context, List<Data> data, SelectListener listener) {
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
        holder.animename.setText(data.get(position).getTitle());
        Images imgdata = data.get(position).getImages();
        Jpg imgjpg = imgdata.getJpg();
        if (imgjpg.getImageUrl() != null) Picasso.get().load(imgjpg.getImageUrl()).into(holder.animeimage);

        holder.animecarditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnAnimeClicked(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
