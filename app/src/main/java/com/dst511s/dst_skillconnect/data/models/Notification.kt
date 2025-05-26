package com.dst511s.dst_skillconnect.data.models

data class Notification(
    val id: String,
    val type: NotificationType,
    val title: String,
    val message: String,
    val timestamp: Long,
    val isRead: Boolean = false,
    val priority: NotificationPriority = NotificationPriority.NORMAL,
    val actionData: NotificationActionData? = null,
    val imageUrl: String? = null,
    val category: NotificationCategory
)