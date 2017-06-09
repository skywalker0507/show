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
import com.skywalker.show.view.transformers.FlipHorizontalTransformer;

import java.util.Arrays;
import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/8  
 ********************************/

public class BottomFragment3 extends Fragment {
    private String title;
    private int page;

    public static BottomFragment3 newInstance(int page, String title) {
        BottomFragment3 fragment3 = new BottomFragment3();
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

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom3, container, false);
        ViewPager viewPager=(ViewPager) view.findViewById(R.id.image_viewpager);
        viewPager.setPageTransformer(true, new FlipHorizontalTransformer());
        PagerIndicator pagerIndicator=(PagerIndicator) view.findViewById(R.id.custom_indicator);
        viewPager.setAdapter(new MyAdapter(getContext(), Arrays.asList(
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

        pagerIndicator.setViewPager(viewPager);
        return view;
    }

    private class MyAdapter extends BasePagerAdapter<Integer> {

        public MyAdapter(Context context, List<Integer> dataList) {
            super(context, dataList);
        }

        @Override
        protected int getLayoutRes() {
            return R.layout.item_card;
        }

        @Override
        protected void onBind(Integer res, int position) {
            ImageView iv = (ImageView)mItemView.findViewById(R.id.iv);
            iv.setImageResource(res);
        }
    }
}
