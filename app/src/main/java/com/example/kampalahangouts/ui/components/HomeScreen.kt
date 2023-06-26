package com.example.kampalahangouts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kampalahangouts.R

@Composable
fun HomeScreen() {
    LazyColumn(content = {
        item {
            CategoryList()
        }
    })
}

@Composable
fun CategoryList(
    modifier: Modifier = Modifier
) {
    CategoryListItem()
    CategoryListItem()
    CategoryListItem()
    CategoryListItem()
}

@Composable
fun CategoryListItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
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
                    text = stringResource(id = R.string.category_attractions),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(id = R.string.category_attractions_description),
                    style = MaterialTheme.typography.bodyMedium,
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
fun HomeScreenCardPreview() {
    CategoryListItem()
}

@Preview(showBackground = true)
@Composable
fun CardScreenListPreview() {
    CategoryList()
}