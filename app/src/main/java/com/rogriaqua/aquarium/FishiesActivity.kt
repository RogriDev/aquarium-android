package com.rogriaqua.aquarium

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FishiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fishies)

        val onClickListener = ItemClickListener { fishies ->
            Toast.makeText(this, "'${fishies.name} clicked", Toast.LENGTH_SHORT).show()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = FishiesAdapter(FishiesData().loadFishies(), onClickListener)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }
}