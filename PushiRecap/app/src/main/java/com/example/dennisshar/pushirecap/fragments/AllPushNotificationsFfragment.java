package com.example.dennisshar.pushirecap.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.recyclerview.RecyclerViewAdapter;

public class AllPushNotificationsFfragment extends BaseFragment {

    public final static String TAG = "AllPushNotificationsFfragment";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private TextView lastUpdatedList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.all_push_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(mCallback.getDataBasehelper().getPushNotification(),getContext());

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        lastUpdatedList = (TextView) view.findViewById(R.id.last_updated_list);
        lastUpdatedList.setText(tools.getTools().getDateTime());

        return view;
    }


}
