package com.sourashis.movieapp.movieList.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sourashis.movieapp.movieList.data.local.categories.Category

@Composable
fun CategoryChip(
    category: Category,
    isSelected: Boolean,
    onSelect: (Category) -> Unit
) {

    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.inverseOnSurface
    }

    val borderColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.outline
    }

    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = backgroundColor)
            .border(
                color = borderColor,
                shape = RoundedCornerShape(8.dp),
                width = 1.dp
            )
            .clickable(
                onClick = { onSelect(category) }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category.name,
            color = textColor,
            fontSize = 12.sp,
            modifier = Modifier.padding(8.dp),
            fontFamily = FontFamily.Monospace
        )
    }

}