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

import com.meow.testanime.ModelsCharacter.Data;
import com.meow.testanime.ModelsCharacter.CharAPIResponse;
import com.meow.testanime.VIewHolderAndAdapters.CharAdapter;

import java.util.List;

public class CharMainActivity extends AppCompatActivity implements SelectListener{

    private RecyclerView recyclerView;
    private CharAdapter charAdapter;
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
        manager.getCharTop(listener);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RequestManager manager = new RequestManager(CharMainActivity.this);
                dialog.setTitle("Fetching " + query + " animeow");
                dialog.show();
                manager.getCharSearch(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchCharacterDataListener<CharAPIResponse> listener = new OnFetchCharacterDataListener<CharAPIResponse>() {
        @Override
        public void onFetchCharacterData(List<Data> list, String message) {
            if (list.isEmpty()) Toast.makeText(CharMainActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
            showChar(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(CharMainActivity.this, "An Error Occurred!" + message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showChar(List<Data> list) {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        charAdapter = new CharAdapter(this, list, this);
        recyclerView.setAdapter(charAdapter);
    }

    @Override
    public void OnAnimeClicked(com.meow.testanime.ModelsAnime.Data data) {

    }

    @Override
    public void OnMangaClicked(com.meow.testanime.ModelsManga.Data data) {

    }

    @Override
    public void OnCharacterClicked(com.meow.testanime.ModelsCharacter.Data data) {
        startActivity(new Intent(CharMainActivity.this, CharDetails.class).putExtra("data", data));
    }
}