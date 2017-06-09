package com.skywalker.show.view;

import android.support.v4.view.ViewPager;
import android.view.View;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/9  
 ********************************/

public class MyPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if (position<-1){ //[-,-1]
            page.setAlpha(0);
            page.setScaleX(0.5f);
            page.setScaleY(0.5f);
        }else if (position<=0){ //[-1,0]
            page.setAlpha(position+1);
            page.setScaleX(1+position*0.5f);
            page.setScaleY(1+position*0.5f);

        }else if (position<=1){ //[0,1]
            page.setAlpha(1f-position*0.5f);
            page.setScaleX(1f-position*0.5f);
            page.setScaleY(1f-position*0.5f);
        }else {
            page.setAlpha(0);
            page.setScaleX(0.5f);
            page.setScaleY(0.5f);
        }
    }
}
