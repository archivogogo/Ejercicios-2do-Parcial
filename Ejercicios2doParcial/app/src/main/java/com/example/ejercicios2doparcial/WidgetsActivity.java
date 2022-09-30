package com.example.ejercicios2doparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class WidgetsActivity extends AppCompatActivity {


    Button myButton;
    SeekBar seekBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        myButton = findViewById(R.id.bt_Button);
        seekBar = findViewById(R.id.sb_SeekBar);
        textView = findViewById(R.id.tv_TextView);

        listenerButton();
        listenerTextView();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("El valor es: " + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void listenerButton(){
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("onClick myButton");
                message("Haz clickeado este botón.");
            }
        });

        myButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                textView.setText("onLongClick myButton");
                message("Haz apretado el botón largo tiempo.");
                return false;
            }
        });

    }

    private void listenerTextView(){
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("before text view" + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                message("changedTextView"+ charSequence);
                textView.setText(charSequence.toString().toUpperCase(Locale.ROOT));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                message("afterTextView");
            }
        });
    }

    private void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}