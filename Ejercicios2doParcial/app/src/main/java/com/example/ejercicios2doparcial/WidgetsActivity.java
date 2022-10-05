package com.example.ejercicios2doparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

public class WidgetsActivity extends AppCompatActivity {


    Button myButton;
    SeekBar seekBar;
    TextView textView;
    EditText editText;
    CheckBox checkBox;
    Switch aSwitch;
    RadioGroup radioGroup;
    RatingBar ratingBar;
    ProgressBar progressBar;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        myButton = findViewById(R.id.bt_Button);
        seekBar = findViewById(R.id.sb_SeekBar);
        textView = findViewById(R.id.tv_TextView);
        editText = findViewById(R.id.et_EditText);
        checkBox = findViewById(R.id.cb_Checkbox);
        aSwitch = findViewById(R.id.s_Switch);
        radioGroup = findViewById(R.id.rg_RadioGroup);
        ratingBar = findViewById(R.id.rb_RatingBar);
        progressBar = findViewById(R.id.pb_ProgressBar);
        toggleButton = findViewById(R.id.tb_ToggleButton);

        listenerButton();
        listenerTextView();
        listenerEditText();
        listenerCheckbox();
        listenerSwitch();
        listenerRadioGroup();
        listenerRatingBar();
        listenerToggleButton();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("El valor es: " + i);
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
            }

            @Override
            public void afterTextChanged(Editable editable) {
                message("afterTextView");
            }
        });
    }

    private void listenerEditText(){
    editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            message("Before Text Changed" + charSequence);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            message("On Text Changed" + charSequence);
        }

        @Override
        public void afterTextChanged(Editable editable) {
            message("After Text Changed");
        }
    });
    }

    private void listenerCheckbox(){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("On Checked Change" + b);
            }
        });

    }

    private void listenerSwitch(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("Hola Soy Diego" + b);
            }
        });

    }

    private void listenerRadioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_Opt1:
                        message("Op1");
                        break;
                    case R.id.rb_Opt2:
                        message("Op2");
                        break;
                    case R.id.rb_Opt3:
                        message("Op3");
                        break;
                }
                message("Hola Soy Diego" + i);
            }
        });
    }

    private void listenerRatingBar(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                message("El valor es:" + "" + v + "" + b);
            }
        });
    }

    private void listenerToggleButton(){
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                message("Papitas Enchiladas" + b);
            }
        });
    }










    private void message(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}