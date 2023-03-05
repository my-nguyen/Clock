package com.theandroidfactory.clock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _segmentTop = MutableLiveData(R.color.unselected)
    val segmentTop: LiveData<Int> = _segmentTop
    private val _segmentTopLeft = MutableLiveData(R.color.unselected)
    val segmentTopLeft: LiveData<Int> = _segmentTopLeft
    private val _segmentTopRight = MutableLiveData(R.color.unselected)
    val segmentTopRight: LiveData<Int> = _segmentTopRight
    private val _segmentMiddle = MutableLiveData(R.color.unselected)
    val segmentMiddle: LiveData<Int> = _segmentMiddle
    private val _segmentBottomLeft = MutableLiveData(R.color.unselected)
    val segmentBottomLeft: LiveData<Int> = _segmentBottomLeft
    private val _segmentBottomRight = MutableLiveData(R.color.unselected)
    val segmentBottomRight: LiveData<Int> = _segmentBottomRight
    private val _segmentBottom = MutableLiveData(R.color.unselected)
    val segmentBottom: LiveData<Int> = _segmentBottom

    private val segments = listOf(
        _segmentTop,
        _segmentTopLeft,
        _segmentTopRight,
        _segmentMiddle,
        _segmentBottomLeft,
        _segmentBottomRight,
        _segmentBottom
    )
    private val map = mapOf(
        _segmentTop to listOf(0, 2, 3, 5, 6, 7, 8, 9),
        _segmentTopLeft to listOf(0, 4, 5, 6, 8, 9),
        _segmentTopRight to listOf(0, 1, 2, 3, 4, 7, 8, 9),
        _segmentMiddle to listOf(2, 3, 4, 5, 6, 8, 9),
        _segmentBottomLeft to listOf(0, 2, 6, 8),
        _segmentBottomRight to listOf(0, 1, 3, 4, 5, 6, 7, 8, 9),
        _segmentBottom to listOf(0, 2, 3, 5, 6, 8)
    )

    fun onNewDigit(digit: Int) {
        segments.forEach {
            val color = if (map[it]!!.contains(digit)) R.color.selected else R.color.unselected
            it.postValue(color)
        }
    }

    fun startCounting() {
        viewModelScope.launch {
            repeat(10) {
                onNewDigit(it)
                delay(1000)
            }
        }
    }
}