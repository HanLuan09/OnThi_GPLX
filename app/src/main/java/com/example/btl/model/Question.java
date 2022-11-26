package com.example.btl.model;

import java.io.Serializable;

public class Question implements Serializable {
    private String name, cau_a, cau_b, cau_c,cau_d,answer;
    private int chon=0;
    private int img;

    public Question(String name, String cau_a, String cau_b, String cau_c, String cau_d, String answer,int img) {
        this.name = name;
        this.cau_a = cau_a;
        this.cau_b = cau_b;
        this.cau_c = cau_c;
        this.cau_d = cau_d;
        this.answer=answer;
        this.img =img;
    }

    public String getName() {
        return name;
    }

    public String getCau_a() {
        return cau_a;
    }

    public String getCau_b() {
        return cau_b;
    }

    public String getCau_c() {
        return cau_c;
    }

    public String getCau_d() {
        return cau_d;
    }

    public String getAnswer(){return  answer;}

    public void setChon(int chon) {
        this.chon = chon;
    }

    public int getChon() {
        return chon;
    }

    public int getImg() {
        return img;
    }
}
