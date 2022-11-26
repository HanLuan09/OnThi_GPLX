package com.example.btl.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.btl.*;
import com.example.btl.data.DBHelperLogin;
import com.google.android.material.textfield.TextInputEditText;
import java.util.regex.Pattern;

public class LogoutActivity extends AppCompatActivity {

    private TextInputEditText username, password, repassword;
    private Button signup;
    private DBHelperLogin DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        ActionBar actionBarlt = getSupportActionBar();
        actionBarlt.setDisplayHomeAsUpEnabled(true);//trở về
        actionBarlt.setTitle("Đăng ký");
        actionBarlt.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.teal_200)));
        Anhxa();
        ControlButton();
    }

    private void Anhxa() {
        username =  findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signup =  findViewById(R.id.btnsignup);
        DB = new DBHelperLogin(this);
    }

    private void ControlButton() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                // dùng Regex để check pass
                Pattern pUper = Pattern.compile("^.*[A-Z]+.*$");
                Pattern pLower = Pattern.compile("^.*[a-z]+.*$");
                Pattern pDigit = Pattern.compile("^.*[0-9]+.*$");
//                Pattern pSpecial = Pattern.compile("^.*[#?!@$%^&*-]+.*$");
                Pattern pLength = Pattern.compile("^.{6,9}$");
                int check = 0;
                if (pLength.matcher(pass).find() && pUper.matcher(pass).find() && pLower.matcher(pass).find() && pDigit.matcher(pass).find()){
                    check=0;
                }
                else{
                    Toast.makeText(LogoutActivity.this, "Mật khẩu phải từ 6 đến 9 ký tự, có đầy đủ chữ cái in hoa, in thường và chữ số", Toast.LENGTH_SHORT).show();
                    check = 1;
                }
                if (check == 0) {
                    if (user.equals("") || pass.equals("") || repass.equals(""))
                        Toast.makeText(LogoutActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    else {
                        if (pass.equals(repass)) {
                            Boolean checkuser = DB.checkusername(user);
                            if (checkuser == false) {
                                Boolean insert = DB.insertData(user, pass);
                                if (insert == true) {
                                    Toast.makeText(LogoutActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(), NavigationHomeActivity.class);
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LogoutActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LogoutActivity.this, "Người dùng đã tồn tại!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LogoutActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}