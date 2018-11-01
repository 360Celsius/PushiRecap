package com.example.dennisshar.pushirecap.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.dennisshar.pushirecap.interfaces.DataBaseHelperInterface;
import com.example.dennisshar.pushirecap.interfaces.ToolsInterface;
import com.example.dennisshar.pushirecap.tools.Tools;

public class BaseFragment extends Fragment{

    public DataBaseHelperInterface mCallback;
    public static ToolsInterface tools = null;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DataBaseHelperInterface) activity;
        tools = (ToolsInterface) activity;
    }


}
