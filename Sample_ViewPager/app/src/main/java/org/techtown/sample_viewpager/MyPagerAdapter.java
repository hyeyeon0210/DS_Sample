package org.techtown.sample_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs; //tab의 갯수

    public MyPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentA tab1 = new FragmentA();
                return tab1;
            case 1:
                FragmentB tab2 = new FragmentB();
                return tab2;
            case 2:
                FragmentC tab3 = new FragmentC();
                return tab3;
            case 3:
                FragmentD tab4 = new FragmentD();
                return tab4;
            case 4:
                FragmentE tab5 = new FragmentE();
                return tab5;
            default:
                return null;
        }
        //return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
