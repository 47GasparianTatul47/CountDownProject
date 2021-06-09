package com.example

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity2
import com.example.myapplication.R


var countDown: CountDownTimer? = null
lateinit var timer: TextView
var remainingtime: Long = 0


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer = findViewById(R.id.timerTV)
        val startTimerBTN = findViewById<Button>(R.id.startTimer)
        val intentNewActivity = findViewById<Button>(R.id.newactivityIntent)


        startTimerBTN.setOnClickListener {

            countDown = object : CountDownTimer(15000, 1000) {
                override fun onTick(millisUntilFinished: Long) {

                    timer.text = (millisUntilFinished / 1000).toString()
                    remainingtime=millisUntilFinished;



                }

                override fun onFinish() {

                    timer.text = "finish"
                }

            }

            countDown?.start()
        }

        intentNewActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("timerPosition", remainingtime)
            startActivity(intent)

        }
    }

    override fun onPause() {
        super.onPause()
        countDown?.cancel()
    }
}