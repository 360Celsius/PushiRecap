package com.example.dennisshar.pushirecap.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dennisshar.pushirecap.fragments.AllPushNotificationsFragment;
import com.example.dennisshar.pushirecap.fragments.AllPushNotificationsFragmentCategorized;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new AllPushNotificationsFragment(); //ChildFragment1 at position 0
            case 1:
                return new AllPushNotificationsFragmentCategorized(); //ChildFragment2 at position 1

        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 2;
    }
}
