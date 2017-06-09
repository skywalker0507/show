package com.skywalker.show.view.transformers;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

import com.skywalker.show.view.CardAdapter;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/8  
 ********************************/

public class ShadowTransformer implements ViewPager.PageTransformer {
    private ViewPager mViewPager;
    private CardAdapter mCardAdapter;

    public ShadowTransformer(ViewPager viewPager,CardAdapter cardAdapter){
        this.mViewPager=viewPager;
        this.mCardAdapter=cardAdapter;
    }

    //停止滑动
    public void enableScaling(boolean enable){
        CardView cardView=mCardAdapter.getCardViewAt(mViewPager.getCurrentItem());
        if (cardView!=null){
            if (enable){
                cardView.animate().scaleX(1);
                cardView.animate().scaleX(1);
            }else {
                cardView.animate().scaleX(1.1f);
                cardView.animate().scaleX(1.1f);
            }
        }

    }
    @Override
    public void transformPage(View page, float position) {
    }
}
