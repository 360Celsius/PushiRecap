package com.example.dennisshar.pushirecap.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.dennisshar.pushirecap.R;
import com.example.dennisshar.pushirecap.services.PushiRecappGlobalService;
import com.example.dennisshar.pushirecap.services.PushiRecappGlobalServiceCalls;

public class NoPermissiomsGrantedFragment extends BaseFragment implements View.OnClickListener{

    public final static String TAG = "NoPermissiomsGrantedFragment";

    private RelativeLayout goToPermisionsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_permissions_granted, container, false);

        goToPermisionsButton = (RelativeLayout) view.findViewById(R.id.go_to_permisions_button);
        goToPermisionsButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.go_to_permisions_button:
                Intent msgIntent = new Intent(getContext(), PushiRecappGlobalService.class);
                msgIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.LOAD_PERMISIONS_FRAGMENT);
                getContext().startService(msgIntent);
                break;
        }
    }
}
