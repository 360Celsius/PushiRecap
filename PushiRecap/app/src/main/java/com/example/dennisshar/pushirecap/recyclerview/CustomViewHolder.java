package com.example.dennisshar.pushirecap.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dennisshar.pushirecap.R;

public class CustomViewHolder extends RecyclerView.ViewHolder{

    public RelativeLayout customRowViewRow;
    public TextView pushNotificationTitle;
    public TextView pushNotificationText;
    public ImageView packageIcon;
    public TextView pushnotificationDate;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        customRowViewRow = (RelativeLayout) itemView.findViewById(R.id.custom_row_item_main_view);
        pushNotificationTitle = (TextView) itemView.findViewById(R.id.pushnotification_title);
        pushNotificationText = (TextView) itemView.findViewById(R.id.pushnotification_text);
        packageIcon = (ImageView) itemView.findViewById(R.id.package_icon);
        pushnotificationDate = (TextView) itemView.findViewById(R.id.pushnotification_date);
    }
}
