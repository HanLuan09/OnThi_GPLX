package com.example.btl.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.btl.R;
import com.example.btl.model.Question;
import androidx.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.*;

public class QuestionFragment extends Fragment {
    private TextView textVQuestion;
    private RadioButton a,b,c,d;
    private View mview;
    private ImageView anh;


    public QuestionFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_question, container, false);
        textVQuestion = mview.findViewById(R.id.tv_qstion);
        a = mview.findViewById(R.id.optionA);
        b = mview.findViewById(R.id.optionB);
        c = mview.findViewById(R.id.optionC);
        d = mview.findViewById(R.id.optionD);
        anh = mview.findViewById(R.id.imv_qstionanh);
        Xuly();
        return mview;
    }

    public void Xuly() {
        Bundle bundleRective = getArguments();
        if(bundleRective!= null){
            Question question = (Question) bundleRective.get("questionObject");
            if(question!=null){
                textVQuestion.setText(question.getName());
                a.setText(question.getCau_a());
                b.setText(question.getCau_b());
                c.setText(question.getCau_c());
                d.setText(question.getCau_d());
                if(question.getImg()!=0)
                    anh.setImageResource(question.getImg());

                else{
                    anh.setVisibility(View.GONE);
                }
                if(c.getText().toString().trim().length() == 0) {
                    c.setVisibility(View.GONE);
                }
                if(d.getText().toString().trim().length() == 0){
                    d.setVisibility(View.GONE);
                }
            }
        }
    }

}