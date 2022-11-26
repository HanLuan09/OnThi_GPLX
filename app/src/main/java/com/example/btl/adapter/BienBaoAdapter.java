package com.example.btl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btl.R;
import com.example.btl.model.BienBao;

import java.util.List;

public class BienBaoAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<BienBao> bienBaoCamList;

    public BienBaoAdapter(Context context, int layout, List<BienBao> bienBaoCamList) {
        this.context = context;
        this.layout = layout;
        this.bienBaoCamList = bienBaoCamList;
    }

    @Override
    public int getCount() {
        //số dòng
        return bienBaoCamList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    static class ViewHolder{//ãnh xạ view
        private ImageView imgHinh;
        private TextView txtTen,txtMota;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            // ánh xạ view
             holder.txtTen = (TextView) view.findViewById(R.id.TeViewten);
             holder.txtMota = (TextView) view.findViewById(R.id.TeViewMota);
             holder.imgHinh =(ImageView) view.findViewById(R.id.ImViewBienbaocam);
             view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        //Gán giá trị
        BienBao baoCam= bienBaoCamList.get(i);
        holder.txtTen.setText(baoCam.getTen());
        holder.txtMota.setText(baoCam.getNoidung());
        holder.imgHinh.setImageResource(baoCam.getHinh());
        return view;
    }
}
