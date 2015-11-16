package com.alisher.android.bugingroup.parse;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Samsung on 11/15/2015.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "aS2wPLqFinGBBk7hL0tF0U34ykDDHPWAx5sCUUQu", "2ZL2LBxVFx5CWqR5WXhfpB89RwCYeFYGunyvjriw");
    }
}
