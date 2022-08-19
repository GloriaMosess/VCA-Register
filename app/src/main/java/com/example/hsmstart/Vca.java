package com.example.hsmstart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Vca extends AppCompatActivity {
    private EditText vcaId,Name,Age;
    private Button addButton;
    public String item;
    int min = 200;
    int max = 400;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vca);

        vcaId = findViewById(R.id.vcaId);
        Name = findViewById(R.id.name);
        Age = findViewById(R.id.age);
        addButton = findViewById(R.id.addbtn);
        int id = (int)(Math.random()*(max-min+1)+min);
        vcaId.setText(String.valueOf(id));
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vcaText = vcaId.getText().toString();
                String nameText = Name.getText().toString();
                String ageText = Age.getText().toString();


                Boolean checkResults = databaseHelper.vcaRegistration(vcaText,nameText,ageText);
              if(checkResults == true){
                  Toast.makeText(Vca.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                  Intent i = new Intent(Vca.this,Register.class);
                  startActivity(i);
                  finish();

              }
              else {
                  Toast.makeText(Vca.this, "Please try again", Toast.LENGTH_SHORT).show();
              }
            }


        });

    }
}
