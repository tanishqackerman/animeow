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

import com.meow.testanime.Models.AnimeAPIResponse;
import com.meow.testanime.Models.Data;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener {

    private RecyclerView recyclerView;
    private AnimeAdapter animeAdapter;
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
        manager.getAnimeTop(listener);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RequestManager manager = new RequestManager(MainActivity.this);
                dialog.setTitle("Fetching " + query + " animeow");
                dialog.show();
                manager.getAnimeSearch(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchDataListener<AnimeAPIResponse> listener = new OnFetchDataListener<AnimeAPIResponse>() {
        @Override
        public void onFetchData(List<Data> list, String message) {
            if (list.isEmpty()) Toast.makeText(MainActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
            showAnime(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "An Error Occurred!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showAnime(List<Data> list) {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        animeAdapter = new AnimeAdapter(this, list, this);
        recyclerView.setAdapter(animeAdapter);
    }

    @Override
    public void OnAnimeClicked(Data data) {
        startActivity(new Intent(MainActivity.this, AnimeDetails.class).putExtra("data", data));
    }
}