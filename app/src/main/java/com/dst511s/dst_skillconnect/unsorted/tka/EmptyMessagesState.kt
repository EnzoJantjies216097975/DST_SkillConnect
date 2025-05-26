package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.enume.MessageFilter

@Composable
fun EmptyMessagesState(filter: MessageFilter) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Message,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = when (filter) {
                MessageFilter.ALL -> "No conversations yet"
                MessageFilter.UNREAD -> "No unread messages"
                MessageFilter.RECRUITERS -> "No conversations with recruiters"
                MessageFilter.COMPANIES -> "No conversations with companies"
                MessageFilter.ARCHIVED -> "No archived conversations"
            },
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )

        Text(
            text = "Start networking and connecting with opportunities!",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
        )
    }
}
