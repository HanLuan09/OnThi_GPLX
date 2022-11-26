package com.example.btl.model;

public class MeoThi {
    private String ten, noidung;

    public MeoThi(String ten, String noidung) {
        this.ten = ten;
        this.noidung = noidung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
