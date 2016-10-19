package com.example.alex.myapplication.threads;

public interface IResultCallback<Result> {

    void onSuccess(Result result);

    void onError(Exception exception);
}
