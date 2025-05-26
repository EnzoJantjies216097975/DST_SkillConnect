package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.NotificationCategory
import com.dst511s.dst_skillconnect.unsorted.enume.NotificationType

class NotificationManager {
    private val _notifications = mutableStateListOf<Notification>()
    val notifications: List<Notification> = _notifications

    private val _unreadCount = mutableStateOf(0)
    val unreadCount: State<Int> = _unreadCount

    fun addNotification(notification: Notification) {
        _notifications.add(0, notification)
        updateUnreadCount()
    }

    fun markAsRead(notificationId: String) {
        val index = _notifications.indexOfFirst { it.id == notificationId }
        if (index != -1) {
            _notifications[index] = _notifications[index].copy(isRead = true)
            updateUnreadCount()
        }
    }

    fun markAllAsRead() {
        _notifications.replaceAll { it.copy(isRead = true) }
        updateUnreadCount()
    }

    fun deleteNotification(notificationId: String) {
        _notifications.removeIf { it.id == notificationId }
        updateUnreadCount()
    }

    fun clearAll() {
        _notifications.clear()
        updateUnreadCount()
    }

    private fun updateUnreadCount() {
        _unreadCount.value = _notifications.count { !it.isRead }
    }

    fun getNotificationsByCategory(category: NotificationCategory): List<Notification> {
        return _notifications.filter { it.category == category }
    }

    fun getNotificationsByType(type: NotificationType): List<Notification> {
        return _notifications.filter { it.type == type }
    }
}