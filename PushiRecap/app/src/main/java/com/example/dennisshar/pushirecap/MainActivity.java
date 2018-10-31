package com.example.dennisshar.pushirecap;

import android.content.Intent;
import android.os.Bundle;

import com.example.dennisshar.pushirecap.services.IncomingPushNotificationInsertPullFromDBService;
import com.example.dennisshar.pushirecap.services.IncomingPushNotificationInsertPullFromDBServiceCalls;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent msgIntent = new Intent(getApplicationContext(), IncomingPushNotificationInsertPullFromDBService.class);
        msgIntent.putExtra(IncomingPushNotificationInsertPullFromDBServiceCalls.DATA_TYPE_KEY, IncomingPushNotificationInsertPullFromDBServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB);
        startService(msgIntent);
    }
}
