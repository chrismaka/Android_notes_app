package com.example.chris.coldturkey.ui;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chris.coldturkey.Model.User;
import com.example.chris.coldturkey.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 6/28/2019.
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<User> userList;

    public MyAdapter(List<User>userList){

        this.userList = userList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView time;
        public TextView note;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            note = itemView.findViewById(R.id.note);
        }
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        holder.time.setText(userList.get(position).getTime());
        holder.note.setText(userList.get(position).getNotes());

    }

    @Override
    public int getItemCount()
    {
        return userList.size();
    }


}
