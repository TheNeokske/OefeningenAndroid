package com.example.koenengels.mylist;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.koenengels.mylist.model.Contact;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Koen Engels on 15/03/2017.
 */

public class ContactsLoader extends AsyncTask<Void, Void, Contact[]> {
    private final String USERS_URL = "http://jsonplaceholder.typicode.com/users";

    private ProgressDialog progressDialog;
    private final Context context;

    public ContactsLoader(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        this.progressDialog = ProgressDialog.show(context, "Loading...", "Loading...");
    }

    @Override
    protected Contact[] doInBackground(Void... params) {
        try {
            URL url = new URL(USERS_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            InputStream contactsStream = conn.getInputStream();
            Reader contactsReader = new InputStreamReader(contactsStream);
            Gson gson = new GsonBuilder().create();
            Contact[] contacts = gson.fromJson(contactsReader, Contact[].class);
            return contacts;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Contact[] contacts) {
        this.progressDialog.dismiss();

        ListView listView = ((ListActivity) this.context).getListView();

        ArrayAdapter<Contact> contactArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(contactArrayAdapter);
    }
}
