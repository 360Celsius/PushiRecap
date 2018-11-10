package com.example.dennisshar.pushirecap.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.viewpager.ViewPagerAdapter;

public class AllPushNotificationsFragmentHolder extends BaseFragment {

    public final static String TAG = "AllPushNotificationsFragmentHolder";
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_push_viewpager, container, false);


        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));



        return view;
    }

}
