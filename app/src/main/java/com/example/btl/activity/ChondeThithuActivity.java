package com.example.btl.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.btl.NavigationHomeActivity;
import com.example.btl.R;

public class ChondeThithuActivity extends AppCompatActivity {
    private Button btde1,btde2,btde3,btde4,btde5,btde6,btde7,btde8,btdenn;
    private int kqde, de;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonde_thithu);
        // Xử lý thanh actionBar
        ActionBar actionBarlt = getSupportActionBar();
        actionBarlt.setDisplayHomeAsUpEnabled(true);//trở về
        actionBarlt.setTitle("Thi thử");
        actionBarlt.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.teal_200)));
        //ánh xạ
        btde1 = findViewById(R.id.bttonde1);
        btde2 = findViewById(R.id.bttonde2);
        btde3 = findViewById(R.id.bttonde3);
        btde4 = findViewById(R.id.bttonde4);
        btde5 = findViewById(R.id.bttonde5);
        btde6 = findViewById(R.id.bttonde6);
        btde7 = findViewById(R.id.bttonde7);
        btde8 = findViewById(R.id.bttonde8);
        btdenn = findViewById(R.id.bttonderd);
        ControlerChonde();
        ControlerXulyKetquaTrave();
    }
    // kết quả trả về
    @SuppressLint("ResourceAsColor")
    private void ControlerXulyKetquaTrave() {
        kqde = getIntent().getIntExtra("Ketqua",0);
        de = getIntent().getIntExtra("Ketquade",0);
        if(de==1){
            if(kqde>=21){
                btde1.setBackgroundColor(R.color.green);
            }
            else{
                btde1.setBackgroundColor(R.color.red);
            }
        }
    }
    // chọn đề
    private void ControlerChonde() {
        btde1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                de = 1;
                Intent itde1= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                itde1.putExtra("De",1);
                startActivity(itde1);
            }
        });
        btde2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itde2= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                de=2;
                itde2.putExtra("De",2);
                startActivity(itde2);
            }
        });
        btde3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itde3= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                de=3;
                itde3.putExtra("De",3);
                startActivity(itde3);
            }
        });
        btde4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itde4= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                startActivity(itde4);
            }
        });
        btde5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itde5= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                startActivity(itde5);
            }
        });
        btde6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itde6= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                startActivity(itde6);
            }
        });
        btde7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itde7= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                startActivity(itde7);
            }
        });
        btde8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itde8= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                startActivity(itde8);
            }
        });
        btdenn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itdenn= new Intent(ChondeThithuActivity.this, ThiThuActivity.class);
                startActivity(itdenn);
            }
        });
    }
    // xử lý khi nhấ vào nút mũi tên trở về
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Intent it = new Intent(ChondeThithuActivity.this, NavigationHomeActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}