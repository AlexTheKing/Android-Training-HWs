package com.example.alex.facebooklayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if(BuildConfig.DEBUG) {
            Toast.makeText(getApplicationContext(), "DEBUG Version", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Release Version for " + BuildConfig.FLAVOR, Toast.LENGTH_SHORT).show();
        }
    }

    public void toNews(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
