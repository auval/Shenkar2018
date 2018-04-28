package com.amiru.shenkar2018;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Integration of LeakCanary (https://github.com/square/leakcanary) requires an Application class
 * We need to add MyApplication class to Android Manifest
 */
public class MyApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }

}
