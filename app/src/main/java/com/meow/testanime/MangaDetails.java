package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meow.testanime.ModelsManga.Published;
import com.meow.testanime.ModelsManga.Data;
import com.meow.testanime.ModelsManga.Images;
import com.meow.testanime.ModelsManga.Jpg;
import com.squareup.picasso.Picasso;

public class MangaDetails extends AppCompatActivity {
    private Data data;
    private ImageView mangaposter;
    private TextView mangatitle, mangascore, mangapublishingperiod, mangach, mangavolumes, mangadescription, learnmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_details);

        mangaposter = findViewById(R.id.mangaposter);
        mangatitle = findViewById(R.id.mangatitle);
        mangascore = findViewById(R.id.mangascore);
        mangapublishingperiod = findViewById(R.id.mangapublishperiod);
        mangach = findViewById(R.id.mangach);
        mangavolumes = findViewById(R.id.mangavolumes);
        mangadescription = findViewById(R.id.mangadescription);
        learnmore = findViewById(R.id.learnmore);

        data = (Data) getIntent().getSerializableExtra("data");
        Images imgdata = data.getImages();
        Jpg imgjpg = imgdata.getJpg();
        if (imgjpg.getImageUrl() != null) Picasso.get().load(imgjpg.getImageUrl()).into(mangaposter);

        Published string = data.getPublished();
        mangapublishingperiod.setText(string.getString());

        if (data.getTitleEnglish() == null) mangatitle.setText(data.getTitle());
        else mangatitle.setText(data.getTitleEnglish());
        mangascore.setText(data.getScore() + "");
        mangach.setText(data.getChapters() + "");
        mangavolumes.setText(data.getVolumes() + "");
        mangadescription.setText(data.getSynopsis());

        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = data.getUrl();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(MangaDetails.this, Uri.parse(url));
            }
        });
    }
}
