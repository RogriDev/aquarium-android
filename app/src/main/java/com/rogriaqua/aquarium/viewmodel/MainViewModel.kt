package com.rogriaqua.aquarium.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rogriaqua.aquarium.FishiesData
import com.rogriaqua.aquarium.models.Fishies

class MainViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Fishies>>()
    val items: LiveData<List<Fishies>> = _items

    fun getItems() {
        _items.value = FishiesData().loadFishies()
    }
}