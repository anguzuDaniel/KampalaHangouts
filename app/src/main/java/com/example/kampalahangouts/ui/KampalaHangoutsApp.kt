package com.example.kampalahangouts.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kampalahangouts.R
import com.example.kampalahangouts.model.CategoryUiState
import com.example.kampalahangouts.ui.components.CategoryScreen
import com.example.kampalahangouts.ui.components.HangoutList
import com.example.kampalahangouts.ui.components.HangoutListItem
import com.example.kampalahangouts.ui.components.SelectedHangOut


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KampalaHangoutApp() {
    val categoryViewModel: CategoryViewModel = viewModel()
    val categoryUiState by categoryViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            KampalaHangoutAppBar(
                categoryName = stringResource(id = categoryUiState.catName),
                onBackButtonClicked = { /*TODO*/ },
                isShowingHomePage = categoryUiState.isShowingCategoryPage
            )
        }
    ) { innerPadding ->
        KampalaHangoutAppContent(
            categoryUiState = categoryUiState,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Composable
fun KampalaHangoutAppContent(
    categoryUiState: CategoryUiState,
    modifier: Modifier = Modifier
) {

    val viewModel: HangoutViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState().value

    if (!categoryUiState.isShowingCategoryPage) {
        if (uiState.isShowingHangoutPage) {
            HangoutList(
                viewModel = viewModel,
                hangouts = uiState.hangouts,
                categoryId = categoryUiState.catType,
                modifier = modifier
            )
        } else {
            SelectedHangOut(
                hangout = uiState.currentHangout,
                modifier = modifier
            )
        }

    } else {
        CategoryScreen(
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KampalaHangoutAppBar(
    categoryName: String = "",
    onBackButtonClicked: () -> Unit,
    isShowingHomePage: Boolean,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = if (!isShowingHomePage) {
                    categoryName
                } else {
                    stringResource(id = R.string.app_name)
                }
            )
        },
        navigationIcon = if (!isShowingHomePage) {
            {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        } else {
            { Box() {} }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier
    )
}
