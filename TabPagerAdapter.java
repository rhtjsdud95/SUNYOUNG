package com.sunyoung.test2;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SUNYOUNG on 2016-01-22.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return MyFragment1.newInstance(position);
        }
        else if(position == 1) {
            return MyFragment2.newInstance(position);
        }
        else if(position == 2) {
            return MyFragment3.newInstance(position);
        }
        else {
            return MyFragment4.newInstance(position);
        }
        //return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "차량관리";
        else if(position==1)
            return "날씨";
        else if(position==2)
            return "도로교통";
        else
            return "주차";
    }
}