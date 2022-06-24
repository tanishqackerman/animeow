package com.meow.testanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meow.testanime.ModelsCharacter.Data;
import com.meow.testanime.ModelsCharacter.Images;
import com.meow.testanime.ModelsCharacter.Jpg;
import com.squareup.picasso.Picasso;

public class CharDetails extends AppCompatActivity {

    private Data data;
    private ImageView charposter;
    private TextView chartitle, chardescription, learnmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_details);

        charposter = findViewById(R.id.charposter);
        chartitle = findViewById(R.id.chartitle);
        chardescription = findViewById(R.id.chardescription);
        learnmore = findViewById(R.id.learnmore);

        data = (Data) getIntent().getSerializableExtra("data");
        Images imgdata = data.getImages();
        Jpg imgjpg = imgdata.getJpg();
        if (imgjpg.getImageUrl() != null) Picasso.get().load(imgjpg.getImageUrl()).into(charposter);

        chartitle.setText(data.getName());
        chardescription.setText(data.getAbout());

        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = data.getUrl();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent intent = builder.build();
                intent.launchUrl(CharDetails.this, Uri.parse(url));
            }
        });
    }
}