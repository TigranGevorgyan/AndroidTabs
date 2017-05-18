package com.example.taron.androidtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CallBackInterface {

    TextView newsTab;
    TextView collectionsTab;
    TextView communitiesTab;
    TextView notificationTab;

    TextView textView;

    String sendString = "47";

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsTab = (TextView)findViewById(R.id.activity_main_news_tab_tv);
        collectionsTab = (TextView)findViewById(R.id.activity_main_collections_tab_tv);
        communitiesTab = (TextView)findViewById(R.id.activity_main_communities_tab_tv);
        notificationTab = (TextView)findViewById(R.id.activity_main_notification_tab_tv);

        textView = (TextView)findViewById(R.id.fragment_notification_text_view);

        Fragment fragment = BottomNewsFragment.newInstance();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
//        fragmentTransaction.addToBackStack(BottomNewsFragment.TAG);
        fragmentTransaction.add(R.id.activity_main_container,fragment, BottomNewsFragment.TAG);
        fragmentTransaction.commit();

        fragmentManager = getSupportFragmentManager();

        newsTab.setOnClickListener(this);
        collectionsTab.setOnClickListener(this);
        communitiesTab.setOnClickListener(this);
        notificationTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment1 = null;
        for (Fragment item : fragmentManager.getFragments()){
            if (item.isVisible()){
                fragment1 = item;
                break;
            }
        }
        switch (v.getId()){
            case R.id.activity_main_news_tab_tv:
                if (!(fragment1 instanceof BottomNewsFragment)){
                    fragmentTransaction.hide(fragment1);
                    fragmentTransaction.show(fragmentManager.getFragments().get(0));
                    fragmentTransaction.commit();
                    return;
                }
                Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_main_collections_tab_tv:
                Log.d("manager","fragment 2 size " + fragmentManager.getFragments().size());
                for (Fragment element : fragmentManager.getFragments()){
                    if (element instanceof BottomCollectionsFragment) {
                        if (fragment1 != null) {
                            fragmentTransaction.hide(fragment1);
                        }
                        fragmentTransaction.show(element);
                        fragmentTransaction.commit();
                        return;
                    }
                }
                fragment = BottomCollectionsFragment.newInstance();
                fragmentTransaction.add(R.id.activity_main_container,fragment, BottomCollectionsFragment.TAG);
                fragmentTransaction.hide(fragment1);
                fragmentTransaction.show(fragment);
                fragmentTransaction.commit();
                Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_main_communities_tab_tv:
                Log.d("manager","fragment 3 size " + fragmentManager.getFragments().size());
                for (Fragment element : fragmentManager.getFragments()){
                    if (element instanceof BottomCommunitiesFragment) {
                        if (fragment1 != null) {
                            fragmentTransaction.hide(fragment1);
                        }
                        fragmentTransaction.show(element);
                        fragmentTransaction.commit();
                        return;
                    }
                }
                fragment = BottomCommunitiesFragment.newInstance();
                fragmentTransaction.add(R.id.activity_main_container,fragment, BottomCommunitiesFragment.TAG);
                fragmentTransaction.hide(fragment1);
                fragmentTransaction.show(fragment);
                fragmentTransaction.commit();
                Toast.makeText(this,"3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_main_notification_tab_tv:
                Log.d("manager","fragment 4 size " + fragmentManager.getFragments().size());
                for (Fragment element : fragmentManager.getFragments()){
                    if (element instanceof BottomNotificationsFragment) {
                        if (sendString != null){
                            fragment = BottomNotificationsFragment.newInstance(sendString);
                            fragmentTransaction.add(R.id.activity_main_container,fragment, BottomNotificationsFragment.TAG);
                        }
                        if (fragment1 != null) {
                            fragmentTransaction.hide(fragment1);
                        }
                        if (fragment != null) {
                            fragmentTransaction.show(fragment);
                            fragmentTransaction.commit();
                        }
                        if(fragment == null){
                            fragmentTransaction.show(element);
                            fragmentTransaction.commit();
                        }
                        return;
                    }
                }
                fragment = BottomNotificationsFragment.newInstance(sendString);
                fragmentTransaction.add(R.id.activity_main_container,fragment, BottomNotificationsFragment.TAG);
                fragmentTransaction.hide(fragment1);
                fragmentTransaction.show(fragment);
                fragmentTransaction.commit();
                Toast.makeText(this,"4",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void sendText(String text) {
        for (Fragment item : fragmentManager.getFragments()){
            if (item instanceof BottomNotificationsFragment){
                sendString = text;
                Log.d("jjj"," " + sendString);
//                fragmentTransaction.add(R.id.activity_main_container,BottomNotificationsFragment.
//                        newInstance(sendString),BottomNotificationsFragment.TAG);
//                fragmentTransaction.commit();
                break;
            }
        }
    }
}
