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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vca);

        vcaId = findViewById(R.id.vcaId);
        Name = findViewById(R.id.name);
        Age = findViewById(R.id.age);
        addButton = findViewById(R.id.addbtn);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vcaText = vcaId.getText().toString();
                String nameText = Name.getText().toString();
                String ageText = Age.getText().toString();
                String userTxt = "allusers";
                String passwordTxt = "1234";


                Boolean checkResults = databaseHelper.vcaRegistration(vcaText,nameText,ageText,userTxt,passwordTxt);
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
