package com.example.chris.coldturkey.Model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by chris on 6/23/2019.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM USER")
    List<User> loadAll();

    @Insert
    public void insertAll(User...users);
}
