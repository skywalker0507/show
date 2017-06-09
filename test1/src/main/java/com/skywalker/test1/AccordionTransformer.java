package com.skywalker.test1;

import android.support.v4.view.ViewPager;
import android.view.View;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/9  
 ********************************/

public class AccordionTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        page.setPivotX(position < 0 ? 0 : page.getWidth());
        page.setScaleX(position < 0 ? 1f + position : 1f - position);
    }
}
