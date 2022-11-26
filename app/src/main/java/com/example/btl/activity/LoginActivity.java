package com.example.btl.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.example.btl.NavigationHomeActivity;
import com.example.btl.data.DBHelperLogin;
import com.example.btl.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText username, password;
    private TextView quenMk;
    private Button btnlogin,signin;
    private DBHelperLogin DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBarlt = getSupportActionBar();
        actionBarlt.setDisplayHomeAsUpEnabled(true);//trở về
        actionBarlt.setTitle("Đăng nhập");
        actionBarlt.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.teal_200)));
        Anhxa();
        ControlButton();
    }

    private void Anhxa() {
        username =  findViewById(R.id.username1);
        password =  findViewById(R.id.password1);
        quenMk = findViewById(R.id.tvquenmkhau);
        btnlogin =  findViewById(R.id.btnsignin1);
        signin =  findViewById(R.id.btnsignin);
        DB = new DBHelperLogin(this);
    }
    private void ControlButton() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), NavigationHomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Thông tin không hợp lệ!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogoutActivity.class);
                startActivity(intent);
            }
        });
        quenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Chức năng đang phát triển!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}