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

    fun initialize() {
        _uiState.value =
            CategoryUiState(
                categories = DataSource.getCategoryData(),
                currentCategory = DataSource.getCategoryData().getOrElse(0) {
                    defaultCategory
                }
            )
    }

    fun updateCurrentCategory(selectedCategory: Category) {
        // when a category is selected, update the current category
        // and set the category type to the selected category type
        _uiState.update {
            it.copy(
                currentCategory = selectedCategory,
                catType = selectedCategory.categoryType,
                catName = selectedCategory.name,
                isShowingCategoryPage = false
            )
        }
    }

    fun navigateToListPage() {
        // when the list page is navigated to, set the isShowingCategoryPage to true
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