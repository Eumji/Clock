package com.eumji.clock.alarm

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.eumji.clock.R
import com.eumji.clock.globaltimes.Globaltimes
import com.eumji.clock.stopwatch.Stopwatch
import com.eumji.clock.timer.Timer

class AlarmCreate : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm_create_page)
    }
}