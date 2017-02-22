package be.kdg.curriculumvitae;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class StudyDetailsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_details);

        Intent intent = getIntent();
        StudyDetailsFragment fragment = new StudyDetailsFragment();
        fragment.setArguments(intent.getExtras());

        FragmentTransaction t = getFragmentManager().beginTransaction();

        t.add(R.id.my_detail_conainer, fragment);
        t.commit();
    }
}
