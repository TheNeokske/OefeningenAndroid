package be.kdg.curriculumvitae;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class StudiesActivity extends Activity {
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);

        if (findViewById(R.id.my_container) != null && savedInstanceState == null) {
            StudyDetailsFragment f = new StudyDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", 0);
            f.setArguments(bundle);

            FragmentTransaction t = getFragmentManager().beginTransaction();
            t.add(R.id.my_container, f);
            t.commit();


        }
    }
}
