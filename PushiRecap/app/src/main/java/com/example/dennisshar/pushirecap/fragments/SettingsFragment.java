package com.example.dennisshar.pushirecap.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.recyclerview.PushNotificationRecyclerViewAdapter;
import com.example.dennisshar.pushirecap.recyclerview.SettingsRecyclerViewAdapter;

public class SettingsFragment extends BaseFragment {

    public final static String TAG = "SettingsFragment";
    public final static String SCREEN_NAME = "Settings";
    private RecyclerView recyclerView;
    private SettingsRecyclerViewAdapter recyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerViewAdapter = new SettingsRecyclerViewAdapter(mCallback.getDataBasehelper().getPackagesOnDevice(),getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
