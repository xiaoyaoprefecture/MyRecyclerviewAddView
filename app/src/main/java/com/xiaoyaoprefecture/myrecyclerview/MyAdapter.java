package com.xiaoyaoprefecture.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final String TAG = "MyAdapter";
    List<Outer> list;
    Context mContext;

    public MyAdapter(List<Outer> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = null;
        if (null == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_out, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //首先实现动态添加view
        Outer outer = list.get(i);
        List<Inner> inners = outer.getList();
        viewHolder.mLinearLayout.removeAllViews();
        initView(inners, viewHolder.mLinearLayout);
        //然后再初始化其它的数据源
        viewHolder.mTv_orderNumber.setText(outer.getOrdernumber());
        viewHolder.mTv_left.setText(outer.getLeft());//这里还是没有值的
        viewHolder.mTv_right.setText(outer.getRight());

    }

    /**
     * 动态添加内部的view条数
     * @param inners
     * @param mLinearLayout
     * @return
     */
    private View initView(List<Inner> inners, LinearLayout mLinearLayout) {
        ImageView img;
        TextView mTv_text;
        View view2 = null;
        for (int i = 0; i < inners.size(); i++) {
            view2 = LayoutInflater.from(mContext).inflate(R.layout.item_inner, null);
            img = (ImageView) view2.findViewById(R.id.mImg);
            mTv_text = (TextView) view2.findViewById(R.id.mTv_text);
            img.setImageBitmap(inners.get(i).getAvatar());
            mTv_text.setText(inners.get(i).getDec());
            mLinearLayout.addView(view2);
        }
        return mLinearLayout;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTv_orderNumber, mTv_left, mTv_right;
        LinearLayout mLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv_orderNumber = (TextView) itemView.findViewById(R.id.mTv_orderNumber);
            mTv_left = (TextView) itemView.findViewById(R.id.mTv_left);
            mTv_right = (TextView) itemView.findViewById(R.id.mTv_right);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.mLinearLayout);
        }
    }
}
