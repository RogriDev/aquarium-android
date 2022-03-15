package com.rogriaqua.aquarium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FishiesAdapter(
    private val list: List<Fishies>,
    private val onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<FishiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishiesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fishies, parent, false)
        return FishiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FishiesViewHolder, position: Int) {
        val fishies = list[position]
        holder.bind(fishies, onItemClickListener)
    }

    override fun getItemCount(): Int = list.size
}

class FishiesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(fishies: Fishies, onItemClickListener: ItemClickListener) {
        view.apply {
            setOnClickListener { onItemClickListener.onClick(fishies) }
            findViewById<ImageView>(R.id.image_item_fish).setImageResource(fishies.image)
            findViewById<TextView>(R.id.text_fish_name).text = fishies.name
            findViewById<TextView>(R.id.text_water_type).text = fishies.water
        }
    }
}

fun interface ItemClickListener {
    fun onClick(fishies: Fishies)
}

