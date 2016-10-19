package com.example.alex.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.myapplication.threads.IProgressCallback;
import com.example.alex.myapplication.threads.IResultCallback;
import com.example.alex.myapplication.threads.ITask;
import com.example.alex.myapplication.threads.MyAsyncTask;

public class ThreadActivity extends AppCompatActivity {
    private static final String TAG = "MYTAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);

        final TextView view = (TextView) findViewById(R.id.threadResult);

        MyAsyncTask myTask = new MyAsyncTask();

        myTask.execute(new ITask<String, Integer, String>() {

            @Override
            public String doInBackground(String s, IProgressCallback<Integer> progressCallback) {
                int count = 0;
                for(char c : s.toCharArray()){
                    Log.d(TAG, "doInBackground: " + c);
                    progressCallback.onProgressUpdate(count);
                    count++;
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return "Work is done!";
            }
        }, "Hello", new IProgressCallback<Integer>() {
            @Override
            public void onProgressUpdate(Integer integer) {
                Toast.makeText(ThreadActivity.this, "Downloading " + integer + " file", Toast.LENGTH_SHORT).show();
            }
        }, new IResultCallback<String>() {
            @Override
            public void onSuccess(String s) {
                view.setText(s);
            }

            @Override
            public void onError(Exception exception) {
                view.setText("Error");
            }
        });
    }
}
