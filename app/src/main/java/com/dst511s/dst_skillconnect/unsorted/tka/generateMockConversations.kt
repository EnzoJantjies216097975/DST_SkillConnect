package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.core.data.models.auth.UserType
import com.dst511s.dst_skillconnect.unsorted.data.Conversation
import com.dst511s.dst_skillconnect.unsorted.data.ConversationParticipant
import com.dst511s.dst_skillconnect.unsorted.data.Message
import com.dst511s.dst_skillconnect.unsorted.enume.ConversationType
import com.dst511s.dst_skillconnect.unsorted.enume.MessageType

private fun generateMockConversations(): List<Conversation> {
    val baseTime = System.currentTimeMillis()

    return listOf(
        Conversation(
            id = "conv_1",
            participants = listOf(
                ConversationParticipant(
                    userId = "user_1",
                    name = "Sarah Johnson",
                    profileImageUrl = null,
                    userType = UserType.EMPLOYER,
                    title = "Senior Recruiter",
                    company = "TechCorp Solutions",
                    isOnline = true,
                    lastSeen = null
                )
            ),
            lastMessage = Message(
                id = "msg_1",
                conversationId = "conv_1",
                senderId = "user_1",
                content = "Hi! I saw your profile and I think you'd be a great fit for our Frontend Developer position.",
                timestamp = baseTime - 300_000,
                type = MessageType.TEXT
            ),
            lastActivity = baseTime - 300_000,
            unreadCount = 2,
            type = ConversationType.JOB_INQUIRY
        ),
        Conversation(
            id = "conv_2",
            participants = listOf(
                ConversationParticipant(
                    userId = "user_2",
                    name = "Michael Chen",
                    profileImageUrl = null,
                    userType = UserType.WORKSHOP_PROVIDER,
                    title = "Workshop Instructor",
                    company = "Code Academy",
                    isOnline = false,
                    lastSeen = baseTime - 1800_000
                )
            ),
            lastMessage = Message(
                id = "msg_2",
                conversationId = "conv_2",
                senderId = "current_user",
                content = "Thank you for the workshop! It was very helpful.",
                timestamp = baseTime - 3600_000,
                type = MessageType.TEXT
            ),
            lastActivity = baseTime - 3600_000,
            unreadCount = 0,
            type = ConversationType.WORKSHOP_DISCUSSION
        )
    )
}