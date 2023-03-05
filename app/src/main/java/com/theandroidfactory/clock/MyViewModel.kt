package com.theandroidfactory.clock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    val hourLeft = DigitDisplay()
    val hourRight = DigitDisplay()
    val secondLeft = DigitDisplay()
    val secondRight = DigitDisplay()

    fun startCounting() {
        viewModelScope.launch {
            var index = 0
            while (true) {
                val hours = index / 60
                val seconds = index % 60
                hourLeft.onNewDigit(hours / 10)
                hourRight.onNewDigit(hours % 10)
                secondLeft.onNewDigit(seconds / 10)
                secondRight.onNewDigit(seconds % 10)
                index++
                delay(250)
            }
        }
    }
}