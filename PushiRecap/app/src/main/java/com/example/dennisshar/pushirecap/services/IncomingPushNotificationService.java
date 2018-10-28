package com.example.dennisshar.pushirecap.services;

import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.example.dennisshar.pushirecap.BaseActivity;
import com.example.dennisshar.pushirecap.datamodels.ExternalPushNotificationsDataModel;
import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;


public class IncomingPushNotificationService extends BaseNotificationListner {


    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        try {
            String pack = sbn.getPackageName();
            String ticker = "";
            if (sbn.getNotification().tickerText != null) {
                ticker = sbn.getNotification().tickerText.toString();
            }
            Bundle extras = sbn.getNotification().extras;
            String title = extras.getString("android.title");
            String text = extras.getCharSequence("android.text").toString();

            ExternalPushNotificationsDataModel externalPushNotificationsDataModel = new ExternalPushNotificationsDataModel();
            externalPushNotificationsDataModel.setPackageName(pack);
            externalPushNotificationsDataModel.setTicker(ticker);
            externalPushNotificationsDataModel.setTitle(title);
            externalPushNotificationsDataModel.setText(text);
            helper.bulkExternalPushNotification(externalPushNotificationsDataModel);


        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    @Override

    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg","Notification Removed");

    }
}
