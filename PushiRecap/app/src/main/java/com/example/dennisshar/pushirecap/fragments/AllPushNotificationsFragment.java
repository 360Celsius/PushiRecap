package com.example.dennisshar.pushirecap.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.recyclerview.RecyclerViewAdapter;
import com.example.dennisshar.pushirecap.services.IncomingPushNotificationInsertPullFromDBService;
import com.example.dennisshar.pushirecap.services.IncomingPushNotificationInsertPullFromDBServiceCalls;

public class AllPushNotificationsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    public final static String TAG = "AllPushNotificationsFragment";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private TextView lastUpdatedList;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.all_push_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(mCallback.getDataBasehelper().getPushNotification(),getContext());

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources( R.color.pullToRefreshCOlor_1, R.color.pullToRefreshCOlor_2, R.color.pullToRefreshCOlor_3);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        lastUpdatedList = (TextView) view.findViewById(R.id.last_updated_list);
        lastUpdatedList.setText(tools.getTools().getDateTime());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Stop refreshing
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        Intent msgIntent = new Intent(getContext(), IncomingPushNotificationInsertPullFromDBService.class);
        msgIntent.putExtra(IncomingPushNotificationInsertPullFromDBServiceCalls.DATA_TYPE_KEY, IncomingPushNotificationInsertPullFromDBServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB);
        getContext().startService(msgIntent);
    }
}