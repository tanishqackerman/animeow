package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AnimeowHomeScreen extends AppCompatActivity {

    ImageView robin, boa, robinchan, boa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animeow_home_screen);

        robin = findViewById(R.id.robin);
        boa = findViewById(R.id.boa);
        robinchan = findViewById(R.id.robinchan);
        boa1 = findViewById(R.id.boa1);

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
    }
}