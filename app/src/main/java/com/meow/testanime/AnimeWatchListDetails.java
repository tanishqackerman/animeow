package com.meow.testanime;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.meow.testanime.DBModels.AnimeDB;
import com.meow.testanime.TableData.DBHandlerAnime;
import com.squareup.picasso.Picasso;

public class AnimeWatchListDetails extends AppCompatActivity {

    private AnimeDB data;
    private ImageView animeposter, bookmark;
    private TextView animetitle, animescore, animeairingperiod, animeep, animeag, animedescription, learnmore, trailer, watchtext;
    LinearLayout watchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_details);

        animeposter = findViewById(R.id.animeposter);
        animetitle = findViewById(R.id.animetitle);
        animescore = findViewById(R.id.animescore);
        animeairingperiod = findViewById(R.id.animeairingperiod);
        animeep = findViewById(R.id.animeep);
        animeag = findViewById(R.id.animeag);
        animedescription = findViewById(R.id.animedescription);
        learnmore = findViewById(R.id.learnmore);
        trailer = findViewById(R.id.trailer);
        watchlist = findViewById(R.id.watchlist);
        bookmark = findViewById(R.id.bookmark);
        watchtext = findViewById(R.id.watchtext);
        DBHandlerAnime db = new DBHandlerAnime(this);

        data = (AnimeDB) getIntent().getSerializableExtra("data");
        if (data.getImgurl() != null) Picasso.get().load(data.getImgurl()).into(animeposter);

        animeairingperiod.setText(data.getAnimeairingperiod());
        animetitle.setText(data.getAnimename());
        animescore.setText(data.getAnimescore() + "");
        animeep.setText(data.getAnimeep() + "");
        animeag.setText(data.getAnimeage());
        animedescription.setText(data.getAnimesypnosis());

        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = data.getLearnmore();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(AnimeWatchListDetails.this, Uri.parse(url));
            }
        });

        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(AnimeWatchListDetails.this, Uri.parse(data.getAnimetrailer()));
            }
        });

        boolean watchlistAdded = db.hasObject(animetitle.getText().toString());
        if (!watchlistAdded) {
            watchtext.setText("Add To WatchList");
            bookmark.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
        }
        else {
            watchtext.setText("Remove From WatchList");
            bookmark.setImageResource(R.drawable.ic_baseline_bookmark_24);
        }

        watchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimeDB animeDB = new AnimeDB(animetitle.getText().toString(), data.getImgurl(), animescore.getText().toString(), animeairingperiod.getText().toString(), animeep.getText().toString(), animeag.getText().toString(), data.getLearnmore(), data.getAnimetrailer(), data.getAnimesypnosis());
                if (watchtext.getText().equals("Add To WatchList")) {
                    db.addAnimeWatchList(animeDB);
                    watchtext.setText("Remove From WatchList");
                    bookmark.setImageResource(R.drawable.ic_baseline_bookmark_24);
                } else if (watchtext.getText().equals("Remove From WatchList")) {
                    db.deleteAnimeFromWatchList(animeDB);
                    watchtext.setText("Add To WatchList");
                    bookmark.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
                }
            }
        });
    }
}
