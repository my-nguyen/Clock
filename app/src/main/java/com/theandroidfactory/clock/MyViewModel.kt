package com.theandroidfactory.clock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val _liveSegment = MutableLiveData(R.color.unselected)
    val liveSegment: LiveData<Int> = _liveSegment

    fun onButtonClicked() {
        val currentColor = _liveSegment.value
        val newColor = if (currentColor == R.color.unselected) R.color.selected else R.color.unselected
        _liveSegment.postValue(newColor)
    }
}