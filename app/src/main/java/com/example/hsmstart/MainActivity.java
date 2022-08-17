package com.example.hsmstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    MaterialButton login;
    public String item;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.loginbtn);






//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        // connect to next page
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("1234")){
            Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(MainActivity.this,Register.class);
            startActivity(i);
        }
        else
            Toast.makeText(MainActivity.this, "INCORRECT PASSWORD OR USERNAME", Toast.LENGTH_SHORT).show();
//        String userTxt = "admin";
//        String passwordTxt = "1234";
//
//        String name = username.getText().toString();
//        String pass = password.getText().toString();
//
//        Boolean checkResults = userlogin.UserLogin(name,pass);
  //     if(checkResults == true){

//        } else{
//            Toast.makeText(MainActivity.this, "Password or Username is invalid", Toast.LENGTH_LONG).show();
//        }






    }
});

    }


}