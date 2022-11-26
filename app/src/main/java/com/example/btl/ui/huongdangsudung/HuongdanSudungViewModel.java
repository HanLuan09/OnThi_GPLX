package com.example.btl.ui.huongdangsudung;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HuongdanSudungViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HuongdanSudungViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}