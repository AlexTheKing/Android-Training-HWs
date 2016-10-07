package com.example.alex.facebooklayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private int counter = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void toPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void likeClick(View view) {
        TextView textView = (TextView) view;
        counter++;
        textView.setText(counter + " Likes");
    }

    public void toastClick(View view) {
        Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
    }


}
