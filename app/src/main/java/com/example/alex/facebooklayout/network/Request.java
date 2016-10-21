package com.example.alex.facebooklayout.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Request {

    private String mUrl;
    private Map<String, String> mHeaders;
    private String mBody;
    private String mMethod;

    public String getMethod() {
        return mMethod;
    }

    public void setMethod(String mMethod) {
        this.mMethod = mMethod;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public Map<String, String> getHeaders() {
        return mHeaders;
    }

    public void setHeaders(Map<String, String> mHeaders) {
        this.mHeaders = mHeaders;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String mBody) {
        this.mBody = mBody;
    }

    public String execute() throws Exception {
        if (mUrl == null) {
            throw new IllegalArgumentException("No url provided");
        }
        URL url = new URL(mUrl);
        HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
        if(connection == null) throw new Exception("connection == null");
        addProperties(connection);
        InputStream inStream;
        int responseCode = connection.getResponseCode();
        if(responseCode == 301){
            url = new URL(connection.getHeaderField("Location"));
            connection = ((HttpURLConnection) url.openConnection());
            addProperties(connection);
        }
        responseCode = connection.getResponseCode();
        boolean isSucceeded = responseCode >= 200 && responseCode < 300;
        if (isSucceeded) {
            inStream = connection.getInputStream();
        } else {
            throw new Exception("Response code is not good " + responseCode);
        }
        if(inStream == null) throw new Exception("inStream == null");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        inStream.close();
        connection.disconnect();
        String response = stringBuilder.toString();

        if (!isSucceeded) {
            throw new Exception(response);
        }
        return response;
    }

    private void addProperties(HttpURLConnection connection) throws Exception{
        if (mHeaders != null) {
            for (String key : mHeaders.keySet()) {
                connection.addRequestProperty(key, mHeaders.get(key));
            }
        }
        if (mBody != null) {
            byte[] body = mBody.getBytes("UTF-8");
            OutputStream stream = connection.getOutputStream();
            stream.write(body);
            stream.close();
        }
    }

}
