package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.meow.testanime.DBModels.AnimeDB;
import com.meow.testanime.DBModels.CharDB;
import com.meow.testanime.DBModels.MangaDB;
import com.meow.testanime.ModelsAnime.Data;
import com.meow.testanime.TableData.DBHandlerChar;
import com.meow.testanime.TableData.DBHandlerManga;
import com.meow.testanime.VIewHolderAndAdapters.CharStarAdapter;
import com.meow.testanime.VIewHolderAndAdapters.MangaWatchListAdapter;

import java.util.List;

public class CharStarred extends AppCompatActivity implements SelectListener {

    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        DBHandlerChar db = new DBHandlerChar(this);
        List<CharDB> data = db.getCharWatchList();
        CharStarAdapter charWatchListAdapter = new CharStarAdapter(this, data, this);
        recyclerView.setAdapter(charWatchListAdapter);
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

    }

    @Override
    public void OnCharacterClicked(CharDB data) {
        startActivity(new Intent(CharStarred.this, CharStarredDetails.class).putExtra("data", data));
    }
}