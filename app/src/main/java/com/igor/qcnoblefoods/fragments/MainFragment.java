package com.igor.qcnoblefoods.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.igor.qcnoblefoods.R;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

    private Button mView,mScan,mCheck,mAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainview,container,false);
        mView = view.findViewById(R.id.viewBtn);
        mScan = view.findViewById(R.id.scanBtn);
        mCheck = view.findViewById(R.id.checkBtn);
        mAdd = view.findViewById(R.id.addBtn);

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewFragment viewFragment = new ViewFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,viewFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return view;

    }
}
