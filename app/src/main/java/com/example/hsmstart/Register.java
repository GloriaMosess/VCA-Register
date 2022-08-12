package com.example.hsmstart;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class Register extends AppCompatActivity {

    FloatingActionButton addVca;


    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    ListView listView;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addVca = findViewById(R.id.floatingActionButton4);
         listView = findViewById(R.id.listView);
         listItem = new ArrayList();

        addVca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addv = new Intent(Register.this, Vca.class);
                startActivity(addv);
            }
        });



        data();

    }

    public void data(){
        Cursor cursor = databaseHelper.displayData();
        if(cursor.getCount()==0){
            Toast.makeText(Register.this, "No data to show", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()){
                listItem.add("Country:\t"+"Zambia");
                listItem.add("ID:\t"+cursor.getString(0));
                listItem.add("Full Name:\t"+cursor.getString(1));
                listItem.add("Age:\t"+cursor.getString(2)+"\n\n");

            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem
            );
            listView.setAdapter(adapter);
        }

    }
}