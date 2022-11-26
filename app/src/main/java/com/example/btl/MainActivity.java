package com.example.btl;

import androidx.appcompat.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.btl.activity.*;


public class MainActivity extends AppCompatActivity {
    private Button btdangnhap,btthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
    }

    private void ControlButton() {
        //Button huy dang nhap
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có muốn thoát khỏi ứng dụng");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();//thoat app
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();// show hop thoai
            }
        });

//        // Button dang nhap tai khoan
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        btdangnhap=findViewById(R.id.buttondangnhapungdung);
        btthoat= findViewById(R.id.buttonthoatungdung);
    }
}