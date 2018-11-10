package com.example.dennisshar.pushirecap.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.dennisshar.pushirecap.MainActivity;
import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.fragments.AllPushNotificationsFragmentHolder;
import com.example.dennisshar.pushirecap.fragments.NoDataFragment;
import com.example.dennisshar.pushirecap.fragments.NoPermissiomsGrantedFragment;
import com.example.dennisshar.pushirecap.fragments.PermissionsFragment;
import com.example.dennisshar.pushirecap.fragments.SettingsFragment;
import com.example.dennisshar.pushirecap.services.PushiRecappGlobalServiceCalls;

public class ResponseReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            FragmentTransaction ft =   ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();

            if(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_view_placeholder) != null) {
                ft.remove(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_view_placeholder));
            }


            switch (intent.getStringExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY)) {

                case PushiRecappGlobalServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB:
                    try {
                        ft.add(R.id.fragment_view_placeholder, new AllPushNotificationsFragmentHolder(), AllPushNotificationsFragmentHolder.TAG);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case PushiRecappGlobalServiceCalls.NO_DATA:
                    try {
                        ft.add(R.id.fragment_view_placeholder, new NoDataFragment(), NoDataFragment.TAG);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case PushiRecappGlobalServiceCalls.NO_PERMISIONS:
                    try {
                        ft.add(R.id.fragment_view_placeholder, new NoPermissiomsGrantedFragment(), NoPermissiomsGrantedFragment.TAG);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case PushiRecappGlobalServiceCalls.LOAD_MAIN_ACTIVITY:
                    try {
                        Intent intentone = new Intent(context, MainActivity.class);
                        intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intentone);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case PushiRecappGlobalServiceCalls.LOAD_SETTINGS_FRGMENTS:
                    try {
                        ft.add(R.id.fragment_view_placeholder, new SettingsFragment(), SettingsFragment.TAG);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case PushiRecappGlobalServiceCalls.LOAD_PERMISIONS_FRAGMENT:
                    try {
                        ft.add(R.id.fragment_view_placeholder, new PermissionsFragment(), PermissionsFragment.TAG);
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
