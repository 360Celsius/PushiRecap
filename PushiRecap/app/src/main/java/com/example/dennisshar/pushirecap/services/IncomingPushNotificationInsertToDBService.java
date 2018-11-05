package com.example.dennisshar.pushirecap.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.example.dennisshar.pushirecap.BaseActivity;
import com.example.dennisshar.pushirecap.datamodels.ExternalPushNotificationsDataModel;
import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;
import com.example.dennisshar.pushirecap.tools.Tools;


public class IncomingPushNotificationInsertToDBService extends NotificationListenerService {

    public static DatabaseHelper helper = null;
    public static Tools tools = null;
    public Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }


    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        helper = BaseActivity.helper;
        tools = BaseActivity.tools;

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
            externalPushNotificationsDataModel.setDate(tools.getDateTime());
            helper.bulkExternalPushNotification(externalPushNotificationsDataModel);


            Intent msgIntent = new Intent(getApplicationContext(), PushiRecappGlobalService.class);
            msgIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB);
            startService(msgIntent);

        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    @Override

    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg","Notification Removed");

    }
}
