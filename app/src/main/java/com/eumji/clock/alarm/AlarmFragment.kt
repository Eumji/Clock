package com.eumji.clock.alarm

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.eumji.clock.R
import com.eumji.clock.VerticalItemDecorator
import com.eumji.clock.data.Alarm
import com.google.android.material.appbar.AppBarLayout
import java.lang.IllegalStateException
import kotlin.math.abs

class AlarmFragment : Fragment(), View.OnClickListener {
    private lateinit var alarmRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val alarmAppBarPlusButton: ImageButton = view.findViewById(R.id.alarm_appbar_plus)
        val alarmAppBarMenuButton: ImageButton= view.findViewById(R.id.alarm_appbar_menu)
        alarmAppBarPlusButton.setOnClickListener(this)
        alarmAppBarMenuButton.setOnClickListener(this)

        val alarmAppBarTitle: TextView = view.findViewById(R.id.alarm_appbar_title)
        val appBarLayout: AppBarLayout = view.findViewById(R.id.alarm_appbar)

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{_, verticalOffset ->
            appBarLayout.post{
                try{
                    if(abs(verticalOffset) >= appBarLayout.totalScrollRange){
                        alarmAppBarTitle.text="알람"
                    }
                    else{
                        alarmAppBarTitle.text=" "
                    }
                } catch (ex: IllegalStateException){
                    println(ex.localizedMessage)
                }
            }
        })

        val list = ArrayList<Alarm>()
        for(i in 1..5){
            list.add(Alarm(
                title="출근",
                holiday = true,
                convertTime = true,
                time = "6:20",
                date = "",
                day = booleanArrayOf(false, true, true, true, true, true, false),
                everyDay = false,
                switch = true
            ))
        }
        for(i in 1..8){
            list.add(Alarm(
                title="결제",
                holiday = false,
                convertTime = false,
                time = "11:58",
                date = "9월 28일 (화)",
                day = booleanArrayOf(),
                everyDay = false,
                switch = true
            ))
        }
        for(i in 1..3){
            list.add(Alarm(
                title="영어 단어",
                holiday = false,
                convertTime = true,
                time = "10:00",
                date = "",
                day = booleanArrayOf(),
                everyDay = true,
                switch = false
            ))
        }

        alarmRecyclerView = view.findViewById(R.id.alarm_recyclerview)
        alarmRecyclerView.adapter = AlarmRecyclerAdapter(list)
        alarmRecyclerView.addItemDecoration(VerticalItemDecorator(20))
    }

    override fun onClick(v: View){
        when (v.id) {
            R.id.alarm_appbar_plus->{
                val intent= Intent(activity, AlarmDetailActivity::class.java)
                startActivity(intent)
            }
            R.id.alarm_appbar_menu->{
                popupAlarmMenu(v)
            }
        }
    }

    private fun popupAlarmMenu(v: View){
        val wrapper = ContextThemeWrapper(activity, R.style.BasePopupMenu)
        val popupMenu= PopupMenu(wrapper,  v)
        popupMenu.menuInflater.inflate(R.menu.alarm_menu,popupMenu.menu)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.alarm_menu_sleep_setting -> {
                    Toast.makeText(activity, "click on sleep setting", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.alarm_menu_edit ->{
                    Toast.makeText(activity, "click on edit", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.alarm_menu_sort ->{
                    Toast.makeText(activity, "click on sort", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.alarm_menu_setting ->{
                    Toast.makeText(activity, "click on setting", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.alarm_menu_question ->{
                    Toast.makeText(activity, "click on question", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
            }
            return@setOnMenuItemClickListener false
        }
    }
}