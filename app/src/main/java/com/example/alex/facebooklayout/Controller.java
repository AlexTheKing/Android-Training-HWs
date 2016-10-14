package com.example.alex.facebooklayout;

import android.os.Handler;
import android.os.Looper;

import com.example.alex.api.ApiManager;
import com.example.user.myapplication.backend.myApi.MyApi;
import com.example.user.myapplication.backend.myApi.model.DataBean;

import java.io.IOException;

public class Controller {

    private FourthActivity activity = null;

    public Controller(FourthActivity activity) {
        this.activity = activity;
    }

    public Handler handler = new Handler(Looper.getMainLooper());

    public void getGithub(final String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String response;
                try {
                    MyApi.GetGithub call = ApiManager.get().getApiObject().getGithub(name);
                    DataBean bean = call.execute();
                    response = bean.getData();
                } catch (IOException e) {
                    response = "Error: " + e;
                    e.printStackTrace();
                }
                printMessage(response);
            }
        }).start();
    }

    private void printMessage(final String response) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                activity.printData(response);
            }
        });
    }
}
