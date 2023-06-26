package com.example.kampalahangouts.data.local

import androidx.annotation.StringRes
import com.example.kampalahangouts.utils.CategoryType

data class Category(
    val id: Int,
    val catType: CategoryType,
    @StringRes val name: Int,
    @StringRes val description: Int,
    val icon: Int
)
