package com.rogriaqua.aquarium

import androidx.annotation.DrawableRes

data class Fishies(
    @DrawableRes val image: Int,
    val name: String,
    val water: String,
    @DrawableRes val favorite: Int
)
