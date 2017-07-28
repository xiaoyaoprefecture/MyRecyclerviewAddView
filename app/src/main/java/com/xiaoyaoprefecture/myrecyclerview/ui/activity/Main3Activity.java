package com.xiaoyaoprefecture.myrecyclerview.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.xiaoyaoprefecture.myrecyclerview.R;
import com.xiaoyaoprefecture.myrecyclerview.ui.adapter.MyAdapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个是玩一下XRecyclerView实现上拉自动加载，下拉刷新
 */
public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "Main3Activity";
    XRecyclerView mRecyclerView;
    MyAdapter3 adapter3;
    List<String>list=new ArrayList<>();
    int page=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mRecyclerView= (XRecyclerView) findViewById(R.id.mRecyclerView);
        initList(page);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter3=new MyAdapter3(list,this);
        mRecyclerView.setAdapter(adapter3);
        View headview= LayoutInflater.from(this).inflate(R.layout.headerview,null);
        mRecyclerView.addHeaderView(headview);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page++;
                Log.e(TAG, "onRefresh: "+page);
                initList(page);
                mRecyclerView.refreshComplete();
                adapter3.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                Log.e(TAG, "onLoadMore: "+page );
                initList(page);
                mRecyclerView.loadMoreComplete();
                adapter3.notifyDataSetChanged();
            }
        });
    }

    /**
     * 初始化list集合数据
     */
    private void initList(int x) {
        for (int i = x*20; i <20*(x+1) ; i++) {
            list.add("中国"+i);
        }
        Log.e(TAG, "initList: "+x );
    }
}
