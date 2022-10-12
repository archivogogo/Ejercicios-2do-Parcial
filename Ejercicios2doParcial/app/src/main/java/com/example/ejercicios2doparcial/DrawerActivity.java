package com.example.ejercicios2doparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        navigationView = findViewById(R.id.nv_Navigation);
        drawerLayout = findViewById(R.id.dl_drawerLayout);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                isOpen = true;
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                isOpen = false;
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            if(isOpen){
                drawerLayout.close();
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
            } else {
                drawerLayout.open();
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
            }
            isOpen = !isOpen;
        }
        return super.onOptionsItemSelected(item);
    }
}