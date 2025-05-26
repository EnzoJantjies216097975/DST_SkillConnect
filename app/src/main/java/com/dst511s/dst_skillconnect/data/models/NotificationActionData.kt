package com.dst511s.dst_skillconnect.data.models

data class NotificationActionData(
    val actionType: String,
    val actionId: String,
    val actionText: String? = null
)