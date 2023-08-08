package com.rajibul.expensetracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajibul.expensetracker.roomdatabase.CategoryEntity

class categoryRecycler(var category: ArrayList<CategoryEntity>) : RecyclerView.Adapter<categoryRecycler.ViewHolder>()  {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvID = view.findViewById<TextView>(R.id.tvID)
        var tvName = view.findViewById<TextView>(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycleritem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(category[position].name)

    }
}