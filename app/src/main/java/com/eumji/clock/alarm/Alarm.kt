package com.eumji.clock.alarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eumji.clock.R
import com.eumji.clock.VerticalItemDecorator
import com.google.android.material.appbar.AppBarLayout
import java.lang.IllegalStateException
import java.lang.Math.abs

class Alarm : Fragment() {
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
        val view: View = inflater.inflate(R.layout.fragment_alarm, container, false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val alarmTextView: TextView = view.findViewById(R.id.alarm_appbar_title)
        val appBarLayout: AppBarLayout = view.findViewById(R.id.alarm_appbar)
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{_, verticalOffset ->
            appBarLayout.post{
                try{
                    if(abs(verticalOffset)>= appBarLayout.totalScrollRange){
                        alarmTextView.text="알람"
                    }
                    else{
                        alarmTextView.text=" "
                    }
                } catch (ex: IllegalStateException){
                    println(ex.localizedMessage)
                }
            }
        })

        val list = ArrayList<AlarmItem>()
        for(i in 1..13){
            list.add(AlarmItem(i))
        }
        alarmRecyclerView = view.findViewById(R.id.alarm_recyclerview)
        alarmRecyclerView.adapter = AlarmRecyclerAdapter(list)
        alarmRecyclerView.addItemDecoration(VerticalItemDecorator(20))

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Alarm().apply {
                arguments = Bundle().apply {
                }
            }
    }
}