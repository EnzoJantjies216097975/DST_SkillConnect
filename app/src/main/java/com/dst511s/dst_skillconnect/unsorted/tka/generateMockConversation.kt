package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.data.Conversation


fun generateMockConversation(conversationId: String): Conversation {
    return generateMockConversations().first { it.id == conversationId }
}