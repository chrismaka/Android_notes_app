package com.example.chris.coldturkey;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chris on 7/11/2019.
 */
@Module
class ContextModule {
   Context context;
    ContextModule(Context context) {
        this.context = context;
    }
    @Provides
    @Named("ApplicationContext")
    Context getContext(){
        return  context;
    }

}
