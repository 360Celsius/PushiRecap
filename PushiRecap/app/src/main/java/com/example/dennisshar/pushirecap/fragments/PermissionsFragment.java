package com.example.dennisshar.pushirecap.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennisshar.pushirecap.R;

public class PermissionsFragment extends BaseFragment {

    public final static String TAG = "PermissionsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permissions, container, false);

        return view;
    }
}
