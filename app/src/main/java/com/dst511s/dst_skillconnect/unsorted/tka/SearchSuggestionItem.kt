package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchSuggestionItem(
    suggestion: SearchSuggestion,
    onClick: () -> Unit
) {
    ListItem(
        headlineContent = { Text(suggestion.text) },
        leadingContent = {
            Icon(
                imageVector = suggestion.icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        supportingContent = {
            Text(
                text = suggestion.type.name.replace("_", " ").lowercase().capitalize(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        },
        modifier = Modifier.clickable { onClick() }
    )
}