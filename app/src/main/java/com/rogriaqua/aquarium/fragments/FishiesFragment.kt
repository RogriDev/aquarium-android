package com.rogriaqua.aquarium.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogriaqua.aquarium.FishiesAdapter
import com.rogriaqua.aquarium.FishiesData
import com.rogriaqua.aquarium.FishiesItemClickListener
import com.rogriaqua.aquarium.R
import com.rogriaqua.aquarium.databinding.FragmentFishiesBinding
import com.rogriaqua.aquarium.models.Fishies
import com.rogriaqua.aquarium.viewmodel.MainViewModel

class FishiesFragment : Fragment(R.layout.fragment_fishies), FishiesItemClickListener {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentFishiesBinding? = null

    private val binding get() = _binding!!

    private val adapter = FishiesAdapter(FishiesData().loadFishies(), this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFishiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getItems()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL,
            false
        )
        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

    private fun setupObservables() {
        viewModel.items.observe(viewLifecycleOwner) { fishiesList ->
            adapter.updateList(fishiesList)
        }
    }

    override fun onItemClick(fishies: Fishies) {
        Toast.makeText(requireContext(), "'${fishies.name} clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onFavoriteClick(fishies: Fishies) {
        Toast.makeText(requireContext(), "'${fishies.name} favorited", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


