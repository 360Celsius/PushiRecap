package com.example.dennisshar.pushirecap.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dennisshar.pushirecap.R;

public class CustomViewHolder extends RecyclerView.ViewHolder{

    RelativeLayout customRowViewRow;
    TextView packadgeName;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        customRowViewRow = (RelativeLayout) itemView.findViewById(R.id.custom_row_item_main_view);
        packadgeName = (TextView) itemView.findViewById(R.id.packedge_name);
    }
}
