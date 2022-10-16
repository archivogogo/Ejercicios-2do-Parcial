package com.example.ejercicios2doparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_Favorite:
                        message("Pulsaste Favorito");
                    break;
                    case R.id.item_Copy:
                        message("Pulsaste Copiar");
                        break;
                    case R.id.item_Remove:
                        message("Pulsaste Eliminar");
                        break;
                }
                return false;
            }
        });
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

    public void showFragmen(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fcv_Fragment, fragment)
                .commit();
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
    private void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}