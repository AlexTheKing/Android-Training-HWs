package com.example.alex.facebooklayout.json;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class JsonRepo {

    @SerializedName("id")
    public int repoId;

    @SerializedName("full_name")
    public String fullName;

    public String createdAt;

    @SerializedName("created_at")
    public Date createdAtDate;

}
