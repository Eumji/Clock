package com.eumji.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.eumji.clock.alarm.Alarm
import com.eumji.clock.globaltimes.Globaltimes
import com.eumji.clock.stopwatch.Stopwatch
import com.eumji.clock.timer.Timer

class MainActivity : AppCompatActivity() ,View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transaction = supportFragmentManager.beginTransaction()
        setContentView(R.layout.activity_main)
        transaction.add(R.id.page_view, Alarm())
        transaction.commit()

        val buttonAlarm = findViewById<Button>(R.id.button_alarm)
        val buttonGlobaltime = findViewById<Button>(R.id.button_globaltime)
        val buttonStopwatch = findViewById<Button>(R.id.button_stopwatch)
        val buttonTimer = findViewById<Button>(R.id.button_timer)

        buttonAlarm.setOnClickListener(this)
        buttonGlobaltime.setOnClickListener(this)
        buttonStopwatch.setOnClickListener(this)
        buttonTimer.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val transaction = supportFragmentManager.beginTransaction()
        when (v.id) {
            R.id.button_alarm -> {
                transaction.replace(R.id.page_view,Alarm())
                transaction.commit()
            }
            R.id.button_globaltime -> {
                transaction.replace(R.id.page_view,Globaltimes())
                transaction.commit()
            }
            R.id.button_stopwatch -> {
                transaction.replace(R.id.page_view,Stopwatch())
                transaction.commit()
            }
            R.id.button_timer -> {
                transaction.replace(R.id.page_view,Timer())
                transaction.commit()
            }
        }
    }
}