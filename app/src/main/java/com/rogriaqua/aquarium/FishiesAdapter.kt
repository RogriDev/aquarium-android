package com.rogriaqua.aquarium

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogriaqua.aquarium.databinding.ItemFishiesBinding

class FishiesAdapter(
    private val list: List<Fishies>,
    private val onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<FishiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishiesViewHolder {
        return FishiesViewHolder(
            ItemFishiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FishiesViewHolder, position: Int) {
        val fishies = list[position]
        holder.bind(fishies, onItemClickListener)
    }

    override fun getItemCount(): Int = list.size
}

class FishiesViewHolder(private val view: ItemFishiesBinding) : RecyclerView.ViewHolder(view.root) {

    fun bind(fishies: Fishies, onItemClickListener: ItemClickListener) {
        view.apply {
            setOnClickListener { onItemClickListener.onClick(fishies) }
            imageButtonFavorite.setImageResource(fishies.favorite)
            imageItemFish.setImageResource(fishies.image)
            textFishName.text = fishies.name
            textWaterType.text = fishies.water
        }
    }

    private fun setOnClickListener(function: () -> Unit) {

    }
}

fun interface ItemClickListener {
    fun onClick(fishies: Fishies)
}

