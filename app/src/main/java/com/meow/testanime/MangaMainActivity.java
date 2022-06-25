package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.meow.testanime.DBModels.AnimeDB;
import com.meow.testanime.DBModels.CharDB;
import com.meow.testanime.DBModels.MangaDB;
import com.meow.testanime.ModelsManga.Data;
import com.meow.testanime.ModelsManga.MangaAPIResponse;
import com.meow.testanime.VIewHolderAndAdapters.AnimeAdapter;
import com.meow.testanime.VIewHolderAndAdapters.MangaAdapter;

import java.util.List;

public class MangaMainActivity extends AppCompatActivity implements SelectListener {

    private RecyclerView recyclerView;
    private MangaAdapter mangaAdapter;
    private SearchView searchView;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.querysearch);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching Top animeows...");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getMangaTop(listener);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RequestManager manager = new RequestManager(MangaMainActivity.this);
                dialog.setTitle("Fetching " + query + " animeow");
                dialog.show();
                manager.getMangaSearch(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchMangaDataListener<MangaAPIResponse> listener = new OnFetchMangaDataListener<MangaAPIResponse>() {
        @Override
        public void onFetchMangaData(List<Data> list, String message) {
            if (list.isEmpty()) Toast.makeText(MangaMainActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
            showAnime(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MangaMainActivity.this, "An Error Occurred!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showAnime(List<Data> list) {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mangaAdapter = new MangaAdapter(this, list, this);
        recyclerView.setAdapter(mangaAdapter);
    }

    @Override
    public void OnAnimeClicked(com.meow.testanime.ModelsAnime.Data data) {

    }

    @Override
    public void OnMangaClicked(Data data) {
        startActivity(new Intent(MangaMainActivity.this, MangaDetails.class).putExtra("data", data));
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

    }
}