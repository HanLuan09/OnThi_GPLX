package com.example.btl.fragment;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.widget.ListView;

import com.example.btl.R;
import com.example.btl.adapter.OnThiAdapter;
import com.example.btl.model.OnTap;

import java.util.ArrayList;

public class SaHinhFragment extends Fragment {
    private ListView lvCauhoiSahinh;
    private ArrayList<OnTap> arraySahinh;
    private OnThiAdapter saHinhAdapter;

    public SaHinhFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sa_hinh, container, false);
    }
    @MainThread
    @CallSuper
    public void onViewStateRestored(@NonNull Bundle saveInstanceState) {
        super.onViewStateRestored(saveInstanceState);
        Anhxa();
        saHinhAdapter = new OnThiAdapter(getActivity(), R.layout.dong_on_tap, arraySahinh);
        lvCauhoiSahinh.setAdapter(saHinhAdapter);
    }

    private void Anhxa() {
        lvCauhoiSahinh = getActivity().findViewById(R.id.listViewCauhoiSahinh);
        arraySahinh = new ArrayList<>();
        arraySahinh.add(new OnTap("Câu hỏi 44: Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông?",
                "1. Người tham gia giao thông ở các hướng phải dừng lại.",
                "2. Người tham gia giao thông ở các hướng được đi theo chiều gậy chỉ của cảnh sát giao thông.",
                "3. Người tham gia giao thông ở phía trước và phía sau người điều khiển được đi tất cả các hướng; người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển phải dừng lại.",
                "4. Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển được đi tất cả các hướng.",
                "Đáp án: Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển được đi tất cả các hướng.",
                "Giải thích: Người điều khiển giao thông tay giang ngang thì trước mặt và sau lưng dừng lại.",
                R.raw.biencau44));
        arraySahinh.add(new OnTap("Câu hỏi 45: Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông?",
                "1. Người tham gia giao thông ở hướng đối diện cảnh sát giao thông được đi, các hướng khác cần phải dừng lại.",
                "2. Người tham gia giao thông được rẽ phải theo chiều mũi tên màu xanh ở bục cảnh sát giao thông.",
                "3. Người tham gia giao thông ở các hướng đều phải dừng lại trừ các xe ở trong khu vực giao nhau.",
                "4. Người ở hướng đối diện cảnh sát giao thông phải dừng lại, các hướng khác được đi trong đó có bạn.",
                "Đáp án: Người tham gia giao thông ở các hướng đều phải dừng lại trừ các xe ở trong khu vực giao nhau.",
                "Giải thích: người điều khiển giao thông giơ tay thẳng đứng thì ở tất cả các hướng phải dừng lại.",
                R.raw.biencau45));
        arraySahinh.add(new OnTap("Câu hỏi 166: Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe tải, xe khách, xe con, mô tô.",
                "2. Xe tải, mô tô, xe khách, xe con.",
                "3. Xe khách, xe tải, xe con, mô tô.",
                "4. Mô tô, xe khách, xe tải, xe con.",
                "Đáp án: Xe tải, mô tô, xe khách, xe con.",
                "Giải thích:\n" +
                        "\n" +
                        "Thứ tự ưu tiên: Xe ưu tiên- Đường ưu tiên- Đường cùng cấp theo thứ tự bên phải trống – rẽ phải – đi thẳng – rẽ trái.\n" +
                        "\n" +
                        "1. Xe tải: Đường ưu tiên và đi thẳng;\n" +
                        "\n" +
                        "2. Mô tô: Đường ưu tiên và rẽ trái;\n" +
                        "\n" +
                        "3. Xe khách: Đường không ưu tiên, đi thẳng.\n" +
                        "\n" +
                        "4. Xe con: Đường không ưu tiên, rẽ trái.",
                R.raw.biencau166));
        arraySahinh.add(new OnTap("Câu hỏi 167: Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe tải, xe con, mô tô.",
                "2. Xe con, xe tải, mô tô.",
                "3. Mô tô, xe con, xe tải.",
                "4. Xe con, mô tô, xe tải.",
                "Đáp án: Mô tô, xe con, xe tải.",
                "Giải thích:\n" +
                        "\n" +
                        "Thứ tự ưu tiên: Xe ưu tiên- Đường ưu tiên- Đường cùng cấp theo thứ tự bên phải trống – rẽ phải – đi thẳng – rẽ trái.\n" +
                        "\n" +
                        "Xe mô tô: Bên phải trống;\n" +
                        "Xe con: Đi thẳng;\n" +
                        "Xe tải: Rẽ trái;",
                R.raw.biencau167));
        arraySahinh.add(new OnTap("Câu hỏi 168: Trường hợp này xe nào được quyền đi trước?",
                "1. Mô tô.",
                "2. Xe con.",
                null,
                null,
                "Đáp án: Xe con.",
                "Giải thích: Xe con được đi trước vì mô tô có biển STOP trước mặt.",
                R.raw.biencau168));
        arraySahinh.add(new OnTap("Câu hỏi 169: Xe nào được quyền đi trước trong trường hợp này?",
                "1. Mô tô.",
                "2. Xe cứu thương",
                null,
                null,
                "Đáp án: Xe cứu thương.",
                "Giải thích: Xe ưu tiên đi trước.",
                R.raw.biencau169));
        arraySahinh.add(new OnTap("Câu hỏi 170: Theo tín hiệu đèn, xe nào được phép đi?",
                "1. Xe con và xe khách.",
                "2. Mô tô.",
                null,
                null,
                "Đáp án: Xe con và xe khách.",
                "Giải thích: Xe con và xe khách đang ở làn đường có tín hiệu đèn xanh nên được phép đi.",
                R.raw.biencau170));
        arraySahinh.add(new OnTap("Câu hỏi 171: Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe khách, xe tải, mô tô.",
                "2. Xe tải, xe con, mô tô.",
                "3. Xe khách, xe con, mô tô.",
                null,
                "Đáp án: Xe khách, xe tải, mô tô.",
                "Giải thích: \n" +
                        "\n" +
                        "1. Xe khách: Sai làn, đi thẳng đèn đang đỏ;\n" +
                        "\n" +
                        "2. Xe tải: Sai làn: Đi trên làn đi thẳng trong khi thực hiện rẽ trái.\n" +
                        "\n" +
                        "3. Xe mô tô: Sai làn: Đi trên làn rẽ trái trong khi thực hiện rẽ phải.\n" +
                        "\n" +
                        "Nên đáp án đúng là xe khách, xe tải và xe mô tô đều vi phạm quy tắc giao thông.",
                R.raw.biencau171));
        arraySahinh.add(new OnTap("Câu hỏi 172: Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe khách, xe tải, mô tô, xe con.",
                "2. Xe con, xe khách, xe tải, mô tô.",
                "3. Mô tô, xe tải, xe khách, xe con.",
                "4. Mô tô, xe tải, xe con, xe khách.",
                "Đáp án: Mô tô, xe tải, xe khách, xe con.",
                "Giải thích: Giao nhau cùng cấp có vòng xuyến: Chưa vào vòng xuyến thì ưu tiên xe bên phải; đã vào vòng xuyến ưu tiên xe từ bên trái tới.\n" +
                        "\n" +
                        "Toàn bộ các xe chưa vào vòng xuyến nên ưu tiên xe bên phải.\n" +
                        "\n" +
                        "Thứ tự sẽ là mô tô, xe tải, xe khách, xe con.",
                R.raw.biencau172));
        arraySahinh.add(new OnTap("Câu hỏi 173: Trong trường hợp này xe nào đỗ vi phạm quy tắc giao thông?",
                "1. Xe tải.",
                "2. Xe con và mô tô.",
                "3. Cả ba xe.",
                "4. Xe con và xe tải.",
                "Đáp án: Xe tải",
                "Giải thích: Biển cấm đỗ xe tải (ở biển phụ) nên chỉ có xe tải vi phạm.",
                R.raw.biencau173));
        arraySahinh.add(new OnTap("Câu hỏi 174: Theo hướng mũi tên, những hướng nào xe gắn máy đi được?",
                "1. Cả ba hướng.",
                "2. Chỉ hướng 1 và 3.",
                "3. Chỉ hướng 1.",
                null,
                "Đáp án: Cả ba hướng.",
                "Giải thích: \n" +
                        "\n" +
                        "Bạn lưu ý câu hỏi này về hướng đi của xe GẮN MÁY. Hướng 1 và 3 chắn chắn là đi được rồi. \n" +
                        "\n" +
                        "Với hướng 2, biển báo cấm mô tô đi vào chỉ có tác dụng với xe mô tô nên xe gắn máy không có hiệu lực. DO đó vẫn đi vào bình thường. ",
                R.raw.biencau174));
        arraySahinh.add(new OnTap("Câu hỏi 175: Xe nào đỗ vi phạm quy tắc giao thông?",
                "1. Cả hai xe.",
                "2. Không xe nào vi phạm.",
                "3. Chỉ xe mô tô vi phạm.",
                "4. Chỉ xe tải vi phạm.",
                "Đáp án: Cả hai xe.",
                "Giải thích: Biển cấm đỗ xe ở cả phía trước và phía sau biển (ở biển báo phụ) nên cả 2 xe vi phạm.",
                R.raw.biencau175));
        arraySahinh.add(new OnTap("Câu hỏi 176: Xe nào đỗ vi phạm quy tắc giao thông?",
                "1. Chỉ mô tô.",
                "2. Chỉ xe tải.",
                "3. Cả ba xe.",
                "4. Chỉ mô tô và xe tải.",
                "Đáp án: Cả ba xe.",
                "Giải thích: Xe tải đậu trái đường; Xe con và mô tô đậu xe đè vạch nên cả 3 xe vi phạm.",
                R.raw.biencau176));
        arraySahinh.add(new OnTap("Câu hỏi 177: Xe tải kéo mô tô ba bánh như hình này có đúng quy tắc giao thông không?",
                "1. Đúng.",
                "2. Không đúng.",
                null,
                null,
                "Đáp án: Không đúng.",
                "Giải thích: Xe tải kéo xe mô tô 3 bánh như trên hình là không đúng vì đi vào đường có biển P.108 “Cấm ô tô kéo moóc” kể cả xe máy, xe ô tô khách kéo theo rơ moóc đi qua.",
                R.raw.biencau177));
        arraySahinh.add(new OnTap("Câu hỏi 178: Xe nào được quyền đi trước trong trường hợp này?",
                "1. Xe con.",
                "2. Xe mô tô.",
                null,
                null,
                "Đáp án: Xe mô tô.",
                "Giải thích: \n" +
                        "\n" +
                        "Cả 2 xe đều gặp đèn xanh nên áp dụng quy tắc đường cùng cấp: Bên phải trống – Rẽ phải – Đi thẳng – Rẽ trái.\n" +
                        "\n" +
                        "Nên đáp án đúng là xe mô tô rẽ phải được quyền đi trước. Xe con rẽ trái phải nhường đường.",
                R.raw.biencau178));
        arraySahinh.add(new OnTap("Câu hỏi 179: Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe con (A), mô tô, xe con (B), xe đạp.",
                "2. Xe con (B), xe đạp, mô tô, xe con (A).",
                "3. Xe con (A), xe con (B), mô tô  + xe đạp.",
                "4. Mô tô + xe đạp, xe con (A), xe con (B).",
                "Đáp án: Mô tô + xe đạp, xe con (A), xe con (B).",
                "Giải thích:\n" +
                        "\n" +
                        "Thứ tự ưu tiên đường cùng cấp: Xe ưu tiên – Đường ưu tiên – Bên phải trống – Rẽ phải – Đi thẳng – Rẽ trái.",
                R.raw.biencau179));
        arraySahinh.add(new OnTap("Câu hỏi 180: Xe nào được quyền đi trước trong trường hợp này?",
                "1. Mô tô.",
                "2. Xe con.",
                null,
                null,
                "Đáp án: Mô tô.",
                "Giải thích: Thứ tự ưu tiên: Xe ưu tiên – Đường ưu tiên – Bên phải trống – Rẽ trái – Đi thẳng – Rẽ trái. Xe mô tô rẽ trái từ đường ưu tiên vào đường ưu tiên (theo biển báo và biển phụ) nên được quyền đi trước.",
                R.raw.biencau180));
        arraySahinh.add(new OnTap("Câu hỏi 181: Xe nào vi phạm quy tắc giao thông?",
                "1. Xe khách.",
                "2. Mô tô.",
                "3. Xe con.",
                "4. Xe con và mô tô.",
                "Đáp án: Xe con.",
                "Giải thích: Xe con quay đầu đè vạch liền trên đường nên vi phạm.",
                R.raw.biencau181));
        arraySahinh.add(new OnTap("Câu hỏi 182: Các xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Các xe ở phía tay phải và tay trái của người điều khiển được phép đi thẳng.",
                "2. Cho phép các xe ở mọi hướng được rẽ phải.",
                "3. Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.",
                null,
                "Đáp án: Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.",
                "Giải thích: Giơ tay thẳng đứng: Tất cả dừng, trừ xe đã ở trong ngã tư được phép đi;\n" +
                        "\n" +
                        "Giang tay ngang: Trái phải đi; Trước sau dừng; \n" +
                        "\n" +
                        "Tay phải giơ trước: sau, phải dừng, trước rẽ trái, trái đi các hướng, người đi bộ qua đường đi sau người điều khiển.",
                R.raw.biencau182));
        arraySahinh.add(new OnTap("Câu hỏi 183: Theo hướng mũi tên, xe nào được phép đi?",
                "1. Mô tô, xe con.",
                "2. Xe con, xe tải.",
                "3. Mô tô, xe tải.",
                "4. Cả ba xe.",
                "Đáp án: Mô tô, xe tải.",
                "Giải thích: Giang ngang tay: Trái phải đi; Trước sau dừng. Xe mô tô và xe tải được phép đi là đáp án đúng.",
                R.raw.biencau183));
        arraySahinh.add(new OnTap("Câu hỏi 184: Trong hình dưới đây, xe nào chấp hành đúng quy tắc giao thông?",
                "1. Chỉ xe khách, mô tô.",
                "2. Tất cả các loại xe trên.",
                "3. Không xe nào chấp hành đúng quy tắc giao thông.",
                null,
                "Đáp án: Tất cả các loại xe trên.",
                "Giải thích: Xe khách chờ đèn đỏ rẽ trái. Xe tải đi thẳng và rẽ phải theo tín hiệu đèn xanh. Xe con đi thẳng và rẽ phải theo tín hiệu đèn xanh. Xe mô tô chờ đèn đỏ rẽ trái. Nên tất cả xe đều chấp hành.",
                R.raw.biencau184));
        arraySahinh.add(new OnTap("Câu hỏi 185: Theo hướng mũi tên, những hướng nào xe mô tô được phép đi?",
                "1. Cả ba hướng.",
                "2. Hướng 1 và 2.",
                "3. Hướng 1 và 3.",
                "4. Hướng 2 và 3.",
                "Đáp án: Hướng 1 và 3.",
                "Giải thích: Hướng 2 có biển số P.104 “Cấm mô tô”\n" +
                        "\n" +
                        "Hướng 3 Biển số P.103a “Cấm ô tô” nhưng không cấm mô tô. Nên đáp án đúng là hướng 1 và hướng 3.",
                R.raw.biencau185));
        arraySahinh.add(new OnTap("Câu hỏi 186: Trong trường hợp này, thứ tự xe đi như thế nào là đúng quy tắc giao thông?",
                "1. Xe công an, xe quân sự, xe con + mô tô.",
                "2. Xe quân sự, xe công an, xe con +mô tô.",
                "3. Xe mô tô + xe con, xe quân sự, xe công an.",
                null,
                "Đáp án: Xe quân sự, xe công an, xe con +mô tô.",
                "Giải thích: \n" +
                        "\n" +
                        "Thứ tự ưu tiên: Xe ưu tiên – Đường ưu tiên – Bên phải trống – Rẽ phải – Đi thẳng – Rẽ trái.\n" +
                        "\n" +
                        "1. Xe quân sự: Xe ưu tiên cùng cấp xe công an nhưng đi thẳng;\n" +
                        "\n" +
                        "2. Xe công an: Xe ưu tiên; rẽ trái;\n" +
                        "\n" +
                        "3. Xe con và xe mô tô: Cùng đi thẳng.",
                R.raw.biencau186));
        arraySahinh.add(new OnTap("Câu hỏi 187: Trong hình dưới, những xe nào vi phạm quy tắc giao thông?",
                "1. Xe con (E), mô tô (C).",
                "2. Xe tải (A), mô tô (D).",
                "3. Xe khách (B), mô tô (C).",
                "4. Xe khách (B), mô tô (D).",
                "Đáp án: Xe con (E), mô tô (C).",
                "Giải thích: Xe mô tô C chạy vào làn danh riêng xe ô tô: Vi phạm; Xe con E chạy vào làn danh riêng xe máy: Vi phạm.",
                R.raw.biencau187));
        arraySahinh.add(new OnTap("Câu hỏi 188: Trong hình dưới, những xe nào vi phạm quy tắc giao thông?",
                "1. Xe con (B), mô tô (C).",
                "2. Xe con (A), mô tô (C).",
                "3. Xe con (E), mô tô (D).",
                "4. Tất cả các loại xe trên.",
                "Đáp án: Xe con (E), mô tô (D).",
                "Giải thích: Nhìn vào bảng chỉ dẫn loại phương tiện theo làn đường: Xe con (E) đi trên làn danh riêng cho mô tô nên vi phạm: Xe mô tô (D) chạy trên làn dành riêng cho ô tô nên cũng vi phạm.",
                R.raw.biencau188));
        arraySahinh.add(new OnTap("Câu hỏi 189: Bạn có được phép vượt xe mô tô phía trước không?",
                "1. Cho phép.",
                "2. Không được vượt.",
                null,
                null,
                "Đáp án: Không được vượt.",
                "Giải thích: Tại nơi giao nhau, trên đoạn đường có làn đường danh cho người đi bộ cắt ngang qua thì không được phép vượt.",
                R.raw.biencau189));
        arraySahinh.add(new OnTap("Câu hỏi 190: Theo tín hiệu đèn của xe cơ giới, xe nào vi phạm quy tắc giao thông?",
                "1. Xe mô tô.",
                "2. Xe ô tô con.",
                "3. Không xe nào vi phạm.",
                "4. Cả hai xe.",
                "Đáp án: Cả hai xe.",
                "Giải thích: Biển số R.301a chỉ cho phép các phương tiện đi thẳng trong khi cả 2 xe đều có tín hiệu xe nhan rẽ sang hướng khách nên cả 2 xe đều vi phạm quy tắc giao thông.",
                R.raw.biencau190));
        arraySahinh.add(new OnTap("Câu hỏi 191: Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe con.",
                "2. Xe tải.",
                "3. Xe con, xe tải.",
                null,
                "Đáp án: Xe tải.",
                "Giải thích: Xe con trong cả 2 phía đều đang đúng làn đường và đi theo hướng mà đèn xanh đang bật nên đúng quy tắc giao thông.\n" +
                        "\n" +
                        "Xe tải trong cả 2 phía đều ở sai làn đường so với hướng rẽ nên vi phạm quy tắc giao thông.",
                R.raw.biencau191));
        arraySahinh.add(new OnTap("Câu hỏi 192: Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe tải, xe con.",
                "2. Xe khách, xe con.",
                "3. Xe khách, xe tải.",
                null,
                "Đáp án: Xe khách, xe tải.",
                "Giải thích: Xe con và xe mô tô đang ở đúng làn đường, đúng hướng rẽ với tín hiệu đèn xanh nên đúng quy tắc giao thông.\n" +
                        "\n" +
                        "Xe khách và xe tải đang ở sai làn đường so với hướng rẽ nên đều vi phạm.",
                R.raw.biencau192));
        arraySahinh.add(new OnTap("Câu hỏi 193: Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",
                "1. Xe con, xe khách, xe tải.",
                "2. Xe tải, xe khách, xe mô tô.",
                "3. Xe khách, xe mô tô, xe con.",
                "4. Cả bốn xe.",
                "Đáp án: Xe tải, xe khách, xe mô tô.",
                "Giải thích: \n" +
                        "\n" +
                        "Xe con đi đúng làn đường theo hướng rẽ và tín hiệu đèn.\n" +
                        "\n" +
                        "Xe khách: Sai làn đường và tín hiệu đèn.\n" +
                        "\n" +
                        "Xe tải: Đi thẳng vi phạm đèn đỏ.\n" +
                        "\n" +
                        "Xe mô tô: Đi thẳng vi phạm đèn đỏ.",
                R.raw.biencau193));
        arraySahinh.add(new OnTap("Câu hỏi 194: Các xe đi theo hướng mũi tên, xe nào chấp hành đúng quy tắc giao thông?",
                "1. Xe tải, mô tô.",
                "2. Xe khách, mô tô.",
                "3. Xe tải, xe con.",
                "4. Mô tô, xe con.",
                "Đáp án: Xe khách, mô tô.",
                "Giải thích: Xe con và xe tải: Vi phạm tín hiệu đèn;\n" +
                        "\n" +
                        "Xe khách và xe mô tô: Đúng làn đường và đúng tín hiệu đèn.",
                R.raw.biencau194));
        arraySahinh.add(new OnTap("Câu hỏi 195: Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?",
                "1. Xe của bạn, mô tô, xe con.",
                "2. Xe con, xe của bạn, mô tô.",
                "3. Mô tô, xe con, xe của bạn.",
                null,
                "Đáp án: Mô tô, xe con, xe của bạn.",
                "Giải thích: Thứ tự ưu tiên: Xe ưu tiên – Đường ưu tiên – Đường cùng cấp: Bên phải trống, rẽ phải, đi thẳng, rẽ trái.\n" +
                        "\n" +
                        "Biển báo phía trước là đường ưu tiên và biển phụ báo hướng di chuyển của xe mô tô là hướng ưu tiên.\n" +
                        "\n" +
                        "1. Xe mô tô: Đường ưu tiên;\n" +
                        "\n" +
                        "2. Xe con: Đường không ưu tiên, bên phải trống;\n" +
                        "\n" +
                        "3.  Xe của bạn: Đường không ưu tiên, bên phải vướng xe con.",
                R.raw.biencau195));
        arraySahinh.add(new OnTap("Câu hỏi 196: Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?",
                "1. Xe của bạn, mô tô, xe con.",
                "2. Xe con, xe của bạn, mô tô.",
                "3. Mô tô, xe con, xe của bạn.",
                null,
                "Đáp án: Xe con, xe của bạn, mô tô.",
                "Giải thích: Thứ tự ưu tiên: Xe ưu tiên – Đường ưu tiên – Đường cùng cấp: Bên phải trống, rẽ phải, đi thẳng, rẽ trái.\n" +
                        "\n" +
                        "1. Xe con: Rẽ phải; 2: Xe của bạn: Đi thẳng; 3. Mô tô: Rẽ trái.",
                R.raw.biencau196));
        arraySahinh.add(new OnTap("Câu hỏi 197: Bạn xử lý như thế nào trong trường hợp này?",
                "1. Tăng tốc độ, rẽ phải trước xe tải và xe đạp.",
                "2. Giảm tốc độ, rẽ phải sau xe tải và xe đạp.",
                "3. Tăng tốc độ, rẽ phải trước xe đạp.",
                null,
                "Đáp án: Giảm tốc độ, rẽ phải sau xe tải và xe đạp.",
                "Giải thích: Xe tải đã vào nơi giao nhau trước nên sẽ được ưu tiên trước. Biển báo phía trước là đường ưu tiên dành cho xe thô sơ nên phải nhường đường cho xe đạp. Do đó, xe bạn rẽ phải sau xe tải và xe đạp.",
                R.raw.biencau197));
        arraySahinh.add(new OnTap("Câu hỏi 198: Xe nào dừng đúng theo quy tắc giao thông?",
                "1. Xe con.",
                "2. Xe mô tô.",
                "3. Cả hai xe đều đúng.",
                null,
                "Đáp án: Xe con.",
                "Giải thích:Biển số W.211a “Giao nhau với đường sắt không có rào chắn” thì các phương tiện đứng cách xa đường sắt tối thiểu 5m nên xe con đúng.",
                R.raw.biencau198));
        arraySahinh.add(new OnTap("Câu hỏi 199: Xe của bạn đang di chuyển gần đến khu vực giao cắt với đường sắt, khi rào chắn đang dịch chuyển, bạn điều khiển xe như thế nào là đúng quy tắc giao thông?",
                "1. Quan sát nếu thấy không có tàu thì tăng tốc cho xe vượt qua đường sắt.",
                "2. Dừng lại trước rào chắn một khoảng cách an toàn.",
                "3. Ra tín hiệu, yêu cầu người gác chắn tàu kéo chậm Barie để xe bạn qua.",
                null,
                "Đáp án: Dừng lại trước rào chắn một khoảng cách an toàn.",
                "Giải thích: Bắt buộc phải dừng xe.",
                R.raw.biencau199));
        arraySahinh.add(new OnTap("Câu hỏi 200: Trong tình huống dưới đây, xa đầu kéo kéo rơ moóc (xe container) đang rẽ phải, xe con màu xanh và xe máy phía sau xe container đi như thế nào để đảm bảo an toàn?",
                "1. Vượt về phía bên phải để đi tiếp.",
                "2. Giảm tốc độ chờ xe container rẽ xong rồi tiếp tục đi.",
                "3. Vượt về phía bên trái để đi tiếp.",
                null,
                "Đáp án: Giảm tốc độ chờ xe container rẽ xong rồi tiếp tục đi.",
                "Giải thích: Giảm tốc độc chờ xe đầu kéo rẽ phải rồi mới tiếp tục đi.",
                R.raw.biencau200));
    }
}