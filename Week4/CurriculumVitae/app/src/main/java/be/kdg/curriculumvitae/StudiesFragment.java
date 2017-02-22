package be.kdg.curriculumvitae;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import be.kdg.curriculumvitae.model.Study;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudiesFragment extends Fragment {
    private ListView lvStudies;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_studies, container, false);
        initialiseViews(view);
        addEventHandlers();

        return view;
    }

    private void initialiseViews(View view) {
        lvStudies = (ListView) view.findViewById(R.id.lvStudies);
        StudyAdapter studyAdapter = new StudyAdapter(getActivity().getApplicationContext(), Study.studies);
        lvStudies.setAdapter(studyAdapter);
    }

    private void addEventHandlers() {
        lvStudies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("index", position);

                    StudyDetailsFragment f = new StudyDetailsFragment();
                    f.setArguments(bundle);
                    FragmentTransaction t = getFragmentManager().beginTransaction();

                    t.replace(R.id.my_container, f);
                    t.addToBackStack(null);
                    t.commit();

                } else {
                    Intent intent = new Intent();
                    intent.putExtra("index", position);
                    intent.setClass(getActivity().getApplicationContext(), StudyDetailsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
