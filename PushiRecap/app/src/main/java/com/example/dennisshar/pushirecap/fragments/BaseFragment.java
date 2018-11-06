package com.example.dennisshar.pushirecap.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.interfaces.ButtonViewInterfce;
import com.example.dennisshar.pushirecap.interfaces.DataBaseHelperInterface;
import com.example.dennisshar.pushirecap.interfaces.ToolsInterface;
import com.example.dennisshar.pushirecap.tools.Tools;

public class BaseFragment extends Fragment{

    public DataBaseHelperInterface mCallback = null;
    public static ToolsInterface tools = null;
    public ButtonViewInterfce buttonViewInterfce = null;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DataBaseHelperInterface) activity;
        tools = (ToolsInterface) activity;
        buttonViewInterfce = (ButtonViewInterfce) activity;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getFragmentManager().findFragmentByTag(AllPushNotificationsFragment.TAG)!=null){
            buttonViewInterfce.getLogo().setVisibility(View.VISIBLE);
            buttonViewInterfce.getBackBUtton().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getSettingsBUtton().setVisibility(View.VISIBLE);
            buttonViewInterfce.getMoreButton().setVisibility(View.VISIBLE);

            buttonViewInterfce.getScreenName().setVisibility(View.INVISIBLE);
        }else if(getFragmentManager().findFragmentByTag(InfoAndCreditsFragment.TAG)!=null){
            buttonViewInterfce.getLogo().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getBackBUtton().setVisibility(View.VISIBLE);
            buttonViewInterfce.getSettingsBUtton().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getMoreButton().setVisibility(View.INVISIBLE);

            buttonViewInterfce.getScreenName().setVisibility(View.VISIBLE);
            buttonViewInterfce.getScreenName().setText(getResources().getString(R.string.credits_screen_name));
        }else if(getFragmentManager().findFragmentByTag(NoDataFragment.TAG)!=null){
            buttonViewInterfce.getLogo().setVisibility(View.VISIBLE);
            buttonViewInterfce.getBackBUtton().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getSettingsBUtton().setVisibility(View.VISIBLE);
            buttonViewInterfce.getMoreButton().setVisibility(View.VISIBLE);

            buttonViewInterfce.getScreenName().setVisibility(View.INVISIBLE);
        }else if(getFragmentManager().findFragmentByTag(NoPermissiomsGrantedFragment.TAG)!=null){
            buttonViewInterfce.getLogo().setVisibility(View.VISIBLE);
            buttonViewInterfce.getBackBUtton().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getSettingsBUtton().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getMoreButton().setVisibility(View.INVISIBLE);

            buttonViewInterfce.getScreenName().setVisibility(View.INVISIBLE);
        }else if(getFragmentManager().findFragmentByTag(PermissionsFragment.TAG)!=null){
            buttonViewInterfce.getLogo().setVisibility(View.INVISIBLE);;
            buttonViewInterfce.getBackBUtton().setVisibility(View.VISIBLE);;
            buttonViewInterfce.getSettingsBUtton().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getMoreButton().setVisibility(View.INVISIBLE);

            buttonViewInterfce.getScreenName().setVisibility(View.VISIBLE);
            buttonViewInterfce.getScreenName().setText(getResources().getString(R.string.permisions_screen_name));
        }else if(getFragmentManager().findFragmentByTag(SettingsFragment.TAG)!=null){
            buttonViewInterfce.getLogo().setVisibility(View.INVISIBLE);;
            buttonViewInterfce.getBackBUtton().setVisibility(View.VISIBLE);;
            buttonViewInterfce.getSettingsBUtton().setVisibility(View.INVISIBLE);
            buttonViewInterfce.getMoreButton().setVisibility(View.INVISIBLE);

            buttonViewInterfce.getScreenName().setVisibility(View.VISIBLE);
            buttonViewInterfce.getScreenName().setText(getResources().getString(R.string.setting_screen_name));
        }


    }
}
