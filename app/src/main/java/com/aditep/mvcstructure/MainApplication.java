package com.aditep.mvcstructure;

import android.app.Application;
import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Initallize thing(s) here
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
