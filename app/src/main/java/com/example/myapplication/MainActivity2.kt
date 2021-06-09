package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var countDown2: CountDownTimer? = null
lateinit var timer2: TextView


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        timer2 = findViewById(R.id.timerTV2)
        val time: Long = intent.getLongExtra("timerPosition", 0)
        timerStart2(time)


    }

    fun timerStart2(mils: Long) {
        countDown2 = object : CountDownTimer(mils, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                timer2.text = (millisUntilFinished / 1000).toString()

            }

            override fun onFinish() {

                timer2.text = "finish"
            }

        }
        countDown2?.start()
    }

    override fun onPause() {
        super.onPause()
        countDown2?.cancel()

    }

}
