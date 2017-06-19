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

public class Pager3 extends Fragment {

    private String title;
    private int page;

    public static Pager3 newInstance(int page, String title) {
        Pager3 pager3 = new Pager3();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        pager3.setArguments(args);
        return pager3;
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
        View view=inflater.inflate(R.layout.fragment_part3_3,container,false);
        return view;
    }

}
