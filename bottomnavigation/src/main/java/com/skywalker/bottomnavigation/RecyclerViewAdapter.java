package com.skywalker.bottomnavigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/13  
 ********************************/

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context mContext;
    private List<CardItem> mList;
    public RecyclerViewAdapter(Context context, List<CardItem> list){
        this.mContext=context;
        this.mList=list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.carditem,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardItem item=mList.get(position);
        holder.mImageView.setImageResource(item.getImageResource());
        holder.mTextView.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;

        public MyViewHolder(View view){
            super(view);
            mImageView=(ImageView) view.findViewById(R.id.carditem_imageView);
            mTextView=(TextView) view.findViewById(R.id.carditem_textView);
        }
    }
}
