package be.kdg.curriculumvitae.model;

import be.kdg.curriculumvitae.R;

public class Study {
    public static Study[] studies = {
            new Study("Mariagaarde",1978,1982, R.drawable.mariagaarde),
            new Study("Sint Jan Bergmanscollege",1983,1991, R.drawable.sjb),
            new Study("Karel de Grote Hogeschool",1992,1995, R.drawable.kdg),
    };

    private String school;
    private int startYear;
    private int endYear;
    private int imageResource;

    public Study(String school, int startYear, int endYear, int imageResource) {
        this.school = school;
        this.startYear = startYear;
        this.endYear = endYear;
        this.imageResource = imageResource;
    }

    public String getSchool() {
        return school;
    }
    public int getStartYear() {
        return startYear;
    }
    public int getEndYear() {
        return endYear;
    }
    public int getImageResource() {
        return imageResource;
    }

    @Override
    public String toString() {
        return school + " (" + startYear + "-" + endYear + ")";
    }
}
