package com.example.dennisshar.pushirecap;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashActivity extends BaseActivity {

    private AVLoadingIndicatorView splashActivityLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashActivityLoadingView = (AVLoadingIndicatorView) findViewById(R.id.splash_activity_avi);
        splashActivityLoadingView.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intentone = new Intent(getApplicationContext(), MainActivity.class);
                intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentone);
            }
        }, 5000);   //5 seconds


    }

    @Override
    protected void onPause() {
        super.onPause();
        splashActivityLoadingView.hide();
    }
}
