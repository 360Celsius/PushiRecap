package com.example.dennisshar.pushirecap.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennisshar.pushirecap.R;

public class NoDataFragment extends BaseFragment {

    public final static String TAG = "NoDataFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.no_data_fragmnet, container, false);

        return view;
    }
}
