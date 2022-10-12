package com.example.ejercicios2doparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnWidgets;
    Button btnAdvancedWidgets;
    Button btnDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWidgets = findViewById(R.id.button_widgets);
        btnAdvancedWidgets = findViewById(R.id.btn_AdvancedButton);
        btnDrawerLayout = findViewById(R.id.btn_DrawerLayout);
        btnWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WidgetsActivity.class);
                startActivity(intent);
            }
        });
        btnAdvancedWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdvancedWidgetsActivity.class);
                startActivity(intent);
            }
        });
        btnDrawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawerActivity.class);
                startActivity(intent);
            }
        });
    }
    }