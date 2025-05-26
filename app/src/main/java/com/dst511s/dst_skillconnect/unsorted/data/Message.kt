package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.MessageType

data class Message(
    val id: String,
    val conversationId: String,
    val senderId: String,
    val content: String,
    val timestamp: Long,
    val type: MessageType,
    val attachments: List<MessageAttachment> = emptyList(),
    val isRead: Boolean = false,
    val replyTo: String? = null,
    val reactions: List<MessageReaction> = emptyList()
)