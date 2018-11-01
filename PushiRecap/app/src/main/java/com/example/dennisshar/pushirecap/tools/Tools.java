package com.example.dennisshar.pushirecap.tools;

import android.content.Context;

import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

    private static Tools sInstance;
    private Context context;

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    public static synchronized Tools getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new Tools(context.getApplicationContext());
        }
        return sInstance;
    }

    public Tools(Context context) {
        this.context = context;
    }
}
