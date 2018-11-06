package com.example.dennisshar.pushirecap.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.dennisshar.pushirecap.R;

public class PermissionsFragment extends BaseFragment implements View.OnClickListener {

    public final static String TAG = "PermissionsFragment";
    public final static String SCREEN_NAME = "Credits";
    private RelativeLayout notificationAccessButton;
    private RelativeLayout permissionsAccessButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permissions, container, false);

        notificationAccessButton = (RelativeLayout) view.findViewById(R.id.go_to_nottification_access_setting);
        notificationAccessButton.setOnClickListener(this);

        permissionsAccessButton = (RelativeLayout) view.findViewById(R.id.go_to_permissions_setting);
        permissionsAccessButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.go_to_nottification_access_setting:
                intent = new Intent(
                        "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                startActivity(intent);
                break;

            case R.id.go_to_permissions_setting:
                intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
    }
}
