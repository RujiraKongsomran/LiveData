package com.rujirakongsomran.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    // Create set text method
    public void setText(String s) {
        // Set value
        mutableLiveData.setValue(s);
    }

    // Create get text method
    public MutableLiveData<String> getText() {
        // Return value
        return mutableLiveData;
    }
}


