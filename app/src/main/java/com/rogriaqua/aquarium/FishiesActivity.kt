package com.rogriaqua.aquarium

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogriaqua.aquarium.databinding.ActivityFishiesBinding

class FishiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFishiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFishiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val onClickListener = ItemClickListener { fishies ->
            Toast.makeText(this, "'${fishies.name} clicked", Toast.LENGTH_SHORT).show()
        }

        val adapter = FishiesAdapter(FishiesData().loadFishies(), onClickListener)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

    }
}