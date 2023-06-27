package com.example.kampalahangouts.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.kampalahangouts.R
import com.example.kampalahangouts.model.CategoryUiState
import com.example.kampalahangouts.model.Hangout
import com.example.kampalahangouts.ui.HangoutViewModel
import com.example.kampalahangouts.utils.CategoryType

@Composable
fun HangoutScreen() {
    val viewModel: HangoutViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()


    HangoutList(
        viewModel = viewModel,
        hangouts = uiState.hangouts,
        categoryId = CategoryType.ATTRACTIONS,
        onBackPressed = {},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HangoutList(
    viewModel: HangoutViewModel,
    categoryUiState: CategoryUiState = CategoryUiState(),
    hangouts: List<Hangout>,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    categoryId: CategoryType
) {
    val hangoutOfSelectedCategory = hangouts.filter { it.category == categoryId }

    Scaffold(
        topBar = {
            KampalaHangoutAppBar(
                categoryName = stringResource(id = categoryUiState.catName),
                onBackButtonClicked = onBackPressed,
                isShowingHomePage = false
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(hangoutOfSelectedCategory, key = { hangout -> hangout.id }) { hangout ->
                HangoutListItem(
                    hangout = hangout,
                    onHangoutClicked = {
                        viewModel.updateHangout(it)
                        viewModel.navigateToDetailPage()
                    },
                    onBackPressed = onBackPressed
                )
            }

        }
    }
}

@Composable
fun HangoutListOnly(
    viewModel: HangoutViewModel,
    categoryUiState: CategoryUiState = CategoryUiState(),
    hangouts: List<Hangout>,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    categoryId: CategoryType
) {
    val hangoutOfSelectedCategory = hangouts.filter { it.category == categoryId }

    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(hangoutOfSelectedCategory, key = { hangout -> hangout.id }) { hangout ->
            HangoutListItem(
                hangout = hangout,
                onHangoutClicked = {
                    viewModel.showHangoutOnLarge(it)
                },
                onBackPressed = onBackPressed
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HangoutListItem(
    hangout: Hangout,
    onHangoutClicked: (Hangout) -> Unit,
    onBackPressed: () -> Unit
) {
    BackHandler() {
        onBackPressed()
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = { onHangoutClicked(hangout) }
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
                    text = stringResource(id = hangout.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(id = hangout.description),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            CategoryArrowIcon()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HangoutScreenPreviewDark() {
    AppTheme(darkTheme = true) {
        HangoutScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HangoutScreenPreviewExpandedDark() {
    AppTheme(darkTheme = true) {
        val viewModel: HangoutViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsState()

        val hangout = uiState.hangouts.first()

        HangoutListOnly(
            viewModel = viewModel,
            hangouts = uiState.hangouts,
            onBackPressed = { /*TODO*/ },
            categoryId = CategoryType.ATTRACTIONS
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HangoutScreenPreviewLight() {
    AppTheme(darkTheme = false) {
        HangoutScreen()
    }
}

