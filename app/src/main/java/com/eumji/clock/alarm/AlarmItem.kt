package com.eumji.clock.alarm

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.eumji.clock.R
import org.w3c.dom.Text

class AlarmItem: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sun = findViewById<TextView>(R.id.alarm_sun)
        val mon = findViewById<TextView>(R.id.alarm_mon)
        val tue = findViewById<TextView>(R.id.alarm_tue)
        val wed = findViewById<TextView>(R.id.alarm_wed)
        val thu = findViewById<TextView>(R.id.alarm_thu)
        val fri = findViewById<TextView>(R.id.alarm_fri)
        val sat = findViewById<TextView>(R.id.alarm_sat)

        sun.text="일"
        mon.text="월"
        tue.text="화"
        wed.text="수"
        thu.text="목"
        fri.text="금"
        sat.text="토"
    }
}