package com.example.kampalahangouts.ui.components

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryArrowIcon() {
    Icon(
        imageVector = Icons.Default.KeyboardArrowRight,
        contentDescription = null,
        modifier = Modifier
            .wrapContentWidth()
    )
}