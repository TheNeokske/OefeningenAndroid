package com.ddns.theneokske.colorchooser;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarRood, seekBarGroen, seekBarBlauw;
    private EditText editTextRood, editTextGroen, editTextBlauw, editTextHex;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBarRood = (SeekBar) findViewById(R.id.seekbar1);
        seekBarRood.setMax(255);
        seekBarGroen = (SeekBar) findViewById(R.id.seekbar2);
        seekBarGroen.setMax(255);
        seekBarBlauw = (SeekBar) findViewById(R.id.seekbar3);
        seekBarBlauw.setMax(255);
        editTextRood = (EditText) findViewById(R.id.edRood);
        editTextGroen = (EditText) findViewById(R.id.edGroen);
        editTextBlauw = (EditText) findViewById(R.id.edBlauw);
        editTextHex = (EditText) findViewById(R.id.hex);
        editTextHex.setKeyListener(null);
        view = findViewById(R.id.kleurView);

        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int newValue, boolean userChanged) {
                if (userChanged) {
                    int rood = seekBarRood.getProgress();
                    int groen = seekBarGroen.getProgress();
                    int blauw = seekBarBlauw.getProgress();
                    updateColor(Color.rgb(rood, groen, blauw));
                    editTextRood.setText(String.valueOf(rood));
                    editTextGroen.setText(String.valueOf(groen));
                    editTextBlauw.setText(String.valueOf(blauw));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        TextWatcher textWatcherColors = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().isEmpty()) {
                    int rood = Integer.valueOf(editTextRood.getText().toString());
                    int groen = Integer.valueOf(editTextGroen.getText().toString());
                    int blauw = Integer.valueOf(editTextBlauw.getText().toString());
                    updateColor(Color.rgb(rood, groen, blauw));
                    seekBarRood.setProgress(rood);
                    seekBarGroen.setProgress(groen);
                    seekBarBlauw.setProgress(blauw);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        editTextRood.addTextChangedListener(textWatcherColors);
        editTextGroen.addTextChangedListener(textWatcherColors);
        editTextBlauw.addTextChangedListener(textWatcherColors);

        seekBarRood.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarGroen.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarBlauw.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private void updateColor(int kleur) {
        String test = Integer.toHexString(kleur);
        System.out.println(test.length());
        editTextHex.setText(test.toUpperCase());
        view.setBackgroundColor(kleur);
    }
}
