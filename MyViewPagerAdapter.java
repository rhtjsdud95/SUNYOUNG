package com.sunyoung.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by SUNYOUNG on 2016-01-08.
 */

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = new Fragment[4];

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0] = new Fragment1();
        fragments[1] = new Fragment2();
        fragments[2] = new Fragment3();
        fragments[3] = new Fragment4();
    }

    public Fragment getItem(int arg0) {
        return fragments[arg0];
    }

    public int getCount() {
        return fragments.length;
    }
}



