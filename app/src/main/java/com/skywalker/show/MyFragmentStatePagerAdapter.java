package com.skywalker.show;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/8  
 ********************************/

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList=new ArrayList<>();
    public MyFragmentStatePagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public void addFragment(Fragment fragment){
        mList.add(fragment);
    }
}
