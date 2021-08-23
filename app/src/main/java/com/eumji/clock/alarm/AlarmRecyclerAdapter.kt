package com.eumji.clock.alarm;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.eumji.clock.R
import java.util.ArrayList

class AlarmRecyclerAdapter(private val items: ArrayList<AlarmItem>) :
    RecyclerView.Adapter<AlarmRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.alarm_item, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, items[position].time.toString(), Toast.LENGTH_SHORT).show()
        }
        holder.bind(listener, items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private var v: View) : RecyclerView.ViewHolder(v) {
        fun bind(listener: View.OnClickListener, item: AlarmItem) {
            v.setOnClickListener(listener)
        }
    }

}