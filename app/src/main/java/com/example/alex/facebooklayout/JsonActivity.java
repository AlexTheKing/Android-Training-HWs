package com.example.alex.facebooklayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.alex.facebooklayout.network.HttpClient;
import com.example.alex.facebooklayout.network.Request;
import com.example.alex.facebooklayout.network.ResultCallback;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JsonActivity extends AppCompatActivity {

    private String response;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }

    public void jsonClick(View view) {
        final TextView textView = ((TextView) findViewById(R.id.jsonview));

        HttpClient client = HttpClient.getInstance();
        Request request = new Request();
        request.setUrl("http://google.com");
        Map<String, String> headers = new ConcurrentHashMap<>();
        headers.put("User-Agent", "MyAppThou");
        request.setHeaders(headers);
        request.setMethod("GET");
        client.makeAsyncRequest(request, new ResultCallback<String>() {
            @Override
            public void processResults(String s) {
                response = s;
                textView.setText(response);
            }
        });
    }
}
