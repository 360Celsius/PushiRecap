package com.example.dennisshar.pushirecap;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.dennisshar.pushirecap.services.PushiRecappGlobalService;
import com.example.dennisshar.pushirecap.services.PushiRecappGlobalServiceCalls;
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
                Intent msgIntent = new Intent(getApplicationContext(), PushiRecappGlobalService.class);
                msgIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.LOAD_MAIN_ACTIVITY);
                startService(msgIntent);


            }
        }, 3000);   //3 seconds


    }

    @Override
    protected void onPause() {
        super.onPause();
        splashActivityLoadingView.hide();
    }
}
