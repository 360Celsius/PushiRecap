package com.example.dennisshar.pushirecap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;
import com.example.dennisshar.pushirecap.interfaces.DataBaseHelperInterface;

public class BaseActivity extends AppCompatActivity implements DataBaseHelperInterface {

    public static DatabaseHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        helper = DatabaseHelper.getInstance(getApplicationContext());

    }

    @Override
    public DatabaseHelper getDataBasehelper() {
        return helper;
    }

}
