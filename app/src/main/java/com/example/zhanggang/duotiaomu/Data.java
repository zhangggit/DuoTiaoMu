package com.example.zhanggang.duotiaomu;

/**
 * 类作用：
 * 时  间：2017/8/31 - 21:21.
 * 创建人：张刚
 */

public class Data {

    public String title;
    public String name;
    public String picture;

    public Data(String title, String name, String picture) {
        this.title = title;
        this.name = name;
        this.picture = picture;
    }

    public int type;

    public void setType(int type) {
        this.type = type;
    }
}
