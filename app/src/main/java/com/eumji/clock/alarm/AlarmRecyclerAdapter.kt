package com.eumji.clock.alarm

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.eumji.clock.R
import com.eumji.clock.data.Alarm
import java.util.ArrayList

class AlarmRecyclerAdapter(private val alarms: ArrayList<Alarm>) :
    RecyclerView.Adapter<AlarmRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.alarm_item, parent, false)
        return ViewHolder(inflatedView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        alarms[position].let{ alarm->
            with(holder){
                alarmTitle.text = alarm.title

                if(alarm.holiday) alarmHoliday.setTextColor(R.color.font)
                else alarmHoliday.setTextColor(R.color.font2)

                alarmConvertTime.text = if(alarm.convertTime) "오전" else "오후"

                alarmTime.text = alarm.time

                if(alarm.date!="" || alarm.everyDay){
                    alarmDate.visibility = View.VISIBLE
                    alarmDay.visibility = View.GONE
                    alarmHoliday.visibility=View.GONE
                    alarmDate.text = if(alarm.everyDay) "매일" else alarm.date
                }
                else{
                    alarmDate.visibility = View.GONE
                    alarmDay.visibility = View.VISIBLE
                    alarmHoliday.visibility=View.VISIBLE

                    for(i in 0..6){
                        alarmDayArray[i].text = alarmDayText[i]
                        if(alarm.day[i]) alarmDayArray[i].setTextColor(R.color.purple)
                        else alarmDayArray[i].setTextColor(R.color.font2)
                    }
                }

                alarmSwitch.isChecked = alarm.switch

            }
        }

        val listener = View.OnClickListener { _ ->
            val intent= Intent(holder.itemView.context, AlarmDetailActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
        holder.bind(listener, alarms[position])
    }

    override fun getItemCount(): Int = alarms.size

    class ViewHolder(private var v: View) : RecyclerView.ViewHolder(v) {

        val alarmTitle: TextView = v.findViewById(R.id.alarm_item_title)
        val alarmHoliday: TextView = v.findViewById(R.id.alarm_item_holiday)
        val alarmConvertTime: TextView = v.findViewById(R.id.alarm_item_convert_time)
        val alarmTime: TextView = v.findViewById(R.id.alarm_item_time)
        val alarmDate: TextView = v.findViewById(R.id.alarm_item_date)
        val alarmDay: LinearLayout = v.findViewById(R.id.alarm_item_day)
        val alarmSwitch: androidx.appcompat.widget.SwitchCompat = v.findViewById(R.id.alarm_item_switch)

        val sun: TextView = v.findViewById(R.id.alarm_sun)
        val mon: TextView = v.findViewById(R.id.alarm_mon)
        val tue: TextView = v.findViewById(R.id.alarm_tue)
        val wed: TextView = v.findViewById(R.id.alarm_wed)
        val thu: TextView = v.findViewById(R.id.alarm_thu)
        val fri: TextView = v.findViewById(R.id.alarm_fri)
        val sat: TextView = v.findViewById(R.id.alarm_sat)

        var alarmDayArray = arrayListOf(sun, mon, tue, wed, thu, fri, sat)
        var alarmDayText = arrayListOf("일", "월", "화", "수", "목", "금", "토")

        fun bind(listener: View.OnClickListener, item: Alarm) {
            v.setOnClickListener(listener)
        }
    }
}