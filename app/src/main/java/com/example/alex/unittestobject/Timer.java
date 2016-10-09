package com.example.alex.unittestobject;

public class Timer {
    public boolean isTimeLessHalfMinute(){
        return System.currentTimeMillis()/1000 % 60 < 30;
    }
}
