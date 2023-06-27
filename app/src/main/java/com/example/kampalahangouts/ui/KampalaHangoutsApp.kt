package com.example.kampalahangouts.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kampalahangouts.model.Category
import com.example.kampalahangouts.model.CategoryUiState
import com.example.kampalahangouts.ui.components.CategoryList
import com.example.kampalahangouts.ui.components.CategoryListExpanded
import com.example.kampalahangouts.ui.components.HangoutListOnly
import com.example.kampalahangouts.ui.components.CategoryScreen
import com.example.kampalahangouts.ui.components.HangoutList
import com.example.kampalahangouts.ui.components.SelectedHangOut
import com.example.kampalahangouts.ui.components.SelectedHangOutExpand
import com.example.kampalahangouts.utils.WindowStateUiUtils


@Composable
fun KampalaHangoutApp(windowSize: WindowWidthSizeClass) {
    val categoryViewModel: CategoryViewModel = viewModel()
    val categoryUiState = categoryViewModel.uiState.collectAsState().value

    KampalaHangoutAppContent(
        categoryUiState = categoryUiState,
        categoryViewModel = categoryViewModel,
        windowSize = windowSize
    )
}


@Composable
fun KampalaHangoutAppContent(
    windowSize: WindowWidthSizeClass,
    categoryUiState: CategoryUiState,
    categoryViewModel: CategoryViewModel,
    modifier: Modifier = Modifier
) {
    val contentDisplayStyle: WindowStateUiUtils

    val viewModel: HangoutViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState().value

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentDisplayStyle = WindowStateUiUtils.NORMAL
        }

        WindowWidthSizeClass.Medium -> {
            contentDisplayStyle = WindowStateUiUtils.NORMAL
        }

        WindowWidthSizeClass.Expanded -> {
            contentDisplayStyle = WindowStateUiUtils.FULL_SCREEN
        }

        else -> {
            contentDisplayStyle = WindowStateUiUtils.NORMAL
        }
    }

    if (contentDisplayStyle == WindowStateUiUtils.FULL_SCREEN) {
        Row(modifier = Modifier.fillMaxSize()) {
            CategoryListExpanded(
                viewModel = categoryViewModel,
                uiState = categoryUiState,
                windowSize = windowSize,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            HangoutListOnly(
                viewModel = viewModel,
                hangouts = uiState.hangouts,
                categoryId = categoryUiState.catType,
                onBackPressed = {},
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            SelectedHangOutExpand(
                hangout = uiState.currentHangout,
                modifier = Modifier.weight(1f)
            )
        }
    } else {

        if (!categoryUiState.isShowingCategoryPage) {
            if (uiState.isShowingHangoutPage) {
                HangoutList(
                    viewModel = viewModel,
                    hangouts = uiState.hangouts,
                    categoryId = categoryUiState.catType,
                    onBackPressed = {
                        categoryViewModel.navigateToListPage()
                    },
                    modifier = modifier
                )
            } else {
                SelectedHangOut(
                    hangout = uiState.currentHangout,
                    onBackPressed = {
                        viewModel.navigateToListPage()
                    },
                    modifier = modifier
                )
            }
        } else {
            CategoryScreen(
                modifier = modifier
            )
        }
    }
}



