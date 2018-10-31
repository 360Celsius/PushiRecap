package com.example.dennisshar.pushirecap.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.dennisshar.pushirecap.interfaces.DataBaseHelperInterface;

public class BaseFragment extends Fragment {

    public DataBaseHelperInterface mCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DataBaseHelperInterface) activity;
    }

}
