package com.example.hsmstart;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class Register extends AppCompatActivity {

    FloatingActionButton addVca;


    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    ListView listView;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    DrawerLayout drawer;
    NavigationView navigation;
    Toolbar toolbar;
    public String item;
    Toolbar test1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addVca = findViewById(R.id.floatingActionButton4);
        listView = findViewById(R.id.listView);
        listItem = new ArrayList();
        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        test1 = findViewById(R.id.test1);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        addVca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addv = new Intent(Register.this, Vca.class);
                startActivity(addv);
            }
        });


        data();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String vcaName = (String) listView.getItemAtPosition(position);
                Intent rV = new Intent(Register.this,RegisterView.class);
                rV.putExtra("name",vcaName);
                startActivity(rV);
            }
        });




        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Toast.makeText(Register.this, "Hello you clicked on Profile", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(Register.this, "Hello you clicked on Setting", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(Register.this, "Logout Successful", Toast.LENGTH_LONG).show();
                        Intent items =new Intent(Register. this,MainActivity.class);
                        startActivity(items);
                        break;
                }

                item.setEnabled(true);
                drawer.close();
                return true;
            }
        });

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.toolbar_menu,menu);
            return super.onCreateOptionsMenu(menu);
        }


        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.test1:
                    Toast.makeText(this, "Selected", Toast.LENGTH_LONG).show();
                    break;
                case R.id.test2:
                    Toast.makeText(this,"Sorted", Toast.LENGTH_LONG).show();
                    break;
                case R.id.test3:
                    Toast.makeText(this,"About Information",Toast.LENGTH_LONG).show();
                    Intent aboutinfo = new Intent(Register.this,About.class);
                    startActivity(aboutinfo);
                    break;
                case R.id.test4:
                    Toast.makeText(this,"Help Information",Toast.LENGTH_LONG).show();
                    Intent helpinfo = new Intent(Register.this,Help.class);
                    startActivity(helpinfo);
                    break;
                case android.R.id.home:
                    drawer.openDrawer(GravityCompat.START);

            }
            return super.onOptionsItemSelected(item);
        }


    public void data(){
        Cursor cursor = databaseHelper.displayData();
        if(cursor.getCount()==0){
            Toast.makeText(Register.this, "No data to show", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()){
               // listItem.add("Country:\t"+"Zambia");
                //listItem.add("ID:\t"+cursor.getString(0));
                listItem.add(cursor.getString(1));
                //listItem.add("Age:\t"+cursor.getString(2)+"\n\n");



            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem
            );
            listView.setAdapter(adapter);
        }



    }
}