package com.example.hsmstart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class Register extends AppCompatActivity {
    private static AdapterView<ArrayAdapter> child_register;
    private static ArrayAdapter ChildR;
    FloatingActionButton addVca;
    //ListView child_register;
    private EditText vcaId,name, age;
    private static ArrayList<String> nlist;
    //public Button save = findViewById(R.id.addbtn);
    //ArrayAdapter ChildR;
    String values[] = new String[0];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addVca = findViewById(R.id.floatingActionButton4);
        child_register = (AdapterView<ArrayAdapter>) findViewById(R.id.myviewls);

        vcaId = findViewById(R.id.vcaId);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        nlist = new ArrayList<>();

        String values [] = {"gloria", "moses", "gabby", "phaless"};


        child_register.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Register.this, "You clicked on:" + values[position], Toast.LENGTH_SHORT).show();
            }

        });


        addVca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addv = new Intent(Register.this, Vca.class);
                startActivity(addv);
            }
        });


    }

    //   public void addItem(String item){
//       if (item.getid() == R.id.addbtn){
//           String text =  save.getText().toString();{
//               if (text.equalsIgnoreCase("next")) {
//                   Intent childintent = new Intent(Register.this, Vca.class);
//                   startActivity(childintent);
//               }  else{
//                   Toast.makeText(getApplicationContext(), "Incorrect Information", Toast.LENGTH_SHORT).show();
//               }
//           }
//       }
    public String addItem(String item) {

        child_register.setAdapter(ChildR);
        ArrayList<String> values  = new ArrayList<String>();
        ChildR = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Arrays.asList(values));

        values.add(item);
            ChildR.notifyDataSetChanged();

            return item;
    }
}