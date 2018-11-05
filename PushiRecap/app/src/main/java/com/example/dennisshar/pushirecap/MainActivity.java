package com.example.dennisshar.pushirecap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dennisshar.pushirecap.interfaces.ButtonViewInterfce;
import com.example.dennisshar.pushirecap.services.PushiRecappGlobalService;
import com.example.dennisshar.pushirecap.services.PushiRecappGlobalServiceCalls;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends BaseActivity implements View.OnClickListener, ButtonViewInterfce{

    private AdView mAdView;
    private ImageView logo;
    private ImageView backButton;
    private ImageView settingsButton;
    private ImageView moreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsButton = (ImageView) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this);
        moreButton = (ImageView) findViewById(R.id.more_button);
        moreButton.setOnClickListener(this);
        logo = (ImageView) findViewById(R.id.action_bar_icon);
        backButton = (ImageView) findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });




        Intent msgIntent = new Intent(getApplicationContext(), PushiRecappGlobalService.class);
        msgIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.GET_PUSH_NOTIFICATIONS_DATA_FROM_SQL_DB);
        startService(msgIntent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.settings_button:
                Intent msgIntent = new Intent(getApplicationContext(), PushiRecappGlobalService.class);
                msgIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.LOAD_SETTINGS_FRGMENTS);
                startService(msgIntent);
                break;

            case R.id.back_button:

                break;
        }
    }

    @Override
    public ImageView getLogo() {
        return logo;
    }

    @Override
    public ImageView getBackBUtton() {
        return backButton;
    }

    @Override
    public ImageView getSettingsBUtton() {
        return settingsButton;
    }

    @Override
    public ImageView getMoreButton() {
        return moreButton;
    }
}
