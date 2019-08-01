package com.example.chris.coldturkey.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

//import com.example.chris.coldturkey.App;

import com.example.chris.coldturkey.App;
import com.example.chris.coldturkey.Model.AppDatabase;
import com.example.chris.coldturkey.Model.User;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by chris on 7/11/2019.
 */

public class MyViewModel extends ViewModel {
    Handler handler;
  //@Inject
    //ContextModule contextModule;
    @Inject
    AppDatabase appDatabase;
    List<User>userz;


    public MyViewModel(){
       App.getComponent().inject(this);
    }
   private MutableLiveData<List<User>> users;
    public LiveData<List<User>> getUser(){
        if(users==null){
           users = new MutableLiveData<List<User>>();
            loadUsers();

        }
        return users;
   }
   public void loadUsers(){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.UserDao().loadAll();
            }
        });


   // return userz =appDatabase.UserDao().loadAll();

    }
    public void saveUsers(final User myUsers){
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    appDatabase.UserDao().insertAll(myUsers);
                }
            });




    }

}
