package com.skywalker.bottomnavigation.bottom1.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skywalker.bottomnavigation.R;
import com.skywalker.bottomnavigation.bottom1.Pager1;
import com.skywalker.bottomnavigation.bottom1.Pager2;
import com.skywalker.bottomnavigation.bottom1.Pager3;
import com.skywalker.bottomnavigation.bottom1.PagerAdapter1;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/16  
 ********************************/

public class Fragment1 extends Fragment {

    private String title;
    private int page;

    public static Fragment1 newInstance(int page, String title) {
        Fragment1 fragment1 = new Fragment1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment1.setArguments(args);
        return fragment1;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_bottom_1_with_toolbar,container,false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_bottom_1_with_toolbar_tabLayout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragment_bottom_1_with_toolbar_viewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {

        PagerAdapter1 pagerAdapter3=new PagerAdapter1(getChildFragmentManager());
        pagerAdapter3.addPager(Pager1.newInstance(1,"page 1"),"page 1");
        pagerAdapter3.addPager(Pager2.newInstance(2,"page 2"),"page 2");
        pagerAdapter3.addPager(Pager3.newInstance(3,"page 3"),"page 3");
        viewPager.setAdapter(pagerAdapter3);
    }
}
