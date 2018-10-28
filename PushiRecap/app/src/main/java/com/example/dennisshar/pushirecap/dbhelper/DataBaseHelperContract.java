package com.example.dennisshar.pushirecap.dbhelper;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.Locale;

public class DataBaseHelperContract {

    public static final String packageName = "com.example.dennisshar.pushirecap";
    public static final String AUTHORITY = packageName + ".provider";
    public static final String CONTENT_BASE = "content://"+AUTHORITY+"/%s";


    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DataBaseHelperContract() {
    }

    ////////////////////////// External Push Notifications //////////////////////////

    public static class ExternalPushNotifications implements BaseColumns {

        public static final String URI_SUFFIX = "external_push_notifications";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "external_push_notifications";

        public static final String DATABASE_TABLE_PACKAGE_COLUMN = "package";
        public static final String DATABASE_TABLE_TICKER_COLUMN = "ticker";
        public static final String DATABASE_TABLE_TITLE_COLUMN = "title";
        public static final String DATABASE_TABLE_TEXT_COLUMN = "text";


        public static final String SQL_CREATE_ENTRIES_EXTERNAL_PUSH_TABLE =
                "CREATE TABLE " + ExternalPushNotifications.TABLE_NAME + " (" +
                        ExternalPushNotifications._ID + " INTEGER PRIMARY KEY," +
                        ExternalPushNotifications.DATABASE_TABLE_PACKAGE_COLUMN + " TEXT," +
                        ExternalPushNotifications.DATABASE_TABLE_TICKER_COLUMN + " TEXT," +
                        ExternalPushNotifications.DATABASE_TABLE_TITLE_COLUMN + " TEXT," +
                        ExternalPushNotifications.DATABASE_TABLE_TEXT_COLUMN + " TEXT)";


        public static final String SQL_DELETE_EXTERNAL_PUSH_TABLE =
                "DROP TABLE IF EXISTS " + ExternalPushNotifications.TABLE_NAME;

        public static final String SQL_SELECT_EXTERNAL_PUSH_TABLE =
                "SELECT  * FROM " + ExternalPushNotifications.TABLE_NAME + " WHERE "+ ExternalPushNotifications._ID;

    }
}
