package com.team.ggzz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _url: MutableLiveData<String> = MutableLiveData("https://www.naver.com")
    val url: LiveData<String>
        get() = _url

}