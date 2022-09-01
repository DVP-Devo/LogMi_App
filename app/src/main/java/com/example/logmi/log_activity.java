package com.example.logmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class log_activity extends AppCompatActivity {

    Button buttonSave;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        buttonSave = findViewById(R.id.button_SaveAct);
        buttonSave.setOnClickListener(this::save_activity);
    }

    public void save_activity(View v) {

        // get existing quantity:
        // if a preferences file named COLOR_PREF already exists, get it
        // otherwise, create one (when required by the associate editor)
        // data stored in this file are for the use of this app only
        SharedPreferences preferences = getSharedPreferences("LOGMI_DATA", Context.MODE_PRIVATE);
        // create an editor to read and write from/to the preferences file
        final SharedPreferences.Editor editor = preferences.edit();
        int tot = preferences.getInt("activity_count", 0);

        EditText textBoxQuant = findViewById(R.id.editText_quantity_int);
        int uQ = Integer.valueOf(textBoxQuant.getText().toString()); // textBoxQuant.getText().toString()
        tot = tot + uQ;
        // save selected color to the preferences file immediately
        editor.putInt("activity_count", tot);
        editor.commit();
        Toast.makeText(getApplicationContext(),
                "Awesome! Keep it up! Total=" + tot, Toast.LENGTH_SHORT).show();
    }

}