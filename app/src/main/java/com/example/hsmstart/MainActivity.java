package com.example.hsmstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigation;
    Toolbar toolbar;
    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.loginbtn);
        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        // connect to next page

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                intent.putExtra("user", username.getText()
                );

                startActivity(intent);
            }

        });
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home1:
                        Toast.makeText(MainActivity.this, "Hello you clicked on home 1", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.home2:
                        Toast.makeText(MainActivity.this, "Hello you clicked on home 2", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.home3:
                        Toast.makeText(MainActivity.this, "Hello you clicked on home 3", Toast.LENGTH_LONG).show();
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
                Toast.makeText(this, "Test 1 selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.test2:
                Toast.makeText(this,"Test 2 selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.test3:
                Toast.makeText(this,"Test 3 Selected",Toast.LENGTH_LONG).show();
                break;
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);

        }
        return super.onOptionsItemSelected(item);
    }
}