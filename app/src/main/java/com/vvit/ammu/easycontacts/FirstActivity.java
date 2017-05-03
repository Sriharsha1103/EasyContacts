package com.vvit.ammu.easycontacts;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private RecyclerView contactView;
    private MyContactsAdapter myContactsAdapter;
    private List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        contactView = (RecyclerView) findViewById(R.id.id_list_contacts);

        myContactsAdapter = new MyContactsAdapter(contactsList, this);
        prepareContacts();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        contactView.setLayoutManager(manager);
        contactView.setItemAnimator(new DefaultItemAnimator());
        contactView.setAdapter(myContactsAdapter);

        Log.d("In method:","onCreate()");

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),StoreContactActivity.class));
            }
        });

    }

    private void prepareContacts() {
        Log.d("In method:","prepareContacts()");
        DbHelper helper = new DbHelper(this);
        Cursor cursor = helper.getContact();
        if(cursor!=null && cursor.moveToFirst()){
            do {
                Contacts contacts = new Contacts();
                contacts.setName(cursor.getString(cursor.getColumnIndex(DbHelper.name)));
                Log.d("Name:", contacts.getName());
                contacts.setPhone(cursor.getString(cursor.getColumnIndex(DbHelper.phone)));
                Log.d("Phone", String.valueOf(contacts.getPhone()));
                contactsList.add(contacts);
            } while (cursor.moveToNext());
        }
        myContactsAdapter.notifyDataSetChanged();


    }
}
