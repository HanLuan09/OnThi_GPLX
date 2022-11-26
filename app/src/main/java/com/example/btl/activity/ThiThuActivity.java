package com.example.btl.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.*;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.example.btl.NavigationHomeActivity;
import com.example.btl.R;
import com.example.btl.model.Question;
import com.example.btl.viewadapter.ViewQuestionAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.*;

public class ThiThuActivity extends AppCompatActivity {
    private TextView tvBack, tvCurren, tvTotal, tvNext, tvSubmit;
    private ImageButton imBtchon;
    private ViewPager viewPager;
    private TextView textViewCountDown;
    private List<Question> listQuestion;
    private List<Question> listSH;
    private List<Question> listBB;
    private List<Question> listLGT;
    private List<Question> listDe1;
    private int de;//xem là đề bao nhiêu
    //xu ly dap an
    Question question;
    int countTrue=0;
    int countFalse=0;
    int index=0;
    int checkcau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_thu);
        // Xử lý thanh actionBar
        ActionBar actionBarlt = getSupportActionBar();
        actionBarlt.setDisplayHomeAsUpEnabled(true);//trở về
        actionBarlt.setTitle("Thi thử");
        actionBarlt.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.teal_200)));
        //ánh xạ
        Anhxa();
        listQuestion = getListQuestion();
        question = listQuestion.get(index);
        //truyền listquestion vào ViewQuestionAdapter
        ViewQuestionAdapter adapter = new ViewQuestionAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,listQuestion);
        viewPager.setAdapter(adapter);
        tvCurren.setText("1");
        tvTotal.setText(String.valueOf(listQuestion.size()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // ẩn hiện các nút
            @Override
            public void onPageSelected(int position) {
                tvCurren.setText(String.valueOf(position+1));
                if(position ==0){
                    tvBack.setVisibility(View.GONE);
                    tvNext.setVisibility(View.VISIBLE);
                    tvSubmit.setVisibility(View.GONE);
                }
                else if(position ==listQuestion.size()-1){
                    tvBack.setVisibility(View.VISIBLE);
                    tvNext.setVisibility(View.GONE);
                    tvSubmit.setVisibility(View.VISIBLE);
                }
                else{
                    tvBack.setVisibility(View.VISIBLE);
                    tvNext.setVisibility(View.VISIBLE);
                    tvSubmit.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // xử lý khi nhấn nút về trang trước
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                question = listQuestion.get(index);
                checkcau=question.getChon();
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });
        // xử lý khi ấn nút sang trang tiếp
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                question = listQuestion.get(index);
                checkcau=question.getChon();
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
        ControlTexView();
        ControlButtonSheet();
        demGio();
    }
    // xử lý khi nhấ vào nút mũi tên trở về
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    // ánh xạ id
    private void Anhxa() {
        tvBack = findViewById(R.id.tvback);
        tvCurren = findViewById(R.id.tv1);
        tvTotal = findViewById(R.id.tv2);
        tvNext = findViewById(R.id.tvNext);
        tvSubmit = findViewById(R.id.tvsubmit);
        imBtchon = findViewById(R.id.imBtchon);
        viewPager = findViewById(R.id.viewPe);
        textViewCountDown = findViewById(R.id.text_view_countdown);
    }
    // bộ đến thời gian
    private void demGio() {
        new CountDownTimer(1200000, 1000) {
            //1200000
            @SuppressLint("ResourceAsColor")
            public void onTick(long millisUntilFinished) {
                long tich = millisUntilFinished / 1000;
                long minutes = tich / 60;
                long seconds = tich - minutes * 60;
                String secondsString = Long.toString(seconds);
                if (seconds <= 9) {
                    secondsString = "0" + secondsString;
                }
//                if(minutes*60 + seconds <= 300) textViewCountDown.setTextColor(red);
                textViewCountDown.setText(String.valueOf(minutes) + ":" + secondsString);
            }
            // xử lý sự kiện hết giờ
            public void onFinish() {
                AlertDialog.Builder builder=new AlertDialog.Builder(ThiThuActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("  Hết giờ!");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setPositiveButton("Nôp bài", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent it = new Intent(ThiThuActivity.this, KetquaActivity.class);
                        it.putExtra("True",countTrue);
                        it.putExtra("False",countFalse);
                        it.putExtra("DeX",de);
                        startActivity(it);
                    }
                });
                builder.show();
            }
        }.start();
    }
    // xử lý sự kiện nộp bài
    private void ControlTexView() {
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countFalse+countTrue ==25) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ThiThuActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có muốn nộp bài!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//                        ket qua
                            Intent it = new Intent(ThiThuActivity.this, KetquaActivity.class);
                            it.putExtra("True", countTrue);
                            it.putExtra("False", countFalse);
                            it.putExtra("DeX",de);
                            startActivity(it);
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();// show hop thoai
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(ThiThuActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn chưa hoàn thành xong bài thi!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Vẫn nộp", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//                        thoát thi thử
                            Intent it = new Intent(ThiThuActivity.this, KetquaActivity.class);
                            it.putExtra("True", countTrue);
                            it.putExtra("False", countFalse);
                            it.putExtra("DeX",de);
                            startActivity(it);
                        }
                    });
                    builder.setNegativeButton("Làm tiếp", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();// show hop thoai
                }
            }
        });
    }
    // ánh xạ vào list question để hiển thị câu hỏi
    @NonNull
    private List<Question> getListQuestion(){
        CauhoiLuatGT();
        CauhoiBienbao();
        CauhoiSahinh();
        List<Question> list = new ArrayList<>();
        de = getIntent().getIntExtra("De",0);
        if(de == 1){
            CauhoiDe1();
            for(int i=0;i<listDe1.size();i++){
                Question question1 = listDe1.get(i);
                list.add(new Question("Câu hỏi "+(i+1)+": "+question1.getName(),question1.getCau_a(),question1.getCau_b(),question1.getCau_c(),question1.getCau_d(),question1.getAnswer(),question1.getImg()));
            }
        }
        else if(de==2){
            for(int i=1;i<=14;i++){
                Question question = listLGT.get(i+14);
                list.add(new Question("Câu hỏi "+i+": "+question.getName(),question.getCau_a(),question.getCau_b(),question.getCau_c(),question.getCau_d(),question.getAnswer(),question.getImg()));
            }
            for(int i=15;i<=20;i++){
                Question question = listBB.get(i-14);
                list.add(new Question("Câu hỏi "+i+": "+question.getName(),question.getCau_a(),question.getCau_b(),question.getCau_c(),question.getCau_d(),question.getAnswer(),question.getImg()));
            }
            for(int i=21;i<=25;i++){
                Question question = listSH.get(i+3);
                list.add(new Question("Câu hỏi "+i+": "+question.getName(),question.getCau_a(),question.getCau_b(),question.getCau_c(),question.getCau_d(),question.getAnswer(),question.getImg()));
            }
        }
        else if(de==3){
            for(int i=1;i<=14;i++){
                Question question = listLGT.get(i+20);
                list.add(new Question("Câu hỏi "+i+": "+question.getName(),question.getCau_a(),question.getCau_b(),question.getCau_c(),question.getCau_d(),question.getAnswer(),question.getImg()));
            }
            for(int i=15;i<=20;i++){
                Question question = listBB.get(i+14);
                list.add(new Question("Câu hỏi "+i+": "+question.getName(),question.getCau_a(),question.getCau_b(),question.getCau_c(),question.getCau_d(),question.getAnswer(),question.getImg()));
            }
            for(int i=21;i<=25;i++){
                Question question = listSH.get(i-14);
                list.add(new Question("Câu hỏi "+i+": "+question.getName(),question.getCau_a(),question.getCau_b(),question.getCau_c(),question.getCau_d(),question.getAnswer(),question.getImg()));
            }
        }
        else {
            Collections.shuffle(listBB);
            Collections.shuffle(listSH);
            Collections.shuffle(listLGT);
            for (int i = 1; i <= 14; i++) {
                Question question = listLGT.get(i);
                list.add(new Question("Câu hỏi " + i + ": " + question.getName(), question.getCau_a(), question.getCau_b(), question.getCau_c(), question.getCau_d(), question.getAnswer(), question.getImg()));
            }
            for (int i = 15; i <= 20; i++) {
                Question question = listBB.get(i);
                list.add(new Question("Câu hỏi " + i + ": " + question.getName(), question.getCau_a(), question.getCau_b(), question.getCau_c(), question.getCau_d(), question.getAnswer(), question.getImg()));
            }
            for (int i = 21; i <= 25; i++) {
                Question question = listSH.get(i);
                list.add(new Question("Câu hỏi " + i + ": " + question.getName(), question.getCau_a(), question.getCau_b(), question.getCau_c(), question.getCau_d(), question.getAnswer(), question.getImg()));
            }
        }
        return list;
    }
    // xử lý sự kiện chọn đáp án
    public void ClickA(View view){
        if(question.getCau_a().equals(question.getAnswer())){
            if(checkcau==-1){
                countFalse--;
            }
            countTrue++;
            checkcau=1;
            question.setChon(checkcau);
        }
        else{
            if(checkcau==0){
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
            if(checkcau==1){
                countTrue--;
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
        }
    }
    public void ClickB(View view){
        if(question.getCau_b().equals(question.getAnswer())){
            if(checkcau==-1){
                countFalse--;
            }
            countTrue++;
            checkcau=1;
            question.setChon(checkcau);
        }
        else{
            if(checkcau==0){
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
            if(checkcau==1){
                countTrue--;
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
        }
    }
    public void ClickC(View view){
        if(question.getCau_c().equals(question.getAnswer())){
            if(checkcau==-1){
                countFalse--;
            }
            countTrue++;
            checkcau=1;
            question.setChon(checkcau);
        }
        else{
            if(checkcau==0){
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
            if(checkcau==1){
                countTrue--;
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
        }
    }
    public void ClickD(View view){
        if(question.getCau_d().equals(question.getAnswer())){
            if(checkcau==-1){
                countFalse--;
            }
            countTrue++;
            checkcau=1;
            question.setChon(checkcau);
        }
        else{
            if(checkcau==0){
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
            if(checkcau==1){
                countTrue--;
                countFalse++;
                checkcau=-1;
                question.setChon(checkcau);
            }
        }
    }
    // sử lý sự kiện mở trang button sheet dialog hiển thị list button 25 câu
    private void ControlButtonSheet() {
        imBtchon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                View viewBtSheet = getLayoutInflater().inflate(R.layout.button_sheet_choncau,null);
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ThiThuActivity.this);
                bottomSheetDialog.setContentView(viewBtSheet);
                bottomSheetDialog.show();
                bottomSheetDialog.setCancelable(false);
                ImageButton imBtthoat = viewBtSheet.findViewById(R.id.imBtthoat);
                ArrayList<Button> bt = new ArrayList<>();
                //ánh xạ button 25 câu cho vào list Button để xử lý sự kiện
                Button btcau1 = viewBtSheet.findViewById(R.id.btcau1); bt.add(btcau1);
                Button btcau2 = viewBtSheet.findViewById(R.id.btcau2); bt.add(btcau2);
                Button btcau3 = viewBtSheet.findViewById(R.id.btcau3); bt.add(btcau3);
                Button btcau4 = viewBtSheet.findViewById(R.id.btcau4); bt.add(btcau4);
                Button btcau5 = viewBtSheet.findViewById(R.id.btcau5); bt.add(btcau5);
                Button btcau6 = viewBtSheet.findViewById(R.id.btcau6); bt.add(btcau6);
                Button btcau7 = viewBtSheet.findViewById(R.id.btcau7); bt.add(btcau7);
                Button btcau8 = viewBtSheet.findViewById(R.id.btcau8); bt.add(btcau8);
                Button btcau9 = viewBtSheet.findViewById(R.id.btcau9); bt.add(btcau9);
                Button btcau10 = viewBtSheet.findViewById(R.id.btcau10); bt.add(btcau10);
                Button btcau11 = viewBtSheet.findViewById(R.id.btcau11); bt.add(btcau11);
                Button btcau12 = viewBtSheet.findViewById(R.id.btcau12); bt.add(btcau12);
                Button btcau13 = viewBtSheet.findViewById(R.id.btcau13); bt.add(btcau13);
                Button btcau14 = viewBtSheet.findViewById(R.id.btcau14); bt.add(btcau14);
                Button btcau15 = viewBtSheet.findViewById(R.id.btcau15); bt.add(btcau15);
                Button btcau16 = viewBtSheet.findViewById(R.id.btcau16); bt.add(btcau16);
                Button btcau17 = viewBtSheet.findViewById(R.id.btcau17); bt.add(btcau17);
                Button btcau18 = viewBtSheet.findViewById(R.id.btcau18); bt.add(btcau18);
                Button btcau19 = viewBtSheet.findViewById(R.id.btcau19); bt.add(btcau19);
                Button btcau20 = viewBtSheet.findViewById(R.id.btcau20); bt.add(btcau20);
                Button btcau21 = viewBtSheet.findViewById(R.id.btcau21); bt.add(btcau21);
                Button btcau22 = viewBtSheet.findViewById(R.id.btcau22); bt.add(btcau22);
                Button btcau23 = viewBtSheet.findViewById(R.id.btcau23); bt.add(btcau23);
                Button btcau24 = viewBtSheet.findViewById(R.id.btcau24); bt.add(btcau24);
                Button btcau25 = viewBtSheet.findViewById(R.id.btcau25); bt.add(btcau25);
                //đóng cửa sổ Button sheet Dialog
                imBtthoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                // xử lý sự kiện khi nhấn vào câu thứ x trong 25 câu hỏi của Button sheet Dialog
                for(int i=0;i<bt.size();i++){
                    question = listQuestion.get(i);
                    checkcau=question.getChon();
                    if(checkcau !=0)
                        bt.get(i).setTextColor(R.color.red);
                }
                for(int i=0;i<bt.size();i++){
                    int finalI = i;
                    bt.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index = finalI;
                            question = listQuestion.get(index);
                            checkcau=question.getChon();
                            viewPager.setCurrentItem(finalI);
                            bottomSheetDialog.dismiss();
                        }
                    });
                }
            }

        });
    }
    //Add dữ liệu cho sự kiện làm đề thi thử
    private void CauhoiDe1(){
        listDe1 = new ArrayList<>();
        listDe1.add(new Question("“Làn đường” là gì?",
                "1. Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.",
                "2. Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.",
                "3. Là đường cho xe ô tô chạy, dừng, đỗ an toàn.",
                null,
                "2. Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.",
                0));
        listDe1.add(new Question("Tại nơi đường bộ giao nhau cùng mức với đường sắt chỉ có đèn tín hiệu hoặc chuông báo hiệu, khi đèn tín hiệu màu đỏ đã bật sáng hoặc có tiếng chuông báo hiệu, người tham gia giao thông phải dừng lại ngay và giữ khoảng cách tối thiểu bao nhiêu mét tính từ ray gần nhất?",
                "1. 5 mét.",
                "2. 3 mét.",
                "3. 4 mét.",
                null,
                "1. 5 mét.",
                0));
        listDe1.add(new Question("Phương tiện tham gia giao thông đường bộ” gồm những loại nào?",
                "1. Phương tiện giao thông cơ giới đường bộ.",
                "2. Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listDe1.add(new Question("Cuộc đua xe chỉ được thực hiện khi nào",
                "1. Diễn ra trên đường phố không có người qua lại.",
                "2. Được người dân ủng hộ.",
                "3. Được cơ quan có thẩm quyền cấp phép.",
                null,
                "3. Được cơ quan có thẩm quyền cấp phép.",
                0));
        listDe1.add(new Question("Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?",
                "1. Bị nghiêm cấm.",
                "2. Không bị nghiêm cấm.",
                "3. Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.",
                null,
                "1. Bị nghiêm cấm.",
                0));
        listDe1.add(new Question("Khi điều khiển xe mô tô quay đầu người lái xe cần thực hiện như thế nào để đảm bảo an toàn?",
                "1. Bật tín hiệu báo rẽ trước khi quay đầu, từ từ giảm tốc độ đến mức có thể dừng lại.",
                "2. Chỉ quay đầu xe ở những nơi được phép quay đầu.",
                "3. Quan sát an toàn các phương tiện tới từ phía trước, phía sau, hai bên đồng thời nhường đường cho xe từ bên phải và phía trước đi tới.",
                "4. Tất cả các ý nêu trên.",
                "4. Tất cả các ý nêu trên.",
                0));
        listDe1.add(new Question("Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây?",
                "1. Để điều khiển xe chạy về phía trước.",
                "2. Để điều tiết công suất động cơ qua đó điều khiển tốc độ của xe.",
                "3. Để điều khiển xe chạy lùi.",
                "4. Cả ý 1 và ý 2.",
                "4. Cả ý 1 và ý 2.",
                0));
        listDe1.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe con (A), mô tô, xe con (B), xe đạp.",
                "2. Xe con (B), xe đạp, mô tô, xe con (A).",
                "3. Xe con (A), xe con (B), mô tô  + xe đạp.",
                "4. Mô tô + xe đạp, xe con (A), xe con (B).",
                "4. Mô tô + xe đạp, xe con (A), xe con (B).",
                R.raw.biencau179));
        listDe1.add(new Question("Xe nào được quyền đi trước trong trường hợp này?",
                "1. Mô tô.",
                "2. Xe con.",
                null,
                null,
                "1. Mô tô.",
                R.raw.biencau180));
        listDe1.add(new Question("Gương chiếu hậu của xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây?",
                "1. Để quan sát an toàn phía bên trái khi chuẩn bị rẽ trái.",
                "2. Để quan sát an toàn phía bên phải khi chuẩn bị rẽ phải.",
                "3. Để quan sát an toàn phía sau cả bên trái và bên phải trước khi chuyển hướng.",
                "4. Để quan sát an toàn phía trước cả bên trái và bên phải trước khi chuyển hướng.",
                "3. Để quan sát an toàn phía sau cả bên trái và bên phải trước khi chuyển hướng.",
                0));
        listDe1.add(new Question("Để đảm bảo an toàn khi tham gia giao thông, người lái xe mô tô hai bánh cần điều khiển tay ga như thế nào trong các trường hợp dưới đây?",
                "1. Tăng ga thật nhanh, giảm ga từ từ.",
                "2. Tăng ga thật nhanh, giảm ga thật nhanh.",
                "3. Tăng ga từ từ, giảm ga thật nhanh.",
                "4. Tăng ga từ từ, giảm ga từ từ.",
                "3. Tăng ga từ từ, giảm ga thật nhanh.",
                0));
        listDe1.add(new Question("Kỹ thuật cơ bản để giữ thăng bằng khi điều khiển xe mô tô đi trên đường gồ ghề như thế nào trong các trường hợp dưới đây?",
                "1. Đứng thẳng trên giá gác chân lái sau đó hơi gập đầu gối và khuỷu tay, đi chậm để không nẩy quá mạnh.",
                "2. Ngồi lùi lại phía sau, tăng ga vượt nhanh qua đoạn đường xóc.",
                "3. Ngồi lệch sang bên trái hoặc bên phải để lấy thăng bằng qua đoạn đường gồ ghề.",
                null,
                "1. Đứng thẳng trên giá gác chân lái sau đó hơi gập đầu gối và khuỷu tay, đi chậm để không nẩy quá mạnh.",
                0));
        listDe1.add(new Question("Người đủ bao nhiêu tuổi trở lên thì được điều khiển xe mô tô hai bánh, xe mô tô ba bánh có dung tích xi lanh từ 50 cm3 trở lên và các loại xe có kết cấu tương tự; xe ô tô tải, máy kéo có trọng tải dưới 3,5 tấn; xe ô tô chở người đến 9 chỗ ngồi?",
                "1. 16 tuổi.",
                "2. 18 tuổi.",
                "3. 17 tuổi.",
                null,
                "2. 18 tuổi.",
                0));
        listDe1.add(new Question("Biển nào dưới đây xe gắn máy được phép đi vào?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển",
                null,
                "3. Cả hai biển",
                R.raw.biencau101));
        listDe1.add(new Question("Biển nào cấm quay đầu xe?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Không biển nào.",
                "4. Cả hai biển.",
                "2. Biển 2.",
                R.raw.biencau104));
        listDe1.add(new Question("Xe nào vi phạm quy tắc giao thông?",
                "1. Xe khách.",
                "2. Mô tô.",
                "3. Xe con.",
                "4. Xe con và mô tô.",
                "3. Xe con.",
                R.raw.biencau181));
        listDe1.add(new Question("Các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Các xe ở phía tay phải và tay trái của người điều khiển được phép đi thẳng.",
                "2. Cho phép các xe ở mọi hướng được rẽ phải.",
                "3. Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.",
                null,
                "3. Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.",
                R.raw.biencau182));
        listDe1.add(new Question("Biển nào báo hiệu đường sắt giao nhau với đường bộ không có rào chắn?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "3. Biển 2 và 3.",
                R.raw.biencau130));
        listDe1.add(new Question("Người lái xe sử dụng đèn như thế nào khi lái xe trong khu đô thị và đông dân cư vào ban đêm?",
                "1. Bất cứ đèn nào miễn là mắt nhìn rõ phía trước.",
                "2. Chỉ bật đèn chiếu xa (đèn pha) khi không nhìn rõ đường.",
                "3. Đèn chiếu xa (đèn pha) khi đường vắng, đèn pha chiếu gần (đèn cốt) khi có xe đi ngược chiều.",
                "4. Đèn chiếu gần (đèn cốt).",
                "4. Đèn chiếu gần (đèn cốt).",
                0));
        listDe1.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe tải, xe khách, xe con, mô tô.",
                "2. Xe tải, mô tô, xe khách, xe con.",
                "3. Xe khách, xe tải, xe con, mô tô.",
                "4. Mô tô, xe khách, xe tải, xe con.",
                "2. Xe tải, mô tô, xe khách, xe con.",
                R.raw.biencau166));
        listDe1.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe tải, xe con, mô tô.",
                "2. Xe con, xe tải, mô tô.",
                "3. Mô tô, xe con, xe tải.",
                "4. Xe con, mô tô, xe tải.",
                "3. Mô tô, xe con, xe tải.",
                R.raw.biencau167));
        listDe1.add(new Question("Trường hợp này xe nào được quyền đi trước?",
                "1. Mô tô.",
                "2. Xe con.",
                null,
                null,
                "2. Xe con.",
                R.raw.biencau168));
        listDe1.add(new Question("Chiều dài đoạn đường 500 m từ nơi đặt biển này, người lái xe có được phép bấm còi không?",
                "1. Được phép.",
                "2. Không được phép.",
                null,
                null,
                "2. Không được phép.",
                R.raw.biencau119));
        listDe1.add(new Question("Sử dụng rượu, bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào?",
                "1. Chỉ bị nhắc nhở.",
                "2. Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
                "3. Không bị xử lý hình sự.",
                null,
                "2. Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
                0));
        listDe1.add(new Question("Biển nào xe mô tô hai bánh được đi vào?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                null,
                "2. Biển 1 và 3.",
                R.raw.biencau120));

    }
    private void CauhoiLuatGT() {
        listLGT = new ArrayList<>();
        listLGT.add(new Question("Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?",
                "1.Phần mặt đường và lề đường.",
                "2. Phần đường xe chạy.",
                "3. Phần đường xe cơ giới.",
                null,
                "3. Phần đường xe cơ giới.",
                0));
        listLGT.add(new Question("“Làn đường” là gì?",
                "1. Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.",
                "2. Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.",
                "3. Là đường cho xe ô tô chạy, dừng, đỗ an toàn.",
                null,
                "2. Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.",
                0));
        listLGT.add(new Question("Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?",
                "1. Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.",
                "2. Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.",
                "3. Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.",
                null,
                "3. Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.",
                0));
        listLGT.add(new Question("“Dải phân cách” trên đường bộ gồm những loại nào?",
                "1. Dải phân cách gồm loại cố định và loại di động.",
                "2. Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.",
                "3. Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.",
                null,
                "1. Dải phân cách gồm loại cố định và loại di động.",
                0));
        listLGT.add(new Question("Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?",
                "1. Là người điều khiển xe cơ giới.",
                "2. Là người điều khiển xe thô sơ.",
                "3. Là người điều khiển xe có súc vật kéo.",
                null,
                "1. Là người điều khiển xe cơ giới.",
                0));
        listLGT.add(new Question("Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ các hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?",
                "1. Đường không ưu tiên",
                "2. Đường tỉnh lộ.",
                "3. Đường quốc lộ.",
                "4. Đường ưu tiên.",
                "4. Đường ưu tiên.",
                0));
        listLGT.add(new Question("Khái niệm “phương tiện giao thông cơ giới đường bộ” được hiểu như thế nào là đúng?",
                "1. Gồm xe ô tô; máy kéo; xe mô tô hai bánh; xe mô tô ba bánh; xe gắn máy; xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.",
                "2. Gồm ô tô; máy kéo; rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo; xe mô tô hai bánh; xe mô tô ba bánh, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự.",
                null,
                null,
                "2. Gồm ô tô; máy kéo; rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo; xe mô tô hai bánh; xe mô tô ba bánh, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự.",
                0));
        listLGT.add(new Question("Khái niệm “phương tiện giao thông thô sơ đường bộ” được hiểu như thế nào là đúng?",
                "1. Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe xích lô, xe lăn dùng cho người khuyết tật, xe súc vật kéo và các loại xe tương tự.",
                "2. Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe gắn máy, xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.",
                "3. Gồm xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo.",
                null,
                "1. Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe xích lô, xe lăn dùng cho người khuyết tật, xe súc vật kéo và các loại xe tương tự.",
                0));
        listLGT.add(new Question("“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?",
                "1. Phương tiện giao thông cơ giới đường bộ.",
                "2. Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("“Người tham gia giao thông đường bộ” gồm những đối tượng nào?",
                "1. Người điều khiển, người sử dụng phương tiện tham gia giao thông đường bộ.",
                "2. Người điều khiển, dẫn dắt súc vật; người đi bộ trên đường bộ.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("“Người điều khiển phương tiện tham gia giao thông đường bộ” gồm những đối tượng nào dưới đây?",
                "1. Người điều khiển xe cơ giới, người điều khiển xe thô sơ.",
                "2. Người điều khiển xe máy chuyên dùng tham gia giao thông đường bộ.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question(" Khái niệm “người điều khiển giao thông” được hiểu như thế nào là đúng?",
                "1. Là người điều khiển phương tiện tham gia giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                "2. Là cảnh sát giao thông, người được giao nhiệm vụ hướng dẫn giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                "3. Là người tham gia giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                null,
                "2. Là cảnh sát giao thông, người được giao nhiệm vụ hướng dẫn giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.",
                0));
        listLGT.add(new Question("Trong các khái niệm dưới đây khái niệm “dừng xe” được hiểu như thế nào là đúng?",
                "1. Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian để cho người lên, xuống phương tiện, xếp dỡ hàng hóa hoặc thực hiện công việc khác.",
                "2. Là trạng thái đứng yên tạm thời của phương tiện giao thông trong một khoảng thời gian cần thiết đủ để cho người lên, xuống phương tiện, xếp dỡ hàng hóa hoặc thực hiện công việc khác.",
                "3. Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian giữa 02 lần vận chuyển hàng hóa hoặc hành khách.",
                null,
                "2. Là trạng thái đứng yên tạm thời của phương tiện giao thông trong một khoảng thời gian cần thiết đủ để cho người lên, xuống phương tiện, xếp dỡ hàng hóa hoặc thực hiện công việc khác.",
                0));
        listLGT.add(new Question("Khái niệm “đỗ xe” được hiểu như thế nào là đúng?",
                "1. Là trạng thái đứng yên của phương tiện giao thông có thời hạn trong một khoảng thời gian cần thiết đủ để cho người lên, xuống phương tiện, xếp dỡ hàng hóa hoặc thực hiện công việc khác.",
                "2. Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian.",
                null,
                null,
                "2. Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian.",
                0));
        listLGT.add(new Question("Cuộc đua xe chỉ được thực hiện khi nào",
                "1. Diễn ra trên đường phố không có người qua lại.",
                "2. Được người dân ủng hộ.",
                "3. Được cơ quan có thẩm quyền cấp phép.",
                null,
                "3. Được cơ quan có thẩm quyền cấp phép",
                0));
        listLGT.add(new Question("Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?",
                "1. Bị nghiêm cấm.",
                "2. Không bị nghiêm cấm.",
                "3. Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.",
                null,
                "1. Bị nghiêm cấm.",
                0));
        listLGT.add(new Question("Sử dụng rượu, bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào?",
                "1. Chỉ bị nhắc nhở.",
                "2. Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
                "3. Không bị xử lý hình sự.",
                null,
                "2. Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.",
                0));
        listLGT.add(new Question("Theo luật phòng chống tác hại của rượu, bia, đối tượng nào dưới đây bị cấm sử dụng rượu, bia khi tham gia giao thông?",
                "1. Người điều khiển: Xe ô tô, xe mô tô, xe đạp, xe gắn máy.",
                "2. Người ngồi phía sau người điều khiển xe cơ giới.",
                "3. Người đi bộ.",
                "4. Cả ý 1 và ý 2.",
                "1. Người điều khiển: Xe ô tô, xe mô tô, xe đạp, xe gắn máy.",
                0));
        listLGT.add(new Question("Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không?",
                "1. Bị nghiêm cấm tùy trường hợp.",
                "2. Không bị nghiêm cấm.",
                "3. Bị nghiêm cấm.",
                null,
                "3. Bị nghiêm cấm.",
                0));
        listLGT.add(new Question("Khi lái xe trong khu đô thị và đông dân cư trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi như thế nào trong các trường hợp dưới đây?",
                "1. Từ 22 giờ đêm đến 5 giờ sáng.",
                "2. Từ 5 giờ sáng đến 22 giờ tối.",
                "3. Từ 23 giờ đêm đến 5 giờ sáng hôm sau.",
                null,
                "2. Từ 5 giờ sáng đến 22 giờ tối.",
                0));
        listLGT.add(new Question("Người lái xe sử dụng đèn như thế nào khi lái xe trong khu đô thị và đông dân cư vào ban đêm?",
                "1. Bất cứ đèn nào miễn là mắt nhìn rõ phía trước.",
                "2. Chỉ bật đèn chiếu xa (đèn pha) khi không nhìn rõ đường.",
                "3. Đèn chiếu xa (đèn pha) khi đường vắng, đèn pha chiếu gần (đèn cốt) khi có xe đi ngược chiều.",
                "4. Đèn chiếu gần (đèn cốt).",
                "4. Đèn chiếu gần (đèn cốt).",
                0));
        listLGT.add(new Question("Trong trường hợp đặc biệt, để được lắp đặt, sử dụng còi, đèn không đúng với thiết kế của nhà sản xuất đối với từng loại xe cơ giới bạn phải đảm bảo yêu cầu nào dưới đây?",
                "1. Phải đảm bảo phụ tùng do đúng nhà sản xuất đó cung cấp.",
                "2. Phải được chấp thuận của cơ quan có thẩm quyền.",
                "3. Phải là xe đăng ký và hoạt động tại các khu vực có địa hình phức tạp.",
                null,
                "2. Phải được chấp thuận của cơ quan có thẩm quyền.",
                0));
        listLGT.add(new Question("Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt có được quay đầu xe hay không?",
                "1. Được phép.",
                "2. Không được phép.",
                "3. Tùy từng trường hợp.",
                null,
                "2. Không được phép.",
                0));
        listLGT.add(new Question("Bạn đang lái xe phía trước có một xe cảnh sát giao thông không phát tín hiệu ưu tiên bạn có được phép vượt hay không?",
                "1. Không được vượt.",
                "2. Được vượt khi đang đi trên cầu.",
                "3. Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.",
                "4. Được vượt khi đảm bảo an toàn.",
                "4. Được vượt khi đảm bảo an toàn.",
                0));
        listLGT.add(new Question("Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?",
                "1. Không được vượt.",
                "2. Được vượt khi đang đi trên cầu.",
                "3. Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.",
                "4. Được vượt khi đảm bảo an toàn.",
                "1. Không được vượt.",
                0));
        listLGT.add(new Question("Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không?",
                "1. Được phép.",
                "2. Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình.",
                "3. Tùy trường hợp.",
                "4. Không được phép.",
                "4. Không được phép.",
                0));
        listLGT.add(new Question("Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép hay không?",
                "1. Được phép.",
                "2. Tùy trường hợp.",
                "3. Không được phép.",
                null,
                "3. Không được phép.",
                0));
        listLGT.add(new Question("Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi nào không được phép?",
                "1. Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy.",
                "2. Buông một tay; sử dụng xe để chở người hoặc hàng hóa; để chân chạm xuống đất khi khởi hành.",
                "3. Đội mũ bảo hiểm; chạy xe đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ.",
                null,
                "1. Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy.",
                0));
        listLGT.add(new Question("Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không?",
                "1. Được mang, vác tùy trường hợp cụ thể.",
                "2. Không được mang, vác.",
                "3. Được mang, vác nhưng phải đảm bảo an toàn.",
                "4. Được mang, vác tùy theo sức khỏe của bản thân.",
                "2. Không được mang, vác.",
                0));
        listLGT.add(new Question("Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được bám, kéo hoặc đẩy các phương tiện khác không?",
                "1. Được phép.",
                "2. Được bám trong trường hợp phương tiện của mình bị hỏng.",
                "3. Được kéo, đẩy trong trường hợp phương tiện khác bị hỏng.",
                "4. Không được phép.",
                "4. Không được phép.",
                0));
        listLGT.add(new Question("Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được sử dụng ô khi trời mưa hay không?",
                "1. Được sử dụng.",
                "2. Chỉ người ngồi sau được sử dụng.",
                "3. Không được sử dụng.",
                "4. Được sử dụng nếu không có áo mưa.",
                "3. Không được sử dụng.",
                0));
        listLGT.add(new Question("Khi đang lên dốc người ngồi trên xe mô tô có được kéo theo người đang điều khiển xe đạp hay không?",
                "1. Chỉ được phép nếu cả hai đội mũ bảo hiểm.",
                "2. Không được phép.",
                "3. Chỉ được thực hiện trên đường thật vắng.",
                "4. Chỉ được phép khi người đi xe đạp đã quá mệt.",
                "2. Không được phép.",
                0));
        listLGT.add(new Question("Hành vi sử dụng xe mô tô để kéo, đẩy xe mô tô khác bị hết xăng đến trạm mua xăng có được phép hay không?",
                "1. Chỉ được kéo nếu đã nhìn thấy trạm xăng.",
                "2. Chỉ được thực hiện trên đường vắng phương tiện cùng tham gia giao thông.",
                "3. Không được phép.",
                null,
                "3. Không được phép.",
                0));
        listLGT.add(new Question("Hành vi vận chuyển đồ vật cồng kềnh bằng xe mô tô, xe gắn máy khi tham gia giao thông có được phép hay không?",
                "1. Không được vận chuyển.",
                "2. Chỉ được vận chuyển khi đã chằng buộc cẩn thận.",
                "3. Chỉ được vận chuyển vật cồng kềnh trên xe máy nếu khoảng cách về nhà ngắn hơn 2 km.",
                null,
                "1. Không được vận chuyển.",
                0));
        listLGT.add(new Question("Người đủ bao nhiêu tuổi trở lên thì được điều khiển xe mô tô hai bánh, xe mô tô ba bánh có dung tích xi lanh từ 50 cm3 trở lên và các loại xe có kết cấu tương tự; xe ô tô tải, máy kéo có trọng tải dưới 3,5 tấn; xe ô tô chở người đến 9 chỗ ngồi?",
                "1. 16 tuổi.",
                "2. 18 tuổi.",
                "3. 17 tuổi.",
                null,
                "2. 18 tuổi.",
                0));
        listLGT.add(new Question("Người đủ 16 tuổi được điều khiển các loại xe nào dưới đây?",
                "1. Xe mô tô 2 bánh có dung tích xi lanh từ 50 cm3 trở lên.",
                "2. Xe gắn máy có dung tích xi lanh dưới 50 cm3.",
                "3. Xe ô tô tải dưới 3,5 tấn; xe chở người đến 9 chỗ ngồi.",
                "4. Tất cả các ý nêu trên.",
                "2. Xe gắn máy có dung tích xi lanh dưới 50 cm3.",
                0));
        listLGT.add(new Question("Người có giấy phép lái xe mô tô hạng A1 không được phép điều khiển loại xe nào dưới đây?",
                "1. Xe mô tô có dung tích xi lanh 125 cm3.",
                "2. Xe mô tô có dung tích xi lanh từ 175 cm3 trở lên.",
                "3. Xe mô tô có dung tích xi lanh 100 cm3.",
                null,
                "2. Xe mô tô có dung tích xi lanh từ 175 cm3 trở lên.",
                0));
        listLGT.add(new Question("Người có giấy phép lái xe mô tô hạng A1 được phép điều khiển loại xe nào dưới đây?",
                "1. Xe mô tô hai bánh có dung tích xi lanh từ 50 cm3 đến dưới 175 cm3.",
                "2. Xe mô tô ba bánh dùng cho người khuyết tật.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Biển báo hiệu hình chữ nhật hoặc hình vuông hoặc hình mũi tên nền xanh lam là loại biển gì dưới đây?",
                "1. Biển báo nguy hiểm.",
                "2. Biển báo cấm.",
                "3. Biển báo hiệu lệnh phải thi hành.",
                "4. Biển báo chỉ dẫn.",
                "4. Biển báo chỉ dẫn.",
                R.raw.biencau42));
        listLGT.add(new Question("Khi sử dụng giấy phép lái xe đã khai báo mất để điều khiển phương tiện cơ giới đường bộ, ngoài việc bị thu hồi giấy phép lái xe, chịu trách nhiệm trước pháp luật, người lái xe không được cấp giấy phép lái xe trong thời gian bao nhiêu năm?",
                "1. 02 năm.",
                "2. 03 năm.",
                "3. 05 năm.",
                "4. 04 năm.",
                "3. 05 năm.",
                0));
        listLGT.add(new Question("Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông?",
                "1. Người tham gia giao thông ở các hướng phải dừng lại",
                "2. Người tham gia giao thông ở các hướng được đi theo chiều gậy chỉ của cảnh sát giao thông.",
                "3. Người tham gia giao thông ở phía trước và phía sau người điều khiển được đi tất cả các hướng; người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển phải dừng lại.",
                "4. Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển được đi tất cả các hướng",
                "4. Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển được đi tất cả các hướng",
                R.raw.biencau44));
        listLGT.add(new Question("Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông?",
                "1. Người tham gia giao thông ở hướng đối diện cảnh sát giao thông được đi, các hướng khác cần phải dừng lại.",
                "2. Người tham gia giao thông được rẽ phải theo chiều mũi tên màu xanh ở bục cảnh sát giao thông.",
                "3. Người tham gia giao thông ở các hướng đều phải dừng lại trừ các xe ở trong khu vực giao nhau.",
                "4. Người ở hướng đối diện cảnh sát giao thông phải dừng lại, các hướng khác được đi trong đó có bạn.",
                "3. Người tham gia giao thông ở các hướng đều phải dừng lại trừ các xe ở trong khu vực giao nhau.",
                R.raw.biencau45));
        listLGT.add(new Question("Tại nơi có biển báo hiệu cố định lại có báo hiệu tạm thời thì người tham gia giao thông phải chấp hành hiệu lệnh của báo hiệu nào?",
                "1. Biển báo hiệu cố định.",
                "2. Báo hiệu tạm thời.",
                null,
                null,
                "2. Báo hiệu tạm thời.",
                0));
        listLGT.add(new Question("Trên đường có nhiều làn đường cho xe đi cùng chiều được phân biệt bằng vạch kẻ phân làn đường, người điều khiển phương tiện phải cho xe đi như thế nào?",
                "1. Cho xe đi trên bất kỳ làn đường nào hoặc giữa hai làn đường nếu không có xe phía trước; khi cần thiết phải chuyển làn đường, người lái xe phải quan sát xe phía trước để bảo đảm an toàn.",
                "2. Phải cho xe đi trong một làn đường và chỉ được chuyển làn đường ở những nơi cho phép; khi chuyển làn phải có tín hiệu báo trước và phải bảo đảm an toàn.",
                "3. Phải cho xe đi trong một làn đường, khi cần thiết phải chuyển làn đường, người lái xe phải quan sát xe phía trước để bảo đảm an toàn.",
                null,
                "2. Phải cho xe đi trong một làn đường và chỉ được chuyển làn đường ở những nơi cho phép; khi chuyển làn phải có tín hiệu báo trước và phải bảo đảm an toàn.",
                0));
        listLGT.add(new Question("Trên đường một chiều có vạch kẻ phân làn đường, xe thô sơ và xe cơ giới phải đi như thế nào là đúng quy tắc giao thông? ",
                "1. Xe thô sơ phải đi trên làn đường bên trái ngoài cùng, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.",
                "2. Xe thô sơ phải đi trên làn đường bên phải trong cùng, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên trái.",
                "3. Xe thô sơ đi trên làn đường phù hợp không gây cản trở giao thông, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.",
                null,
                "2. Xe thô sơ phải đi trên làn đường bên phải trong cùng, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên trái.",
                0));
        listLGT.add(new Question("Bạn đang lái xe trong khu vực đô thi từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông?",
                "1. Phải báo hiệu bằng đèn hoặc còi.",
                "2. Chỉ được báo hiệu bằng còi.",
                "3. Phải báo hiệu bằng cả còi và đèn.",
                "4. Chỉ báo hiệu bằng đèn.",
                "4. Chỉ báo hiệu bằng đèn.",
                0));
        listLGT.add(new Question("Khi điều khiển xe chạy trên đường biết có xe sau xin vượt nếu đủ điều kiện an toàn người lái xe phải làm gì?",
                "1. Tăng tốc độ và ra hiệu cho xe sau vượt, không được gây trở ngại cho xe sau vượt.",
                "2. Người điều khiển phương tiện phía trước phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại cho xe sau vượt.",
                "3. Cho xe tránh về bên trái mình và ra hiệu cho xe sau vượt; nếu có chướng ngại vật phía trước hoặc thiếu điều kiện an toàn chưa cho vượt được phải ra hiệu cho xe sau biết; cấm gây trở ngại cho xe xin vượt.",
                null,
                "2. Người điều khiển phương tiện phía trước phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại cho xe sau vượt.",
                0));
        listLGT.add(new Question("Khi muốn chuyển hướng, người lái xe phải thực hiện như thế nào để đảm bảo an toàn giao thông?",
                "1. Quan sát gương, ra tín hiệu, quan sát an toàn và chuyển hướng.",
                "2. Quan sát gương, giảm tốc độ, ra tín hiệu chuyển hướng, quan sát an toàn và chuyển hướng.",
                "3. Quan sát gương, tăng tốc độ, ra tín hiệu và chuyển hướng.",
                null,
                "2. Quan sát gương, giảm tốc độ, ra tín hiệu chuyển hướng, quan sát an toàn và chuyển hướng.",
                0));
        listLGT.add(new Question("Khi tránh xe đi ngược chiều, các xe phải nhường đường như thế nào là đúng quy tắc giao thông?",
                "1. Nơi đường hẹp chỉ đủ cho một xe chạy và có chỗ tránh xe thì xe nào ở gần chỗ tránh hơn phải vào vị trí tránh, nhường đường cho xe kia đi.",
                "2. Xe xuống dốc phải nhường đường cho xe đang lên dốc; xe nào có chướng ngại vật phía trước phải nhường đường cho xe không có chướng ngại vật đi trước.",
                "3. Xe lên dốc phải nhường đường cho xe xuống dốc; xe nào không có chướng ngại vật đi phía trước phải nhường đường cho xe có chướng ngại vật đi trước.",
                "4. Cả ý 1 và ý 2",
                "4. Cả ý 1 và ý 2",
                0));
        listLGT.add(new Question("Bạn đang lái xe trên đường hẹp, xuống dốc và gặp một xe đang đi lên dốc, bạn cần làm gì?",
                "1. Tiếp tục đi vì xe lên dốc phải nhường đường cho mình.",
                "2. Nhường đường cho xe lên dốc.",
                "3. Chỉ nhường đường khi xe lên dốc nháy đèn.",
                null,
                "2. Nhường đường cho xe lên dốc.",
                0));
        listLGT.add(new Question("Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên phải nhường đường như thế nào là đúng quy tắc giao thông?",
                "1. Nhường đường cho xe đi ở bên phải mình tới.",
                "2. Nhường đường cho xe đi ở bên trái mình tới.",
                "3. Nhường đường cho xe đi trên đường ưu tiên hoặc đường chính từ bất kỳ hướng nào tới.",
                null,
                "3. Nhường đường cho xe đi trên đường ưu tiên hoặc đường chính từ bất kỳ hướng nào tới.",
                0));
        listLGT.add(new Question("Tại nơi đường giao nhau không có báo hiệu đi theo vòng xuyến, người điều khiển phương tiện phải nhường đường như thế nào là đúng quy tắc giao thông?",
                "1. Phải nhường đường cho xe đi đến từ bên phải.",
                "2. Xe báo hiệu xin đường trước xe đó được đi trước.",
                "3. Phải nhường đường cho xe đi đến từ bên trái.",
                null,
                "1. Phải nhường đường cho xe đi đến từ bên phải.",
                0));
        listLGT.add(new Question("Tại nơi đường bộ giao nhau cùng mức với đường sắt chỉ có đèn tín hiệu hoặc chuông báo hiệu, khi đèn tín hiệu màu đỏ đã bật sáng hoặc có tiếng chuông báo hiệu, người tham gia giao thông phải dừng lại ngay và giữ khoảng cách tối thiểu bao nhiêu mét tính từ ray gần nhất?",
                "1. 5 mét.",
                "2. 3 mét.",
                "3. 4 mét.",
                null,
                "1. 5 mét.",
                0));
        listLGT.add(new Question("Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào dưới đây?",
                "1. Xe cơ giới, xe máy chuyên dùng phải bật đèn; xe thô sơ phải bật đèn hoặc có vật phát sáng báo hiệu; chỉ được dùng xe, đỗ xe ở nơi quy định.",
                "2. Xe cơ giới phải bật đèn ngay cả khi đường hầm sáng; phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.",
                "3. Xe máy chuyên dùng phải bật đèn ngay cả khi đường hầm sáng; phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết.",
                null,
                "1. Xe cơ giới, xe máy chuyên dùng phải bật đèn; xe thô sơ phải bật đèn hoặc có vật phát sáng báo hiệu; chỉ được dùng xe, đỗ xe ở nơi quy định.",
                0));
        listLGT.add(new Question("Người ngồi trên xe mô tô 2 bánh, xe gắn máy phải đội mũ bảo hiểm có cài quai đúng quy cách khi nào?",
                "1. Khi tham gia giao thông đường bộ.",
                "2. Chỉ khi đi trên đường chuyên dùng; đường cao tốc.",
                "3. Khi tham gia giao thông trên đường tỉnh lộ hoặc quốc lộ.",
                null,
                "1. Khi tham gia giao thông đường bộ.",
                0));
        listLGT.add(new Question("Người điều khiển xe mô tô hai bánh, xe gắn máy được phép chở tối đa 2 người trong những trường hợp nào?",
                "1. Chở người bệnh đi cấp cứu; trẻ em dưới 14 tuổi.",
                "2. Áp giải người có hành vi vi phạm pháp luật.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Người điều khiển xe mô tô hai bánh, xe gắn máy không được thực hiện những hành vi nào dưới đây?",
                "1. Đi vào phần đường dành cho người đi bộ và phương tiện khác; sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính), đi xe dàn hàng ngang.",
                "2. Chở 02 người; trong đó, có người bị bệnh đi cấp cứu hoặc trẻ em dưới 14 tuổi hoặc áp giải người có hành vi vi phạm pháp luật.",
                "3. Điều khiển phương tiện tham gia giao thông trên đường tỉnh lộ hoặc quốc lộ.",
                null,
                "1. Đi vào phần đường dành cho người đi bộ và phương tiện khác; sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính), đi xe dàn hàng ngang.",
                0));
        listLGT.add(new Question("Người điều khiển xe mô tô hai bánh, xe gắn máy có được đi xe dàn hàng ngang; xe đi vào phần đường dành cho người đi bộ và phương tiện khác; sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính) hay không?",
                "1. Được phép nhưng phải đảm bảo an toàn.",
                "2. Không được phép.",
                "3. Được phép tùy từng hoàn cảnh, điều kiện cụ thể.",
                null,
                "2. Không được phép",
                0));
        listLGT.add(new Question("Người lái xe phải giảm tốc độ thấp hơn tốc độ tối đa cho phép (có thể dừng lại một cách an toàn) trong trường hợp nào dưới đây?",
                "1. Khi có báo hiệu cảnh báo nguy hiểm hoặc có chướng ngại vật trên đường; khi chuyển hướng xe chạy hoặc tầm nhìn bị hạn chế; khi qua nơi đường giao nhau, nơi đường bộ giao nhau với đường sắt; đường vòng; đường có địa hình quanh co, đèo dốc.",
                "2. Khi qua cầu, cống hẹp; khi lên gần đỉnh dốc, khi xuống dốc, khi qua trường học, khu đông dân cư, khu vực đang thi công trên đường bộ; hiện trường xảy ra tai nạn giao thông.",
                "3. Khi điều khiển xe vượt xe khác trên đường quốc lộ, đường cao tốc.",
                "4. Cả ý 1 và ý 2",
                "4. Cả ý 1 và ý 2",
                0));
        listLGT.add(new Question("Tại ngã ba hoặc ngã tư không có đảo an toàn, người lái xe phải nhường đường như thế nào là đúng trong các trường hợp dưới đây?",
                "1. Nhường đường cho người đi bộ đang đi trên phần đường dành cho người đi bộ sang đường; nhường đường cho xe đi trên đường ưu tiên, đường chính từ bất kỳ hướng nào tới; nhường đường cho xe ưu tiên, xe đi từ bên phải đến.",
                "2. Nhường đường cho người đi bộ đang đứng chờ đi qua phần đường dành cho người đi bộ sang đường; nhường đường cho xe đi trên đường ngược chiều, đường nhánh từ bất kỳ hướng nào tới; nhường đường cho xe đi từ bên trái đến.",
                "3. Không phải nhường đường.",
                null,
                "1. Nhường đường cho người đi bộ đang đi trên phần đường dành cho người đi bộ sang đường; nhường đường cho xe đi trên đường ưu tiên, đường chính từ bất kỳ hướng nào tới; nhường đường cho xe ưu tiên, xe đi từ bên phải đến.",
                0));
        listLGT.add(new Question("Khi điều khiển xe cơ giới, người lái xe phải bật đèn tín hiệu báo rẽ trong trường hợp nào sau đây?",
                "1. Khi cho xe chạy thẳng.",
                "2. Trước khi thay đổi làn đường.",
                "3. Sau khi thay đổi làn đường.",
                null,
                "2. Trước khi thay đổi làn đường.",
                0));
        listLGT.add(new Question("Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?",
                "1. Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường.",
                "2. Xe bị vượt giảm tốc độ và nhường đường.",
                "3. Phát hiện có xe đi ngược chiều.",
                "4. Cả ý 1 và ý 3",
                "4. Cả ý 1 và ý 3",
                0));
        listLGT.add(new Question("Người lái xe mô tô xử lý như thế nào khi cho xe mô tô phía sau vượt?",
                "1. Nếu đủ điều kiện an toàn, người lái xe phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại đối với xe xin vượt.",
                "2. Lái xe vào lề đường bên trái và giảm tốc độ để xe phía sau vượt qua, không được gây trở ngại đối với xe xin vượt.",
                "3. Nếu đủ điều kiện an toàn, người lái xe phải tăng tốc độ, đi sát về bên phải của phần đường chạy cho đến khi xe sau vượt qua.",
                null,
                "1. Nếu đủ điều kiện an toàn, người lái xe phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại đối với xe xin vượt.",
                0));
        listLGT.add(new Question("Trong các trường hợp dưới đây, để bảo đảm an toàn khi tham gia giao thông, người lái xe mô tô cần thực hiện như thế nào?",
                "1. Phải đội mũ bảo hiểm đạt chuẩn, có cài quai đúng quy cách, mặc quần áo gọn gàng; không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính).",
                "2. Phải đội mũ bảo hiểm khi trời mưa gió hoặc trời quá nắng; có thể sử dụng ô, điện thoại di động, thiết bị âm thanh nhưng phải đảm bảo an toàn.",
                "3. Phải đội mũ bảo hiểm khi cảm thấy mất an toàn giao thông hoặc khi chuẩn bị di chuyển quãng đường xa.",
                null,
                "1. Phải đội mũ bảo hiểm đạt chuẩn, có cài quai đúng quy cách, mặc quần áo gọn gàng; không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính).",
                0));
        listLGT.add(new Question("Đường bộ trong khu vực đông dân cư gồm những đoạn đường nào dưới đây?",
                "1. Là đoạn đường nằm trong khu công nghiệp có đông người và phương tiện tham gia giao thông và được xác định cụ thể bằng biển chỉ dẫn địa giới.",
                "2. Là đoạn đường bộ nằm trong khu vực nội thành phố, nội thị xã, nội thị trấn và những đoạn đường có đông dân cư sinh sống sát dọc theo đường, có các hoạt động ảnh hưởng đến an toàn giao thông; được xác định bằng biển báo hiệu là đường khu đông dân cư.",
                "3. Là đoạn đường nằm ngoài khu vực nội thành phố, nội thị xã có đông người và phương tiện tham gia giao thông và được xác định cụ thể bằng biển chỉ dẫn địa giới.",
                null,
                "2. Là đoạn đường bộ nằm trong khu vực nội thành phố, nội thị xã, nội thị trấn và những đoạn đường có đông dân cư sinh sống sát dọc theo đường, có các hoạt động ảnh hưởng đến an toàn giao thông; được xác định bằng biển báo hiệu là đường khu đông dân cư.",
                0));
        listLGT.add(new Question("Tốc độ tối đa cho phép đối với xe máy chuyên dùng, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự trên đường bộ (trừ đường cao tốc) không được vượt quá bao nhiêu km/h?",
                "1. 50 km/h.",
                "2. 40 km/h.",
                "3. 60 km/h.",
                null,
                "2. 40 km/h.",
                0));
        listLGT.add(new Question("Trên đường bộ (trừ đường cao tốc) trong khu vực đông dân cư, đường đôi có dải phân cách giữa, xe mô tô hai bánh, ô tô chở người đến 30 chỗ tham gia giao thông với tốc độ tối đa cho phép là bao nhiêu?",
                "1. 60 km/h.",
                "2. 50 km/h.",
                "3. 40 km/h.",
                null,
                "1. 60 km/h.",
                0));
        listLGT.add(new Question("Trên đường bộ (trừ đường cao tốc) trong khu vực đông dân cư, đường hai chiều không có dải phân cách giữa, xe mô tô hai bánh, ô tô chở người đến 30 chỗ tham gia giao thông với tốc độ tối đa cho phép là bao nhiêu?",
                "1. 60 km/h.",
                "2. 50 km/h.",
                "3. 40 km/h.",
                null,
                "2. 50 km/h.",
                0));
        listLGT.add(new Question("Trên đường bộ (trừ đường cao tốc) trong khu vực đông dân cư, đường hai chiều hoặc đường một chiều có một làn xe cơ giới, loại xe nào dưới đây được tham gia giao thông với tốc độ tối đa cho phép là 50 km/h?",
                "1. Ô tô con, ô tô tải, ô tô chỏ người trên 30 chỗ.",
                "2. Xe gắn máy, xe máy chuyên dùng.",
                "3. Cả ý 1 và ý 2.",
                null,
                "1. Ô tô con, ô tô tải, ô tô chỏ người trên 30 chỗ.",
                0));

        listLGT.add(new Question("Khi điều khiển xe chạy với tốc độ dưới 60 km/h, để đảm bảo khoảng cách an toàn giữa hai xe, người lái xe phải điều khiển xe như thế nào?",
                "1. Chủ động giữ khoảng cách an toàn phù hợp với xe chạy liền trước xe của mình.",
                "2. Đảm bảo khoảng cách an toàn theo mật độ phương tiện, tình hình giao thông thực tế.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Người lái xe phải giảm tốc độ thấp hơn tốc độ tối đa cho phép đến mức cần thiết, chú ý quan sát và chuẩn bị sẵn sàng những tình huống có thể xảy ra để phòng ngừa tai nạn trong các trường hợp nào dưới đây??",
                "1. Gặp biển báo nguy hiểm trên đường.",
                "2. Gặp biển chỉ dẫn trên đường.",
                "3. Gặp biển báo hết mọi lệnh cấm.",
                "4. Gặp biển báo hết hạn chế tốc độ tối đa cho phép.",
                "1. Gặp biển báo nguy hiểm trên đường.",
                0));
        listLGT.add(new Question("Các phương tiện tham gia giao thông đường bộ (kể cả những xe có quyền ưu tiên) đều phải dừng lại bên phải đường của mình và trước vạch “dừng xe” tại các điểm giao cắt giữa đường bộ và đường sắt khi có báo hiệu dừng nào dưới đây?",
                "1. Hiệu lệnh của nhân viên gác chắn.",
                "2. Đèn đỏ sáng nháy, cờ đỏ, biển đỏ.",
                "3. Còi, chuông kêu, chắn đã đóng.",
                "4. Tất cả các ý trên.",
                "4. Tất cả các ý trên.",
                0));
        listLGT.add(new Question("Tác dụng của mũ bảo hiểm đối với người ngồi trên xe mô tô hai bánh trong trường hợp xảy ra tai nạn giao thông là gì?",
                "1. Để làm đẹp.",
                "2. Để tránh mưa nắng.",
                "3. Để giảm thiểu chấn thương vùng đầu.",
                "4. Để các loại phương tiện khác dễ quan sát.",
                "3. Để giảm thiểu chấn thương vùng đầu.",
                0));
        listLGT.add(new Question("Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên phải xử lý như thế nào là đúng quy tắc giao thông?",
                "1. Tăng tốc độ qua đường giao nhau để đi trước xe đi trên đường ưu tiên.",
                "2. Giảm tốc độ qua đường giao nhau để đi trước xe đi trên đường ưu tiên.",
                "3. Nhường đường cho xe đi trên ưu tiên từ bất kỳ hướng nào tới.",
                null,
                "3. Nhường đường cho xe đi trên ưu tiên từ bất kỳ hướng nào tới.",
                0));
        listLGT.add(new Question("Người lái xe phải xử lý như thế nào khi quan sát phía trước thấy người đi bộ đang sang đường tại nơi có vạch đường dành cho người đi bộ để đảm bảo an toàn?",
                "1. Giảm tốc độ, đi từ từ để vượt qua trước người đi bộ.",
                "2. Giảm tốc độ, có thể dừng lại nếu cần thiết trước vạch dừng xe để nhường đường cho người đi bộ qua đường.",
                "3. Tăng tốc độ để vượt qua trước người đi bộ.",
                null,
                "2. Giảm tốc độ, có thể dừng lại nếu cần thiết trước vạch dừng xe để nhường đường cho người đi bộ qua đường.",
                0));
        listLGT.add(new Question("Theo Luật Giao thông đường bộ, tín hiệu đèn giao thông gồm 3 màu nào dưới đây?",
                "1. Đỏ – Vàng – Xanh.",
                "2. Cam – Vàng – Xanh.",
                "3. Vàng – Xanh dương – Xanh lá.",
                "4. Đỏ – Cam – Xanh.",
                "1. Đỏ – Vàng – Xanh.",
                0));
        listLGT.add(new Question("Tại nơi đường giao nhau, khi đèn điều khiển giao thông có tín hiệu màu vàng, người điều khiển giao thông phải chấp hành như thế nào là đúng quy tắc giao thông?",
                "1. Phải cho xe dừng lại trước vạch dừng, trường hợp đã đi quá vạch dừng hoặc đã quá gần vạch dừng nếu dừng lại thấy nguy hiểm thì được đi tiếp.",
                "2. Trong trường hợp tín hiệu vàng nhấp nháy là được đi nhưng phải giảm tốc độ, chú ý quan sát nhường đường cho người đi bộ qua đường.",
                "3. Nhanh chóng tăng tốc độ, vượt qua nút giao và chú ý đảm bảo an toàn.",
                "4. Cả ý 1 và ý 2.",
                "4. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Để báo hiệu cho xe phía trước biết xe mô tô của bạn muốn vượt, bạn phải có tín hiệu như thế nào dưới đây?",
                "1. Ra tín hiệu bằng tay rồi cho xe vượt qua.",
                "2. Tăng ga mạnh để gây sự chú ý rồi cho xe vượt qua.",
                "3. Bạn phải có tín hiệu bằng đèn hoặc còi.",
                null,
                "3. Bạn phải có tín hiệu bằng đèn hoặc còi.",
                0));
        listLGT.add(new Question("Người điều khiển xe mô tô phải giảm tốc độ và hết sức thận trọng khi qua những đoạn đường nào dưới đây??",
                "1. Đường ướt, đường có sỏi cát trên nền đường.",
                "2. Đường hẹp có nhiều điểm giao cắt từ hai phía.",
                "3. Đường đèo dốc, vòng liên tục.",
                "4. Tất cả các ý nêu trên.",
                "4. Tất cả các ý nêu trên.",
                0));
        listLGT.add(new Question("Khi gặp xe buýt đang dừng đón, trả khách, người điều khiển xe mô tô phải xử lý như thế nào dưới đây để đảm bảo an toàn giao thông?",
                "1. Tăng tốc độ để nhanh chóng vượt qua bến đỗ.",
                "2. Giảm tốc độ đến mức an toàn có thể và quan sát người qua đường và từ từ vượt qua xe buýt.",
                "3. Yêu cầu phải dừng lại phía sau xe buýt chờ xe rời bến mới đi tiếp.",
                null,
                "2. Giảm tốc độ đến mức an toàn có thể và quan sát người qua đường và từ từ vượt qua xe buýt.",
                0));
        listLGT.add(new Question("Khái niệm về văn hóa giao thông được hiểu như thế nào là đúng?",
                "1. Là sự hiểu biết và chấp hành nghiêm chỉnh pháp luật về giao thông; là ý thức trách nhiệm với cộng đồng khi tham gia giao thông.",
                "2. Là ứng xử có văn hóa, có tình yêu thương con người trong các tình huống không may xảy ra khi tham gia giao thông.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Trong các hành vi dưới đây, người lái xe mô tô có văn hóa giao thông phải ứng xử như thế nào?",
                "1. Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; đội mũ bảo hiểm đạt chuẩn, cài quai đúng quy định.",
                "2. Điều khiển xe đi trên phần đường, làn đường có ít phương tiện tham gia giao thông.",
                "3. Điều khiển xe và đội mũ bảo hiểm ở nơi có biển báo bắt buộc đội mũ bảo hiểm.",
                null,
                "1. Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; đội mũ bảo hiểm đạt chuẩn, cài quai đúng quy định.",
                0));
        listLGT.add(new Question("Trong các hành vi dưới đây, người lái xe ô tô, mô tô có văn hóa giao thông phải ứng xử như thế nào?",
                "1. Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; dừng, đỗ xe đúng nơi quy định; đã uống rượu, bia thì không lái xe.",
                "2. Điều khiển xe đi trên phần đường, làn đường có ít phương tiện giao thông; dừng xe, đỗ xe ở nơi thuận tiện hoặc theo yêu cầu của hành khách, của người thân.",
                "3. Dừng và đỗ xe ở nơi thuận tiện cho việc chuyên chở hành khách và giao nhận hàng hóa; sử dụng ít rượu, bia thì có thể lái xe.",
                null,
                "1. Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; dừng, đỗ xe đúng nơi quy định; đã uống rượu, bia thì không lái xe.",
                0));
        listLGT.add(new Question("Khi xảy ra tai nạn giao thông, có người bị thương nghiêm trọng, người lái xe và người có mặt tại hiện trường vụ tai nạn phải thực hiện các công việc gì dưới đây?",
                "1. Thực hiện sơ cứu ban đầu trong trường hợp khẩn cấp; thông báo vụ tai nạn đến cơ quan thi hành pháp luật.",
                "2. Nhanh chóng lái xe gây tai nạn hoặc đi nhờ xe khác ra khỏi hiện tượng vụ tai nạn.",
                "3. Cả ý 1 và ý 2.",
                null,
                "3. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Trên đường đang xảy ra ùn tắc có những hành vi nào sau đây là thiếu văn hóa khi tham gia giao thông?",
                "1. Bấm còi liên tục thúc giục các phương tiện phía trước nhường đường.",
                "2. Đi lên vỉa hè, tận dùng mọi khoảng trống để nhanh chóng thoát khỏi nơi ùn tắc.",
                "3. Lấn sàng trái đường cố gắng vượt lên xe khác.",
                "4. Tất cả các ý nêu trên.",
                "4. Tất cả các ý nêu trên.",
                0));
        listLGT.add(new Question("Khi điều khiển xe mô tô tay ga chạy xuống đường dốc dài, độ dốc cao, người lái xe cần thực hiện những thao tác nào dưới đây để đảm bảo an toàn?",
                "1. Giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                "2. Nhả hết tay ga, tắt động cơ, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                "3. Sử dụng phanh trước để giảm tốc độ kết hợp tắt chìa khóa điện của xe.",
                null,
                "1. Giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ.",
                0));
        listLGT.add(new Question("Khi quay đầu xe, người lái xe cần phải quan sát và thực hiện các thao tác nào để đảm bảo an toàn giao thông?",
                "1. Quan sát biển báo hiệu để biết nơi được phép quay đầu; quan sát kỹ địa hình nơi chọn để quay đầu; lựa chọn quỹ đạo quay đầu xe cho thích hợp; quay đầu xe với tốc độ thấp; thường xuyên báo tín hiệu để người, các phương tiện xung quanh được biết; nếu quay đầu xe ở nơi nguy hiểm thì đưa đầu xe về phía nguy hiểm đưa đuôi xe về phía an toàn.",
                "2. Quan sát biển báo hiệu để biết nơi được phép quay đầu; quan sát kỹ địa hình nơi chọn để quay đầu; lựa chọn quỹ đạo quay đầu xe; quay đầu xe với tốc độ tối đa; thường xuyên báo tín hiệu để người, các phương tiện xung quanh được biết; nếu quay đầu xe ở nơi nguy hiểm thì đưa đuôi xe về phía nguy hiểm và đầu xe về phía an toàn.",
                null,
                null,
                "1. Quan sát biển báo hiệu để biết nơi được phép quay đầu; quan sát kỹ địa hình nơi chọn để quay đầu; lựa chọn quỹ đạo quay đầu xe cho thích hợp; quay đầu xe với tốc độ thấp; thường xuyên báo tín hiệu để người, các phương tiện xung quanh được biết; nếu quay đầu xe ở nơi nguy hiểm thì đưa đầu xe về phía nguy hiểm đưa đuôi xe về phía an toàn.",
                0));
        listLGT.add(new Question("Khi tránh nhau trên đường hẹp, người lái xe cần phải chú ý những điểm nào để đảm bảo an toàn giao thông?",
                "1. Không nên đi cố vào đường hẹp; xe đi ở phía sườn núi nên dừng lại trước để nhường đường; khi dừng xe nhường đường phải đỗ ngay ngắn.",
                "2. Trong khi tránh nhau không nơi đổi số; khi tránh nhau ban đêm, phải tắt đèn pha bật đèn cốt.",
                "3. Khi tránh nhau ban đêm, phải thường xuyên bật đèn pha tắt đèn cốt.",
                "4. Cả ý 1 và ý 2.",
                "4. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Khi điều khiển xe trên đường vòng người lái xe cần phải làm gì để đảm bảo an toàn?",
                "1. Quan sát cẩn thận các chướng ngại vật và báo hiệu bằng còi, đèn; giảm tốc độ tới mức cần thiết, về số thấp và thực hiện quay vòng với tốc độ phù hợp với bán kính cong của đường vòng.",
                "2. Quan sát cẩn thận các chướng ngại vật và báo hiệu bằng còi, đèn; tăng tốc để nhanh chóng qua đường vòng và giảm tốc độ sau khi qua đường vòng.",
                null,
                null,
                "1. Quan sát cẩn thận các chướng ngại vật và báo hiệu bằng còi, đèn; giảm tốc độ tới mức cần thiết, về số thấp và thực hiện quay vòng với tốc độ phù hợp với bán kính cong của đường vòng.",
                0));
        listLGT.add(new Question("Để đạt được hiệu quả phanh cao nhất, người lái xe mô tô phải sử dụng các kỹ năng như thế nào dưới đây?",
                "1. Sử dụng phanh trước.",
                "2. Sử dụng phanh sau.",
                "3. Giảm hết ga; sử dụng đồng thời cả phanh sau và phanh trước.",
                null,
                "3. Giảm hết ga; sử dụng đồng thời cả phanh sau và phanh trước.",
                0));
        listLGT.add(new Question("Khi đang lái xe mô tô và ô tô, nếu có nhu cầu sử dụng điện thoại để nhắn tin hoặc gọi điện, người lái xe phải thực hiện như thế nào trong các tình huống nêu dưới đây?",
                "1. Giảm tốc độ để đảm bảo an toàn với xe phía trước và sử dụng điện thoại để liên lạc.",
                "2. Giảm tốc độ để dừng xe ở nơi cho phép dừng xe sau đó sử dụng điện thoại để liên lạc.",
                "3. Tăng tốc độ để cách xa xe phía sau và sử dụng điện thoại để liên lạc.",
                null,
                "2. Giảm tốc độ để dừng xe ở nơi cho phép dừng xe sau đó sử dụng điện thoại để liên lạc.",
                0));
        listLGT.add(new Question("Những thói quen nào dưới đây khi điều khiển xe mô tô tay ga tham gia giao thông dễ gây tai nạn nguy hiểm?",
                "1. Sử dụng còi.",
                "2. Phanh đồng thời cả phanh trước và phanh sau.",
                "3. Chỉ sử dụng phanh trước.",
                null,
                "3. Chỉ sử dụng phanh trước.",
                0));
        listLGT.add(new Question("Khi điều khiển xe mô tô quay đầu người lái xe cần thực hiện như thế nào để đảm bảo an toàn?",
                "1. Bật tín hiệu báo rẽ trước khi quay đầu, từ từ giảm tốc độ đến mức có thể dừng lại.",
                "2. Chỉ quay đầu xe ở những nơi được phép quay đầu.",
                "3. Quan sát an toàn các phương tiện tới từ phía trước, phía sau, hai bên đồng thời nhường đường cho xe từ bên phải và phía trước đi tới.",
                "4. Tất cả các ý nêu trên.",
                "4. Tất cả các ý nêu trên.",
                0));
        listLGT.add(new Question("Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây?",
                "1. Để điều khiển xe chạy về phía trước.",
                "2. Để điều tiết công suất động cơ qua đó điều khiển tốc độ của xe.",
                "3. Để điều khiển xe chạy lùi.",
                "4. Cả ý 1 và ý 2.",
                "4. Cả ý 1 và ý 2.",
                0));
        listLGT.add(new Question("Gương chiếu hậu của xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây?",
                "1. Để quan sát an toàn phía bên trái khi chuẩn bị rẽ trái.",
                "2. Để quan sát an toàn phía bên phải khi chuẩn bị rẽ phải.",
                "3. Để quan sát an toàn phía sau cả bên trái và bên phải trước khi chuyển hướng.",
                "4. Để quan sát an toàn phía trước cả bên trái và bên phải trước khi chuyển hướng.",
                "3. Để quan sát an toàn phía sau cả bên trái và bên phải trước khi chuyển hướng.",
                0));
        listLGT.add(new Question("Để đảm bảo an toàn khi tham gia giao thông, người lái xe mô tô hai bánh cần điều khiển tay ga như thế nào trong các trường hợp dưới đây?",
                "1. Tăng ga thật nhanh, giảm ga từ từ.",
                "2. Tăng ga thật nhanh, giảm ga thật nhanh.",
                "3. Tăng ga từ từ, giảm ga thật nhanh.",
                "4. Tăng ga từ từ, giảm ga từ từ.",
                "3. Tăng ga từ từ, giảm ga thật nhanh.",
                0));
        listLGT.add(new Question("Kỹ thuật cơ bản để giữ thăng bằng khi điều khiển xe mô tô đi trên đường gồ ghề như thế nào trong các trường hợp dưới đây?",
                "1. Đứng thẳng trên giá gác chân lái sau đó hơi gập đầu gối và khuỷu tay, đi chậm để không nẩy quá mạnh.",
                "2. Ngồi lùi lại phía sau, tăng ga vượt nhanh qua đoạn đường xóc.",
                "3. Ngồi lệch sang bên trái hoặc bên phải để lấy thăng bằng qua đoạn đường gồ ghề.",
                null,
                "1. Đứng thẳng trên giá gác chân lái sau đó hơi gập đầu gối và khuỷu tay, đi chậm để không nẩy quá mạnh.",
               0));

    }
    
    private void CauhoiBienbao() {
        listBB = new ArrayList<>();
        listBB.add(new Question("Biển nào dưới đây xe gắn máy được phép đi vào?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển",
                null,
                "3. Cả hai biển",
                R.raw.biencau101));
        listBB.add(new Question("Biển nào báo hiệu cấm xe mô tô hai bánh đi vào?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3",
                null,
                "1. Biển 1.",
                R.raw.biencau102));
        listBB.add(new Question("Khi gặp biển nào thì xe mô tô hai bánh được đi vào?",
                "1. Không biển nào.",
                "2. Biển 1 và 2.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "3. Biển 2 và 3.",
                R.raw.biencau103));
        listBB.add(new Question("Biển nào cấm quay đầu xe?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Không biển nào.",
                "4. Cả hai biển.",
                "2. Biển 2.",
                R.raw.biencau104));
        listBB.add(new Question("Biển nào cấm xe rẽ trái?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển.",
                null,
                "1. Biển 1.",
                R.raw.biencau105));
        listBB.add(new Question("Khi gặp biển nào xe được rẽ trái?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Không biển nào",
                null,
                "2. Biển 2.",
                R.raw.biencau106));
        listBB.add(new Question("Biển nào cấm các phương tiện giao thông đường bộ rẽ phải?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển",
                "1. Biển 1 và 2",
                R.raw.biencau107));
        listBB.add(new Question("Biển nào cấm các phương tiện giao thông đường bộ rẽ trái?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "1. Biển 1 và 2",
                R.raw.biencau108));
        listBB.add(new Question("Biển nào cho phép xe rẽ trái?",
                "1. Biển 1.",
                "2. Biển 2",
                "3. Không biển nào.",
                null,
                "2. Biển 2",
                R.raw.biencau109));
        listBB.add(new Question("Biển nào xe được phép quay đầu nhưng không được rẽ trái?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển.",
                null,
                "3. Cả hai biển.",
                R.raw.biencau110));
        listBB.add(new Question("Biển nào xe được phép quay đầu nhưng không được rẽ trái?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển.",
                null,
                "3. Cả hai biển.",
                R.raw.biencau111));
        listBB.add(new Question("Biển nào là biển “Cấm đi ngược chiều”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả ba biển.",
                null,
                "2. Biển 2.",
                R.raw.biencau112));
        listBB.add(new Question("Biển nào dưới đây các phương tiện không được phép đi vào?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 1 và 2.",
                null,
                "3. Biển 1 và 2.",
                R.raw.biencau113));
        listBB.add(new Question("Khi gặp biển nào xe ưu tiên theo luật định vẫn phải dừng lại?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả ba biển.",
                null,
                "2. Biển 2.",
                R.raw.biencau114));
        listBB.add(new Question("Biển nào cấm tất cả các loại xe cơ giới và thô sơ đi lại trên đường, trừ xe ưu tiên theo luật định (nếu đường vẫn cho xe chạy được)?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển.",
                null,
                "1. Biển 1.",
                R.raw.biencau115));
        listBB.add(new Question("Gặp biển nào xe xích lô được phép đi vào?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Biển 1 và biển 2.",
                "4. Biển 1 và biển 2.",
                R.raw.biencau116));
        listBB.add(new Question("Gặp biển nào xe lam, xe xích lô máy được phép đi vào?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "3. Biển 3.",
                R.raw.biencau117));
        listBB.add(new Question("Biển báo này có ý nghĩa như thế nào?",
                "1. Tốc độ tối đa cho phép về ban đêm cho các phương tiện là 70 km/h.",
                "2. Tốc độ tối thiểu cho phép về ban đêm cho các phương tiện là 70 km/h.",
                null,
                null,
                "1. Tốc độ tối đa cho phép về ban đêm cho các phương tiện là 70 km/h.",
                R.raw.biencau118));
        listBB.add(new Question("Chiều dài đoạn đường 500 m từ nơi đặt biển này, người lái xe có được phép bấm còi không?",
                "1. Được phép.",
                "2. Không được phép.",
                null,
                null,
                "2. Không được phép.",
                R.raw.biencau119));
        listBB.add(new Question("Biển nào xe mô tô hai bánh được đi vào?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                null,
                "2. Biển 1 và 3.",
                R.raw.biencau120));
        listBB.add(new Question("Biển nào xe mô tô hai bánh không được đi vào?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "2. Biển 2.",
                R.raw.biencau121));
        listBB.add(new Question("Biển báo nào báo hiệu bắt đầu đoạn đường vào phạm vi khu dân cư, các phương tiện tham gia giao thông phải tuân theo các quy định đi đường được áp dụng ở khu đông dân cư?",
                "1. Biển 1.",
                "2. Biển 2.",
                null,
                null,
                "1. Biển 1.",
                R.raw.biencau122));
        listBB.add(new Question("Gặp biển nào người lái xe phải nhường đường cho người đi bộ ?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Biển 1 và 3.",
                "1. Biển 1.",
                R.raw.biencau123));
        listBB.add(new Question("Biển nào chỉ đường dành cho người đi bộ, các loại xe không được đi vào khi gặp biển này?",
                "1. Biển 1.",
                "2. Biển 1 và 3.",
                "3. Biển 3.",
                "4. Cả ba biển.",
                "3. Biển 3.",
                R.raw.biencau124));
        listBB.add(new Question("Biển nào báo hiệu “Đường dành cho xe thô sơ”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "1. Biển 1.",
                R.raw.biencau125));
        listBB.add(new Question("Biển nào báo hiệu sắp đến chỗ giao nhau nguy hiểm?",
                "1. Biển 1.",
                "2. Biển 1 và 2.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "4. Cả ba biển.",
                R.raw.cau126));
        listBB.add(new Question("Biển nào báo hiệu “Giao nhau với đường sắt có rào chắn”?",
                "1. Biển 1.",
                "2. Biển 2 và 3.",
                "3. Biển 3.",
                null,
                "1. Biển 1.",
                R.raw.cau127));
        listBB.add(new Question("Biển nào báo hiệu “Giao nhau với tín hiệu đèn”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Cả ba biển.",
                "3. Biển 3.",
                R.raw.cau128));
        listBB.add(new Question("Biển nào báo hiệu nguy hiểm giao nhau với đường sắt?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "3. Biển 2 và 3.",
                R.raw.cau129));
        listBB.add(new Question("Biển nào báo hiệu đường sắt giao nhau với đường bộ không có rào chắn?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "3. Biển 2 và 3.",
                R.raw.biencau130));
        listBB.add(new Question(" Biển nào báo hiệu sắp đến chỗ giao nhau giữa đường bộ và đường sắt?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Biển 1 và 3.",
                "1. Biển 1.",
                R.raw.biencau131));
        listBB.add(new Question(" Biển nào báo hiệu, chỉ dẫn xe đi trên đường này được quyền ưu tiên qua nơi giao nhau?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "2. Biển 1 và 3.",
                R.raw.cau132));
        listBB.add(new Question(" Biển nào báo hiệu “Giao nhau với đường không ưu tiên”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Biển 2 và 3.",
                "1. Biển 1.",
                R.raw.cau133));
        listBB.add(new Question(" Biển nào báo hiệu “Giao nhau với đường ưu tiên”?",
                "1. Biển 1 và 3.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "2. Biển 2.",
                R.raw.cau134));
        listBB.add(new Question("Biển nào báo hiệu “Đường bị thu hẹp”?",
                "1. Biển 1 và 2.",
                "2. Biển 1 và 3.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "2. Biển 2.",
                R.raw.biencau135));
        listBB.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 2 và 3.",
                "4. Cả ba biển.",
                "3. Biển 2 và 3.",
                R.raw.biencau136));
        listBB.add(new Question("Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "1. Biển 1.",
                R.raw.cau137));
        listBB.add(new Question("Biển nào báo hiệu “Đường đôi”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "2. Biển 2.",
                R.raw.cau138));
        listBB.add(new Question("Biển nào báo hiệu “Đường đôi”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "3. Biển 3.",
                R.raw.cau139));
        listBB.add(new Question("Biển nào báo hiệu “Giao nhau với đường hai chiều”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "1. Biển 1.",
                R.raw.cau140));
        listBB.add(new Question("Biển nào báo hiệu “Đường hai chiều”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3.Biển 3.",
                null,
                "2. Biển 2.",
                R.raw.biencau141));
        listBB.add(new Question("Biển nào báo hiệu “Giao nhau với đường hai chiều”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "2. Biển 2.",
                R.raw.biencau142));
        listBB.add(new Question("Biển nào báo hiệu “Chú ý chướng ngại vật”?",
                "1. Biển 1.",
                "2. Biển 2 và 3.",
                "3. Cả ba biển.",
                null,
                "2. Biển 2 và 3.",
                R.raw.biencau143));
        listBB.add(new Question("Gặp biển nào người tham gia giao thông phải đi chậm và thận trọng đề phòng khả năng xuất hiện và di chuyển bất ngờ của trẻ em trên mặt đường?",
                "1. Biển 1.",
                "2. Biển 2.",
                null,
                null,
                "2. Biển 2.",
                R.raw.biencau144));
        listBB.add(new Question("Biển nào chỉ dẫn nơi bắt đầu đoạn đường dành cho người đi bộ?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3.Biển 3.",
                null,
                "2. Biển 2.",
                R.raw.biencau145));
        listBB.add(new Question("Biển báo này có ý nghĩa gì?",
                "1. Báo hiệu đường có ổ gà, lồi lõm.",
                "2. Báo hiệu đường có gồ giảm tốc phía trước.",
                null,
                null,
                "2. Báo hiệu đường có gồ giảm tốc phía trước.",
                R.raw.biencau146));
        listBB.add(new Question("Biển nào (đặt trước ngã ba, ngã tư) cho phép xe được rẽ sang hướng khác?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Không biển nào.",
                null,
                "3. Không biển nào.",
                R.raw.biencau147));
        listBB.add(new Question("Biển nào báo hiệu “Hướng đi thẳng phải theo”?",
                "1. Biển 1.",
                "2. Biển 2.",
                null,
                null,
                "1. Biển 1.",
                R.raw.biencau148));
        listBB.add(new Question("Biển nào báo hiệu “Đường một chiều”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển.",
                null,
                "2. Biển 2.",
                R.raw.biencau149));
        listBB.add(new Question("Trong các biển dưới đây biển nào là biển “Hết tốc độ tối đa cho phép”??",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "1. Biển 1.",
                R.raw.biencau150));
        listBB.add(new Question("Hiệu lực của biển “Tốc độ tối đa cho phép” hết tác dụng khi gặp biển nào dưới đây??",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Biển 1 và 2.",
                "4. Biển 1 và 2.",
                R.raw.biencau151));
        listBB.add(new Question("Trong các biển dưới đây biển nào là biển “Hết tốc độ tối thiểu”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Cả ba biển.",
                "3. Biển 3.",
                R.raw.biencau152));
        listBB.add(new Question("Biển nào dưới đây báo hiệu hết cấm vượt?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Biển 2 và 3.",
                "4. Biển 2 và 3.",
                R.raw.biencau153));
        listBB.add(new Question("Trong các biển dưới đây biển nào là biển “Hết mọi lệnh cấm”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                "4. Cả ba biển.",
                "2. Biển 2.",
                R.raw.biencau154));
        listBB.add(new Question("Biển nào chỉ dẫn cho người đi bộ sử dụng cầu vượt qua đường?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển.",
                "4. Không biển nào.",
                "1. Biển 1.",
                R.raw.biencau155));
        listBB.add(new Question("Biển nào chỉ dẫn cho người đi bộ sử dụng hầm chui qua đường?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Cả hai biển.",
                "4. Không biển nào.",
                "2. Biển 2.",
                R.raw.biencau156));
        listBB.add(new Question("Biển nào báo hiệu “Nơi đỗ xe dành cho người khuyết tật”?",
                "1. Biển 1.",
                "2. Biển 2.",
                "3. Biển 3.",
                null,
                "2. Biển 2.",
                R.raw.biencau157));
        listBB.add(new Question("Gặp biển báo này, người tham gia giao thông phải xử lý như thế nào?",
                "1. Dừng xe tại khu vực có trạm Cảnh sát giao thông.",
                "2. Tiếp tục lưu thông với tốc độ bình thường.",
                "3. Phải giảm tốc độ đến mức an toàn và không được vượt khi đi qua khu vực này.",
                null,
                "3. Phải giảm tốc độ đến mức an toàn và không được vượt khi đi qua khu vực này.",
                R.raw.biencau158));
        listBB.add(new Question("Biển số 1 có ý nghĩa gì?",
                "1. Đi thẳng hoặc rẽ trái trên cầu vượt.",
                "2. Đi thẳng hoặc rẽ phải trên cầu vượt.",
                "3. Báo hiệu cầu vượt liên thông.",
                null,
                "3. Báo hiệu cầu vượt liên thông.",
                R.raw.biencau159));
        listBB.add(new Question("Vạch kẻ đường nào dưới đây là vạch phân chia các làn xe cùng chiều?",
                "1. Vạch 1.",
                "2. Vạch 2.",
                "3. Vạch 3.",
                "4. Vạch 1 và 2.",
                "4. Vạch 1 và 2.",
                R.raw.biencau160));
        listBB.add(new Question("Vạch kẻ đường nào dưới đây là vạch phân chia hai chiều xe chạy (vạch tim đường), xe không được lấn làn, không được đè lên vạch?",
                "1. Vạch 1.",
                "2. Vạch 2.",
                "3. Vạch 3.",
                "4. Cả 3 vạch.",
                "2. Vạch 2.",
                R.raw.biencau161));
        listBB.add(new Question("Vạch kẻ đường nào dưới đây là vạch phân chia hai chiều xe chạy (vạch tim đường)?",
                "1. Vạch 1.",
                "2. Vạch 2.",
                "3. Vạch 3.",
                "4. Vạch 1 và 3.",
                "4. Vạch 1 và 3.",
                R.raw.biencau162));
        listBB.add(new Question("Các vạch dưới đây có tác dụng gì?",
                "1. Phân chia hai chiều xe chạy ngược chiều nhau.",
                "2. Phân chia các làn xe chạy cùng chiều nhau.",
                null,
                null,
                "1. Phân chia hai chiều xe chạy ngược chiều nhau.",
                R.raw.biencau163));
        listBB.add(new Question("Khi gặp vạch kẻ đường nào các xe được phép đè vạch?",
                "1. Vạch 1.",
                "2. Vạch 2.",
                "3. Vạch 3.",
                "4. Vạch 1 và vạch 3.",
                "4. Vạch 1 và vạch 3.",
                R.raw.biencau164));
        listBB.add(new Question("Vạch dưới đây có ý nghĩa gì?",
                "1. Vị trí dừng xe của các phương tiện vận tải hành khách công cộng.",
                "2. Báo cho người điều khiển được dừng phương tiện trong phạm vi phần mặt đường có bố trí vạch để tránh ùn tắc giao thông.",
                "3. Dùng để xác định vị trí giữa các phương tiện trên đường.",
                null,
                "1. Vị trí dừng xe của các phương tiện vận tải hành khách công cộng.",
                R.raw.biencau165));



    }

    private void CauhoiSahinh() {
        listSH = new ArrayList<>();
        listSH.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe tải, xe khách, xe con, mô tô.",
                "2. Xe tải, mô tô, xe khách, xe con.",
                "3. Xe khách, xe tải, xe con, mô tô.",
                "4. Mô tô, xe khách, xe tải, xe con.",
                "2. Xe tải, mô tô, xe khách, xe con.",
                R.raw.biencau166));
        listSH.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe tải, xe con, mô tô.",
                "2. Xe con, xe tải, mô tô.",
                "3. Mô tô, xe con, xe tải.",
                "4. Xe con, mô tô, xe tải.",
                "3. Mô tô, xe con, xe tải.",
                R.raw.biencau167));
        listSH.add(new Question("Trường hợp này xe nào được quyền đi trước?",
                "1. Mô tô.",
                "2. Xe con.",
                null,
                null,
                "2. Xe con.",
                R.raw.biencau168));
        listSH.add(new Question("Xe nào được quyền đi trước trong trường hợp này?",
                "1. Mô tô.",
                "2. Xe cứu thương.",
                null,
                null,
                "2. Xe cứu thương.",
                R.raw.biencau169));
        listSH.add(new Question("Theo tín hiệu đèn, xe nào được phép đi?",
                "1. Xe con và xe khách.",
                "2. Mô tô.",
                null,
                null,
                "1. Xe con và xe khách.",
                R.raw.biencau170));
        listSH.add(new Question("Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe khách, xe tải, mô tô.",
                "2. Xe tải, xe con, mô tô.",
                "3. Xe khách, xe con, mô tô.",
                null,
                "1. Xe khách, xe tải, mô tô.",
                R.raw.biencau171));
        listSH.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe khách, xe tải, mô tô, xe con.",
                "2. Xe con, xe khách, xe tải, mô tô.",
                "3. Mô tô, xe tải, xe khách, xe con.",
                "4. Mô tô, xe tải, xe con, xe khách.",
                "3. Mô tô, xe tải, xe khách, xe con.",
                R.raw.biencau172));
        listSH.add(new Question("Trong trường hợp này xe nào đỗ vi phạm quy tắc giao thông?",
                "1. Xe tải.",
                "2. Xe con và mô tô.",
                "3. Cả ba xe.",
                "4. Xe con và xe tải.",
                "1. Xe tải.",
                R.raw.biencau173));
        listSH.add(new Question("Theo hướng mũi tên, những hướng nào xe gắn máy đi được?",
                "1. Cả ba hướng.",
                "2. Chỉ hướng 1 và 3.",
                "3. Chỉ hướng 1.",
                null,
                "1. Cả ba hướng.",
                R.raw.biencau174));
        listSH.add(new Question("Xe nào đỗ vi phạm quy tắc giao thông?",
                "1. Cả hai xe.",
                "2. Không xe nào vi phạm.",
                "3. Chỉ xe mô tô vi phạm.",
                "4. Chỉ xe tải vi phạm.",
                "1. Cả hai xe.",
                R.raw.biencau175));
        listSH.add(new Question("Xe nào đỗ vi phạm quy tắc giao thông?",
                "1. Chỉ mô tô.",
                "2. Chỉ xe tải.",
                "3. Cả ba xe.",
                "4. Chỉ mô tô và xe tải.",
                "3. Cả ba xe.",
                R.raw.biencau176));
        listSH.add(new Question("Xe tải kéo mô tô ba bánh như hình này có đúng quy tắc giao thông không?",
                "1. Đúng.",
                "2. Không đúng.",
                null,
                null,
                "2.Không đúng.",
                R.raw.biencau177));
        listSH.add(new Question("Xe nào được quyền đi trước trong trường hợp này?",
                "1. Xe con.",
                "2. Xe mô tô.",
                null,
                null,
                "2. Xe mô tô.",
                R.raw.biencau178));
        listSH.add(new Question("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe con (A), mô tô, xe con (B), xe đạp.",
                "2. Xe con (B), xe đạp, mô tô, xe con (A).",
                "3. Xe con (A), xe con (B), mô tô  + xe đạp.",
                "4. Mô tô + xe đạp, xe con (A), xe con (B).",
                "4. Mô tô + xe đạp, xe con (A), xe con (B).",
                R.raw.biencau179));
        listSH.add(new Question("Xe nào được quyền đi trước trong trường hợp này?",
                "1. Mô tô.",
                "2. Xe con.",
                null,
                null,
                "1. Mô tô.",
                R.raw.biencau180));
        listSH.add(new Question("Xe nào vi phạm quy tắc giao thông?",
                "1. Xe khách.",
                "2. Mô tô.",
                "3. Xe con.",
                "4. Xe con và mô tô.",
                "3. Xe con.",
                R.raw.biencau181));
        listSH.add(new Question("Các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Các xe ở phía tay phải và tay trái của người điều khiển được phép đi thẳng.",
                "2. Cho phép các xe ở mọi hướng được rẽ phải.",
                "3. Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.",
                null,
                "3. Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.",
                R.raw.biencau182));
        listSH.add(new Question("Theo hướng mũi tên, xe nào được phép đi?",
                "1. Mô tô, xe con.",
                "2. Xe con, xe tải.",
                "3. Mô tô, xe tải.",
                "4. Cả ba xe.",
                "3. Mô tô, xe tải.",
                R.raw.biencau183));
        listSH.add(new Question("Trong hình dưới đây, xe nào chấp hành đúng quy tắc giao thông?",
                "1. Chỉ xe khách, mô tô.",
                "2. Tất cả các loại xe trên.",
                "3. Không xe nào chấp hành đúng quy tắc giao thông.",
                null,
                "2. Tất cả các loại xe trên.",
                R.raw.biencau184));
        listSH.add(new Question("Theo hướng mũi tên, những hướng nào xe mô tô được phép đi?",
                "1. Cả ba hướng.",
                "2. Hướng 1 và 2.",
                "3. Hướng 1 và 3.",
                "4. Hướng 2 và 3.",
                "3. Hướng 1 và 3.",

                R.raw.biencau185));
        listSH.add(new Question("Trong trường hợp này, thứ tự xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe công an, xe quân sự, xe con + mô tô.",
                "2. Xe quân sự, xe công an, xe con +mô tô.",
                "3. Xe mô tô + xe con, xe quân sự, xe công an.",
                null,
                "2. Xe quân sự, xe công an, xe con +mô tô.",
                R.raw.biencau186));
        listSH.add(new Question("Trong hình dưới, những xe nào vi phạm quy tắc giao thông?",
                "1. Xe con (E), mô tô (C).",
                "2. Xe tải (A), mô tô (D).",
                "3. Xe khách (B), mô tô (C).",
                "4. Xe khách (B), mô tô (D).",
                "1. Xe con (E), mô tô (C).",
                R.raw.biencau187));
        listSH.add(new Question("Trong hình dưới, những xe nào vi phạm quy tắc giao thông?",
                "1. Xe con (B), mô tô (C).",
                "2. Xe con (A), mô tô (C).",
                "3. Xe con (E), mô tô (D).",
                "4. Tất cả các loại xe trên.",
                "3. Xe con (E), mô tô (D).",
                R.raw.biencau188));
        listSH.add(new Question("Bạn có được phép vượt xe mô tô phía trước không?",
                "1. Cho phép.",
                "2. Không được vượt.",
                null,
                null,
                "2. Không được vượt.",
                R.raw.biencau189));
        listSH.add(new Question("Theo tín hiệu đèn của xe cơ giới, xe nào vi phạm quy tắc giao thông?",
                "1. Xe mô tô.",
                "2. Xe ô tô con.",
                "3. Không xe nào vi phạm.",
                "4. Cả hai xe.",
                "4. Cả hai xe.",
                R.raw.biencau190));
        listSH.add(new Question("Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe con.",
                "2. Xe tải.",
                "3. Xe con, xe tải.",
                null,
                "2. Xe tải.",

                R.raw.biencau191));
        listSH.add(new Question("Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe tải, xe con.",
                "2. Xe khách, xe con.",
                "3. Xe khách, xe tải.",
                null,
                "3. Xe khách, xe tải.",
                R.raw.biencau192));
        listSH.add(new Question("Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe con, xe khách, xe tải.",
                "2. Xe tải, xe khách, xe mô tô.",
                "3. Xe khách, xe mô tô, xe con.",
                "4. Cả bốn xe.",
                "2. Xe tải, xe khách, xe mô tô.",

                R.raw.biencau193));
        listSH.add(new Question("Các xe đi theo hướng mũi tên, xe nào chấp hành đúng quy tắc giao thông?",
                "1. Xe tải, mô tô.",
                "2. Xe khách, mô tô.",
                "3. Xe tải, xe con.",
                "4. Mô tô, xe con.",
                "2. Xe khách, mô tô.",

                R.raw.biencau194));
        listSH.add(new Question("Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?",
                "1. Xe của bạn, mô tô, xe con.",
                "2. Xe con, xe của bạn, mô tô.",
                "3. Mô tô, xe con, xe của bạn.",
                null,
                "3. Mô tô, xe con, xe của bạn.",
                R.raw.biencau195));
        listSH.add(new Question("Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?",
                "1. Xe của bạn, mô tô, xe con.",
                "2. Xe con, xe của bạn, mô tô.",
                "3. Mô tô, xe con, xe của bạn.",
                null,
                "2. Xe con, xe của bạn, mô tô.",

                R.raw.biencau196));
        listSH.add(new Question("Bạn xử lý như thế nào trong trường hợp này?",
                "1. Tăng tốc độ, rẽ phải trước xe tải và xe đạp.",
                "2. Giảm tốc độ, rẽ phải sau xe tải và xe đạp.",
                "3. Tăng tốc độ, rẽ phải trước xe đạp.",
                null,
                "2. Giảm tốc độ, rẽ phải sau xe tải và xe đạp.",
                R.raw.biencau197));
        listSH.add(new Question("Xe nào dừng đúng theo quy tắc giao thông?",
                "1. Xe con.",
                "2. Xe mô tô.",
                "3. Cả hai xe đều đúng.",
                null,
                "1. Xe con.",
                R.raw.biencau198));
        listSH.add(new Question("Xe của bạn đang di chuyển gần đến khu vực giao cắt với đường sắt, khi rào chắn đang dịch chuyển, bạn điều khiển xe như thế nào là đúng quy tắc giao thông?",
                "1. Quan sát nếu thấy không có tàu thì tăng tốc cho xe vượt qua đường sắt.",
                "2. Dừng lại trước rào chắn một khoảng cách an toàn.",
                "3. Ra tín hiệu, yêu cầu người gác chắn tàu kéo chậm Barie để xe bạn qua.",
                null,
                "2. Dừng lại trước rào chắn một khoảng cách an toàn.",
                R.raw.biencau199));
        listSH.add(new Question("Trong tình huống dưới đây, xa đầu kéo kéo rơ moóc (xe container) đang rẽ phải, xe con màu xanh và xe máy phía sau xe container đi như thế nào để đảm bảo an toàn?",
                "1. Vượt về phía bên phải để đi tiếp.",
                "2. Giảm tốc độ chờ xe container rẽ xong rồi tiếp tục đi.",
                "3. Vượt về phía bên trái để đi tiếp.",
                null,
                "2. Giảm tốc độ chờ xe container rẽ xong rồi tiếp tục đi.",
                R.raw.biencau200));
    }
}
