package com.example.chris.coldturkey.Model;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

//import com.example.chris.coldturkey.App;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chris on 6/23/2019.
 */
@Module
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    static volatile AppDatabase appDatabase;

    public abstract UserDao UserDao();

    @Provides
    public static AppDatabase getDb(@Named("ApplicationContext")Context context) {
        if (appDatabase == null) {
            synchronized (AppDatabase.class) {
                if (appDatabase == null) {

                    appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "addiction").build();
                }
            }

        }
        return appDatabase;
    }

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}