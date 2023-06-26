package com.example.kampalahangouts.model

import androidx.annotation.StringRes
import com.example.kampalahangouts.data.DataSource
import com.example.kampalahangouts.utils.CategoryType

data class Category(
    val id: Int,
    val catType: CategoryType,
    @StringRes val name: Int,
    @StringRes val description: Int,
    val icon: Int
)

data class CategoryUiState(
    val categories: List<Category> = emptyList(),
    val currentCategory: Category = DataSource.defaultCategory,
    val isShowingCategoryPage: Boolean = false
)