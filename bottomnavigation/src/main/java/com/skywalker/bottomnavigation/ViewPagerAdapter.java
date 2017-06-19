package com.skywalker.bottomnavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/13  
 ********************************/

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    public void addFragment(Fragment fragment){
        if (!mList.contains(fragment)){
            mList.add(fragment);
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
