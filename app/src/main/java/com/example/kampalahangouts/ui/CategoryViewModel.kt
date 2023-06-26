package com.example.kampalahangouts.ui

import androidx.lifecycle.ViewModel
import com.example.kampalahangouts.data.DataSource
import com.example.kampalahangouts.data.DataSource.defaultCategory
import com.example.kampalahangouts.model.Category
import com.example.kampalahangouts.model.CategoryUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class CategoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        CategoryUiState(
            // get the list of categories from the data source
            categories = DataSource.getCategoryData(),
            // get the first category from the list of categories
            // else return the default category
            currentCategory = DataSource.getCategoryData().getOrElse(0) {
                defaultCategory
            }
        )
    )

    val uiState = _uiState

    fun updateCurrentCategory(selectedCategory: Category) {
        _uiState.update {
            it.copy(
                currentCategory = selectedCategory,
                isShowingCategoryPage = false
            )
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingCategoryPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingCategoryPage = false)
        }
    }
}