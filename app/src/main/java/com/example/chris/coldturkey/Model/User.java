package com.example.chris.coldturkey.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by chris on 6/23/2019.
 */
@Entity(tableName = "User")
public class User {

    @NonNull@PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name="notes")
    private String notes;

    public User(String time, String notes) {
        this.time = time;
        this.notes = notes;

    }
    public String getTime(){
        return this.time;
    }
    public String getNotes(){
        return this.notes;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
