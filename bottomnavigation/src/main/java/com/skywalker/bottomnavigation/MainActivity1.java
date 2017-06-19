package com.skywalker.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.skywalker.bottomnavigation.bottom1.Fragment1;
import com.skywalker.bottomnavigation.bottom2.Fragment2;
import com.skywalker.bottomnavigation.bottom3.Fragment3;


/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/15  
 ********************************/

public class MainActivity1 extends AppCompatActivity {

    private Fragment1 mFragment1;
    private Fragment2 mFragment2;
    private Fragment3 mFragment3;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_disable_swipe);
        mFragmentManager=getSupportFragmentManager();
        showFragment(1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:

                        showFragment(1);
                        return true;
                    case R.id.navigation_dashboard:
                        showFragment(2);
                        return true;
                    case R.id.navigation_notifications:

                        showFragment(3);
                        return true;
                }
                return false;
            }
        });
    }


    private void showFragment(int index){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 1:

                if (mFragment1 == null) {
                    mFragment1 = Fragment1.newInstance(1, "main page 1");
                    transaction.add(R.id.fragment, mFragment1);
                } else {
                    transaction.show(mFragment1);
                }
                break;
            case 2:
                if (mFragment2 == null) {
                    mFragment2 = Fragment2.newInstance(2, "main page 2");
                    transaction.add(R.id.fragment, mFragment2);
                } else {
                    transaction.show(mFragment2);
                }
                break;
            case 3:

                if (mFragment3 == null) {
                    mFragment3 = Fragment3.newInstance(3, "main page 3");
                    transaction.add(R.id.fragment, mFragment3);
                } else {
                    transaction.show(mFragment3);
                }
                break;
        }

        transaction.commit();
    }


    private void hideFragments(FragmentTransaction transaction) {
        if (mFragment1 != null) {
            transaction.hide(mFragment1);
        }
        if (mFragment2 != null) {
            transaction.hide(mFragment2);
        }
        if (mFragment3 != null) {
            transaction.hide(mFragment3);
        }

    }
}
