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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
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

@Composable
fun HangoutScreen() {
    val viewModel: HangoutViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    HangoutList(
        viewModel = viewModel,
        hangouts = uiState.hangouts,
    )
}

@Composable
fun HangoutList(
    viewModel: HangoutViewModel,
    hangouts: List<Hangout>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(hangouts, key = { hangout -> hangout.id }) { hangout ->
            HangoutListItem(
                hangout = hangout,
                onItemClicked = {
                    viewModel.updateHangout(it)
                    viewModel.navigateToDetailPage()
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HangoutListItem(
    hangout: Hangout,
    onItemClicked: (Hangout) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onItemClicked }
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

            CategoryIcon(
                image = Icons.Default.KeyboardArrowRight,
                modifier = Modifier
                    .wrapContentWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HangoutScreenPreviewDark() {
    AppTheme(useDarkTheme = true) {
        HangoutScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HangoutScreenPreviewLight() {
    AppTheme(useDarkTheme = false) {
        HangoutScreen()
    }
}

