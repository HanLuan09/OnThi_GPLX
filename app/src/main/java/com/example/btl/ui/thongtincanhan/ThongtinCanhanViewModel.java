package com.example.btl.ui.thongtincanhan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThongtinCanhanViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ThongtinCanhanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is thong tin ca nhan");
    }

    public LiveData<String> getText() {
        return mText;
    }
}