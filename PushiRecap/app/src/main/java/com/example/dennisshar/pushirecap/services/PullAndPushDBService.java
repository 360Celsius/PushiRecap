package com.example.dennisshar.pushirecap.services;

import android.app.IntentService;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.dennisshar.pushirecap.BaseActivity;
import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;

public class PullAndPushDBService extends IntentService {

    public static final String GET_DATA = "GET_DATA";
    private static DatabaseHelper helper = null;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PullAndPushDBService(String name) {
        super(name);
    }

    public PullAndPushDBService() {
        super("PullAndPushDBService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        helper = BaseActivity.helper;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String isEnabledNotificationListeners = null;
        isEnabledNotificationListeners = Settings.Secure.getString(getApplicationContext().getContentResolver(),  "enabled_notification_listeners");

        if (intent.getStringExtra(PullAndPushServiceCalls.DATA_TYPE_KEY).equalsIgnoreCase(PullAndPushServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB)) {

            if(helper.getPushNotificationCount() != 0 && isEnabledNotificationListeners != null && !isEnabledNotificationListeners.equals("")) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_DATA);
                broadcastIntent.putExtra(PullAndPushServiceCalls.DATA_TYPE_KEY, PullAndPushServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB);
                sendBroadcast(broadcastIntent);
            }else if(helper.getPushNotificationCount() == 0 && isEnabledNotificationListeners != null  && !isEnabledNotificationListeners.equals("") ) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_DATA);
                broadcastIntent.putExtra(PullAndPushServiceCalls.DATA_TYPE_KEY, PullAndPushServiceCalls.NO_DATA);
                sendBroadcast(broadcastIntent);
            }else if(helper.getPushNotificationCount() != 0 && isEnabledNotificationListeners != null  && isEnabledNotificationListeners.equals("")) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_DATA);
                broadcastIntent.putExtra(PullAndPushServiceCalls.DATA_TYPE_KEY, PullAndPushServiceCalls.NO_PERMISIONS);
                sendBroadcast(broadcastIntent);
            }else if(helper.getPushNotificationCount() == 0 && isEnabledNotificationListeners != null  && isEnabledNotificationListeners.equals("")) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_DATA);
                broadcastIntent.putExtra(PullAndPushServiceCalls.DATA_TYPE_KEY, PullAndPushServiceCalls.NO_PERMISIONS);
                sendBroadcast(broadcastIntent);
            }
        }
    }
}
