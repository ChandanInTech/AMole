package com.kurella.amole

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var activeButtonLD = MutableLiveData(Pair(-1, -1))
    private lateinit var timer: CountDownTimer
    val winStateLD = MutableLiveData(false)

    companion object {
        const val SECOND = 500.toLong()
    }

    init {
        startTimer()
    }

    private fun startTimer() {
        getRand()

        timer = object : CountDownTimer(SECOND, SECOND) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                getRand()

                timer.start()
            }
        }
        timer.start()
    }

    fun getRand() {
        activeButtonLD.value?.also {
            activeButtonLD.value = Pair(it.second, (0..8).random())
        }
    }

    fun onButtonClick(i: Int) {
        if (i == activeButtonLD.value?.second) {
            winStateLD.value = true
            timer.cancel()
        }
    }

    fun reset() {
        startTimer()
    }
}