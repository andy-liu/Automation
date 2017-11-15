package com.liuguoping.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuguoping.helloworld.R;

/**
 * Created by liuguoping on 2017/11/14.
 */

public class MyGridAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    MyGridAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder = null;
    if(convertView == null){
        convertView = mLayoutInflater.inflate(R.layout.grid_item, null);
        viewHolder = new ViewHolder();
        viewHolder.imageView = convertView.findViewById(R.id.im_1);
        viewHolder.textView = convertView.findViewById(R.id.tx_1);
        convertView.setTag(viewHolder);
    }else {
        viewHolder = (ViewHolder) convertView.getTag();
    }
        viewHolder.textView.setText("张敏");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510663124936&di=56835eddd9cd0e5414cc136a7b8b2e5c&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2F74e87f9ba37bc7f9e283baae6ea7d3047973cb9a.jpg").into(viewHolder.imageView);
        return convertView;
    }
}
