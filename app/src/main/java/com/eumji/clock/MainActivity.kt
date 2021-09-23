package com.eumji.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.eumji.clock.alarm.AlarmFragment
import com.eumji.clock.globalTime.GlobalTimeFragment
import com.eumji.clock.stopwatch.StopwatchFragment
import com.eumji.clock.timer.TimerFragment

class MainActivity : AppCompatActivity() ,View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transaction = supportFragmentManager.beginTransaction()
        setContentView(R.layout.activity_main)
        transaction.replace(R.id.page_view, AlarmFragment())
        transaction.commit()

        val buttonAlarm = findViewById<Button>(R.id.button_alarm)
        val buttonGlobalTime = findViewById<Button>(R.id.button_global_time)
        val buttonStopwatch = findViewById<Button>(R.id.button_stopwatch)
        val buttonTimer = findViewById<Button>(R.id.button_timer)

        buttonAlarm.setOnClickListener(this)
        buttonGlobalTime.setOnClickListener(this)
        buttonStopwatch.setOnClickListener(this)
        buttonTimer.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val transaction = supportFragmentManager.beginTransaction()
        when (v.id) {
            R.id.button_alarm -> {
                transaction.replace(R.id.page_view, AlarmFragment())
                transaction.commit()
            }
            R.id.button_global_time -> {
                transaction.replace(R.id.page_view, GlobalTimeFragment())
                transaction.commit()
            }
            R.id.button_stopwatch -> {
                transaction.replace(R.id.page_view, StopwatchFragment())
                transaction.commit()
            }
            R.id.button_timer -> {
                transaction.replace(R.id.page_view, TimerFragment())
                transaction.commit()
            }
        }
    }
}