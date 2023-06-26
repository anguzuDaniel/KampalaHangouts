package com.example.kampalahangouts.ui

import androidx.lifecycle.ViewModel
import com.example.kampalahangouts.data.DataSource
import com.example.kampalahangouts.data.DataSource.defaultHangout
import com.example.kampalahangouts.model.Hangout
import com.example.kampalahangouts.model.HangoutUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class HangoutViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        HangoutUiState(
            // get the list of hangouts from the data source
            hangouts = DataSource.getHangoutData(),
            // get the first hangout from the list of hangouts
            // else return the default hangout
            currentHangout = DataSource.getHangoutData().getOrElse(0) {
                defaultHangout
            }
        )
    )

    val uiState = _uiState

    fun updateHangout(selectedHangout: Hangout) {
        _uiState.update {
            it.copy(
                currentHangout = selectedHangout,
                isShowingHangoutPage = false
            )
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingHangoutPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingHangoutPage = false)
        }
    }
}