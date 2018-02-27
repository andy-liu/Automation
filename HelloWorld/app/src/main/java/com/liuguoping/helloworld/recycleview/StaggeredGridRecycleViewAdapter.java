package com.liuguoping.helloworld.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuguoping.helloworld.R;

/**
 * Created by liuguoping on 2017/11/21.
 */

public class StaggeredGridRecycleViewAdapter extends RecyclerView.Adapter<StaggeredGridRecycleViewAdapter.LinearViewHolder>{
    private Context mContext;
    private OnItemClickListener mListener;
    StaggeredGridRecycleViewAdapter(Context context, OnItemClickListener onItemClickListener){
        this.mContext = context;
        this.mListener = onItemClickListener;
    }
    @Override
    public StaggeredGridRecycleViewAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.staggered_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(StaggeredGridRecycleViewAdapter.LinearViewHolder holder, final int position) {
        if(position % 2 != 0){
//            Glide.with(mContext).load("http://a.hiphotos.baidu.com/image/h%3D300/sign=04d7f38212d8bc3ed90800cab28aa6c8/e7cd7b899e510fb36772312fd233c895d1430c1a.jpg").into(holder.imageView);
            holder.imageView.setImageResource(R.drawable.test_2);
        }else{
            holder.imageView.setImageResource(R.drawable.test_1);
            //Glide.with(mContext).load("http://c.hiphotos.baidu.com/image/h%3D300/sign=a497744e43ed2e73e3e9802cb703a16d/6a63f6246b600c3315a94502134c510fd8f9a12c.jpg").into(holder.imageView);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
