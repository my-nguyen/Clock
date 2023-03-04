package com.theandroidfactory.clock

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MyViewModel: ViewModel() {
    private val _liveInfo = MutableLiveData<Info>()
    val liveInfo: LiveData<Info> = _liveInfo

    data class Info(val text: String, val rotation: Int, val backgroundColor: Int)

    fun onButtonClicked() {
        _liveInfo.postValue(getRandomInfo())
    }

    private fun getRandomInfo() =
        Info(Random().nextInt(100).toString(), Random().nextInt(360), getRandomColor())

    private fun getRandomColor() =
        Color.rgb(Random().nextInt(255), Random().nextInt(255), Random().nextInt(255))
}