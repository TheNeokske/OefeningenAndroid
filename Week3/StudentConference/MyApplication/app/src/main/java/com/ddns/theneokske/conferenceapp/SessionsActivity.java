package com.ddns.theneokske.conferenceapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SessionsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new SessionAdapter(this,R.layout.session_item,Session.sessions));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    }
}
