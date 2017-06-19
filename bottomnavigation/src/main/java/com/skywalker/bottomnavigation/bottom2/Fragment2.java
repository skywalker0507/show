package com.skywalker.bottomnavigation.bottom2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skywalker.bottomnavigation.R;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/13  
 ********************************/

public class Fragment2 extends Fragment {

    private String title;
    private int page;

    public static Fragment2 newInstance(int page, String title) {
        Fragment2 fragment2 = new Fragment2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment2.setArguments(args);
        return fragment2;
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
        View view=inflater.inflate(R.layout.fragment_bottom_2,container,false);
        return view;
    }
}
