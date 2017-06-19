package com.skywalker.bottomnavigation.bottom1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/15  
 ********************************/

public class PagerAdapter1 extends FragmentStatePagerAdapter {

    private List<Fragment> mList=new ArrayList<>();
    private List<String> mTitles=new ArrayList<>();

    public PagerAdapter1(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    public void addPager(Fragment fragment,String title){
        mList.add(fragment);
        mTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
