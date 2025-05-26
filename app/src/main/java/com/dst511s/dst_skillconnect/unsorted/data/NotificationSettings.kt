package com.dst511s.dst_skillconnect.unsorted.data

data class NotificationSettings(
    val jobMatches: Boolean = true,
    val applicationUpdates: Boolean = true,
    val workshopReminders: Boolean = true,
    val skillVerifications: Boolean = true,
    val companyUpdates: Boolean = true,
    val messages: Boolean = true,
    val systemUpdates: Boolean = false,
    val pushNotifications: Boolean = true,
    val emailNotifications: Boolean = true,
    val quietHours: QuietHours = QuietHours()
)