package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.core.data.models.auth.UserType

data class ConversationParticipant(
    val userId: String,
    val name: String,
    val profileImageUrl: String?,
    val userType: UserType,
    val title: String?,
    val company: String?,
    val isOnline: Boolean = false,
    val lastSeen: Long?
)