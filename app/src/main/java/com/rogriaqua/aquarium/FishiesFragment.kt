package com.rogriaqua.aquarium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rogriaqua.aquarium.databinding.FragmentFishiesBinding

class FishiesFragment: Fragment() {

    private lateinit var binding: FragmentFishiesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFishiesBinding.inflate(inflater)
        return binding.root
    }
}