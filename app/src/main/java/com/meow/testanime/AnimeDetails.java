package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meow.testanime.Models.Aired;
import com.meow.testanime.Models.Data;
import com.meow.testanime.Models.Images;
import com.meow.testanime.Models.Jpg;
import com.meow.testanime.Models.Trailer;
import com.squareup.picasso.Picasso;

public class AnimeDetails extends AppCompatActivity {

    private Data data;
    private ImageView animeposter;
    private TextView animetitle, animescore, animeairingperiod, animeep, animeag, animedescription, learnmore,trailer;

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

        data = (Data) getIntent().getSerializableExtra("data");
        Images imgdata = data.getImages();
        Jpg imgjpg = imgdata.getJpg();
        if (imgjpg.getImageUrl() != null) Picasso.get().load(imgjpg.getImageUrl()).into(animeposter);

        Aired string = data.getAired();
        animeairingperiod.setText(string.getString());

        animetitle.setText(data.getTitle());
        animescore.setText(data.getScore() + "");
        animeep.setText(data.getEpisodes() + "");
        animeag.setText(data.getRating());
        animedescription.setText(data.getSynopsis());

        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = data.getUrl();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(AnimeDetails.this, Uri.parse(url));
            }
        });

        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trailer trailerurl = data.getTrailer();
                String yturl = trailerurl.getUrl();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(AnimeDetails.this, Uri.parse(yturl));
            }
        });
    }
}