package com.vvit.ammu.easycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListContactsActivity extends AppCompatActivity {
    private RecyclerView contactView;
    private MyContactsAdapter myContactsAdapter;
    List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);

        contactView = (RecyclerView) findViewById(R.id.id_list_contacts);
        myContactsAdapter = new MyContactsAdapter(contactsList, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        contactView.setLayoutManager(manager);
        contactView.setItemAnimator(new DefaultItemAnimator());
        contactView.setAdapter(myContactsAdapter);

        prepareContacts();
    }

    private void prepareContacts() {

        Contacts contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);
        contact = new Contacts("ABCD", "12345678");
        contactsList.add(contact);


        myContactsAdapter.notifyDataSetChanged();

    }
}
