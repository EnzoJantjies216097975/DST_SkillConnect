package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.data.Message
import com.dst511s.dst_skillconnect.unsorted.enume.MessageType

fun generateMockMessages(conversationId: String, currentUserId: String): List<Message> {
    val baseTime = System.currentTimeMillis()

    return listOf(
        Message(
            id = "msg_1",
            conversationId = conversationId,
            senderId = "user_1",
            content = "Hi! I saw your profile and I think you'd be a great fit for our Frontend Developer position.",
            timestamp = baseTime - 7200_000,
            type = MessageType.TEXT,
            isRead = true
        ),
        Message(
            id = "msg_2",
            conversationId = conversationId,
            senderId = currentUserId,
            content = "Thank you for reaching out! I'm interested in learning more about the position.",
            timestamp = baseTime - 6900_000,
            type = MessageType.TEXT,
            isRead = true
        ),
        Message(
            id = "msg_3",
            conversationId = conversationId,
            senderId = "user_1",
            content = "Great! The position involves working with React, TypeScript, and our design system. Would you like to schedule a call to discuss further?",
            timestamp = baseTime - 6600_000,
            type = MessageType.TEXT,
            isRead = true
        ),
        Message(
            id = "msg_4",
            conversationId = conversationId,
            senderId = currentUserId,
            content = "That sounds perfect! I have experience with both React and TypeScript. When would be a good time for the call?",
            timestamp = baseTime - 6300_000,
            type = MessageType.TEXT,
            isRead = true
        ),
        Message(
            id = "msg_5",
            conversationId = conversationId,
            senderId = "user_1",
            content = "How about tomorrow at 2 PM? I'll send you a calendar invite with the meeting details.",
            timestamp = baseTime - 300_000,
            type = MessageType.TEXT,
            isRead = false
        )
    )
}