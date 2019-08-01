package com.example.chris.coldturkey.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chris.coldturkey.Model.AppDatabase;
import com.example.chris.coldturkey.Model.User;
import com.example.chris.coldturkey.R;

public class NoteActivity extends AppCompatActivity {

    User myUser;
    EditText time;
    EditText note;
    Button save;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        
        time = (EditText)findViewById(R.id.time);
        note = (EditText)findViewById(R.id.note);
        save = (Button)findViewById(R.id.Save);


    }
    public void saving(View view){
        myUser = new User(time.getText().toString(), note.getText().toString());
         MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);


                viewModel.saveUsers(myUser);

        Intent i = new Intent(NoteActivity.this,MainActivity.class);
        startActivity(i);

        finish();
    }
}
