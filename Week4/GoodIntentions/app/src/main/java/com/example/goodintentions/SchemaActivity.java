package com.example.goodintentions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class SchemaActivity extends AppCompatActivity {

    private TextView textViewafstand;
    private NumberPicker numberPicker;
    private String afstand;
    private String aantaldagen;
    private Button delen;
    private int aantalKM;
    private int dagVanTraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schema);

        Intent intent = getIntent();
        aantaldagen = intent.getStringExtra("aantaldagen");
        afstand = intent.getStringExtra("afstand");
        initialiseViews();
        addEventHandlers();
    }

    private void addEventHandlers() {
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                dagVanTraining = numberPicker.getValue();
                aantalKM = Integer.parseInt(afstand) / (Integer.parseInt(aantaldagen) / dagVanTraining);
                textViewafstand.setText(String.valueOf(aantalKM) + " KM");
            }
        });
        delen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Ik heb zonet " + String.valueOf(aantalKM) + "km gelopen! Flink he");
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }

    private void initialiseViews() {
        textViewafstand = (TextView) findViewById(R.id.textViewafstandberekend);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(Integer.parseInt(aantaldagen));
        textViewafstand = (TextView) findViewById(R.id.textViewafstandberekend);
        delen = (Button) findViewById(R.id.buttonDelen);
    }
}
