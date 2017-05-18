package com.example.taron.androidtabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Taron on 05/18/17.
 */

public class TopSubscribersFragment extends Fragment {

    public static TopSubscribersFragment newInstance() {
        TopSubscribersFragment fragment = new TopSubscribersFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_6,container,false);

        return view;
    }
}
