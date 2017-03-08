package com.example.koenengels.studentenapp;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Koen Engels on 8/03/2017.
 */

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager(Context context) throws IOException {
        students = new ArrayList<>();
        readStudenten(context);
    }

    private void readStudenten(Context context) throws IOException {

        try (Scanner scanner = new Scanner(context.getAssets().open("studenten.txt"))) {
            while (scanner.hasNext()) {
                String lijn = scanner.nextLine();
                String[] studentDeeltjes = lijn.split(";");
                Student student = new Student(studentDeeltjes[0], studentDeeltjes[1], studentDeeltjes[2], studentDeeltjes[3]);
                students.add(student);
            }
        }
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
