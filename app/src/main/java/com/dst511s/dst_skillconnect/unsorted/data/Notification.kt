package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.NotificationCategory
import com.dst511s.dst_skillconnect.unsorted.enume.NotificationPriority
import com.dst511s.dst_skillconnect.unsorted.enume.NotificationType

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