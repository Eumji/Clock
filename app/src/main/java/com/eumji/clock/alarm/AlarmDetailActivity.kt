package com.eumji.clock.alarm

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.eumji.clock.R
import java.text.SimpleDateFormat
import java.util.*

class AlarmDetailActivity : AppCompatActivity(), View.OnClickListener {
    private val cal: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm_detail_page)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

        val alarmDatePicker = findViewById<ImageButton>(R.id.alarm_date_picker)
        alarmDatePicker.setOnClickListener {
            DatePickerDialog(
                this@AlarmDetailActivity,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        setDayItemListener()
        setSettingItemListener()
    }

    private fun updateDateInView() {
        val alarmTitle = findViewById<TextView>(R.id.alarm_detail_title)
        val mDateFormat = "yyyy.MM.dd"
        val sdf = SimpleDateFormat(mDateFormat, Locale.KOREA)
        alarmTitle!!.text = sdf.format(cal.time)
    }

    private fun setDayItemListener(){
        val sun = findViewById<TextView>(R.id.detail_sun)
        val mon = findViewById<TextView>(R.id.detail_mon)
        val tue = findViewById<TextView>(R.id.detail_tue)
        val wed = findViewById<TextView>(R.id.detail_wed)
        val thu = findViewById<TextView>(R.id.detail_thu)
        val fri = findViewById<TextView>(R.id.detail_fri)
        val sat = findViewById<TextView>(R.id.detail_sat)

        sun.addClickListener("???")
        mon.addClickListener("???")
        tue.addClickListener("???")
        wed.addClickListener("???")
        thu.addClickListener("???")
        fri.addClickListener("???")
        sat.addClickListener("???")
    }

    private fun setSettingItemListener(){
        val holiday = findViewById<LinearLayout>(R.id.alarm_detail_holiday)
        val sound = findViewById<LinearLayout>(R.id.alarm_detail_sound)
        val vibration = findViewById<LinearLayout>(R.id.alarm_detail_vibration)
        val repeat = findViewById<LinearLayout>(R.id.alarm_detail_repeat)

        holiday.setOnClickListener(this)
        sound.setOnClickListener(this)
        vibration.setOnClickListener(this)
        repeat.setOnClickListener(this)

        holiday.setTitleBody("holiday", getString(R.string.detail_setting_holiday_body))
        sound.setTitleBody("sound", "Homecoming")
        vibration.setTitleBody("vibration", "?????? ??? ???")
        repeat.setTitleBody("repeat", "5???, 3???")
    }

    private fun LinearLayout.setTitleBody(title : String, body : String){
        val titleText = this.findViewById<TextView>(R.id.detail_item_title)
        val bodyText = this.findViewById<TextView>(R.id.detail_item_body)
        when(title){
            "holiday"->titleText.text="???????????? ?????? ??????"
            "sound"->titleText.text="?????????"
            "vibration"->titleText.text="??????"
            "repeat"->titleText.text="?????? ??????"
        }
        bodyText.text=body
    }

    override fun onClick(v: View){
        when (v.id) {
            R.id.alarm_detail_holiday->{
                val intent = Intent(this, AlarmDetailSettingActivity::class.java).apply{
                    putExtra("title", "holiday")
                }
                startActivity(intent)
            }
            R.id.alarm_detail_sound->{
                val intent = Intent(this, AlarmDetailSettingActivity::class.java).apply{
                    putExtra("title", "sound")
                }
                startActivity(intent)
            }
            R.id.alarm_detail_vibration->{
                val intent = Intent(this, AlarmDetailSettingActivity::class.java).apply{
                    putExtra("title", "vibration")
                }
                startActivity(intent)
            }
            R.id.alarm_detail_repeat->{
                val intent = Intent(this, AlarmDetailSettingActivity::class.java).apply{
                    putExtra("title", "repeat")
                }
                startActivity(intent)
            }
        }
    }

    private fun TextView.addClickListener(day : String){
        this.text=day
        var isClicked = false

        this.setOnClickListener{
            isClicked = !isClicked
            this.background = if(isClicked) ContextCompat.getDrawable(this.context, R.drawable.circle) else null
        }
    }
}