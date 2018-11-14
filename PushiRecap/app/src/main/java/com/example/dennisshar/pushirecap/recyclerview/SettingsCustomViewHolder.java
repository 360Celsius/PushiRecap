package com.example.dennisshar.pushirecap.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dennisshar.pushirecap.R;

public class SettingsCustomViewHolder extends RecyclerView.ViewHolder{

    public RelativeLayout customRowViewRow;
    public ImageView packageIcon;
    public TextView pushNotificationTitle;


    public SettingsCustomViewHolder(@NonNull View itemView) {
        super(itemView);
        customRowViewRow = (RelativeLayout) itemView.findViewById(R.id.custom_row_item_main_view);
        packageIcon = (ImageView) itemView.findViewById(R.id.package_icon);
        pushNotificationTitle = (TextView) itemView.findViewById(R.id.pushnotification_title);

    }
}
