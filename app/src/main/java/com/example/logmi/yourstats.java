package com.example.logmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class yourstats extends AppCompatActivity {

    TextView show_stat;
    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourstats);
        buttonReset = findViewById(R.id.button_ResetStats);
        buttonReset.setOnClickListener(this::reset_stats);

        show_stat = (TextView) findViewById(R.id.show_stats);
        SharedPreferences pref =
                getApplicationContext().getSharedPreferences("LOGMI_DATA", Context.MODE_PRIVATE);
        // create an editor to read and write from/to the preferences file
//        final SharedPreferences.Editor editor = pref.edit();
        int tot = pref.getInt("activity_count", 0);
//        editor.apply();
        show_stat.setText( String.valueOf(tot) );

    }

    public void reset_stats(View v) {

        SharedPreferences preferences = getSharedPreferences("LOGMI_DATA", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        // save selected color to the preferences file immediately
        editor.putInt("activity_count", 0);
        editor.commit();
        Toast.makeText(getApplicationContext(),
                "Stats cleared!", Toast.LENGTH_SHORT).show();
        show_stat = (TextView) findViewById(R.id.show_stats);
        show_stat.setText( String.valueOf(0) );
    }

}