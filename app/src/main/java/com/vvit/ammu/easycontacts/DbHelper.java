package com.vvit.ammu.easycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ammu on 02-05-2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private final static String DBNAME = "MyDb";
    private final static int version = 1;
    public static final String table = "mycontacts";
    public static final String id = "id";
    public static final String name = "name";
    public static final String phone = "phone";
    public DbHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+ table + " ( "+id+" INTEGER, "+name+ " TEXT, "
                +phone+ " TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+table+ " IF EXISTS");
        onCreate(db);
    }

    public void storeContact(Contacts contacts){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name,contacts.getName());
        contentValues.put(phone,contacts.getPhone());
        db.insert(table,null,contentValues);

    }

    public Cursor getContact(){
        /*Log.d("In method:","In DbHelper getContact()");
        List<Contacts> contactsArrayList = new ArrayList<>();
        Log.d("In method:","Executing qeury");
        String query = "SELECT * FROM "+table;
        Log.d("In method:","Executed query");
        SQLiteDatabase db= getReadableDatabase();
        Cursor c= db.rawQuery(query,null);
        c.moveToFirst();
        if(c!=null && c.moveToFirst()) {
            do {
                Contacts contacts = new Contacts();
                contacts.setName(c.getString(c.getColumnIndex(DbHelper.name)));
                Log.d("Name:", contacts.getName());
                contacts.setPhone(c.getString(c.getColumnIndex(DbHelper.phone)));
                Log.d("Phone", String.valueOf(contacts.getPhone()));
                contactsArrayList.add(contacts);
            } while (c.moveToNext());
        }
        return contactsArrayList;*/
        SQLiteDatabase db= getReadableDatabase();
        Cursor c= db.rawQuery("SELECT * FROM "+table,null);
        return c;
      }
}
