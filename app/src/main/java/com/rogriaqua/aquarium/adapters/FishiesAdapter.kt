package com.rogriaqua.aquarium

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogriaqua.aquarium.databinding.ItemFishiesBinding
import com.rogriaqua.aquarium.models.Fishies

class FishiesAdapter(
    private var list: List<Fishies>,
    private val onItemClickListener: FishiesItemClickListener
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

    fun updateList(list: List<Fishies>) {
        this.list = list

        notifyDataSetChanged()
    }
}

class FishiesViewHolder(private val binding: ItemFishiesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(fishies: Fishies, onItemClickListener: FishiesItemClickListener) {
        binding.apply {
            root.setOnClickListener { onItemClickListener.onItemClick(fishies) }
            imageButtonFavorite.setImageResource(R.drawable.button_favorite)
            imageButtonFavorite.setOnClickListener {
                if (fishies.isFavorite) {
                    imageButtonFavorite.setImageResource(R.drawable.button_favorite)
                } else {
                    imageButtonFavorite.setImageResource(R.drawable.favorite_filled)
                }
                onItemClickListener.onFavoriteClick(fishies)
            }
            imageItemFish.setImageResource(fishies.image)
            textFishName.text = fishies.name
            textWaterType.text = fishies.water
        }
    }
}

interface FishiesItemClickListener {
    fun onItemClick(fishies: Fishies)
    fun onFavoriteClick(fishies: Fishies)
}
