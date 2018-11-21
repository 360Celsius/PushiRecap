package com.example.dennisshar.pushirecap.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.datamodels.ExternalPushNotificationsDataModel;
import com.example.dennisshar.pushirecap.tools.Tools;

import java.util.ArrayList;

public class CategorizedPushNotificationRecyclerViewAdapter extends RecyclerView.Adapter<PushNotificationCustomViewHolder>{

    ArrayList<ExternalPushNotificationsDataModel> externalPushNotificationsDataModelList = new ArrayList<>();
    Context context;
    String rowHeader = null;
    public static Tools tools = null;

    public CategorizedPushNotificationRecyclerViewAdapter(ArrayList<ExternalPushNotificationsDataModel> list, Context context, Activity act) {
        this.externalPushNotificationsDataModelList = list;
        this.context = context;
        this.tools = Tools.getInstance(context,act);
    }

    @NonNull
    @Override
    public PushNotificationCustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row_item, viewGroup, false);
        PushNotificationCustomViewHolder holder = new PushNotificationCustomViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PushNotificationCustomViewHolder viewHolder, int position) {
        viewHolder.pushNotificationTitle.setText(externalPushNotificationsDataModelList.get(position).getTitle());
        viewHolder.pushNotificationText.setText(externalPushNotificationsDataModelList.get(position).getText());
        viewHolder.pushnotificationDate.setText(externalPushNotificationsDataModelList.get(position).getDate());

        int layOutHight = 80;
        final float scale = context.getResources().getDisplayMetrics().density;


        if(rowHeader ==null || position == 0 || !rowHeader.equals( tools.getPackageName(externalPushNotificationsDataModelList.get(position).getPackageName()) )){
            layOutHight = 90;
            rowHeader = tools.getPackageName(externalPushNotificationsDataModelList.get(position).getPackageName());
            viewHolder.date.setVisibility(View.VISIBLE);
            viewHolder.date.setText(rowHeader);

            int pixels = (int) (layOutHight * scale + 0.5f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, pixels);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        }else{
            layOutHight = 80;
            viewHolder.date.setVisibility(View.GONE);

            int pixels = (int) (layOutHight * scale + 0.5f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, pixels);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            viewHolder.customRowViewRow.setLayoutParams(layoutParams);
        }

        try
        {
            Drawable icon = context.getPackageManager().getApplicationIcon(externalPushNotificationsDataModelList.get(position).getPackageName());
            viewHolder.packageIcon.setImageDrawable(icon);
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }

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
