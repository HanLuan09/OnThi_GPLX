package com.example.btl.adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.example.btl.R;
import com.example.btl.model.MeoThi;
import java.util.List;

public class MeoThiAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<MeoThi> meothiList;

    public MeoThiAdapter(Context context, int layout, List<MeoThi> meothiList) {
        this.context = context;
        this.layout = layout;
        this.meothiList = meothiList;
    }

    @Override
    public int getCount() {
        return meothiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{//ãnh xạ view
        TextView txtTen,txtNoidung,txtXemChiTiet,txtAn;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MeoThiAdapter.ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new MeoThiAdapter.ViewHolder();
            // ánh xạ view
            holder.txtTen = (TextView) view.findViewById(R.id.TeViewteenMeothi);
            holder.txtNoidung = (TextView) view.findViewById(R.id.TeViewNoidungMeothi);
            holder.txtXemChiTiet = (TextView) view.findViewById(R.id.TeViewxemchitiet);
            holder.txtAn = (TextView) view.findViewById(R.id.TeViewan);
            view.setTag(holder);
        }
        else{
            holder = (MeoThiAdapter.ViewHolder) view.getTag();
        }
        //Gán giá trị
        MeoThi meoThi= meothiList.get(i);
        holder.txtTen.setText(meoThi.getTen());
        holder.txtNoidung.setText(meoThi.getNoidung());
        holder.txtXemChiTiet.setText("Xem chi tiết");
        holder.txtAn.setText("Ẩn xem chi tiết");
        holder.txtXemChiTiet.setVisibility(View.VISIBLE);
        holder.txtNoidung.setVisibility(View.GONE);
        holder.txtAn.setVisibility(View.GONE);
        holder.txtXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.txtXemChiTiet.setVisibility(View.GONE);
                holder.txtNoidung.setVisibility(View.VISIBLE);
                holder.txtAn.setVisibility(View.VISIBLE);
            }
        });
        holder.txtAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.txtXemChiTiet.setVisibility(View.VISIBLE);
                holder.txtNoidung.setVisibility(View.GONE);
                holder.txtAn.setVisibility(View.GONE);
            }
        });
        return view;
    }
}
