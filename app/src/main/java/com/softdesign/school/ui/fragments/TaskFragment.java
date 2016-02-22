package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.utils.BlockToolbar;

public class TaskFragment extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View convertView = inflater.inflate(R.layout.fragment_task,null,false);
            getActivity().setTitle(getResources().getString(R.string.drawer_task));
            ((MainActivity)getActivity()).mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(false);
            ((MainActivity)getActivity()).mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(false);
            ((MainActivity)getActivity()).mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(false);
            ((MainActivity)getActivity()).mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(false);
            ((MainActivity)getActivity()).mNavigationView.getMenu().findItem(R.id.drawer_task).setChecked(true);
            ((MainActivity)getActivity()).mCollapsingToolbar.setTitle(getResources().getString(R.string.drawer_task));
            ((MainActivity) getActivity()).lockAppBar(true);
            return convertView;
        }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        AppBarLayout appBar = (AppBarLayout) getActivity().findViewById(R.id.appbar_layout);
        BlockToolbar.setDrag(false, appBar);
    }
}
