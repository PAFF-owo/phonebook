package com.example.phonebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhone;
    private Button buttonAdd;

    private ArrayList<String> contactsList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonAdd = findViewById(R.id.buttonAdd);
        ListView listViewContacts = findViewById(R.id.listViewContacts);

        contactsList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactsList);
        listViewContacts.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });
    }

    private void addContact() {
        String name = editTextName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();

        if (!name.isEmpty() && !phone.isEmpty()) {
            String contact = name + " - " + phone;
            contactsList.add(contact);
            adapter.notifyDataSetChanged();
            editTextName.setText("");
            editTextPhone.setText("");
        } else {
            Toast.makeText(this, "Please enter name and phone number", Toast.LENGTH_SHORT).show();
        }
    }
}