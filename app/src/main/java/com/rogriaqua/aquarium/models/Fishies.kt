package com.rogriaqua.aquarium.models

import androidx.annotation.DrawableRes

data class Fishies(
    @DrawableRes val image: Int,
    val name: String,
    val water: String,
    val isFavorite: Boolean
)
