package com.example.dennisshar.pushirecap.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.dennisshar.pushirecap.BaseActivity;
import com.example.dennisshar.pushirecap.MainActivity;
import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;
import com.example.dennisshar.pushirecap.tools.Tools;

public class PushiRecappGlobalService extends IntentService {

    public static final String GET_DATA = "GET_DATA";
    private static DatabaseHelper helper = null;
    public static Tools tools = null;


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PushiRecappGlobalService(String name) {
        super(name);
    }

    public PushiRecappGlobalService() {
        super("PushiRecappGlobalService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        helper = BaseActivity.helper;
        tools = BaseActivity.tools;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        if (intent.getStringExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY).equalsIgnoreCase(PushiRecappGlobalServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB)) {

            if(helper.getPushNotificationCount() != 0 && tools.checkNotificationAccessPermisions() ) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_DATA);
                broadcastIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB);
                sendBroadcast(broadcastIntent);
            }else if(helper.getPushNotificationCount() == 0  && tools.checkNotificationAccessPermisions() ) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_DATA);
                broadcastIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.NO_DATA);
                sendBroadcast(broadcastIntent);
            }else if( (helper.getPushNotificationCount() == 0 && !tools.checkNotificationAccessPermisions())  || (helper.getPushNotificationCount() != 0 && !tools.checkNotificationAccessPermisions())) {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_DATA);
                broadcastIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.NO_PERMISIONS);
                sendBroadcast(broadcastIntent);
            }
        }else if( intent.getStringExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY).equalsIgnoreCase(PushiRecappGlobalServiceCalls.LOAD_MAIN_ACTIVITY) ){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_DATA);
            broadcastIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.LOAD_MAIN_ACTIVITY);
            sendBroadcast(broadcastIntent);
        }
    }
}
