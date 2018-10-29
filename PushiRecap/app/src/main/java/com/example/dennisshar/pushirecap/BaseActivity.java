package com.example.dennisshar.pushirecap;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.dennisshar.pushirecap.dbhelper.DatabaseHelper;
import com.example.dennisshar.pushirecap.interfaces.DataBaseHelperInterface;

public class BaseActivity extends AppCompatActivity implements DataBaseHelperInterface {

    public static DatabaseHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.splashScreenBg));
        }

        helper = DatabaseHelper.getInstance(getApplicationContext());

    }

    @Override
    public DatabaseHelper getDataBasehelper() {
        return helper;
    }

}
