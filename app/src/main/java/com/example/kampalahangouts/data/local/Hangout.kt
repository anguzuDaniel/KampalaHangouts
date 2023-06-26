package com.example.kampalahangouts.data.local

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.kampalahangouts.utils.CategoryType

data class Hangout(
    val id: Int,
    @StringRes val name: Int,
    val category: CategoryType,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)
