package com.eumji.clock.alarm

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.eumji.clock.R

class AlarmDetailSettingActivity: AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transaction = supportFragmentManager.beginTransaction()
        setContentView(R.layout.alarm_detail_setting)

        val settingTitle = findViewById<TextView>(R.id.alarm_detail_setting_title)

        when(intent.getStringExtra("title")){
            "holiday" -> {
                settingTitle.text="공휴일엔 알람 끄기"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmHolidayFragment())
                transaction.commit()}
            "sound" -> {
                settingTitle.text="알람음"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmSoundFragment())
                transaction.commit()}
            "vibration" -> {
                settingTitle.text="진동"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmVibrationFragment())
                transaction.commit() }
            "repeat" -> {
                settingTitle.text="다시 울림"
                transaction.replace(R.id.alarm_detail_setting_view,AlarmRepeatFragment())
                transaction.commit() }
        }

        val settingBack = findViewById<ImageButton>(R.id.alarm_detail_setting_back)
        settingBack.setOnClickListener(this)
        val settingSwitch = findViewById<SwitchCompat>(R.id.alarm_detail_setting_switch)
        settingSwitch.setOnCheckedChangeListener{ _, isChecked->
            settingSwitch.text = if(isChecked) "사용 중" else "사용 안 함"
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