package com.liuguoping.myfriends;

/**
 * Created by liuguoping on 2017/9/26.
 */

import java.util.ArrayList;
import java.util.List;


public class Friends {
    private String name;
    private int imageId;
    private String desc;

    public Friends(String name, int imageId, String desc){
        this.name = name;
        this.imageId = imageId;
        this.desc = desc;
    }

    public static List<Friends> getAllFriends() {
        List<Friends> friends = new ArrayList<Friends>();
        friends.add(new Friends("张三", R.drawable.img_001, "这是张三！"));
        friends.add(new Friends("李四", R.drawable.img_001, "这是李四！"));
        friends.add(new Friends("周五", R.drawable.img_001, "这是周五！"));
        return friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
