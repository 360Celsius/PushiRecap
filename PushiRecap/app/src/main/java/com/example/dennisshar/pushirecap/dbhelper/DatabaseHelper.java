package com.example.dennisshar.pushirecap.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dennisshar.pushirecap.datamodels.ExternalPushNotificationsDataModel;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ExternalPushNotifications.db";
    private static DatabaseHelper sInstance;
    private Context context;


    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseHelperContract.ExternalPushNotifications.SQL_CREATE_ENTRIES_EXTERNAL_PUSH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(DataBaseHelperContract.ExternalPushNotifications.SQL_CREATE_ENTRIES_EXTERNAL_PUSH_TABLE);
        }
    }

    ////////////////////////// External Push Notifications //////////////////////////

    public void bulkExternalPushNotification(ExternalPushNotificationsDataModel externalPushNotificationsDataModel){
        try {
            deletexternalPushNotification();
            ContentValues[] ipInfoObjectArr = new ContentValues[1];
            ;
            for (int i = 0; i < ipInfoObjectArr.length; i++) {
                ContentValues values = new ContentValues();
                values.put(DataBaseHelperContract.ExternalPushNotifications.DATABASE_TABLE_PACKAGE_COLUMN, externalPushNotificationsDataModel.getPackageName());
                values.put(DataBaseHelperContract.ExternalPushNotifications.DATABASE_TABLE_TICKER_COLUMN, externalPushNotificationsDataModel.getTicker());
                values.put(DataBaseHelperContract.ExternalPushNotifications.DATABASE_TABLE_TITLE_COLUMN, externalPushNotificationsDataModel.getTitle());
                values.put(DataBaseHelperContract.ExternalPushNotifications.DATABASE_TABLE_TEXT_COLUMN, externalPushNotificationsDataModel.getText());
                ipInfoObjectArr[i] = values;
            }
            context.getContentResolver().bulkInsert(DataBaseHelperContract.ExternalPushNotifications.CONTENT_URI, ipInfoObjectArr);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    private void deletexternalPushNotification(){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DataBaseHelperContract.ExternalPushNotifications.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }
}
