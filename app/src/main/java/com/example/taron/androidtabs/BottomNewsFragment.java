package com.example.taron.androidtabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Taron on 05/17/17.
 */

public class BottomNewsFragment extends Fragment {

    public static final String TAG = ".androidtabs.BottomNewsFragment";

    public static BottomNewsFragment newInstance(){
        BottomNewsFragment fragment = new BottomNewsFragment();

        return fragment;
    }

    public BottomNewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_1,container,false);

        return view;
    }

}
