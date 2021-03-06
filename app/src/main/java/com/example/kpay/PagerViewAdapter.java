package com.example.kpay;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class PagerViewAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmenTitle = new ArrayList<>();

    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }




    @Override
    public Fragment getItem(int position) {
        return  fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmenTitle.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmenTitle.get(position);
    }

    public  void addFragment(Fragment fragment,String title){

        fragmenTitle.add(title);
        fragmentList.add(fragment);

    }

}
