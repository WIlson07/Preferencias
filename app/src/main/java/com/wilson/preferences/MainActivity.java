package com.wilson.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtPrefs;

    Button storeInfo, showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeInfo = findViewById(R.id.storeinformation);
        showInfo = findViewById(R.id.showinformation);
        txtPrefs = findViewById(R.id.txtPrefs);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case  R.id.storeinformation:
                        Intent intent = new Intent(MainActivity.this, PrefsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.showinformation:
                        displaySharedPreferences();
                        break;
                    default:
                        break;
                }
            }
        };
        storeInfo.setOnClickListener(listener);
        showInfo.setOnClickListener(listener);
    }

    private void displaySharedPreferences(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = prefs.getString("username","Default Nickname");
        String passw = prefs.getString("password","Default Password");
        boolean checkbox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list prefs");

        StringBuilder builder = new StringBuilder();
        builder.append("Username: " + username + "\n");
        builder.append("Password: " + passw + "\n");
        builder.append("Keep me logged in: " + String.valueOf(checkbox) + "\n");
        builder.append("List preference: " + listPrefs + "\n");
        txtPrefs.setText(builder.toString());
    }
}
