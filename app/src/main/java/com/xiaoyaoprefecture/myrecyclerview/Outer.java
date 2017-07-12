package com.xiaoyaoprefecture.myrecyclerview;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Outer {
    private String ordernumber;
    private String left;
    private String right;
    private List<Inner>list;

    public Outer(String ordernumber, String left, String right, List<Inner> list) {
        this.ordernumber = ordernumber;
        this.left = left;
        this.right = right;
        this.list = list;
    }

    public List<Inner> getList() {
        return list;
    }

    public void setList(List<Inner> list) {
        this.list = list;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
