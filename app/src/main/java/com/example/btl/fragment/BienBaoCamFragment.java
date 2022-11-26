package com.example.btl.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.widget.ListView;

import com.example.btl.adapter.BienBaoAdapter;
import com.example.btl.R;
import com.example.btl.model.BienBao;

import java.util.ArrayList;


public class BienBaoCamFragment extends Fragment {
    private ListView lvBienbaocam;
    private ArrayList<BienBao> arrayBienbaocam;
    private BienBaoAdapter baocamAdapter;

    public BienBaoCamFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_bao_cam, container, false);
    }
    @Override
    public void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        Anhxa();
        baocamAdapter = new BienBaoAdapter(getActivity(), R.layout.dong_hoc_bien_bao, arrayBienbaocam);
        lvBienbaocam.setAdapter(baocamAdapter);
    }

    private void Anhxa() {
        lvBienbaocam = (ListView) getActivity().findViewById(R.id.listViewBienbaocam);
        arrayBienbaocam = new ArrayList<>();
        arrayBienbaocam.add(new BienBao("Cấm quay đầu xe",
                "Để báo cấm các loại xe quay đầu(theo kiểu chữ U)" +
                ". Chiều mũi tên phù hợp với chiều quay đầu xe" +
                ". Biển không có giá trị cấm rẽ trái để đi sang hướng đường khác.",
                R.raw.camquaydauxe));
        arrayBienbaocam.add(new BienBao("Biển báo Cấm xe ô tô và xe máy",
                "Để báo cấm các loại xe cơ giới và xe máy đi vào," +
                " ngoại trừ xe gắn máy và xe ưu tiên theo quy định.",
                R.raw.camxeotvaxemay));
        arrayBienbaocam.add(new BienBao("Biển báo đường cấm",
                "Để báo cấm các loại phương tiện di chuyển cả 2 hướng " +
                "(ngoại trừ xe ưu tiên theo quy định).",
                R.raw.duongcam));
        arrayBienbaocam.add(new BienBao("Biển báo Cấm đi ngược chiều",
                "Để báo cấm các loại phương tiện đi vào chiều đặt biển " +
                "(ngoại trừ xe ưu tiên theo quy định).",
                R.raw.biencamdinguocchieu));
        arrayBienbaocam.add(new BienBao("Biển báo cấm rẽ trái",
                "Để báo cấm rẽ trái ở những vị trí đường giao nhau.\n" +
                "Biển không có giá trị cấm quay đầu xe.\n" +
                "Biển có hiệu lực cấm các loại xe(cơ giới và thô sơ) rẽ sang phía trái trừ các xe được ưu tiên treo quy định.",
                R.raw.camretrai));
        arrayBienbaocam.add(new BienBao("Biển báo cấm rẽ phải",
                "Để báo cấm rẽ phải ở những vị trí đường giao nhau.\n" +
                "Biển không có giá trị cấm quay đầu xe.\n" +
                "Biển có hiệu lực cấm các loại xe(cơ giới và thô sơ) rẽ sang phía phải trừ các xe được ưu tiên treo quy định.",
                R.raw.camrephai));
        arrayBienbaocam.add(new BienBao("Biển báo cấm rẽ trái và quay đầu xe",
                "Để báo cấm các loại xe rẽ trái " +
                "đồng thời cấm quay đầu xe.",
                R.raw.camretraivaquaydauxe));
        arrayBienbaocam.add(new BienBao("Biển báo cấm rẽ phải và quay đầu xe",
                "Để báo cấm các loại xe rẽ phải đồng thời cấm quay đầu xe.",
                R.raw.camrephaivaquaydauxe));
        arrayBienbaocam.add(new BienBao("Biển báo cấm vượt",
                "Để báo cấm các loại xe cơ giới vượi nhau.\n" +
                "Biển có hiệu lực cấm tất cả các loại xe cơ giới vượt nhau(kể cả xe được ưu tiên theo quy định) " +
                "nhưng được phép vượi xe máy 2 bánh, xe gắn máy.",
                R.raw.camvuot));
        arrayBienbaocam.add(new BienBao("Biển báo tốc độ tối đa cho phép",
                "Để báo tốc độ tối đa cho phép các xe cơ giới chạy.",
                R.raw.tocdotoidachophep));
        arrayBienbaocam.add(new BienBao("Biển báo tốc độ tối đa cho phép về đêm",
                "Khi cần phải quy định tốc độ tối đa" +
                "về ban đêm cho các phương tiện.",
                R.raw.tocdotoidachophepvaobandem));
        arrayBienbaocam.add(new BienBao("Biển báo cấm sử dụng còi",
                "Để báo cấm các loại xe sử dụng còi.",
                R.raw.camsudungcoi));
        arrayBienbaocam.add(new BienBao("Biển báo cấm dừng và đỗ xe",
                "Để báo nơi cấm dừng và đỗ xe.",
                R.raw.camdungvadoxe));
        arrayBienbaocam.add(new BienBao("Biển báo đỗ xe",
                "Để báo nơi cấm đỗ xe trừ các xe được ưu tiên theo quy định.\n" +
                "Biển có hiệu lực cấm các loại xe cơ giới đỗ ở phía đường có mặt biển.",
                R.raw.camdoxe));
        arrayBienbaocam.add(new BienBao("Biển báo hết cấm vượt",
                "Để báo hết đoạn đường cấm vượt.\n" +
                "Biển có tác dụng báo cho người tham gia giao thông được phép vượt nhưng phải theo quy định về điều kiện cho phép vượt nhau.",
                R.raw.hetcamvuot));
        arrayBienbaocam.add(new BienBao("Biển bóa hết hạn chế tốc độ tối đa",
                "Đến hết đoạn đường hạn chế tốc độ tối đa.",
                R.raw.hettocdotida1));
        arrayBienbaocam.add(new BienBao("Biển báo hết tất cả các lệnh cấm",
                "Đên hết đoạn đường mà nhiều biển báo cấm cùng hết hiệu lực.",
                R.raw.hettatcacaclenhcam));
    }
}