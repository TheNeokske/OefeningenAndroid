package com.example.koenengels.studentenapp;

/**
 * Created by Koen Engels on 8/03/2017.
 */

public class Student {
    private String achternaam;
    private String voornaam;
    private String studentenNummer;
    private String klas;

    public Student(String achternaam, String voornaam, String studentenNummer, String klas) {
        this.achternaam = achternaam;
        this.voornaam = voornaam;
        this.studentenNummer = studentenNummer;
        this.klas = klas;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getStudentenNummer() {
        return studentenNummer;
    }

    public String getKlas() {
        return klas;
    }
}
