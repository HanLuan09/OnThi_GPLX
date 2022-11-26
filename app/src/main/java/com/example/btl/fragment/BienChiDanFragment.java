package com.example.btl.fragment;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.btl.adapter.BienBaoAdapter;
import com.example.btl.R;
import com.example.btl.model.BienBao;

import java.util.ArrayList;

public class BienChiDanFragment extends Fragment {
    private ListView lvBienchidan;
    private ArrayList<BienBao> arrayBienchidan;
    private BienBaoAdapter chidanAdapter;

    public BienChiDanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_chi_dan, container, false);
    }
    public void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        Anhxa();
        chidanAdapter = new BienBaoAdapter(getActivity(), R.layout.dong_hoc_bien_bao,arrayBienchidan);
        lvBienchidan.setAdapter(chidanAdapter);
    }

    private void Anhxa() {
        lvBienchidan = (ListView) getActivity().findViewById(R.id.listViewBienchidan);
        arrayBienchidan = new ArrayList<>();
        arrayBienchidan.add(new BienBao("Bắt đầu đường ưu tiên",
                "Biểu thị ưu tiên cho các phương tiện trên đường trên đường có mặt biển này được đi trước.",
                R.raw.batdauduonguutien));
        arrayBienchidan.add(new BienBao("Hết đoạn đường ưu tiên",
                "Biểu thị hết đoạn đường quy định là ưu tiên.",
                R.raw.hetduonguutien));
        arrayBienchidan.add(new BienBao("Đường một chiều",
                "Chỉ dẫn những đoạn đường chạy một chiều.",
                R.raw.duong1chieu));
        arrayBienchidan.add(new BienBao("Đường cụt",
                "Chỉ dẫn phía trước là đường cụt.",
                R.raw.duongcut));
        arrayBienchidan.add(new BienBao("Được ưu tiên qua đường hẹp",
                "Chỉ dẫn cho người tham gia giao thông cơ giới biết mình được quyền ưu tiên đi trước trên đoạn đường hẹp.",
                R.raw.uutienquaduonghep));
        arrayBienchidan.add(new BienBao("Khu vực quay xe",
                "Chỉ dẫn khu vực được phép quay đầu xe.",
                R.raw.choduocquayxe));
        arrayBienchidan.add(new BienBao("Cầu vượt qua đường cho người đi bộ",
                "Chỉ dẫn cho người đi bộ sử dụng cầu vượt qua đường.",
                R.raw.cauvuot));
        arrayBienchidan.add(new BienBao("Hầm chui qua đường cho người đi bộ",
                "Chỉ dẫn cho người đi bộ sử dụng hầm chui qua đường",
                R.raw.hambo));
        arrayBienchidan.add(new BienBao("Vị trí người đi bộ sang ngang",
                "Chỉ dẫn cho người đi bộ và người lái xe biết nơi dành cho người đi bộ sang ngang. " +
                        "Gặp biển này người lái xe phải ưu tiên cho người đi bộ sang ngang.",
                R.raw.duongdanhchonguoidibosangngang));
        arrayBienchidan.add(new BienBao("Chỉ hướng đường",
                "Chỉ dẫn hướng đường đến các địa danh, khu dân cư.",
                R.raw.chihuongduong));
        arrayBienchidan.add(new BienBao("Rẽ ra đường có làn đường dành cho ô tô khách",
                "Chỉ dẫn cho người lái xe biết ở ngã ba, ngã tư rẽ phải là rẽ ra đường có làn đường dành cho ôtô khách.",
                R.raw.reranancoduongdanhchoxekhach));
        arrayBienchidan.add(new BienBao("Chỉ dẫn địa giới",
                "Chỉ dẫn địa giới hành chính giữa các thành phố, tỉnh, huyện. Đặt trên các tuyến đường quốc lộ, đường tỉnh.",
                R.raw.diaphan));
        arrayBienchidan.add(new BienBao("Di tích lịch sử",
                "Chỉ dẫn những nơi có danh lam thắng cảnh, những nơi có thể tham quan v.v... ở hai ven đường.",
                R.raw.ditichlichsu));
//        arrayBienchidan.add(new BienBao("","", R.raw.camxeotvaxemay));
        arrayBienchidan.add(new BienBao("Trạm cấp cứu",
                "Chỉ dẫn những chỗ có trạm cấp cứu y tế ở gần đường.",
                R.raw.tramcapcuu));
        arrayBienchidan.add(new BienBao("Cửa hàng xăng dầu",
                "Chỉ dẫn những nơi có đặt trạm kinh doanh xăng dầu phục vụ cho xe cộ đi trên đường.",
                R.raw.tramcungcapxangdau));
    }
}