package com.eumji.clock.alarm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.eumji.clock.R

class AlarmDetailSetting: AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transaction = supportFragmentManager.beginTransaction()
        setContentView(R.layout.alarm_detail_setting)

        val settingTitle = findViewById<TextView>(R.id.alarm_detail_setting_title)

        when(intent.getStringExtra("title")){
            "holiday" -> {
                settingTitle.text="공휴일엔 알람 끄기"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmHoliday())
                transaction.commit()
            }
            "sound" -> {
                settingTitle.text="알람음"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmSound())
                transaction.commit()
            }
            "vibration" -> {
                settingTitle.text="진동"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmVibration())
                transaction.commit()
            }
            "repeat" -> {
                settingTitle.text="다시 울림"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmRepeat())
                transaction.commit()
            }
        }

        val settingBack = findViewById<ImageButton>(R.id.alarm_detail_setting_back)
        settingBack.setOnClickListener(this)
        val settingSwitch = findViewById<SwitchCompat>(R.id.alarm_detail_setting_switch)
        settingSwitch.setOnCheckedChangeListener{buttonView, isChecked->
            if(isChecked){
                settingSwitch.text="사용 중"
            }
            else {
                settingSwitch.text="사용 안 함"
            }

        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.alarm_detail_setting_back->{
                finish()
            }
        }
    }
}