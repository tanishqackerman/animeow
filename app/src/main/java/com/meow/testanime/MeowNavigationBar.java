package com.meow.testanime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MeowNavigationBar extends AppCompatActivity {

    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    ImageView robin, boa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meow_navigation_bar);

        robin = findViewById(R.id.robin);
        boa = findViewById(R.id.boa);

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navmenu);
        drawerLayout = findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
//        This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuanime:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(MeowNavigationBar.this, MainActivity.class));
                        break;
                    case R.id.menumanga:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(MeowNavigationBar.this, MangaMainActivity.class));
                        break;
                    case R.id.menuchar:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        startActivity(new Intent(MeowNavigationBar.this, CharMainActivity.class));
                        break;
                }
                return true;
            }
        });
        navigationView.getMenu().getItem(0).setChecked(true);

        robin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeowNavigationBar.this, MainActivity.class));
                Toast.makeText(MeowNavigationBar.this, "anime", Toast.LENGTH_SHORT).show();
            }
        });

        boa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeowNavigationBar.this, MangaMainActivity.class));
                Toast.makeText(MeowNavigationBar.this, "manga", Toast.LENGTH_SHORT).show();
            }
        });
    }
}