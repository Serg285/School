package com.softdesign.school.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.model.User;

public class RecycleUsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<User> mUsers;

    public RecycleUsersAdapter(ArrayList<User> mUsers) {
        this.mUsers = mUsers;
    }

    public int getItemCount() {
        return mUsers.size();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_card, parent, false);
        return new UserViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User mUser = mUsers.get(position);
        holder.fullName.setText(mUser.getmFirstName() + " " + mUser.getmLastName());
        holder.avatar.setImageDrawable(mUser.getmImage());
    }


}