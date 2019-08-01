package com.example.chris.coldturkey;


import android.app.Application;

/**
 * Created by chris on 7/11/2019.
 */

public class App extends Application {


    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
//needs to run once to generate it
        component = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }
    public static AppComponent getComponent() {
        return component;
}
}
