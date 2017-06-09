package com.skywalker.show.view;

import android.support.v7.widget.CardView;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/8  
 ********************************/

public interface CardAdapter {

    CardView getCardViewAt(int i);

    float getBaseElevation();

}
