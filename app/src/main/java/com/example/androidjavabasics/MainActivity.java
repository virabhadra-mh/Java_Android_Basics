package com.example.androidjavabasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidjavabasics.service.ActivityIntentService;

public class MainActivity extends AppCompatActivity {
    Button src_intentservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        src_intentservice= findViewById(R.id.src_intentservice);

        src_intentservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, ActivityIntentService.class);
                startActivity(in);
            }
        });
    }
}