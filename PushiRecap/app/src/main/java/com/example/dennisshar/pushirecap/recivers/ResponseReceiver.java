package com.example.dennisshar.pushirecap.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.fragments.AllPushNotificationsFfragment;
import com.example.dennisshar.pushirecap.services.IncomingPushNotificationInsertPullFromDBServiceCalls;

public class ResponseReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            FragmentTransaction ft =   ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();

            if(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_view_placeholder) != null) {
                ft.remove(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_view_placeholder));
            }


            switch (intent.getStringExtra(IncomingPushNotificationInsertPullFromDBServiceCalls.DATA_TYPE_KEY)) {

                case IncomingPushNotificationInsertPullFromDBServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB:
                    try {
                        ft.add(R.id.fragment_view_placeholder, new AllPushNotificationsFfragment(), AllPushNotificationsFfragment.TAG);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }

            ft.commit();

        }catch (Exception e){
            e.printStackTrace();
            //TODO load error screen
        }
    }
}
