package com.example.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendDataViewModel : ViewModel() {
    var text = MutableLiveData<String>()
}