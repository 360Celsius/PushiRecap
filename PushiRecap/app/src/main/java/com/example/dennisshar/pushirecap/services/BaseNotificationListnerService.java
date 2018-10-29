package com.example.dennisshar.pushirecap.services;

import android.content.Context;
import android.service.notification.NotificationListenerService;

import com.example.dennisshar.pushirecap.BaseActivity;
import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;

public class BaseNotificationListnerService extends NotificationListenerService {

    public static DatabaseHelper helper = null;
    public Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        helper = BaseActivity.helper;
    }
}
