package com.example.dennisshar.pushirecap.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.dennisshar.pushirecap.R;

public class NoPermissiomsGrantedFragment extends BaseFragment implements View.OnClickListener{

    public final static String TAG = "NoPermissiomsGrantedFragment";

    private RelativeLayout goToPermisionsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.no_permissions_granted_fragment, container, false);

        goToPermisionsButton = (RelativeLayout) view.findViewById(R.id.go_to_permisions_button);
        goToPermisionsButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.go_to_permisions_button:
                Log.e("TEST","go_to_permisions_button");
                break;
        }
    }
}
