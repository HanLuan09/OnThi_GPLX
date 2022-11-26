package com.example.btl.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.btl.R;
import com.example.btl.model.MeoThi;
import com.example.btl.adapter.MeoThiAdapter;

import java.util.ArrayList;

public class MeoThiLyThuyetActivity extends AppCompatActivity {
    private ListView lvMeothi;
    private ArrayList<MeoThi> arrayMeothi;
    private MeoThiAdapter meoTHiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meo_thi_ly_thuyet);
        ActionBar actionBarlt = getSupportActionBar();
        actionBarlt.setDisplayHomeAsUpEnabled(true);//trở về
        actionBarlt.setTitle("Mẹo thi lý thuyết");
        actionBarlt.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.teal_200)));
        Anhxa();
        // Truyền dữ liệu các dòng sang adapter
        meoTHiAdapter = new MeoThiAdapter(this, R.layout.dong_meo_thi,arrayMeothi);
        lvMeothi.setAdapter(meoTHiAdapter);
    }

    private void Anhxa() {
        lvMeothi = findViewById(R.id.listViewMeothi);
        // add dữ liệu
        arrayMeothi = new ArrayList<>();
        arrayMeothi.add(new MeoThi("Cấp phép","Đường cấm dừng, cấm đỗ, cấm đi doUBNN cấp tỉnh cấp\n" +
                "Xe quá khổ, quá tải do cơ quan quản lý đường bộ có thẩm quyền cấp phép."));
        arrayMeothi.add(new MeoThi("Nồng độ cồn","Người điều khiển xe mô tô, ô tô, " +
                "máy kéo trên đường mà trong máu hoặc hơi thở có nồng độ cồn: BỊ NGHIÊM CẤM."));
        arrayMeothi.add(new MeoThi("Hỏi về tuổi(T)","Gắn máy: 16T (dưới 50cm3)\nMô tô + B1 + B2: 18T"));
        arrayMeothi.add(new MeoThi("Các hạng GPLX","A1 mô tô dưới 175 cm3 và xe 3 bánh của người " +
                "khuyết tật\nA2 mô tô 175cm3 trở lên"));
        arrayMeothi.add(new MeoThi("Khoảng cách tối thiểu","35m nếu vận tốc lưu hành(V) = 60(km/h)\n" +
                "55m nếu 60<V<80(km/h)\n70m nếu 80<V<100(km/h)\n100m nếu 100<V<120(km/h)\n" +
                "Dưới 60km/h: Chủ động và đảm bảo khoảng cách"));
        arrayMeothi.add(new MeoThi("Thứ tự xe ưu tiên:\nHỏa - Sự - An - Thương",".Hỏa: Xe Cứu hỏa\n" +
                ".Sự: Xe Quân sự\n.An: Xe Công an\n.Thương: Xe cứu thương\n.Xe hộ đê, xe đi làm nhiệm vụ khẩn cấp\n" +
                ".Đoàn xe tang"));
        arrayMeothi.add(new MeoThi("Kỹ thuật lái xe","Xe mô tô xuống dốc dài cần sử dụng cả phanh " +
                "trước và phanh sau để giảm tốc độ.\nThực hiện quay đầu xe với tốc độ thấp."));
        arrayMeothi.add(new MeoThi("Phương tiện giao thông đường bộ","Gồm phương tiện giao thông đường bộ và xe máy chuyên dùng."));
        arrayMeothi.add(new MeoThi("Xe máy chuyên dùng","Gồm xe máy thi công, xe máy nông nghiệp, lâm nghiệp và các loại xe đặc " +
                "chủng khác sử dụng vào mục đích quốc phòng, an ninh."));
        arrayMeothi.add(new MeoThi("Hiệu lệnh người điều khiển giao thông",".Giơ tay thẳng đứng: Tất cả dừng, trừ xe đã ở trong ngã tư được phép đi\n" +
                ".Giang ngang tay: Trái phải đi, trước sau dừng\n.Tay phải giơ trước: Sau, phải dừng, trước rẽ phải, trái đi các hướng, người đi bộ qua đường " +
                "đi sau người điều khiển."));
        arrayMeothi.add(new MeoThi("Các quy tắc sa hình",".Thứ tự ưu tiên không vòng xuyến: Xe vào ngã ba, ngã tư trước - Xe ưu tiên - Đường ưu tiên - " +
                "Đường cùng cấp theo thứ tự bên phải trống - rẽ phải - đi thẳng - rẽ trái.\n.Giao nhau cùng cấp có vòng xuyến: Chưa vào vòng xuyến thì ưu tiên xe bên phải; " +
                "đã vào vòng xuyến ưu tiên từ bên trái tới.\n.Xe xuống dốc phải nhường đường cho xe đang lên dốc."));
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}