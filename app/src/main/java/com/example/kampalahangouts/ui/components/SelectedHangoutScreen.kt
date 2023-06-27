package com.example.kampalahangouts.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.kampalahangouts.R
import com.example.kampalahangouts.model.CategoryUiState
import com.example.kampalahangouts.model.Hangout
import com.example.kampalahangouts.ui.HangoutViewModel

@Composable
fun SelectedApp() {
    val viewModel: HangoutViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    SelectedHangOut(
        hangout = uiState.hangouts[0]
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedHangOut(
    hangout: Hangout,
    categoryUiState: CategoryUiState = CategoryUiState(),
    onBackPressed: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = {
        onBackPressed()
    })

    Scaffold(
        topBar = {
            KampalaHangoutAppBar(
                categoryName = stringResource(id = hangout.name),
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
            item {
                HangoutImage(
                    image = hangout.image,
                    description = hangout.description
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = hangout.name),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = hangout.description))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedHangOutExpand(
    hangout: Hangout,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        item {
            HangoutImage(
                image = hangout.image,
                description = hangout.description
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = hangout.name),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = hangout.description))
        }
    }
}

@Composable
fun HangoutImage(
    image: Int,
    description: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = stringResource(id = description),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SelectedHangOutPreviewDark() {
    AppTheme(darkTheme = true) {
        SelectedApp()
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedHangOutPreviewLight() {
    AppTheme(darkTheme = false) {
        SelectedApp()
    }
}