package com.example.btl.fragment;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.btl.R;
import com.example.btl.adapter.OnThiAdapter;
import com.example.btl.model.OnTap;
import java.util.ArrayList;

public class LythuyetBienbaoFragment extends Fragment {
    private ListView lvCauhoiBienbao;
    private ArrayList<OnTap> arrayBienbao;
    private OnThiAdapter bienBaoAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lythuyet_bienbao, container, false);
    }
    @MainThread
    @CallSuper
    public void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        Anhxa();
        bienBaoAdapter = new OnThiAdapter(getActivity(), R.layout.dong_on_tap, arrayBienbao);
        lvCauhoiBienbao.setAdapter(bienBaoAdapter);
    }

    private void Anhxa() {
        lvCauhoiBienbao = getActivity().findViewById(R.id.listViewCauhoiBienbao);
        arrayBienbao = new ArrayList<>();
        arrayBienbao.add(new OnTap("Câu hỏi 39: Biển báo hiệu có dạng hình tròn, viền đỏ, nền trắng, trên nền có hình vẽ hoặc chữ số, chữ viết màu đen là loại biển gì dưới đây?\n",
                "1. Biển báo nguy hiểm.\n",
                "2. Biển báo cấm.\n",
                "3. Biển báo hiệu lệnh.\n",
                "4. Biển báo chỉ dẫn.\n",
                "Đáp án: Biển báo cấm",
                "Giải thích: Biển cấm: vòng tròn đỏ.",
                R.raw.biencau39));
        arrayBienbao.add(new OnTap("Câu hỏi 40: Biển báo hiệu có dạng tam giác đều, viền đỏ, nền màu vàng, trên có hình vẽ màu đen là loại biển gì dưới đây?\n",
                "1. Biển báo nguy hiểm.\n",
                "2. Biển báo cấm.\n",
                "3. Biển báo hiệu lệnh.\n",
                "4. Biển báo chỉ dẫn.\n",
                "Đáp án: Biển báo nguy hiểm\n",
                "Giải thích: Biển nguy hiểm: Hình tam giác vàng.\n",
                R.raw.biencau40));
        arrayBienbao.add(new OnTap("Câu hỏi 41: Biển báo hiệu hình tròn có nền xanh lam có hình vẽ màu trắng là loại biển gì dưới đây?",
                "1. Biển báo nguy hiểm.\n",
                "2. Biển báo cấm.\n",
                "3. Biển báo hiệu lệnh phải thi hành.\n",
                "4. Biển báo chỉ dẫn.\n",
                "Đáp án: Biển báo hiệu lệnh phải thi hành.\n",
                "Giải thích: Biển hiệu lệnh: Vòng tròn xanh.\n",
                R.raw.biencau41));
        arrayBienbao.add(new OnTap("Câu hỏi 42: Biển báo hiệu hình chữ nhật hoặc hình vuông hoặc hình mũi tên nền xanh lam là loại biển gì dưới đây?\n" ,
                "1. Biển báo nguy hiểm.\n",
                "2. Biển báo cấm.\n",
                "3. Biển báo hiệu lệnh phải thi hành.\n",
                "4. Biển báo chỉ dẫn.\n",
                "Đáp án: Biển báo chỉ dẫn.\n",
                "Giải thích: Biển chỉ dẫn: Hình vuông hoặc hình chữ nhật xanh.\n",
                R.raw.biencau42));
        arrayBienbao.add(new OnTap("Câu hỏi 101: Biển nào dưới đây xe gắn máy được phép đi vào?" ,
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Cả hai biển.\n",
                "Giải thích: Biển 1 “Cấm mô tô” và biển 2 “Cấm ô tô” không cấm xe gắn máy (không phải mô tô). Nên cả 2 biển đều cho phép xe gắn máy đi vào.\n",
                R.raw.biencau101));
        arrayBienbao.add(new OnTap("Câu hỏi 102: Biển nào báo hiệu cấm xe mô tô hai bánh đi vào?" ,
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1 “Cấm mô tô”.\n",
                R.raw.biencau102));
        arrayBienbao.add(new OnTap("Câu hỏi 103: Biển nào thì xe mô tô hai bánh được đi vào?" ,
                "1. Không biển nào.\n",
                "2. Biển 1 và 2.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển",
                "Đáp án: Biển 2 và 3.\n",
                "Giải thích: Biển 2 “Cấm ô tô” và biển 3 “Cấm xe tải”.\n",
                R.raw.biencau103));
        arrayBienbao.add(new OnTap("Câu hỏi 104: Biển nào cấm quay đầu xe?\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Không biển nào.\n",
                "4. Cả hai biển",
                "Đáp án: Biển 2.\n",
                "Giải thích: Biển 1 “Cấm rẽ trái” không cấm quay đầu xe; Biển 2 “Cấm quay xe” không cấm rẽ trái..\n",
                R.raw.biencau104));
        arrayBienbao.add(new OnTap("Câu hỏi 105: Biển nào cấm xe rẽ trái?\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1 “Cấm rẽ trái” không cấm quay đầu xe; Biển 2 “Cấm quay xe” không cấm rẽ trái..\n",
                R.raw.biencau105));
        arrayBienbao.add(new OnTap("Câu hỏi 106: Khi gặp biển nào xe được rẽ trái?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Không biển nào.\n",
                null,
                "Đáp án: Biển 2.\n",
                "Giải thích: Biển 1 “Cấm rẽ trái” không cấm quay đầu xe; Biển 2 “Cấm quay xe” không cấm rẽ trái..\n",
                R.raw.biencau106));
        arrayBienbao.add(new OnTap("Câu hỏi 107: Biển nào cấm các phương tiện giao thông đường bộ rẽ phải?",
                "1. Biển 1 và 2.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển\n",
                "Đáp án: Biển 1 và 2.\n",
                "Giải thích: Biển 1 “Cấm rẽ phải”; Biển 2 “Cấm rẽ phải và cấm quay xe”; Biển 3 “cấm ô tô rẽ phải và quay xe”\n",
                R.raw.biencau107));
        arrayBienbao.add(new OnTap("Câu hỏi 108: Biển nào cấm các phương tiện giao thông đường bộ rẽ trái?",
                "1. Biển 1 và 2.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển\n",
                "Đáp án: Biển 1 và 2.\n",
                "Giải thích: Biển 1 “Cấm rẽ trái”; Biển 2 “Cấm rẽ trái và cấm quay xe”; Biển 3 “cấm ô tô rẽ trái và quay xe”\n",
                R.raw.biencau108));
        arrayBienbao.add(new OnTap("Câu hỏi 109: Biển nào cho phép xe rẽ trái?\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Không biển nào.\n",
                null,
                "Đáp án: Biển 2.\n",
                "Giải thích: Theo QCVN41:2019 thì Biển 2 “Khu vực quay xe” chỉ dẫn khu vưc được phép quay đầu xe. Biển này thuộc nhóm biển chỉ dẫn nên KHÔNG cấm rẽ trái. Do đó, đáp án đúng là Biển 2. ",
                R.raw.biencau109));
        arrayBienbao.add(new OnTap("Câu hỏi 110: Biển nào xe được phép quay đầu nhưng không được rẽ trái?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1 “cấm rẽ trái” không cấm quay đầu xe; Biển 2 “Khu vực quay xe” . Nên cả 2 biển cho phép quay đầu xe là đáp án đúng.",
                R.raw.biencau110));
        arrayBienbao.add(new OnTap("Câu hỏi 111: Biển nào xe được phép quay đầu nhưng không được rẽ trái ?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1 “cấm rẽ trái” nhưng không cấm quay đầu xe. Biển 2 đặt trước ngã ba ngã tư chỉ được rẽ trái ở phạm vi ngã ba, ngã tư phía sau mặt biển nên không thể quay đầu xe.",
                R.raw.biencau111));
        arrayBienbao.add(new OnTap("Câu hỏi 112: Biển nào là biển “Cấm đi ngược chiều”?\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1 “Đường cấm”; Biển 2 “cấm đi ngược chiều”; Biển 3 “Cấm đỗ xe”. Nên biển 2 là cấm đi ngược chiều.",
                R.raw.biencau112));
        arrayBienbao.add(new OnTap("Câu hỏi 113: Biển nào dưới đây các phương tiện không được phép đi vào?" +
                "\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 1 và 2.\n",
                null,
                "Đáp án: Biển 1 và 2.\n",
                "Giải thích: Biển 1 “Đường cấm”;\n" +
                        "\n" +
                        "Biển 2 “Cấm đi ngược chiều” cấm đi vào theo chiều đặt biển;\n" +
                        "\n" +
                        "Biển 3 “Cấm đỗ xe”.\n" +
                        "\n" +
                        "Nên biển 1 và biển 2 là cấm các phương tiện không được phép đi vào.\n" +
                        "\n",
                R.raw.biencau113));
        arrayBienbao.add(new OnTap("Câu hỏi 114: Khi gặp biển nào xe ưu tiên theo luật định vẫn phải dừng lại?" +
                "\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả ba biển.\n",
                null,
                "Đáp án: Biển 2.\n",
                "Giải thích: Biển 1 “Đường cấm” không cấm xe ưu tiên;\n" +
                        "\n" +
                        "Biển 2 “Dừng lại” áp dụng với cả xe ưu tiên;\n" +
                        "\n" +
                        "Biển 3 “Cấm đi ngược chiều” không áp dụng với xe ưu tiên;",
                R.raw.biencau114));
        arrayBienbao.add(new OnTap("Câu hỏi 115: Biển nào cấm tất cả các loại xe cơ giới và thô sơ đi lại trên đường, trừ xe ưu tiên theo luật định (nếu đường vẫn cho xe chạy được)?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1 “Đường cấm” không cấm xe ưu tiên;\n" +
                        "\n" +
                        "Biển 2 “Dừng lại” áp dụng với cả xe ưu tiên;\n" +
                        "\n" +
                        "Nên biển 1 là đáp án đúng.",
                R.raw.biencau115));
        arrayBienbao.add(new OnTap("Câu hỏi 116: Gặp biển nào xe xích lô được phép đi vào?\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Biển 1 và 2",
                "Đáp án: Biển 1 và 2.\n",
                "Giải thích: Biển 3 cấm xích lô; Biển 1 và 2 không cấm xích lô",
                R.raw.biencau116));
        arrayBienbao.add(new OnTap("Câu hỏi 117: Gặp biển nào xe lam, xe xích lô máy được phép đi vào?" +
                "\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 3.\n",
                "Giải thích: Biển 1 cấm xe lam; Biển 2 cấm xe xích lô máy; Biển 3 cấm xe xích lô.",
                R.raw.biencau117));
        arrayBienbao.add(new OnTap("Câu hỏi 118: Biển báo này có ý nghĩa như thế nào?" +
                "\n",
                "1. Tốc độ tối đa cho phép về ban đêm cho các phương tiện là 70 km/h.\n",
                "2. Tốc độ tối thiểu cho phép về ban đêm cho các phương tiện là 70 km/h.\n",
                null,
                null,
                "Đáp án: Tốc độ tối đa cho phép về ban đêm cho các phương tiện là 70 km/h.\n",
                "Giải thích: Biển phụ chỉ phạm vi tác dụng biển, biển viền đỏ trong trường hợp này hiểu là giới hạn tốc độ.",
                R.raw.biencau118));
        arrayBienbao.add(new OnTap("Câu hỏi 119: Chiều dài đoạn đường 500 m từ nơi đặt biển này, người lái xe có được phép bấm còi không?\n",
                "1. Được phép.\n",
                "2. Không được phép.\n",
                null,
                null,
                "Đáp án: Không được phép.\n",
                "Giải thích: Biển phụ là biển S.501 “Phạm vi tác dụng của biển” xác định chiều dài áp dụng biển chính từ nơi đặt biển.",
                R.raw.biencau119));
        arrayBienbao.add(new OnTap("Câu hỏi 120: Biển nào xe mô tô hai bánh được đi vào?\n",
                "1. Biền 1 và 2.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                null,
                "Đáp án: Biển 1 và 3.\n",
                "Giải thích: Biển chính là P.101 “Đường cấm”, có biển phụ thì áp dụng cấm theo biển phụ. Nên Biển 1 và Biển 3 không áp dụng với xe mô tô là câu trả lời đúng.\n",
                R.raw.biencau120));
        arrayBienbao.add(new OnTap("Câu hỏi 121: Biển nào xe mô tô hai bánh không được đi vào?",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 2.\n",
                "Giải thích: Biển chính là P.101 “Đường cấm”, có biển phụ thì áp dụng cấm theo biển phụ. Nên Biển 2 áp dụng với xe mô tô là câu trả lời đúng.",
                R.raw.biencau121));
        arrayBienbao.add(new OnTap("Câu hỏi 122: Biển báo nào báo hiệu bắt đầu đoạn đường vào phạm vi khu dân cư, các phương tiện tham gia giao thông phải tuân theo các quy định đi đường được áp dụng ở khu đông dân cư?",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                null,
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1 báo hiệu đến khu dân cư; Biển 2 báo hiệu hết khu dân cư.",
                R.raw.biencau122));
        arrayBienbao.add(new OnTap("Câu hỏi 123: Gặp biển nào người lái xe phải nhường đường cho người đi bộ ?\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Biển 1 và 3.\n",
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1: W.224 “Đường người đi bộ cắt ngang”;\n" +
                        "\n" +
                        "Biển 2: P.112 “Cấm người đi bộ”; Biển 3: R.305 “Đường dành cho người đi bộ”.",
                R.raw.biencau123));
        arrayBienbao.add(new OnTap("Câu hỏi 124: Biển nào chỉ đường dành cho người đi bộ, các loại xe không được đi vào khi gặp biển này?",
                "1. Biền 1.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 3.\n",
                "Giải thích: Biển 1: W.224 “Đường người đi bộ cắt ngang”;\n" +
                        "\n" +
                        "Biển 2: P.112 “Cấm người đi bộ”; Biển 3: R.305 “Đường dành cho người đi bộ”.\n" +
                        "\n" +
                        "Biển 3 báo đường dành cho người đi bộ nên phương tiện khác không được đi vào.\n" +
                        "\n",
                R.raw.biencau124));
        arrayBienbao.add(new OnTap("Câu hỏi 125: Biển nào báo hiệu “Đường dành cho xe thô sơ”?\n" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 1.\n",
                null,
                R.raw.biencau125));
        arrayBienbao.add(new OnTap("Câu hỏi 126: Biển nào báo hiệu sắp đến chỗ giao nhau nguy hiểm?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 1 và 2.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Cả ba biển.\n",
                "Giải thích: Biển 1: W.210 “Giao nhau với đường sắt có rào chắn”; Biển : W.208 “Giao nhau với đường ưu tiên”; Biển 3: W209 “Giao nhau có tín hiệu đèn”",
                R.raw.cau126));
        arrayBienbao.add(new OnTap("Câu hỏi 127: Biển nào báo hiệu “Giao nhau với đường sắt có rào chắn”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2 và 3.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1: W.210 “Giao nhau với đường sắt có rào chắn”; Biển : W.208 “Giao nhau với đường ưu tiên”; Biển 3: W209 “Giao nhau có tín hiệu đèn”",
                R.raw.cau127));
        arrayBienbao.add(new OnTap("Câu hỏi 128: Biển nào báo hiệu “Giao nhau với tín hiệu đèn”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 3.\n",
                "Giải thích: Biển 1: W.210 “Giao nhau với đường sắt có rào chắn”; Biển : W.208 “Giao nhau với đường ưu tiên”; Biển 3: W209 “Giao nhau có tín hiệu đèn”",
                R.raw.cau128));
        arrayBienbao.add(new OnTap("Câu hỏi 129: Biển nào báo hiệu nguy hiểm giao nhau với đường sắt?" +
                "\n",
                "1. Biền 1 và 2.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 1 và 3.\n",
                "Giải thích: Biển 1: W.210 “Giao nhau với đường sắt có rào chắn”; Biển 2: W.234 “Giao nhau với đường 2 chiều”; Biển 3: W.242a “Nơi đường sắt giao vuông gốc với đường bộ”.",
                R.raw.cau129));
        arrayBienbao.add(new OnTap("Câu hỏi 130: Biển nào báo hiệu đường sắt giao nhau với đường bộ không có rào chắn?" +
                "\n",
                "1. Biền 1 và 2.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 2 và 3.\n",
                "Giải thích: Biển 1: W.210 “Giao nhau với đường sắt có rào chắn”; Biển 2: W.211a “Giao nhau với đường sắt không có rào chắn”; Biển 3: W.242a “Nơi đường sắt giao vuông gốc với đường bộ” ổ sung cho biển W.211a. Nên cả 2 biển 2 và 3 đều đúng.",
                R.raw.biencau130));
        arrayBienbao.add(new OnTap("Câu hỏi 131: Biển nào báo hiệu sắp đến chỗ giao nhau giữa đường bộ và đường sắt?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Biển 1 và 3.\n",
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 211a Giao nhau với đường sắt không có rào chắn.\n" +
                        "\n" +
                        "Biển 2: Biển 208 Giao nhau với đường ưu tiên. \n" +
                        "\n" +
                        "Biển 3: Biển 211b Giao nhau với tàu điện.",
                R.raw.biencau131));
        arrayBienbao.add(new OnTap("Câu hỏi 132: Biển nào báo hiệu, chỉ dẫn xe đi trên đường này được quyền ưu tiên qua nơi giao nhau?" +
                "\n",
                "1. Biền 1 và 2.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 1 và 3.\n",
                "Giải thích: Biển 1: W.207a “Giao nhau với đường không ưu tiên”;\n" +
                        "\n" +
                        "Biển 2: W.208 “Giao nhau với đường ưu tiên”;\n" +
                        "\n" +
                        "Biển 3: I.401 “Bắt đầu đường ưu tiên”. Nên biến 1 và Biển 3 là đáp án đúng.",
                R.raw.cau132));
        arrayBienbao.add(new OnTap("Câu hỏi 133: Biển nào báo hiệu “Giao nhau với đường không ưu tiên”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Biển 2 và 3.\n",
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1: W.207a “Giao nhau với đường không ưu tiên”;\n" +
                        "\n" +
                        "Biển 2: W.208 “Giao nhau với đường ưu tiên”;\n" +
                        "\n" +
                        "Biển 3: I.401 “Bắt đầu đường ưu tiên”.",
                R.raw.cau133));
        arrayBienbao.add(new OnTap("Câu hỏi 134: Biển nào báo hiệu “Giao nhau với đường ưu tiên”?" +
                "\n",
                "1. Biền 1 và 3.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 2.\n",
                "Giải thích: Biển 1: W.207a “Giao nhau với đường không ưu tiên”;\n" +
                        "\n" +
                        "Biển 2: W.208 “Giao nhau với đường ưu tiên”;\n" +
                        "\n" +
                        "Biển 3: I.401 “Bắt đầu đường ưu tiên”.",
                R.raw.cau134));
        arrayBienbao.add(new OnTap("Câu hỏi 135: Biển nào báo hiệu “Đường bị thu hẹp”?" +
                "\n",
                "1. Biền 1 và 2.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển",
                "Đáp án: Biển 1 và 2.\n",
                "Giải thích: Biển 1:W.203a “Đường bị hép cả 2 bên”;\n" +
                        "\n" +
                        "Biển 2: W.203b “Đường bị hẹp về phía trái”\n" +
                        "\n" +
                        "Biển 3: W.201b “Chỗ ngoặt nguy hiểm vòng bên phải”. Nên đáp án đúng là biển 1 và biển 2.",
                R.raw.biencau135));
        arrayBienbao.add(new OnTap("Câu hỏi 136: Khi gặp biển nào, người lái xe phải giảm tốc độ, chú ý xe đi ngược chiều, xe đi ở phía đường bị hẹp phải nhường đường cho xe đi ngược chiều?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 1 và 3.\n",
                "3. Biển 2 và 3.\n",
                "4. Cả ba biển",
                "Đáp án: Biển 2 và 3.\n",
                "Giải thích: Biển 1: W.236 “Hết đường đôi; Biển 2:W.203b ‘Đường đi bị hẹp về phía trái”; Biển 2: W.203c “Đường bị hẹp về phía phải”. Câu này hỏi về việc đường bị thu hẹp nên câu tả lời đúng là Biển 2 và Biển 3.\n" +
                        "\n",
                R.raw.biencau136));
        arrayBienbao.add(new OnTap("Câu hỏi 137: Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1: W.205a “Đường giao nhau cùng cấp; Biển 2: W.207a “Giao nhauvới đường không ưu tiên”; Biển 3: W.208 “Giao nhau với đường ưu tiên”.",
                R.raw.cau137));
        arrayBienbao.add(new OnTap("Câu hỏi 138: Biển nào báo hiệu “Đường đôi”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 2.\n",
                null,
                R.raw.cau138));
        arrayBienbao.add(new OnTap("Câu hỏi 139: Biển nào báo hiệu “Đường đôi”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 3.\n",
                null,
                R.raw.cau139));
        arrayBienbao.add(new OnTap("Câu hỏi 140: Biển nào báo hiệu “Giao nhau với đường hai chiều”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 1.\n",
                null,
                R.raw.cau140));
        arrayBienbao.add(new OnTap("Câu hỏi 141: Biển nào báo hiệu “Đường hai chiều”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 2.\n",
                null,
                R.raw.biencau141));
        arrayBienbao.add(new OnTap("Câu hỏi 142: Biển nào báo hiệu “Giao nhau với đường hai chiều”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 2.\n",
                null,
                R.raw.biencau142));
        arrayBienbao.add(new OnTap("Câu hỏi 143: Biển nào báo hiệu “Chú ý chướng ngại vật”?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2 và 3.\n",
                "3. Cả ba biển.\n",
                null,
                "Đáp án: Biển 2 và 3.\n",
                null,
                R.raw.biencau143));
        arrayBienbao.add(new OnTap("Câu hỏi 144: Gặp biển nào người tham gia giao thông phải đi chậm và thận trọng đề phòng khả năng xuất hiện và di chuyển bất ngờ của trẻ em trên mặt đường?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                null,
                null,
                "Đáp án: Biển 2.\n",
                null,
                R.raw.biencau144));
        arrayBienbao.add(new OnTap("Câu hỏi 145: Biển nào chỉ dẫn nơi bắt đầu đoạn đường dành cho người đi bộ?" +
                "\n",
                "1. Biền 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 2.\n",
                "Giải thích: W.224 “Đường người đi bộ cắt ngang”;\n" +
                        "\n" +
                        "Biển 2: I.423c “Điểm bắt đầu đường đi bộ”\n" +
                        "\n" +
                        "Biển3: W.225 “trẻ em”",
                R.raw.biencau145));
        arrayBienbao.add(new OnTap("Câu hỏi 146: Biển báo này có ý nghĩa gì?" +
                "\n",
                "1. Báo hiệu đường có ổ gà, lồi lõm.\n",
                "2. Báo hiệu đường có gồ giảm tốc phía trước.\n",
                null,
                null,
                "Đáp án: Báo hiệu đường có gồ giảm tốc phía trước.\n",
                "Giải thích: Biển W221b “Đường có sóng mấp mô nhân tạo”.",
                R.raw.biencau146));
        arrayBienbao.add(new OnTap("Câu hỏi 147: Biển nào (đặt trước ngã ba, ngã tư) cho phép xe được rẽ sang hướng khác?" +
                "\n",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Không biển nào.\n",
                null,
                "Đáp án: Không biển nào.\n",
                "Giải thích: Biển 1: R.301a “Hướng đi phải theo” chỉ được đi thẳng đặt trước ngã ba, ngã tư;\n" +
                        "\n" +
                        "Biển 2: R.301h “Hướng đi phải theo” chỉ được rẽ trái hoặc rẽ phải đặt sau ngã ba, ngã tư;\n" +
                        "\n" +
                        "Nên đáp án đúng là không có biển nào.",
                R.raw.biencau147));
        arrayBienbao.add(new OnTap("Câu hỏi 148: Biển nào báo hiệu “Hướng đi thẳng phải theo”?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                null,
                null,
                "Đáp án: Biển 1.\n",
                "Giải thích: Biển 1: R.301a “Hướng đi phải theo” chỉ được đi thẳng đặt trước ngã ba, ngã tư;\n" +
                        "\n" +
                        "Biển 2: I.407a “Đường một chiều” không liên quan hướng đi phải theo.\n" +
                        "\n" +
                        "Nên Biển 1 là đáp án đúng.",
                R.raw.biencau148));
        arrayBienbao.add(new OnTap("Câu hỏi 149: Biển nào báo hiệu “Đường một chiều”?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                null,
                "Đáp án: Biển 2.\n",
                "Giải thích: Biển 1: R.301a “Hướng đi phải theo” chỉ được đi thẳng đặt trước ngã ba, ngã tư;\n" +
                        "\n" +
                        "Biển 2: I.407a “Đường một chiều” không liên quan hướng đi phải theo.\n" +
                        "\n" +
                        "Nên biển 2 là đáp án đúng.",
                R.raw.biencau149));
        arrayBienbao.add(new OnTap("Câu hỏi 150: Trong các biển dưới đây biển nào là biển “Hết tốc độ tối đa cho phép”?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 1.\n",
                "Giải thích:\n" +
                        "\n" +
                        "Biển 1: DP134 “Hết hạn chế tốc độ tối đa”\n" +
                        "\n" +
                        "Biển 2: DP135 “Hết mọi lệnh cấm”;\n" +
                        "\n" +
                        "Biển 3: R307 “Hết hạn chế tốc độ tối thiểu”.\n" +
                        "\n" +
                        "Nên biển 1 là biển “Hết hạn chế tốc độ tối đa”. Chú ý câu này hỏi ý nghĩa của biển.",
                R.raw.biencau150));
        arrayBienbao.add(new OnTap("Câu hỏi 151: Hiệu lực của biển “Tốc độ tối đa cho phép” hết tác dụng khi gặp biển nào dưới đây?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Biển 1 và 2.\n",
                "Đáp án: Biển 1 và 2.\n",
                "Giải thích:\n" +
                        "\n" +
                        "Biển 1: DP134 “Hết hạn chế tốc độ tối đa”\n" +
                        "\n" +
                        "Biển 2: DP135 “Hết mọi lệnh cấm”;\n" +
                        "\n" +
                        "Biển 3: R307 “Hết hạn chế tốc độ tối thiểu”.\n" +
                        "\n" +
                        "Nên Biển 1 và Biển 2 là biển “Hết hạn chế tốc độ tối đa”. Chú ý câu hỏi các biển hết hạn chế, không phải hỏi ý nghĩa của biển.",
                R.raw.biencau151));
        arrayBienbao.add(new OnTap("Câu hỏi 152: Trong các biển dưới đây biển nào là biển “Hết tốc độ tối thiểu”?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 3.\n",
                "Giải thích:\n" +
                        "\n" +
                        "Biển 1: DP134 “Hết hạn chế tốc độ tối đa”\n" +
                        "\n" +
                        "Biển 2: DP135 “Hết mọi lệnh cấm”;\n" +
                        "\n" +
                        "Biển 3: R307 “Hết hạn chế tốc độ tối thiểu”.\n" +
                        "\n" +
                        "Nên Biển 3 là biển “Hết hạn chế tốc độ tối thiểu”. Câu này hỏi ý nghĩa của biển.",
                R.raw.biencau152));
        arrayBienbao.add(new OnTap("Câu hỏi 153: Biển nào dưới đây báo hiệu hết cấm vượt?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Biển 2 và 3.\n",
                "Đáp án: Biển 2 và 3.\n",
                "Giải thích:\n" +
                        "\n" +
                        "Biển 1: DP134 “Hết hạn chế tốc độ tối đa”\n" +
                        "\n" +
                        "Biển 2: DP135 “Hết mọi lệnh cấm”;\n" +
                        "\n" +
                        "Biển 3: DP.133 “Hết cấm vượt”\n" +
                        "\n" +
                        "Nên đáp án đúng phải là Biển 2 và Biển 3.",
                R.raw.biencau153));
        arrayBienbao.add(new OnTap("Câu hỏi 154: Trong các biển dưới đây biển nào là biển “Hết mọi lệnh cấm”?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                "4. Cả ba biển.\n",
                "Đáp án: Biển 2.\n",
                "Giải thích:\n" +
                        "\n" +
                        "Biển 1: DP134 “Hết hạn chế tốc độ tối đa”\n" +
                        "\n" +
                        "Biển 2: DP135 “Hết mọi lệnh cấm”;\n" +
                        "\n" +
                        "Biển 3: R307 “Hết hạn chế tốc độ tối thiểu”.",
                R.raw.biencau154));
        arrayBienbao.add(new OnTap("Câu hỏi 155: Biển nào chỉ dẫn cho người đi bộ sử dụng cầu vượt qua đường?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                "4. Không biển nào.\n",
                "Đáp án: Biển 1.\n",
                "Giải thích:\n" +
                        "\n" +
                        "Biển 1: I424a “Cầu vượt qua đường cho người đi bộ; Biển 2: I424c “Hầm chui qua đường cho người đi bộ” nên đáp án đúng là biển 1.",
                R.raw.biencau155));
        arrayBienbao.add(new OnTap("Câu hỏi 156: Biển nào chỉ dẫn cho người đi bộ sử dụng hầm chui qua đường?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Cả hai biển.\n",
                "4. Không biển nào.\n",
                "Đáp án: Biển 2.\n",
                "Giải thích: Biển 1: I424b “Cầu vượt qua đường cho người đi bộ”; Biển 2: I424d “Hầm chui qua đường cho người đi bộ” nên đáp án đúng là biển 2.",
                R.raw.biencau156));
        arrayBienbao.add(new OnTap("Câu hỏi 157: Biển nào báo hiệu “Nơi đỗ xe dành cho người khuyết tật”?",
                "1. Biển 1.\n",
                "2. Biển 2.\n",
                "3. Biển 3.\n",
                null,
                "Đáp án: Biển 2.\n",
                null,
                R.raw.biencau157));
        arrayBienbao.add(new OnTap("Câu hỏi 158: Gặp biển báo này, người tham gia giao thông phải xử lý như thế nào?",
                "1. Dừng xe tại khu vực có trạm Cảnh sát giao thông.\n",
                "2. Tiếp tục lưu thông với tốc độ bình thường.\n",
                "3. Phải giảm tốc độ đến mức an toàn và không được vượt khi đi qua khu vực này.\n",
                null,
                "Đáp án: Phải giảm tốc độ đến mức an toàn và không được vượt khi đi qua khu vực này.\n",
                "Giải thích: Biển I.436 “Trạm cảnh sát giảo thông”. Các phương tiện phải giảm tốc độ đến mức an toàn và không được vượt khi đi qua khu vực này.",
                R.raw.biencau158));
        arrayBienbao.add(new OnTap("Câu hỏi 159: Biển số 1 có ý nghĩa gì?",
                "1. Đi thẳng hoặc rẽ trái trên cầu vượt.\n",
                "2. Đi thẳng hoặc rẽ phải trên cầu vượt.\n",
                "3. Báo hiệu cầu vượt liên thông.\n",
                null,
                "Đáp án: Báo hiệu cầu vượt liên thông.\n",
                null,
                R.raw.biencau159));
        arrayBienbao.add(new OnTap("Câu hỏi 160: Vạch kẻ đường nào dưới đây là vạch phân chia các làn xe cùng chiều?",
                "1. Vạch 1.\n",
                "2. Vạch 2.\n",
                "3. Vạch 3.\n",
                "4. Vạch 1 và 2",
                "Đáp án: Vạch 1 và 2.\n",
                null,
                R.raw.biencau160));
        arrayBienbao.add(new OnTap("Câu hỏi 161: Vạch kẻ đường nào dưới đây là vạch phân chia hai chiều xe chạy (vạch tim đường), xe không được lấn làn, không được đè lên vạch?",
                "1. Vạch 1.\n",
                "2. Vạch 2.\n",
                "3. Vạch 3.\n",
                "4. Cả ba vạch",
                "Đáp án: Vạch 2.\n",
                null,
                R.raw.biencau161));
        arrayBienbao.add(new OnTap("Câu hỏi 162: Vạch kẻ đường nào dưới đây là vạch phân chia hai chiều xe chạy (vạch tim đường)?",
                "1. Vạch 1.\n",
                "2. Vạch 2.\n",
                "3. Vạch 3.\n",
                "4. Vạch 1 và 3",
                "Đáp án: Vạch 1 và 3.\n",
                null,
                R.raw.biencau162));
        arrayBienbao.add(new OnTap("Câu hỏi 163: Các vạch dưới đây có tác dụng gì?",
                "1. Phân chia hai chiều xe chạy ngược chiều nhau.\n",
                "2. Phân chia các làn xe chạy cùng chiều nhau.\n",
                null,
                null,
                "Đáp án: Phân chia hai chiều xe chạy ngược chiều nhau.\n",
                null,
                R.raw.biencau163));
        arrayBienbao.add(new OnTap("Câu hỏi 164: Khi gặp vạch kẻ đường nào các xe được phép đè vạch?",
                "1. Vạch 1.\n",
                "2. Vạch 2.\n",
                "3. Vạch 3.\n",
                "4. Vạch 1 và 3.\n",
                "Đáp án: Vạch 1 và 3.\n",
                null,
                R.raw.biencau164));
        arrayBienbao.add(new OnTap("Câu hỏi 165: Vạch dưới đây có ý nghĩa gì?",
                "1. Vị trí dừng xe của các phương tiện vận tải hành khách công cộng.\n",
                "2. Báo cho người điều khiển được dừng phương tiện trong phạm vi phần mặt đường có bố trí vạch để tránh ùn tắc giao thông.\n",
                "3. Dùng để xác định vị trí giữa các phương tiện trên đường.\n",
                null,
                "Đáp án: Vị trí dừng xe của các phương tiện vận tải hành khách công cộng.\n",
                "Giải thích: Vạch 9.2: Vạch quy đình vị trí dừng đỗ của phương tiện giao thông công cộng trên đường.",
                R.raw.biencau165));

    }

}