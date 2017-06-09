package com.skywalker.show.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.skywalker.show.BasePagerAdapter;
import com.skywalker.show.R;

import java.util.Arrays;
import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/8  
 ********************************/

public class BottomFragment2 extends Fragment {
    private String title;
    private int page;

    public static BottomFragment2 newInstance(int page, String title) {
        BottomFragment2 bottomFragment2 = new BottomFragment2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        bottomFragment2.setArguments(args);
        return bottomFragment2;
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
        final View view = inflater.inflate(R.layout.fragment_bottom2, container, false);
        ViewPager viewPager=(ViewPager) view.findViewById(R.id.fragment_bottom2_viewpager);
        viewPager.setPageTransformer(true, new MyPageTransformer1());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(40);

        viewPager.setAdapter(new MyPageAdapter(getContext(), Arrays.asList(
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9
        )));
        return view;
    }


    private class MyPageAdapter extends BasePagerAdapter<Integer>{
        public MyPageAdapter(Context context, List<Integer> list){
            super(context,list);
        }

        @Override
        protected int getLayoutRes() {
            return R.layout.card_imageview;
        }

        @Override
        protected void onBind(Integer integer, int position) {
            ImageView iv = (ImageView)mItemView.findViewById(R.id.card_imageView);
            iv.setImageResource(integer);
        }
    }
}
