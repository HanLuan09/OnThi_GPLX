package com.example.btl.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.btl.adapter.BienBaoAdapter;
import com.example.btl.R;
import com.example.btl.model.BienBao;

import java.util.ArrayList;

public class BienHieuLenhFragment extends Fragment {
    private ListView lvBienhieulenh;
    private ArrayList<BienBao> arrayBienhieulenh;
    private BienBaoAdapter hieulenhAdapter;
    public BienHieuLenhFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_hieu_lenh, container, false);
    }
    public void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        Anhxa();
        hieulenhAdapter = new BienBaoAdapter(getActivity(), R.layout.dong_hoc_bien_bao,arrayBienhieulenh);
        lvBienhieulenh.setAdapter(hieulenhAdapter);
    }

    private void Anhxa() {
        lvBienhieulenh = getActivity().findViewById(R.id.listViewBienhieulenh);
        arrayBienhieulenh = new ArrayList<>();
        arrayBienhieulenh.add(new BienBao("Hướng đi phải theo",
                "Để thông báo các xe chỉ được đi thẳng.",
                R.raw.bienhieulenh301a));
        arrayBienhieulenh.add(new BienBao("Hướng đi phải theo",
                "Để thông báo hiệu lệnh các xe chỉ được rẽ phải.",
                R.raw.bienhieulenh301b));
        arrayBienhieulenh.add(new BienBao("Hướng đi phải theo",
                "Để thông báo hiệu lệnh các xe chỉ được rẽ trái.",
                R.raw.bienhieulenh301c));
//        arrayBienhieulenh.add(new BienBao("","", R.raw.bienhieulenh301b));
        arrayBienhieulenh.add(new BienBao("Nơi giao nhau chạy theo vòng xuyến",
                "Để báo cho các loại xe (thô sơ và cơ giới) phải chạy vòng theo đảm bảo an toàn" +
                " ở nơi đường giao nhau. Biển có hiệu lực bắt buộc các loại xe muốn chuyển hướng " +
                        "phải chạy vòng theo đảm bảo an toàn theo hướng mũi tên.",
                R.raw.bienhieulenh303));
        arrayBienhieulenh.add(new BienBao("Đường dành cho xe thô sơ",
                "Để báo đường chỉ dành cho xe thô sơ (kể cả xe của người tàn tật) và người đi bộ.",
                R.raw.bienhieulenh304));
        arrayBienhieulenh.add(new BienBao("Đường dành cho người đi bộ",
                "Để báo đường chỉ dành cho người đi bộ. Biển có hiệu lực băt buộc người đi bộ phải dùng đường dành riêng này để đi." +
                " các loại xe cơ giới và thô sơ (trừ xe đạp và xe lăn của người tàn tật), kể cả xe ưu tiên không được phép đi vào đường này.",
                R.raw.bienhieulenh305));
        arrayBienhieulenh.add(new BienBao("Tốc độ tối thiểu cho phép",
                "Để báo tốc độ tối thiểu cho phép các xe cơ giơi chạy. Biển có hiệu lực bắt buộc xe cơ giới vận hành với tốc độ không " +
                "nhỏ hơn trị số ghi trên biển trong điều kiện giao thông thuận lợi và an toàn.",
                R.raw.bienhieulenh306));
        arrayBienhieulenh.add(new BienBao("Hết hạn chế tốc độ tối thiểu",
                "Để báo hết hiệu lực tốc độ tối thiểu cho phép. Kể từ biển này các xe được phép " +
                "chạy chậm hơn trị số ghi trên biển nhưng không được gây cản trở các xe khác.",
                R.raw.bienhieulenh307));
        arrayBienhieulenh.add(new BienBao("Tuyến đường cầu vượt cắt qua",
                "Biển phía trước có cầu vượt, xe có thể đi thẳng hoặc theo chỉ dẩn trên hình vẽ.",
                R.raw.bienhieulenh308a));
        arrayBienhieulenh.add(new BienBao("Ấn còi",
                "Biển thị xe cộ đi đến vị trí cắm biển đó thì phải ấn còi.",
                R.raw.bienhieulenh309));
    }
}