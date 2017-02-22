package com.ddns.theneokske.conferenceapp;

/**
 * Created by Koen on 15/02/2017.
 */

public class Session {
    public static final Session[] sessions = {
            new Session("The Actor Model", "16 feb 2017", R.drawable.session1),
            new Session("Kotlin, a new hope", "16 feb 2017", R.drawable.session2),
            new Session("Docker vs virtual machines", "16 feb 2017", R.drawable.session3),
            new Session("Crowdfunding blockchained", "16 feb 2017", R.drawable.session4),
            new Session("Datascience is knowledge", "16 feb 2017", R.drawable.session5),
            new Session("Concurrent programming in Akka.Net", "16 feb 2017", R.drawable.session6),
            new Session("Vulnerabilities", "16 feb 2017", R.drawable.session7),
            new Session("Conversational User Interfaces", "16 feb 2017", R.drawable.session8),
            new Session("Communicatie tussen microservices", "16 feb 2017", R.drawable.session9),
            new Session("Best practice bij Big Data analytics", "16 feb 2017", R.drawable.session10),
    };

    public static Session getSession(int i){
        return sessions[i];
    }


    private String title;
    private String datum;
    private int sessionPic;

    public Session(String title, String datum, int sessionPic) {
        this.title = title;
        this.datum = datum;
        this.sessionPic = sessionPic;
    }

    public String getTitle() {
        return title;
    }

    public String getDatum() {
        return datum;
    }

    public int getSessionPic() {
        return sessionPic;
    }

    @Override
    public String toString() {
        return "Session{" +
                "title='" + title + '\'' +
                ", datum='" + datum + '\'' +
                ", sessionPic=" + sessionPic +
                '}';
    }
}
