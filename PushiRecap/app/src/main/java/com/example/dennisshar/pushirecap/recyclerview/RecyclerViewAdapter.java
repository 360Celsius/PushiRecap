package com.example.dennisshar.pushirecap.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.datamodels.ExternalPushNotificationsDataModel;

import java.util.ArrayList;
import java.util.Collections;

public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder>{

    ArrayList<ExternalPushNotificationsDataModel> externalPushNotificationsDataModelList = new ArrayList<>();
    Context context;


    public RecyclerViewAdapter(ArrayList<ExternalPushNotificationsDataModel> list, Context context) {
        this.externalPushNotificationsDataModelList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row_item, viewGroup, false);
        CustomViewHolder holder = new CustomViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, int position) {
        viewHolder.packadgeName.setText(externalPushNotificationsDataModelList.get(position).getPackageName());

    }

    @Override
    public int getItemCount() {
        return externalPushNotificationsDataModelList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, ExternalPushNotificationsDataModel data) {
        externalPushNotificationsDataModelList.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(ExternalPushNotificationsDataModel data) {
        int position = externalPushNotificationsDataModelList.indexOf(data);
        externalPushNotificationsDataModelList.remove(position);
        notifyItemRemoved(position);
    }
}
