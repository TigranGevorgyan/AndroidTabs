package com.example.taron.androidtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Taron on 05/18/17.
 */

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return TopAdviceFragment.newInstance();
            case 1:
                return TopSubscribersFragment.newInstance();
            case 2:
                return TopYourCollectionsFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
