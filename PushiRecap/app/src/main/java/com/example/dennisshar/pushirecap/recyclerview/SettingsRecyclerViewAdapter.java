package com.example.dennisshar.pushirecap.recyclerview;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.datamodels.ExternalPushNotificationsDataModel;

import java.util.ArrayList;

public class SettingsRecyclerViewAdapter extends RecyclerView.Adapter<SettingsCustomViewHolder>{

    ArrayList<String> packadgeList = new ArrayList<>();
    Context context;

    public SettingsRecyclerViewAdapter(ArrayList<String> list, Context context) {
        this.packadgeList = list;
        this.context = context;
    }


    @NonNull
    @Override
    public SettingsCustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row_settings, viewGroup, false);
        SettingsCustomViewHolder holder = new SettingsCustomViewHolder(v);
        return holder;    }

    @Override
    public void onBindViewHolder(@NonNull SettingsCustomViewHolder settingsCustomViewHolder, int position) {
        settingsCustomViewHolder.pushNotificationTitle.setText(packadgeList.get(position));
        try
        {
            Drawable icon = context.getPackageManager().getApplicationIcon(packadgeList.get(position));
            settingsCustomViewHolder.packageIcon.setImageDrawable(icon);
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return packadgeList.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
