package com.example.alex.facebooklayout.threads;

public interface IResultCallback<Result> {

    void onSuccess(Result result);

    void onError(Exception exception);
}
