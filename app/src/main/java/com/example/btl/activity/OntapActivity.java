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
import com.example.btl.viewadapter.OnTapViewAdapter;
import com.google.android.material.tabs.TabLayout;

public class OntapActivity extends AppCompatActivity {
    private TabLayout mtabLayout;
    private ViewPager mviewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap);
        ActionBar actionBarlt = getSupportActionBar();
        actionBarlt.setDisplayHomeAsUpEnabled(true);//trở về
        actionBarlt.setTitle("Ôn tập");
        actionBarlt.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.teal_200)));

        mtabLayout= findViewById(R.id.tablayoutontap);
        mviewPager= findViewById(R.id.viewpagerontap);
        OnTapViewAdapter onTapViewAdapter= new OnTapViewAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mviewPager.setAdapter(onTapViewAdapter);
        mtabLayout.setupWithViewPager(mviewPager);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}