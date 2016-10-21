package com.example.alex.facebooklayout.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse {

    @SerializedName("total_count")
    public int totalCount;

    @SerializedName("items")
    public List<JsonRepo> repos = new ArrayList<>();
}
