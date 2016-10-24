package com.example.alex.facebooklayout;

import android.content.Context;

/**
 * Created by Alex on 24.10.2016.
 */

public class ContextHolder {

    private static ContextHolder mContextHolder;
    private Context mContext;

    public static ContextHolder getInstance(){
        if(mContextHolder == null){
            mContextHolder = new ContextHolder();
        }
        return mContextHolder;
    }

    public void setContext(Context context){
        mContext = context;
    }

    public Context getContext(){
        return mContext;
    }
}
