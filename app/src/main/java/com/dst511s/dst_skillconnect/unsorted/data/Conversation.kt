package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.ConversationType

data class Conversation(
    val id: String,
    val participants: List<ConversationParticipant>,
    val lastMessage: Message?,
    val lastActivity: Long,
    val unreadCount: Int = 0,
    val type: ConversationType,
    val isArchived: Boolean = false
)