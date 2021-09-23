package com.eumji.clock.alarm

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.eumji.clock.R
import java.util.ArrayList

class AlarmRecyclerAdapter(private val items: ArrayList<Alarm>) :
    RecyclerView.Adapter<AlarmRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.alarm_item, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listener = View.OnClickListener { _ ->
            val intent= Intent(holder.itemView.context, AlarmDetailActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
        holder.bind(listener, items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private var v: View) : RecyclerView.ViewHolder(v) {
        fun bind(listener: View.OnClickListener, item: Alarm) {
            v.setOnClickListener(listener)
        }
    }

}