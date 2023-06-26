package com.example.kampalahangouts.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.kampalahangouts.data.DataSource
import com.example.kampalahangouts.utils.CategoryType

data class Hangout(
    val id: Int,
    @StringRes val name: Int,
    val category: CategoryType,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)

data class HangoutUiState(
    val hangouts: List<Hangout> = emptyList(),
    val currentHangout: Hangout = DataSource.defaultHangout,
    val isShowingHangoutPage: Boolean = false
)