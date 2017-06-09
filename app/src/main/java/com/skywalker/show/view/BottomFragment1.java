package com.skywalker.show.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skywalker.show.Contact;
import com.skywalker.show.R;
import com.skywalker.show.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/8  
 ********************************/

public class BottomFragment1 extends Fragment {
    private String title;
    private int page;

    public static BottomFragment1 newInstance(int page, String title) {
        BottomFragment1 fragment1 = new BottomFragment1();
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

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom1, container, false);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.fragment_recyclerView);
        List<Contact> list=new ArrayList<>();
        for (int i=0;i<20;i++){
            Contact contact=new Contact();
            contact.setName("name "+i);
            contact.setOnline(i % 2 == 0);
        }
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
