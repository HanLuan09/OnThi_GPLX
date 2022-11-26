package com.example.btl.viewadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.*;
import com.example.btl.fragment.*;

public class OnTapViewAdapter extends FragmentStatePagerAdapter {
    public OnTapViewAdapter(@NonNull FragmentManager fm,int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VideoThuchhanhFragment();
            case 1:
                return new LuatGiaoThongFragment();
            case 2:
                return new LythuyetBienbaoFragment();
            case 3:
                return new SaHinhFragment();
            default:
                return new VideoThuchhanhFragment();
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
                title="Thực hành";
                break;
            case 1:
                title="Luật GT";
                break;
            case 2:
                title="Biển báo";
                break;
            case 3:
                title="Sa hình";
                break;
        }
        return title;
    }
}
