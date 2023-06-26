package com.example.kampalahangouts.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.kampalahangouts.R
import com.example.kampalahangouts.model.Category
import com.example.kampalahangouts.ui.CategoryViewModel

@Composable
fun HomeScreen() {
    val viewModel: CategoryViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    CategoryList(
        viewModel = viewModel,
        categories = uiState.categories,
    )
}

@Composable
fun CategoryList(
    viewModel: CategoryViewModel,
    categories: List<Category>,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(categories, key = { category -> category.id }) { category ->
            CategoryListItem(
                category = category,
                onItemClicked = {
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
    onItemClicked: (Category) -> Unit
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
                    text = stringResource(id = category.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(id = category.description),
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

@Composable
fun CategoryIcon(
    image: ImageVector,
    modifier: Modifier = Modifier
) {
    Image(
        imageVector = image,
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenCardPreviewDark() {
    AppTheme(useDarkTheme = true) {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenCardPreviewLight() {
    AppTheme(useDarkTheme = false) {
        HomeScreen()
    }
}