package com.example.btl.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.btl.R;

public class KetquaActivity extends AppCompatActivity {

    private TextView kqdung,kqsai,ket_qua_tong;
    private Button btok;
    private int True,False;
    private int Tilekqdung, KetquaDe;
    private ProgressBar progressBar;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);
        True=getIntent().getIntExtra("True",0);
        False= getIntent().getIntExtra("False",0);
        KetquaDe = getIntent().getIntExtra("DeX",0);
        Anhxa();
        ControlerXulyKetQua();

    }

    private void Anhxa() {
        kqdung=findViewById(R.id.kqdung);
        kqsai=findViewById(R.id.kqsai);
        progressBar = findViewById(R.id.circularProgressbar);
        textView = findViewById(R.id.tv);
        ket_qua_tong=findViewById(R.id.ket_qua_tong);
        btok = findViewById(R.id.buttonroitrangkq);
    }
    // xử lý kết quả
    private void ControlerXulyKetQua() {
        Tilekqdung = True*4;
        Drawable drawable = getResources().getDrawable(R.drawable.circular);
        progressBar.setMax(25);
        progressBar.setSecondaryProgress(25);
        progressBar.setProgress(True);
        progressBar.setProgressDrawable(drawable);
        textView.setText(Tilekqdung + "%");
        if(True>=21) textView.setTextColor(ContextCompat.getColor(this, R.color.teal_200));
        kqdung.setText(True+"/25");
        kqsai.setText(False+"/25");
        if(True>=21)
            ket_qua_tong.setText("Đề "+KetquaDe+" Đỗ");
        else
            ket_qua_tong.setText("Đề "+KetquaDe+" Trượt");

        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(getApplicationContext(), ChondeThithuActivity.class);
                it.putExtra("Ketqua",True);
                it.putExtra("Ketquade",KetquaDe);
                startActivity(it);
            }
        });
    }
}