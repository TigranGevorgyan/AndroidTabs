package com.example.taron.androidtabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Taron on 05/17/17.
 */

public class BottomCommunitiesFragment extends Fragment{

    EditText editText;

    CallBackInterface callBackInterface;

    public static final String TAG = ".androidtabs.BottomCommunitiesFragment";

    public static BottomCommunitiesFragment newInstance(){
        BottomCommunitiesFragment fragment = new BottomCommunitiesFragment();

        return fragment;
    }

    public BottomCommunitiesFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CallBackInterface){
            callBackInterface = (CallBackInterface)context;
        }
        else throw
                new RuntimeException("Must implamant CallBackInterface");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_3,container,false);

        editText = (EditText) view.findViewById(R.id.communities_fragment_edittext);



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("edittext","beforeTextChanged " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext","onTextChanged " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("edittext","afterTextChanged " + s.toString());
                callBackInterface.sendText(s.toString());
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
