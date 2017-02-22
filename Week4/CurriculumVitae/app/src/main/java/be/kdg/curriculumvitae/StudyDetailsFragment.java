package be.kdg.curriculumvitae;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.kdg.curriculumvitae.model.Study;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyDetailsFragment extends Fragment {
    private TextView school, jaren;

    public StudyDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study_details, container, false);

        initialiseViews(view);

        Bundle bundle = getArguments();
        int index = bundle.getInt("index");
        Study study = Study.studies[index];
        this.school.setText(study.getSchool());
        this.jaren.setText(study.getStartYear() + " - " + study.getEndYear());

        return view;
    }


    private void initialiseViews(View view) {
        school = (TextView) view.findViewById(R.id.school);
        jaren = (TextView) view.findViewById(R.id.jaren);
    }

}
