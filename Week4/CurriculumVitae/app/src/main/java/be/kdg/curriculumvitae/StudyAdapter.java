package be.kdg.curriculumvitae;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import be.kdg.curriculumvitae.model.Study;

public class StudyAdapter extends ArrayAdapter<Study> {

    public StudyAdapter(Context context, Study[] studies) {
        super(context, -1, studies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Study study = getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.study_list_item, parent, false);
        }
        ImageView ivSchoolIcon = (ImageView) convertView.findViewById(R.id.ivSchoolIcon);
        Drawable image = getContext().getDrawable(study.getImageResource());
        ivSchoolIcon.setImageDrawable(image);
        TextView tvSchool = (TextView) convertView.findViewById(R.id.tvSchool);
        tvSchool.setText(study.getSchool());
        TextView tvYears = (TextView) convertView.findViewById(R.id.tvYears);
        tvYears.setText(study.getStartYear() + " - " + study.getEndYear());
        return convertView;
    }
}
