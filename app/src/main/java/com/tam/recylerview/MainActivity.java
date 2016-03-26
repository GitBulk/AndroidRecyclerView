package com.tam.recylerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        rvContacts.setItemAnimator(new SlideInUpAnimator());
        this.contacts = Contact.createContactsList(20);
        final ContactsAdapter adapter = new ContactsAdapter(this.contacts);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        final Button btnAddContacts = (Button) findViewById(R.id.btnAddContacts);
        btnAddContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentSize = adapter.getItemCount();
//                Toast.makeText(MainActivity.this, String.valueOf(currentSize), Toast.LENGTH_SHORT).show();
                ArrayList<Contact> newContacts = Contact.createContactsList(5);
                contacts.addAll(newContacts);
                adapter.notifyItemRangeInserted(currentSize, newContacts.size());
                rvContacts.scrollToPosition(adapter.getItemCount() - 1);
            }
        });
    }
}
