package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meow.testanime.DBModels.MangaDB;
import com.meow.testanime.ModelsManga.Data;
import com.meow.testanime.ModelsManga.Images;
import com.meow.testanime.ModelsManga.Jpg;
import com.meow.testanime.ModelsManga.Published;
import com.meow.testanime.TableData.DBHandlerManga;
import com.squareup.picasso.Picasso;

public class MangaWatchListDetails extends AppCompatActivity {

    private MangaDB data;
    private ImageView mangaposter, bookmark;
    private TextView mangatitle, mangascore, mangapublishingperiod, mangach, mangavolumes, mangadescription, learnmore, watchtext;
    private LinearLayout watchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_details);

        DBHandlerManga db = new DBHandlerManga(MangaWatchListDetails.this);

        mangaposter = findViewById(R.id.mangaposter);
        mangatitle = findViewById(R.id.mangatitle);
        mangascore = findViewById(R.id.mangascore);
        mangapublishingperiod = findViewById(R.id.mangapublishperiod);
        mangach = findViewById(R.id.mangach);
        mangavolumes = findViewById(R.id.mangavolumes);
        mangadescription = findViewById(R.id.mangadescription);
        learnmore = findViewById(R.id.learnmore);
        watchtext = findViewById(R.id.watchtext);
        bookmark = findViewById(R.id.bookmark);
        watchlist = findViewById(R.id.watchlist);

        data = (MangaDB) getIntent().getSerializableExtra("data");
        if (data.getImgurl() != null) Picasso.get().load(data.getImgurl()).into(mangaposter);

        mangapublishingperiod.setText(data.getMangapublishingperiod());

        mangatitle.setText(data.getAnimename());
        mangascore.setText(data.getMangascore() + "");
        mangach.setText(data.getMangach() + "");
        mangavolumes.setText(data.getMangavol() + "");
        mangadescription.setText(data.getMangaabout());

        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(MangaWatchListDetails.this, Uri.parse(data.getLearnmore()));
            }
        });

        boolean watchlistAdded = db.hasObject(mangatitle.getText().toString());
        if (!watchlistAdded) {
            watchtext.setText("Bookmark");
            bookmark.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
        }
        else {
            watchtext.setText("Remove Bookmark");
            bookmark.setImageResource(R.drawable.ic_baseline_bookmark_24);
        }

        watchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MangaDB mangaDB = new MangaDB(mangatitle.getText().toString(), data.getImgurl(), mangascore.getText().toString(), mangapublishingperiod.getText().toString(), mangach.getText().toString(), mangavolumes.getText().toString(), data.getLearnmore(), data.getMangaabout());
                if (watchtext.getText().equals("Bookmark")) {
                    db.addMangaWatchList(mangaDB);
                    watchtext.setText("Remove Bookmark");
                    bookmark.setImageResource(R.drawable.ic_baseline_bookmark_24);
                } else if (watchtext.getText().equals("Remove Bookmark")) {
                    db.deleteMangaFromWatchList(mangaDB);
                    watchtext.setText("Bookmark");
                    bookmark.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
                }
            }
        });
    }
}