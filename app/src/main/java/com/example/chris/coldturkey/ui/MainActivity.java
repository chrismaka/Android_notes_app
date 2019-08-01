package com.example.chris.coldturkey.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.icu.lang.UScript;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.example.chris.coldturkey.App;
import com.example.chris.coldturkey.Model.AppDatabase;
import com.example.chris.coldturkey.Model.User;
import com.example.chris.coldturkey.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   List<User> user;
    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    AppDatabase appDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyViewModel viewModel2 = ViewModelProviders.of(this).get(MyViewModel.class);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));

        final Observer<List<User>>userList = new Observer<List<User>>() {
            @Override
            public void onChanged(final List list) {

                adapter = new MyAdapter(list);
                recyclerView.setAdapter(adapter);

            }
        };

            viewModel2.getUser().observeForever(userList);







        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
