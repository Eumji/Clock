package com.eumji.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<AlarmItem>()

        list.add(AlarmItem(1))
        list.add(AlarmItem(2))
        list.add(AlarmItem(3))
        list.add(AlarmItem(4))
        list.add(AlarmItem(5))
        list.add(AlarmItem(6))
        alarm_recyclerview.adapter = AlarmRecyclerAdapter(list)
        alarm_recyclerview.addItemDecoration(VerticalItemDecorator(20))
    }

}