package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AnimeowHomeScreen extends AppCompatActivity {

    ImageView robin, boa, robinchan, boa1, robinnew, boa3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animeow_home_screen);

        robin = findViewById(R.id.robin);
        boa = findViewById(R.id.boa);
        robinchan = findViewById(R.id.robinchan);
        boa1 = findViewById(R.id.boa1);
        robinnew = findViewById(R.id.robinnew);
        boa3 = findViewById(R.id.boa3);

        robin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimeowHomeScreen.this, MainActivity.class));
            }
        });

        boa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimeowHomeScreen.this, MangaMainActivity.class));
            }
        });

        robinchan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimeowHomeScreen.this, CharMainActivity.class));
            }
        });

        boa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimeowHomeScreen.this, AnimeWatchList.class));
            }
        });

        robinnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimeowHomeScreen.this, MangaWatchList.class));
            }
        });

        boa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimeowHomeScreen.this, CharStarred.class));
            }
        });
    }
}