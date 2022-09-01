package com.example.logmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonLogAct, buttonStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogAct = findViewById(R.id.button_LogAct);
        buttonLogAct.setOnClickListener(this::enter);
        buttonStats = findViewById(R.id.button_YourStats);
        buttonStats.setOnClickListener(this::goToStats);
    }

    public void enter(View v) {
        Intent goToLogAct = new Intent();
        goToLogAct.setClass(this, log_activity.class);
        startActivity(goToLogAct);
    }

    public void goToStats(View v) {
        Intent toStats = new Intent();
        toStats.setClass(this, yourstats.class);
        startActivity(toStats);
    }

}