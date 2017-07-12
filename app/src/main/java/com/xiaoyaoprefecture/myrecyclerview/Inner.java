package com.xiaoyaoprefecture.myrecyclerview;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/7/12.
 */

public class Inner {
    private Bitmap avatar;
    private String dec;

    public Inner(Bitmap avatar, String dec) {
        this.avatar = avatar;
        this.dec = dec;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}
