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

public class BienCanhBaoFragment extends Fragment {
    private ListView lvBiencanhbao;
    private ArrayList<BienBao> arrayBiencanhbao;
    private BienBaoAdapter canhbaoAdapter;

    public BienCanhBaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_canh_bao, container, false);
    }
    public void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        Anhxa();
        canhbaoAdapter = new BienBaoAdapter(getActivity(), R.layout.dong_hoc_bien_bao,arrayBiencanhbao);
        lvBiencanhbao.setAdapter(canhbaoAdapter);
    }

    private void Anhxa() {
        lvBiencanhbao = (ListView) getActivity().findViewById(R.id.listViewBiencanhbao);
        arrayBiencanhbao = new ArrayList<>();
        arrayBiencanhbao .add(new BienBao("Chỗ ngoặt nguy hiểm bên trái","Để cảnh báo các loại phía trước có đoạn rẽ," +
                " lưu ý giảm tốc.", R.raw.canthanretrai));

        arrayBiencanhbao .add(new BienBao("Chỗ ngoặt nguy hiểm bên phải","Để cảnh báo các loại phía trước có đoạn rẽ," +
                " lưu ý giảm tốc.", R.raw.canthanrephai));

        arrayBiencanhbao .add(new BienBao("Đường đi hẹp cả hai bên","Để cảnh báo các loại phương tiện di chuyển tới " +
                "đằng trước đường bị thu hẹp.",R.raw.canthanduongthuhep));

        arrayBiencanhbao .add(new BienBao("Đường bị hẹp bên trái","Để cảnh báo các loại phương tiện đang lưu thông " +
                "bên trái đường bị thu hẹp.",R.raw.canthanduongthuhepbentrai));

        arrayBiencanhbao .add(new BienBao("Đường bị hẹp bên phải","Để cảnh báo các loại phương tiện đang lưu thông " +
                "bên phai đường bị thu hẹp.",R.raw.canthanduongthuhepbenphai));

        arrayBiencanhbao .add(new BienBao("Đường hai chiều","Để cảnh báo đoạn đường tiếp theo có 2 làn xe chạy ngược chiều."
                ,R.raw.duonghaichieu));

        arrayBiencanhbao .add(new BienBao("Giao nhau theo vòng xuyến","Để cảnh báo phía trước có vòng xuyến.\n" +
                "Lưu ý bật xi nhan trái khi đi vào vòng xuyến.\n",R.raw.vongxuyen));

        arrayBiencanhbao .add(new BienBao("Giao nhau với đường ưu tiên","Để cảnh báo phía trước giao nhau với đường ưu tiên.\n" +
                "Lưu ý nhường đường cho mọi phương tiện di chuyển trên đường ưu tiên.\n",R.raw.giaonhauvoiduonguutien));

        arrayBiencanhbao .add(new BienBao("Giao nhau với đường không ưu tiên","Để cảnh báo phía trước giao nhau với đường không ưu tiên.\n" +
                "Lưu ý giảm tốc để tránh va chạm.\n",R.raw.giaonhauvoiduongkhonguutien));

        arrayBiencanhbao .add(new BienBao("Đoạn giao nhau không ưu tiên","Để cảnh báo phía trước có đoạn giao, \n" +
                "Lưu ý giảm tốc để tránh va chạm.\n",R.raw.doangiaokhonguutien));

        arrayBiencanhbao .add(new BienBao("Giao nhau có tín hiệu đèn","Để cảnh báo phía trước là đoạn giao nhau có đèn tín hiệu.\n" +
                "Lưu ý cần đề ý theo hiệu lệnh của đèn.\n"
                +"xanh đi, đỏ dừng, vàng giảm tốc. ",R.raw.canhbaodengiaothong));

        arrayBiencanhbao .add(new BienBao("Giao nhau với đường sắt có rào chắn","Để cảnh báo phía trước có đường tàu hỏa và có rào chắn.\n" +
                "Lưu ý giảm tốc, chú ý tín hiệu đèn cảnh báo hoặc nhân viên tàu.\n",R.raw.canhbaoraochantau));

        arrayBiencanhbao .add(new BienBao("Giao nhau với đường sắt không có rào chắn","Để cảnh báo phía trước có đường tàu hỏa và không có rào chắn.\n" +
                "Lưu ý giảm tốc, chú ý xem tàu hỏa đến chưa.\n",R.raw.canhbaocotauhoa));

        arrayBiencanhbao .add(new BienBao("Có cầu hẹp","Để cảnh báo phía trước có cầu bị thu hẹp so với đường đang đi.\n" +
                "Lưu ý giảm tốc, nhường đường cho xe khác nếu cần thiết.\n",R.raw.cauhep));

        arrayBiencanhbao .add(new BienBao("Có cầu tạm","Để cảnh báo phía trước có cầu bị tạm thời.\n" +
                "Lưu ý giảm tốc, đề phòng cầu bị gỡ.\n",R.raw.cautam));

        arrayBiencanhbao .add(new BienBao("Có cầu hẹp","Để cảnh báo phía trước có cầu bị thu hẹp so với đường đang đi.\n" +
                "Lưu ý giảm tốc, nhường đường cho xe khác nếu cần thiết.\n",R.raw.cauhep));

        arrayBiencanhbao .add(new BienBao("Có cầu cất","Để cảnh báo phía trước có cầu bị cất, \n" +
                "lưu ý giảm tốc để phòng cầu bị cất lên\n",R.raw.caunang));
    }
}