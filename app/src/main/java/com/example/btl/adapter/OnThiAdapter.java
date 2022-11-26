package com.example.btl.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.*;
import android.view.ViewGroup;
import android.widget.*;

import androidx.fragment.app.FragmentManager;

import com.example.btl.R;
import com.example.btl.model.OnTap;
import java.util.List;

public class OnThiAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<OnTap> onTapList;

    public OnThiAdapter(Context context, int layout, List<OnTap> onTapList) {
        this.context = context;
        this.layout = layout;
        this.onTapList = onTapList;
    }


    @Override
    public int getCount() {
        return onTapList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHold{//ãnh xạ view
        public ImageView imgHinh;
        public TextView txtNd,txtDan1,txtDan2,txtDan3,txtDan4,txtDan,txtGiaithich, txtXemdapAn;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        OnThiAdapter.ViewHold holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new OnThiAdapter.ViewHold();
            // ánh xạ view
            holder.txtNd =  view.findViewById(R.id.TeViewndOntap);
            holder.txtDan1 =  view.findViewById(R.id.TeViewDan1);
            holder.txtDan2 =  view.findViewById(R.id.TeViewDan2);
            holder.txtDan3 =  view.findViewById(R.id.TeViewDan3);
            holder.txtDan4 =  view.findViewById(R.id.TeViewDan4);
            holder.txtXemdapAn = view.findViewById(R.id.TeViewXemDapan);
            holder.txtDan =  view.findViewById(R.id.TeViewDan);
            holder.txtGiaithich =  view.findViewById(R.id.TeViewgiathich);
            holder.imgHinh = view.findViewById(R.id.ImViewHinhBienbao);
            view.setTag(holder);
        }
        else{
            holder = (OnThiAdapter.ViewHold) view.getTag();
        }
        //Gán giá trị
        OnTap onTap= onTapList.get(i);
        holder.txtNd.setText(onTap.getCauhoi());
        holder.txtDan1.setText(onTap.getDan_a());
        holder.txtDan2.setText(onTap.getDan_b());
        holder.txtDan3.setText(onTap.getDan_c());
        holder.txtDan4.setText(onTap.getDan_d());
        holder.txtDan.setText(onTap.getDap_an());
        holder.txtGiaithich.setText(onTap.getGoi_y());
        holder.imgHinh.setImageResource(onTap.getAnh());
        holder.txtXemdapAn.setText("Xem đáp án");
        holder.txtXemdapAn.setVisibility(View.VISIBLE);
        holder.txtDan.setVisibility(View.GONE);
        holder.txtGiaithich.setVisibility(View.GONE);
        holder.txtXemdapAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.txtXemdapAn.setVisibility(View.GONE);
                holder.txtDan.setVisibility(View.VISIBLE);
                holder.txtGiaithich.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}
