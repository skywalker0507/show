package com.skywalker.bottomnavigation.bottom3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skywalker.bottomnavigation.CardItem;
import com.skywalker.bottomnavigation.R;
import com.skywalker.bottomnavigation.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/13  
 ********************************/

public class Fragment3 extends Fragment {
    private String title;
    private int page;

    public static Fragment3 newInstance(int page, String title) {
        Fragment3 fragment3 = new Fragment3();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment3.setArguments(args);
        return fragment3;
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
        View view = inflater.inflate(R.layout.fragment_bottom_3, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_bottom_3_recyclerView);

        List<CardItem> mList = new ArrayList<>();
        mList.add(new CardItem("carditem 1", R.drawable.a1));
        mList.add(new CardItem("carditem 2", R.drawable.a2));
        mList.add(new CardItem("carditem 3", R.drawable.a3));
        mList.add(new CardItem("carditem 4", R.drawable.a4));
        mList.add(new CardItem("carditem 5", R.drawable.a5));
        mList.add(new CardItem("carditem 6", R.drawable.a6));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
