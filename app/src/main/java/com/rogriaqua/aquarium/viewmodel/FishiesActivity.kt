package com.rogriaqua.aquarium.viewmodel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogriaqua.aquarium.FishiesAdapter
import com.rogriaqua.aquarium.FishiesData
import com.rogriaqua.aquarium.FishiesItemClickListener
import com.rogriaqua.aquarium.databinding.ActivityFishiesBinding
import com.rogriaqua.aquarium.models.Fishies

class FishiesActivity : AppCompatActivity(), FishiesItemClickListener {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityFishiesBinding

    private val adapter = FishiesAdapter(FishiesData().loadFishies(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFishiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getItems()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,
            false
        )
        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

    private fun setupObservables() {
        viewModel.items.observe(this) { fishiesList ->
            adapter.updateList(fishiesList)
        }
    }

    override fun onItemClick(fishies: Fishies) {
        Toast.makeText(this, "'${fishies.name} clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onFavoriteClick(fishies: Fishies) {
        Toast.makeText(this, "'${fishies.name} favorited", Toast.LENGTH_SHORT).show()
    }
}