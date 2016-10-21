package com.example.alex.facebooklayout.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class JsonHandler {

    public static JsonResponse handleOverJSON(String jsonAsString) throws JSONException{
        JSONObject jsonObject = new JSONObject(jsonAsString);
        JsonResponse responseAsJson  = new JsonResponse();
        responseAsJson.totalCount = jsonObject.getInt("total_count");
        JSONArray repos = jsonObject.getJSONArray("items");
        for(int i = 0; i < repos.length(); i++){
            JsonRepo repo = new JsonRepo();
            JSONObject obj = repos.getJSONObject(i);
            repo.repoId = obj.getInt("id");
            repo.fullName = obj.getString("full_name");
            repo.createdAt = obj.getString("created_at");
            responseAsJson.repos.add(repo);
        }
        return responseAsJson;
    }

    public static JsonResponse handleOverGSON(String jsonAsString){
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateConverter()).create();
        return gson.fromJson(jsonAsString, JsonResponse.class);
    }

}