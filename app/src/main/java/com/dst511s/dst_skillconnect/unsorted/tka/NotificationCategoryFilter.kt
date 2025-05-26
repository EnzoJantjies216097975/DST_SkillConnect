package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import com.dst511s.dst_skillconnect.unsorted.data.NotificationManager
import com.dst511s.dst_skillconnect.unsorted.enume.NotificationCategory

@Composable
fun NotificationCategoryFilter(
    selectedCategory: NotificationCategory?,
    onCategorySelected: (NotificationCategory?) -> Unit,
    notificationManager: NotificationManager
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            FilterChip(
                selected = selectedCategory == null,
                onClick = { onCategorySelected(null) },
                label = {
                    Text("All (${notificationManager.notifications.size})")
                }
            )
        }

        items(NotificationCategory.values()) { category ->
            val count = notificationManager.getNotificationsByCategory(category).size
            if (count > 0) {
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { onCategorySelected(category) },
                    label = {
                        Text("${category.name.lowercase().capitalize()} ($count)")
                    }
                )
            }
        }
    }
}