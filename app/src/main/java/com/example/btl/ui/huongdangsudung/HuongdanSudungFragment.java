package com.example.btl.ui.huongdangsudung;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.btl.NavigationHomeActivity;
import com.example.btl.R;
import com.example.btl.model.JsonResolve;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HuongdanSudungFragment extends Fragment {
    private TextView tvsd;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_huongdan_sudung, container, false);
        tvsd = view.findViewById(R.id.tvnhay);
//        InputStream in= getResources().openRawResource(R.raw.gioithieu);
//        InputStreamReader inreader=new InputStreamReader(in);
//        BufferedReader bufreader=new BufferedReader(inreader);
//        StringBuilder builder=new StringBuilder();
//        Gson gson = new Gson();
//        JsonResolve gioithieu =gson.fromJson(bufreader,JsonResolve.class);
//        ((TextView)view.findViewById(R.id.tvtn)).setText(gioithieu.getContent());
        controlerTexView();
        return view;
    }

    private void controlerTexView() {
        tvsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), NavigationHomeActivity.class);
                startActivity(it);
            }
        });
    }
}