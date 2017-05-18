package com.example.taron.androidtabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Taron on 05/17/17.
 */

public class BottomCollectionsFragment extends Fragment {

    public static final String TAG = ".androidtabs.BottomCollectionsFragment";

    TabLayout tabLayout;
    ViewPager viewPager;

    public static BottomCollectionsFragment newInstance(){
        BottomCollectionsFragment fragment = new BottomCollectionsFragment();

        return fragment;
    }

    public BottomCollectionsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_2,container,false);

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);


        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        viewPager.setAdapter(new MyViewPagerAdapter(getFragmentManager()));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return view;
    }
}
