package com.example.btl.model;

public class OnTap {
    private String cauhoi, dan_a,dan_b,dan_c,dan_d,dap_an,goi_y;
    private int anh;

    public OnTap(String cauhoi, String dan_a, String dan_b, String dan_c, String dan_d, String dap_an, String goi_y, int anh) {
        this.cauhoi = cauhoi;
        this.dan_a = dan_a;
        this.dan_b = dan_b;
        this.dan_c = dan_c;
        this.dan_d = dan_d;
        this.dap_an = dap_an;
        this.goi_y = goi_y;
        this.anh = anh;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDan_a() {
        return dan_a;
    }

    public void setDan_a(String dan_a) {
        this.dan_a = dan_a;
    }

    public String getDan_b() {
        return dan_b;
    }

    public void setDan_b(String dan_b) {
        this.dan_b = dan_b;
    }

    public String getDan_c() {
        return dan_c;
    }

    public void setDan_c(String dan_c) {
        this.dan_c = dan_c;
    }

    public String getDan_d() {
        return dan_d;
    }

    public void setDan_d(String dan_d) {
        this.dan_d = dan_d;
    }

    public String getDap_an() {
        return dap_an;
    }

    public void setDap_an(String dap_an) {
        this.dap_an = dap_an;
    }

    public String getGoi_y() {
        return goi_y;
    }

    public void setGoi_y(String goi_y) {
        this.goi_y = goi_y;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
