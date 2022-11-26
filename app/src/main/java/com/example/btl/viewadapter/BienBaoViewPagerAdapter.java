package com.example.btl.viewadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.btl.fragment.BienBaoCamFragment;
import com.example.btl.fragment.BienCanhBaoFragment;
import com.example.btl.fragment.BienChiDanFragment;
import com.example.btl.fragment.BienHieuLenhFragment;

public class BienBaoViewPagerAdapter extends FragmentStatePagerAdapter {
    public BienBaoViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BienBaoCamFragment();
            case 1:
                return new BienHieuLenhFragment();
            case 2:
                return new BienChiDanFragment();
            case 3:
                return new BienCanhBaoFragment();
            default:
                return new BienBaoCamFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position) {
            case 0:
                title="BIỂN BÁO CẤM";
                break;
            case 1:
                title="BIỂN HIỆU LỆNH";
                break;
            case 2:
                title="BIỂN CHỈ DẪN";
                break;
            case 3:
                title="BIỂN CẢNH BÁO";
                break;
        }
        return title;
    }
}
