package com.example.koenengels.mylist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.koenengels.mylist.model.Contact;

public class DetailsContactActivity extends Activity {
    private TextView name, username, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_contact);
        Contact contact = (Contact) getIntent().getSerializableExtra("contact");
        initViews(contact);
    }

    private void initViews(Contact contact) {
        name = (TextView) findViewById(R.id.name);
        name.setText(contact.getName());
        username = (TextView) findViewById(R.id.username);
        username.setText(contact.getUsername());
        email = (TextView) findViewById(R.id.email);
        email.setText(contact.getEmail());
    }
}
