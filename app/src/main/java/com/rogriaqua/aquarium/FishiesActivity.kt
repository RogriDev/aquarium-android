package com.rogriaqua.aquarium

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogriaqua.aquarium.databinding.ActivityFishiesBinding

class FishiesActivity : AppCompatActivity(), FishiesItemClickListener {

    private lateinit var binding: ActivityFishiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFishiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = FishiesAdapter(FishiesData().loadFishies(), this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

    override fun onItemClick(fishies: Fishies) {
        Toast.makeText(this, "'${fishies.name} clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onFavoriteClick(fishies: Fishies) {
        Toast.makeText(this, "'${fishies.name} favorited", Toast.LENGTH_SHORT).show()
    }
}