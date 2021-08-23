package com.eumji.clock.alarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eumji.clock.R
import com.eumji.clock.VerticalItemDecorator
import com.eumji.clock.alarm.AlarmRecyclerAdapter
import com.eumji.clock.databinding.ActivityMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Alarm.newInstance] factory method to
 * create an instance of this fragment.
 */
class Alarm : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<AlarmItem>()

        list.add(AlarmItem(1))
        list.add(AlarmItem(2))
        list.add(AlarmItem(3))
        list.add(AlarmItem(4))
        list.add(AlarmItem(5))
        list.add(AlarmItem(6))
        alarmRecyclerView = view.findViewById(R.id.alarm_recyclerview)
        alarmRecyclerView.adapter = AlarmRecyclerAdapter(list)
        alarmRecyclerView.addItemDecoration(VerticalItemDecorator(20))
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Alarm.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Alarm().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}