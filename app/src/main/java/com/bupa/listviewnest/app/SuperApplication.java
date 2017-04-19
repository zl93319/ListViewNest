package com.bupa.listviewnest.app;

import android.app.Application;

import com.bupa.listviewnest.util.UIUtils;

public class SuperApplication extends Application {


    @Override
    public void onCreate() {
        UIUtils.init(this);
    }
}
