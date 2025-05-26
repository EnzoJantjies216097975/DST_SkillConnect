package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.core.data.models.auth.UserType
import com.dst511s.dst_skillconnect.unsorted.data.Conversation
import com.dst511s.dst_skillconnect.unsorted.enume.MessageFilter

private fun filterConversations(
    conversations: List<Conversation>,
    searchQuery: String,
    filter: MessageFilter
): List<Conversation> {
    var filtered = conversations

    // Apply text filter
    if (searchQuery.isNotEmpty()) {
        filtered = filtered.filter { conversation ->
            conversation.participants.any { participant ->
                participant.name.contains(searchQuery, ignoreCase = true) ||
                        participant.company?.contains(searchQuery, ignoreCase = true) == true
            }
        }
    }

    // Apply category filter
    filtered = when (filter) {
        MessageFilter.ALL -> filtered
        MessageFilter.UNREAD -> filtered.filter { it.unreadCount > 0 }
        MessageFilter.RECRUITERS -> filtered.filter { conversation ->
            conversation.participants.any { it.userType == UserType.EMPLOYER }
        }
        MessageFilter.COMPANIES -> filtered.filter { conversation ->
            conversation.participants.any { it.company != null }
        }
        MessageFilter.ARCHIVED -> filtered.filter { it.isArchived }
    }

    return filtered.sortedByDescending { it.lastActivity }
}