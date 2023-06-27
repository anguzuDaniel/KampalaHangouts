package com.example.kampalahangouts.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.kampalahangouts.R
import com.example.kampalahangouts.model.Category
import com.example.kampalahangouts.model.CategoryUiState
import com.example.kampalahangouts.ui.CategoryViewModel

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: CategoryViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState().value

    CategoryList(
        viewModel = viewModel,
        uiState = uiState,
        modifier = modifier,
        windowSize = WindowWidthSizeClass.Compact
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryList(
    viewModel: CategoryViewModel,
    uiState: CategoryUiState,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val categories = uiState.categories

    Scaffold(
        topBar = {
            KampalaHangoutAppBar(
                categoryName = stringResource(id = R.string.app_name),
                onBackButtonClicked = {},
                isShowingHomePage = uiState.isShowingCategoryPage
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(categories, key = { category -> category.id }) { category ->
                CategoryListItem(
                    category = category,
                    selected = if (windowSize == WindowWidthSizeClass.Expanded) {
                        uiState.currentCategory?.id == category.id
                    } else {
                        false
                    },
                    onCardClicked = {
                        viewModel.updateCurrentCategory(it)
                        viewModel.navigateToDetailPage()
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryListExpanded(
    viewModel: CategoryViewModel,
    uiState: CategoryUiState,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val categories = uiState.categories

    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(categories, key = { category -> category.id }) { category ->
            CategoryListItem(
                category = category,
                selected = if (windowSize == WindowWidthSizeClass.Expanded) {
                    uiState.currentCategory?.id == category.id
                } else {
                    false
                },
                onCardClicked = {
                    viewModel.updateCurrentCategory(it)
                    viewModel.navigateToDetailPage()
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListItem(
    category: Category,
    selected: Boolean,
    onCardClicked: (Category) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = {
            onCardClicked(category)
        }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                Text(
                    text = stringResource(id = category.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                )
//                Spacer(modifier = Modifier.height(5.dp))
//                Text(
//                    text = stringResource(id = category.description),
//                    style = MaterialTheme.typography.titleSmall,
//                    modifier = Modifier
//                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            CategoryArrowIcon()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenCardPreviewDark() {
    AppTheme(darkTheme = true) {
        CategoryScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenCardPreviewLight() {
    AppTheme(darkTheme = false) {
        CategoryScreen()
    }
}