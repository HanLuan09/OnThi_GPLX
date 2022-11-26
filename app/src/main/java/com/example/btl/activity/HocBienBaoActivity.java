package com.example.btl.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.btl.R;
import com.example.btl.viewadapter.BienBaoViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class HocBienBaoActivity extends AppCompatActivity {
    private TabLayout stabLayout;
    private ViewPager sviewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_bien_bao);
        ActionBar actionBarlt = getSupportActionBar();
        actionBarlt.setDisplayHomeAsUpEnabled(true);//trở về
        actionBarlt.setTitle("Biển Báo Giao thông");
        actionBarlt.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.teal_200)));

        stabLayout= findViewById(R.id.tablayouthocbienbao);
        sviewPager= findViewById(R.id.viewpagerhocbienbao);
        BienBaoViewPagerAdapter bienBaoViewPagerAdapter= new BienBaoViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        sviewPager.setAdapter(bienBaoViewPagerAdapter);
        stabLayout.setupWithViewPager(sviewPager);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}