package com.example.kampalahangouts.ui.components

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
    )
}

@Composable
fun HangoutList(
    viewModel: HangoutViewModel,
    hangouts: List<Hangout>,
    modifier: Modifier = Modifier,
    categoryId: CategoryType
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(hangouts, key = { hangout -> hangout.id }) { hangout ->
            if (hangout.category == categoryId) {
                HangoutListItem(
                    hangout = hangout,
                    onHangoutClicked = {
                        viewModel.updateHangout(it)
                        viewModel.navigateToDetailPage()
                    }
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HangoutListItem(
    hangout: Hangout,
    onHangoutClicked: (Hangout) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
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
fun HangoutScreenPreviewLight() {
    AppTheme(darkTheme = false) {
        HangoutScreen()
    }
}

