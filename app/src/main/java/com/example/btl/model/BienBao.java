package com.example.btl.model;

public class BienBao {
    private String ten, noidung;
    private int hinh;

    public BienBao(String ten, String noidung, int hinh) {
        this.ten = ten;
        this.noidung = noidung;
        this.hinh = hinh;
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

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
