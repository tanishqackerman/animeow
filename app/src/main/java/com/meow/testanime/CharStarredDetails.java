package com.meow.testanime;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.meow.testanime.DBModels.CharDB;
import com.meow.testanime.TableData.DBHandlerChar;
import com.squareup.picasso.Picasso;

public class CharStarredDetails extends AppCompatActivity {

    private CharDB data;
    private ImageView charposter, star;
    private TextView chartitle, chardescription, learnmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_details);

        DBHandlerChar db = new DBHandlerChar(CharStarredDetails.this);

        charposter = findViewById(R.id.charposter);
        chartitle = findViewById(R.id.chartitle);
        chardescription = findViewById(R.id.chardescription);
        learnmore = findViewById(R.id.learnmore);
        star = findViewById(R.id.star);

        data = (CharDB) getIntent().getSerializableExtra("data");
        if (data.getImgurl() != null) Picasso.get().load(data.getImgurl()).into(charposter);

        chartitle.setText(data.getCharname());
        chardescription.setText(data.getCharabout());

        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(CharStarredDetails.this, Uri.parse(data.getLearnmore()));
            }
        });

        boolean watchlistAdded = db.hasObject(data.getCharname());
        if (!watchlistAdded) {
            star.setImageResource(R.drawable.ic_baseline_star_border_24);
        } else {
            star.setImageResource(R.drawable.ic_baseline_star_24);
        }

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharDB charDB = new CharDB(chartitle.getText().toString(), data.getImgurl(), data.getLearnmore(), data.getCharabout());
                if (!watchlistAdded) {
                    db.addCharWatchList(charDB);
                    star.setImageResource(R.drawable.ic_baseline_star_24);
                } else {
                    db.deleteCharFromWatchList(charDB);
                    star.setImageResource(R.drawable.ic_baseline_star_border_24);
                }
            }
        });
    }
}
