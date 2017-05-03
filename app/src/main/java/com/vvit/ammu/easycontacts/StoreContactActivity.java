package com.vvit.ammu.easycontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StoreContactActivity extends AppCompatActivity {
    EditText name,phone;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_contact);

        name = (EditText) findViewById(R.id.id_name);
        phone = (EditText) findViewById(R.id.id_phone);

        save = (Button)findViewById(R.id.id_save_contact);
        final DbHelper helper = new DbHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String p= phone.getText().toString();
                helper.storeContact(new Contacts(n,p));
                Toast.makeText(getApplicationContext(),"Stored Contact",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(getApplicationContext(),FirstActivity.class));
            }
        });
    }
}
