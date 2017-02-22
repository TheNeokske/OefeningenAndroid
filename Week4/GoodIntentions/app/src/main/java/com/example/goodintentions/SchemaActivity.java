package com.example.goodintentions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;
import android.widget.TextView;

public class SchemaActivity extends AppCompatActivity {

    TextView textViewafstand;
    NumberPicker numberPicker;
    String afstand;
    String aantaldagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schema);

        Intent intent=getIntent();
        aantaldagen=intent.getStringExtra("aantaldagen");
        textViewafstand= (TextView) findViewById(R.id.textViewafstandberekend);
        numberPicker= (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
                numberPicker.setMaxValue(Integer.parseInt(aantaldagen));
        textViewafstand= (TextView) findViewById(R.id.textViewafstandberekend);
        afstand=intent.getStringExtra("afstand");


        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int aantalKM=Integer.parseInt(afstand)/(Integer.parseInt(aantaldagen)/numberPicker.getValue());
                textViewafstand.setText(String.valueOf(aantalKM)+" KM");
            }
        });
    }
}
