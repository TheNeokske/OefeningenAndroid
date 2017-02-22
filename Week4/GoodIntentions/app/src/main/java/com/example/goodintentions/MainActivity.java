package com.example.goodintentions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnBerekenSchema;
    EditText editTextAfstand;
    EditText editTextaantaldagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBerekenSchema= (Button) findViewById(R.id.buttonberekenschema);
        editTextAfstand= (EditText) findViewById(R.id.editTextAfstand);
        editTextaantaldagen= (EditText) findViewById(R.id.editTextPeriode);

btnBerekenSchema.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,SchemaActivity.class);
        String afstand=editTextAfstand.getText().toString();
        String aantalDagen=editTextaantaldagen.getText().toString();

        intent.putExtra("afstand",afstand);
        intent.putExtra("aantaldagen",aantalDagen);
        startActivity(intent);
    }
});

    }


}
