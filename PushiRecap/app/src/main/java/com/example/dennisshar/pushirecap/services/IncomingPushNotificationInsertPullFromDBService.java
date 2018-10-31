package com.example.dennisshar.pushirecap.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;

public class IncomingPushNotificationInsertPullFromDBService extends IntentService {

    public static final String GET_DATA = "GET_DATA";
    private static DatabaseHelper helper = null;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IncomingPushNotificationInsertPullFromDBService(String name) {
        super(name);
    }

    public IncomingPushNotificationInsertPullFromDBService() {
        super("IncomingPushNotificationInsertPullFromDBService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent.getStringExtra(IncomingPushNotificationInsertPullFromDBServiceCalls.DATA_TYPE_KEY).equalsIgnoreCase(IncomingPushNotificationInsertPullFromDBServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB)) {


            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_DATA);
            broadcastIntent.putExtra(IncomingPushNotificationInsertPullFromDBServiceCalls.DATA_TYPE_KEY, IncomingPushNotificationInsertPullFromDBServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB);
            sendBroadcast(broadcastIntent);
        }
    }
}
