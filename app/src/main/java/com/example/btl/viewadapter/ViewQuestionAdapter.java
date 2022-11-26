package com.example.btl.viewadapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.btl.fragment.QuestionFragment;
import com.example.btl.model.Question;

import java.util.List;

public class ViewQuestionAdapter extends FragmentStatePagerAdapter {
    private List<Question> questionList;
    public ViewQuestionAdapter(@NonNull FragmentManager fm, int behavior, List<Question> list) {
        super(fm,behavior);
        this.questionList = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(questionList ==null || questionList.isEmpty())  return null;
        Question question = questionList.get(position);
        QuestionFragment questionFragment = new QuestionFragment();
        Bundle bundle= new Bundle();
        bundle.putSerializable("questionObject", question );
        questionFragment.setArguments(bundle);
        return questionFragment;
    }

    @Override
    public int getCount() {
        if(questionList!=null) return questionList.size();
        return 0;
    }
}
