package com.liuguoping.myfriends;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liuguoping on 2017/9/27.
 */

public class FriendsAdapter extends ArrayAdapter<Friends>{
    public FriendsAdapter(Context context, int resource, List<Friends> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 获取老师的数据
        final Friends friend = getItem(position);

        // 创建布局
        View oneFriendView = LayoutInflater.from(getContext()).inflate(R.layout.friends_item,
                parent, false);

        // 获取ImageView和TextView
        ImageView imageView = (ImageView) oneFriendView.findViewById(R.id.friends_small_imageView);
        TextView textView = (TextView) oneFriendView.findViewById(R.id.friends_name_textView);

        // 根据老师数据设置ImageView和TextView的展现
        imageView.setImageResource(friend.getImageId());
        textView.setText(friend.getName());

        oneFriendView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  初始化一个准备跳转到TeacherDetailActivity的Intent
                Intent intent = new Intent(getContext(), FriendDetailActivity.class);

                // 往Intent中传入Teacher相关的数据，供TeacherDetailActivity使用
                intent.putExtra("friend_image", friend.getImageId());
                intent.putExtra("friend_desc", friend.getDesc());

                getContext().startActivity(intent);
            }
        });
        return oneFriendView;
    }
}
