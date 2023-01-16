package com.example.catfacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.R
import com.example.catfacts.api.CatModel

class MainAdapter(private var factList: ArrayList<CatModel>): RecyclerView.Adapter<MainAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fact_view, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.textViewFact.text = factList[position].text
    }
    override fun getItemCount(): Int {
        return factList.size
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var textViewFact: TextView
        init {
            textViewFact = view.findViewById(R.id.textViewFact)
        }
    }
}