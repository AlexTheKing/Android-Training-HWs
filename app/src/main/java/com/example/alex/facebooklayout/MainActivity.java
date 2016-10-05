package com.example.alex.facebooklayout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
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
