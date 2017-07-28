package com.xiaoyaoprefecture.myrecyclerview.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoyaoprefecture.myrecyclerview.R;
import com.xiaoyaoprefecture.myrecyclerview.ui.adapter.MyAdapter4;
import com.xiaoyaoprefecture.myrecyclerview.ui.bean.Main4Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩一下Grild布局
 */
public class Main4Activity extends AppCompatActivity {
    RecyclerView recyclerview;
    MyAdapter4 adapter;
    List<Main4Bean>list=new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        recyclerview= (RecyclerView) findViewById(R.id.recyclerview);
        mLinearLayout= (LinearLayout) findViewById(R.id.mLinearLayout);
        initData();
        adapter=new MyAdapter4(list,this);
        layoutManager=new GridLayoutManager(this,5);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);
        initViews();
    }

    /**
     * 动态添加子view
     */
    private void initViews() {
        TextView mTv_number;
        TextView mTv_money;
        View view=null;
        for (int i = 0; i <list.size() ; i++) {
            view= LayoutInflater.from(this).inflate(R.layout.item_grideview,null);
            mTv_number= (TextView) view.findViewById(R.id.mTv_number);
            mTv_money= (TextView) view.findViewById(R.id.mTv_money);
            mTv_number.setText(list.get(i).getNumber());
            mTv_money.setText(list.get(i).getMoney());
            mLinearLayout.addView(view);
        }
    }

    /**
     * 初始化数据源
     */
    private void initData() {
        Main4Bean bean=new Main4Bean("0","¥10");
        Main4Bean bean1=new Main4Bean("1","¥10");
        Main4Bean bean2=new Main4Bean("2","¥1");
        Main4Bean bean3=new Main4Bean("3","¥10");
        Main4Bean bean4=new Main4Bean("4","¥1");
        Main4Bean bean5=new Main4Bean("5","¥10");
        Main4Bean bean6=new Main4Bean("6","¥10");
        Main4Bean bean7=new Main4Bean("7","¥1");
        Main4Bean bean8=new Main4Bean("8","¥10");
        Main4Bean bean9=new Main4Bean("9","¥1");
        Main4Bean bean10=new Main4Bean("10","¥10");
        Main4Bean bean11=new Main4Bean("11","¥1");
        Main4Bean bean12=new Main4Bean("12","¥10");
        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        list.add(bean6);
        list.add(bean7);
        list.add(bean8);
        list.add(bean9);
        list.add(bean10);
        list.add(bean11);
        list.add(bean12);
    }
}
