package be.kdg.curriculumvitae;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import be.kdg.curriculumvitae.model.Study;

public class StudiesActivity extends Activity {
    private ListView lvStudies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);
        lvStudies = (ListView) findViewById(R.id.lvStudies);
        StudyAdapter adapter = new StudyAdapter(this,Study.studies);
        lvStudies.setAdapter(adapter);
    }
}
