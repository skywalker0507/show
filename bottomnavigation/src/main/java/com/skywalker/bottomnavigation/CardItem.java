package com.skywalker.bottomnavigation;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/6/13  
 ********************************/

public class CardItem {

    private int imageResource;
    private String name;

    public CardItem(String name,int imageResource){
        this.name=name;
        this.imageResource=imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
