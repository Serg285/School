package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.softdesign.school.R;
import com.softdesign.school.data.storage.model.User;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.adapters.RecycleUsersAdapter;


import java.util.ArrayList;

public class ContactsFragment extends Fragment {
    private ArrayList<User> mUsers = new ArrayList<User>();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private View mContactView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ((MainActivity)getActivity()).lockAppBar(false);
        if (mContactView == null) {
            mContactView = inflater.inflate(R.layout.fragment_contacts, container, false);
        }

        NavigationView mNavigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
        mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_task).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(false);

        generateData();

        mRecyclerView = (RecyclerView) mContactView.findViewById(R.id.contacts_recyclerview);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecycleUsersAdapter(mUsers);
        mRecyclerView.setAdapter(mAdapter);
        return mContactView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).lockAppBar(true);

        FloatingActionButton mFloationgActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mFloationgActionButton.getLayoutParams();
        params.setAnchorId(R.id.coordinator_layout);
        params.anchorGravity = Gravity.BOTTOM | Gravity.END;
        mFloationgActionButton.setLayoutParams(params);
        mFloationgActionButton.setImageResource(R.drawable.ic_add_24dp);
    }

    private void generateData() {
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Ольга", "Кулик"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Елена", "Щурова"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Анжелика", "Семенычева"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Людмила", "Людмилова"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Татьяна", "Черткова"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Ирина", "Милайлова"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Татьяна", "Татьянова"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Ирина", "Богданова"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Наталья", "Наталья"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.contact_1), "Мария", "Доронина"));
    }
}