package com.example.alex.facebooklayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alex.unittestobject.Timer;

public class ThirdActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void createTimer(Timer timer){
        this.timer = timer;
    }

    @Override
    protected void onResume() {
        Button btn = (Button) findViewById(R.id.btn);
        btn.setVisibility(timer.isTimeLessHalfMinute() ? View.INVISIBLE : View.VISIBLE);
        super.onResume();
    }
}
