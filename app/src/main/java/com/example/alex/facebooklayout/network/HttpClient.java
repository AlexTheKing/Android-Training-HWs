package com.example.alex.facebooklayout.network;

import android.os.AsyncTask;
import android.util.Log;

public class HttpClient {

    private static HttpClient client;

    private HttpClient() {
    }

    public static HttpClient getInstance() {
        if (client == null) {
            client = new HttpClient();
        }
        return client;
    }

    public void makeAsyncRequest(final Request request, final ResultCallback<String> callback) {
        AsyncTask<Request, Void, String> networkTask = new AsyncTask<Request, Void, String>() {
            @Override
            protected String doInBackground(Request... requests) {
                String response;
                try {
                    response = requests[0].execute();
                } catch (Exception e) {
                    Log.e("HTTPCLIENT", "doInBackground: ", e);
                    response = e.toString();
                }
                return response;
            }

            @Override
            protected void onPostExecute(String result) {
                callback.processResults(result);
                super.onPostExecute(result);
            }
        }.execute(request);
    }
}
