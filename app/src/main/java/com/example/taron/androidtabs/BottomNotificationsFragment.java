package com.example.taron.androidtabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Taron on 05/17/17.
 */

public class BottomNotificationsFragment extends Fragment{

    public static final String TAG = ".androidtabs.BottomNotificationsFragment";

    private static final String KEY_STRING_EXTRA = "str";

    String stringFromMain = "";

    TextView textView;

    public static BottomNotificationsFragment newInstance(String str){
        BottomNotificationsFragment fragment = new BottomNotificationsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_STRING_EXTRA,str);
        fragment.setArguments(bundle);

        return fragment;
    }

    public BottomNotificationsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        stringFromMain = getArguments().getString(KEY_STRING_EXTRA);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_4,container,false);

        textView = (TextView)view.findViewById(R.id.fragment_notification_text_view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView.setText(stringFromMain);
    }
}
