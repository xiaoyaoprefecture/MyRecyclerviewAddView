package com.xiaoyaoprefecture.myrecyclerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 用RecyclerView动态添加item内的view避免嵌套RecyclerView
 */
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Outer> listOut = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_out);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(listOut, this);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 模拟外部RecyclerView的数据源
     */
    private void initList() {
        Outer out1 = new Outer("123456789", "随便玩玩", "我就静静的看着你装逼", initInner(1));
        Outer out2 = new Outer("123456789", "随便玩玩", "我就静静的看着你装逼", initInner(2));
        Outer out3 = new Outer("123456789", "随便玩玩", "我就静静的看着你装逼", initInner(3));
        Outer out4 = new Outer("123456789", "随便玩玩", "我就静静的看着你装逼", initInner(4));
        Outer out5 = new Outer("123456789", "随便玩玩", "我就静静的看着你装逼", initInner(5));
        listOut.add(out1);
        listOut.add(out2);
        listOut.add(out3);
        listOut.add(out4);
        listOut.add(out5);
    }

    /**
     * 模拟内部item的数据源
     * @param x
     * @return
     */
    private List<Inner> initInner(int x) {
        List<Inner> listIn = new ArrayList<>();//全局变量 他的值会一直加在里面
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
        String dec = "我就这么看着你" + x;
        Inner in1 = new Inner(bitmap, dec);
        for (int i = 0; i < x; i++) {
            listIn.add(in1);
        }
        return listIn;
    }
}
