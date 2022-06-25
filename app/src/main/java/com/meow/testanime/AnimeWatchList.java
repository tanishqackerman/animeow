package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.meow.testanime.DBModels.AnimeDB;
import com.meow.testanime.DBModels.CharDB;
import com.meow.testanime.DBModels.MangaDB;
import com.meow.testanime.ModelsAnime.Data;
import com.meow.testanime.TableData.DBHandlerAnime;
import com.meow.testanime.VIewHolderAndAdapters.AnimeAdapter;
import com.meow.testanime.VIewHolderAndAdapters.AnimeWatchListAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnimeWatchList extends AppCompatActivity implements SelectListener {

    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        DBHandlerAnime db = new DBHandlerAnime(this);
        List<AnimeDB> data = db.getAnimeWatchList();
        AnimeWatchListAdapter animeWatchListAdapter = new AnimeWatchListAdapter(this, data, this);
        recyclerView.setAdapter(animeWatchListAdapter);
    }

    @Override
    public void OnAnimeClicked(Data data) {

    }

    @Override
    public void OnMangaClicked(com.meow.testanime.ModelsManga.Data data) {

    }

    @Override
    public void OnCharacterClicked(com.meow.testanime.ModelsCharacter.Data data) {

    }

    @Override
    public void OnMangaClicked(MangaDB mangaDB) {

    }

    @Override
    public void OnAnimeClicked(AnimeDB animeDB) {
        startActivity(new Intent(AnimeWatchList.this, AnimeWatchListDetails.class).putExtra("data", animeDB));
    }

    @Override
    public void OnCharacterClicked(CharDB data) {

    }
}