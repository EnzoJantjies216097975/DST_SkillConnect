package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.dst511s.dst_skillconnect.unsorted.data.Conversation

@Composable
fun ConversationsList(
    conversations: List<Conversation>,
    currentUserId: String,
    onConversationClick: (String) -> Unit
) {
    LazyColumn {
        items(conversations) { conversation ->
            ConversationItem(
                conversation = conversation,
                currentUserId = currentUserId,
                onClick = { onConversationClick(conversation.id) }
            )
        }
    }
}
