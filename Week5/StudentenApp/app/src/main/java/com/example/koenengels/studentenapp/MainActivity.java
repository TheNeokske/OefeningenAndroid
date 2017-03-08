package com.example.koenengels.studentenapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private int currentIndex = 0;
    private EditText naam, voornaam, studentennummer, klas;
    private Button vorige, volgende;
    private StudentManager studentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniitialiseViews();
        addEventHandlers();
        try {
            studentManager = new StudentManager(getApplicationContext());
            updateView();
        }catch (IOException ex){
            Toast.makeText(getApplicationContext(),"Kon bestand niet vinden",Toast.LENGTH_SHORT).show();
        }
    }

    private void iniitialiseViews() {
        naam = (EditText) findViewById(R.id.edAchternaam);
        naam.setEnabled(false);
        voornaam = (EditText) findViewById(R.id.edVoornaam);
        voornaam.setEnabled(false);
        studentennummer = (EditText) findViewById(R.id.edStudentNummer);
        studentennummer.setEnabled(false);
        klas = (EditText) findViewById(R.id.edKlas);
        klas.setEnabled(false);

        vorige = (Button) findViewById(R.id.button2);
        volgende = (Button) findViewById(R.id.button3);
    }

    private void addEventHandlers() {
        vorige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex--;
                updateView();
            }
        });
        volgende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                updateView();
            }
        });
    }

    private void updateView() {
        if (currentIndex == 0) {
            vorige.setEnabled(false);
        }
        if (currentIndex == studentManager.getStudents().size() - 1) {
            volgende.setEnabled(false);
        }
        if (currentIndex > 0 && currentIndex < studentManager.getStudents().size() - 1) {
            vorige.setEnabled(true);
            volgende.setEnabled(true);
        }
        Student student = studentManager.getStudent(currentIndex);

        naam.setText(student.getAchternaam());
        voornaam.setText(student.getVoornaam());
        studentennummer.setText(student.getStudentenNummer());
        klas.setText(student.getKlas());
    }
}
