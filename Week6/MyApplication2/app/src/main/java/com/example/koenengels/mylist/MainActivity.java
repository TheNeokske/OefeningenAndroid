package com.example.koenengels.mylist;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.koenengels.mylist.model.Contact;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        initListActivity();
        addEventHandlers();
    }

    private void addEventHandlers() {
        final ListView listView = getListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = (Contact) listView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetailsContactActivity.class);
                intent.putExtra("contact", contact);
                startActivity(intent);
            }
        });
    }

    private void initListActivity() {
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            ContactsLoader contactsLoader = new ContactsLoader(this);
            contactsLoader.execute();
        }
    }
}
