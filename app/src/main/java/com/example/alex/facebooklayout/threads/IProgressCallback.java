package com.example.alex.facebooklayout.threads;

import android.app.Activity;

public abstract class IProgressCallback<Progress> {

    public abstract void onProgressUpdate(Progress progress, Activity activity);
    public void onProgressUpdate(Progress progress) {
        onProgressUpdate(progress, null);
    }

}
