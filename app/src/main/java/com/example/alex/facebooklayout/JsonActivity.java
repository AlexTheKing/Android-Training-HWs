package com.example.alex.facebooklayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.alex.facebooklayout.json.JsonHandler;
import com.example.alex.facebooklayout.json.JsonResponse;
import com.example.alex.facebooklayout.network.HttpClient;
import com.example.alex.facebooklayout.network.Request;
import com.example.alex.facebooklayout.network.ResultCallback;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JsonActivity extends AppCompatActivity {

    private JsonResponse jsonResponse;
    private JsonResponse gsonResponse;
    private int count = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }

    private void scrollInfo(){
        View view = findViewById(R.id.jsonview);
        if (count >= jsonResponse.repos.size()) count = 0;
        if(count < 0) count = jsonResponse.repos.size() - 1;
        ((TextView) view).setText("ORG.JSON Parser:\nRepo number " + (count+1) + "\n" +
                    Integer.toString(jsonResponse.repos.get(count).repoId) + "\n" +
                    jsonResponse.repos.get(count).fullName + "\n" +
                    jsonResponse.repos.get(count).createdAt + "\n" +
                    "GSON Parser:\nRepo number " + (count+1) + "\n" +
                    Integer.toString(gsonResponse.repos.get(count).repoId) + "\n" +
                    gsonResponse.repos.get(count).fullName + "\n" +
                    gsonResponse.repos.get(count).createdAtDate.toString());
    }

    public void jsonClick(View view) {
        final TextView textView = ((TextView) findViewById(R.id.jsonview));
        HttpClient client = HttpClient.getInstance();
        Request request = new Request();
        request.setUrl("http://api.github.com/search/repositories?q=epam");
        Map<String, String> headers = new ConcurrentHashMap<>();
        headers.put("User-Agent", "MyAppThou");
        request.setHeaders(headers);
        request.setMethod("GET");
        client.makeAsyncRequest(request, new ResultCallback<String>() {
            @Override
            public void processResults(String s) {
                try {
                    jsonResponse = JsonHandler.handleOverJSON(s);
                    gsonResponse = JsonHandler.handleOverGSON(s);
                    textView.setText("Ready!");
                } catch (Exception e) {
                    e.printStackTrace();
                    textView.setText(e.toString());
                }
            }
        });
    }

    public void scrollLeft(View view) {
        if(jsonResponse != null) {
            count--;
            scrollInfo();
        }
    }

    public void scrollRight(View view) {
        if(jsonResponse != null) {
            count++;
            scrollInfo();
        }
    }
}
