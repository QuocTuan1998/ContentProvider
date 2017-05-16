package com.example.quoctuan.contentprovider.activity;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quoctuan.contentprovider.R;
import com.example.quoctuan.contentprovider.model.Contact;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<Contact> listContact;
    ArrayAdapter<Contact> adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        addControls();
        addEvents();

        showAllContactFromDivice();
    }

    private void showAllContactFromDivice() {
        Uri uriContact = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursorContact = getContentResolver().query(uriContact,null,null,null,null);
        listContact.clear();
        while (cursorContact.moveToNext()){
            String nameColName = ContactsContract.Contacts.DISPLAY_NAME;
            String nameColPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int colNameIndex = cursorContact.getColumnIndex(nameColName);
            int colPhoneIndex = cursorContact.getColumnIndex(nameColPhone);
            String name = cursorContact.getString(colNameIndex);
            String phone = cursorContact.getString(colPhoneIndex);
            Contact contact = new Contact(name,phone);
            listContact.add(contact);

        }
        adapterContact.notifyDataSetChanged();
    }

    private void addControls() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        listContact = new ArrayList<>();
        adapterContact = new ArrayAdapter<Contact>(
                ContactActivity.this,
                android.R.layout.simple_list_item_1,
                listContact);
        lvContact.setAdapter(adapterContact);

    }

    private void addEvents() {

    }
}
