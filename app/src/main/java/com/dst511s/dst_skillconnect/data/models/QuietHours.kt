package com.dst511s.dst_skillconnect.data.models

data class QuietHours(
    val enabled: Boolean = false,
    val startTime: String = "22:00",
    val endTime: String = "08:00"
)