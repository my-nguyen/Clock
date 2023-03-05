package com.theandroidfactory.clock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    val digitLeft = DigitDisplay()
    val digitRight = DigitDisplay()

    fun startCounting() {
        viewModelScope.launch {
            var index = 0
            while (true) {
                digitLeft.onNewDigit(index / 10)
                digitRight.onNewDigit(index % 10)
                index++
                delay(1000)
            }
        }
    }
}