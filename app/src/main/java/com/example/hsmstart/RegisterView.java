package com.example.hsmstart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterView extends AppCompatActivity {
    private TextView vcaId,Name,Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        vcaId = findViewById(R.id.vcaId2);
        Name = findViewById(R.id.name2);
        Age = findViewById(R.id.age2);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");

        data(name);




    }

    public void data(String name){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        Cursor cursor = databaseHelper.displayDataForSingleVca(name);
        if(cursor.getCount()==0){
            Toast.makeText(RegisterView.this, "No data to show", Toast.LENGTH_LONG).show();
        } else {
                // listItem.add("Country:\t"+"Zambia"); e.setText(cursor.getString(2));;
            cursor.moveToFirst();
            vcaId.setText(new StringBuilder().append("ID: ").append(cursor.getString(0)).toString());
            //listItem.add("ID:\t"+cursor.getString(0));
            Name.setText(new StringBuilder().append("Name:").append(cursor.getString(1)).toString());
            Age.setText(new StringBuilder().append("Age:").append(cursor.getString(2)).toString());
        }

        }

    }