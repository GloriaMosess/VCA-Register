package com.example.hsmstart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Vca extends AppCompatActivity {
    private EditText vcaId;
    private Button addButton;
    public String item;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vca);

        vcaId = findViewById(R.id.vcaId);
        addButton = findViewById(R.id.addbtn);

        
        
//        save.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                item = savetext.getText().toString();
////                if (text == null || text.length() == 0) {
////                    Toast.makeText(Vca.this, "Enter Information", Toast.LENGTH_SHORT).show();
////                } else {
//                //save.setText("");
//                Intent childintent = new Intent(Vca.this, Register.class);
//                startActivity(childintent);
//                Toast.makeText(Vca.this, "Saved", Toast.LENGTH_SHORT).show();
//
// //           }
//            }
//        });

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        
        
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vcaText = vcaId.getText().toString();
                
              Boolean checkResults = databaseHelper.vcaRegistration(vcaText);
              if(checkResults == true){
                  Toast.makeText(Vca.this, "Registration Successful", Toast.LENGTH_SHORT).show();
              }
              else {
                  Toast.makeText(Vca.this, "Please try again", Toast.LENGTH_SHORT).show();
              }




            }
        });



    }

//    public static String addItem(String item) {
//        return item;
//    }
}
