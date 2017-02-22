package com.ddns.theneokske.conferenceapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Koen on 15/02/2017.
 */

public class SessionAdapter extends ArrayAdapter<Session> {
    public SessionAdapter(Context context, int resource, Session[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Session session = Session.getSession(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.session_item,
                    parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivSessionIcon);
        imageView.setImageResource(session.getSessionPic());
        TextView tvSession = (TextView) convertView.findViewById(R.id.tvSession);
        tvSession.setText(session.getTitle());
        TextView tvDate = (TextView) convertView.findViewById(R.id.tvDate);
        tvDate.setText(session.getDatum());
        return convertView;
    }
}
