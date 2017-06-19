package com.skywalker.bottomnavigation.bottom1;

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
 * data: 2017/6/15  
 ********************************/

public class Pager2 extends Fragment {

    private String title;
    private int page;

    public static Pager2 newInstance(int page, String title) {
        Pager2 pager2 = new Pager2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        pager2.setArguments(args);
        return pager2;
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
        View view=inflater.inflate(R.layout.fragment_part3_2,container,false);
        return view;
    }

}
