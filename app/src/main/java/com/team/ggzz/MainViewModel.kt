package com.team.ggzz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _url: MutableLiveData<String> = MutableLiveData("http://10.0.2.2:3000")
    val url: LiveData<String>
        get() = _url

}