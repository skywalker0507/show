package com.skywalker.show.view.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.skywalker.show.R;

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
        RecyclerView thumbRecyclerView=(RecyclerView)view.findViewById(R.id.fragment_bottom1_recyclerView);
        final ImageView imageView=(ImageView) view.findViewById(R.id.fragment_bottom1_imageView);
        List<Integer> mList=new ArrayList<>();
        mList.add(R.drawable.a1);
        mList.add(R.drawable.a2);
        mList.add(R.drawable.a3);
        mList.add(R.drawable.a4);
        mList.add(R.drawable.a5);
        mList.add(R.drawable.a6);
        ThumbCardAdapter thumbCardAdapter=new ThumbCardAdapter(mList);
        thumbRecyclerView.setAdapter(thumbCardAdapter);
        LinearLayoutManager thumbLinearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        thumbRecyclerView.setLayoutManager(thumbLinearLayoutManager);
        thumbCardAdapter.setOnItemClickLitener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int res=(int)(view.getTag());
                imageView.setImageResource(res);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        return view;
    }

    private class ThumbCardAdapter extends RecyclerView.Adapter<ThumbCardAdapter.ViewHolder> {
        private List<Integer> mList = new ArrayList<>();


        private OnItemClickListener mOnItemClickListener;

        public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener)
        {
            this.mOnItemClickListener = mOnItemClickLitener;
        }

        public ThumbCardAdapter(List<Integer> mList) {
            this.mList = mList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_thumb, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mImageView.setImageResource(mList.get(position));
            holder.mImageView.setTag(mList.get(position));
            if (mOnItemClickListener!=null){

            }
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(view,pos);
                }
            });

            holder.mImageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(v,pos);
                    return false;
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
                mImageView = (ImageView) itemView.findViewById(R.id.imageView_thumb);
            }

        }

    }

    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }
}
