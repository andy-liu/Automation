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

public class GridRecycleViewAdapter extends RecyclerView.Adapter<GridRecycleViewAdapter.LinearViewHolder>{
    private Context mContext;
    private OnItemClickListener mListener;
    GridRecycleViewAdapter(Context context, OnItemClickListener onItemClickListener){
        this.mContext = context;
        this.mListener = onItemClickListener;
    }
    @Override
    public GridRecycleViewAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.grid_recycle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(GridRecycleViewAdapter.LinearViewHolder holder, final int position) {
        Glide.with(mContext).load("http://h.hiphotos.baidu.com/image/pic/item/b812c8fcc3cec3fdeb2739bfdf88d43f869427da.jpg").into(holder.imageView);
        holder.textView.setText("小清晰");
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
        private TextView textView;
        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            textView = itemView.findViewById(R.id.tv);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
