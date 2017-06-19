package com.skywalker.show.view.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.skywalker.show.BasePagerAdapter;
import com.skywalker.show.R;
import com.skywalker.show.view.recyclerview.CardAdapterHelper;
import com.skywalker.show.view.recyclerview.CardScaleHelper;
import com.skywalker.show.view.recyclerview.SpeedRecyclerView;

import java.util.ArrayList;
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
        /*ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragment_bottom2_viewpager);
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
        )));*/
        List<Integer> mList=new ArrayList<>();
        mList.add(R.drawable.a1);
        mList.add(R.drawable.a2);
        mList.add(R.drawable.a3);
        mList.add(R.drawable.a4);
        mList.add(R.drawable.a5);
        mList.add(R.drawable.a6);
        SpeedRecyclerView recyclerView=(SpeedRecyclerView)view.findViewById(R.id.fragment_bottom2_viewpager);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new CardAdapter(mList));
        // mRecyclerView绑定scale效果
        CardScaleHelper mCardScaleHelper=new CardScaleHelper();
        mCardScaleHelper.setCurrentItemPos(2);
        //mCardScaleHelper.attachToRecyclerView(recyclerView);
        SnapHelper mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(recyclerView);

        /*RecyclerView thumbRecyclerView=(RecyclerView)view.findViewById(R.id.thumb_recyclerView);
        ThumbCardAdapter thumbCardAdapter=new ThumbCardAdapter(mList);
        thumbRecyclerView.setAdapter(thumbCardAdapter);
        LinearLayoutManager thumbLinearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        thumbRecyclerView.setLayoutManager(thumbLinearLayoutManager);
        thumbCardAdapter.setOnItemClickLitener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });*/


        return view;
    }


    private class MyPageAdapter extends BasePagerAdapter<Integer> {
        public MyPageAdapter(Context context, List<Integer> list) {
            super(context, list);
        }

        @Override
        protected int getLayoutRes() {
            return R.layout.card_imageview;
        }

        @Override
        protected void onBind(Integer integer, int position) {
            ImageView iv = (ImageView) mItemView.findViewById(R.id.card_imageView);
            iv.setImageResource(integer);
        }
    }

    private class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
        private List<Integer> mList = new ArrayList<>();
        private CardAdapterHelper mCardAdapterHelper = new CardAdapterHelper();

        public CardAdapter(List<Integer> mList) {
            this.mList = mList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_imageview, parent, false);
            mCardAdapterHelper.onCreateViewHolder(parent, itemView);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());
            holder.mImageView.setImageResource(mList.get(position));
            holder.mImageView.setTag(mList.get(position));
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //ToastUtils.show(holder.mImageView.getContext(), "" + position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final ImageView mImageView;

            public ViewHolder(final View itemView) {
                super(itemView);
                mImageView = (ImageView) itemView.findViewById(R.id.card_imageView);

            }

        }

    }


}
