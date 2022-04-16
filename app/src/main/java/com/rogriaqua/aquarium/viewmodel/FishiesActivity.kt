package com.rogriaqua.aquarium.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rogriaqua.aquarium.R
import com.rogriaqua.aquarium.databinding.ActivityFishiesBinding
import com.rogriaqua.aquarium.fragments.FishiesFragment

class FishiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFishiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFishiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, FishiesFragment())
            .addToBackStack(null)
            .commit()
    }
}