package com.example.hsmstart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    ImageView imageView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        imageView = findViewById(R.id.imageView);
        textView2 = findViewById(R.id.textView2);
    }
}