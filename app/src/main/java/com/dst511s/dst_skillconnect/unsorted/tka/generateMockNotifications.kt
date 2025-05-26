package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.data.Notification
import com.dst511s.dst_skillconnect.unsorted.data.NotificationActionData
import com.dst511s.dst_skillconnect.unsorted.enume.NotificationCategory
import com.dst511s.dst_skillconnect.unsorted.enume.NotificationPriority
import com.dst511s.dst_skillconnect.unsorted.enume.NotificationType

private fun generateMockNotifications(): List<Notification> {
    val baseTime = System.currentTimeMillis()

    return listOf(
        Notification(
            id = "1",
            type = NotificationType.JOB_MATCH,
            title = "New Job Match!",
            message = "Senior Frontend Developer at TechCorp Solutions matches your skills",
            timestamp = baseTime - 300_000, // 5 minutes ago
            priority = NotificationPriority.HIGH,
            actionData = NotificationActionData("view_job", "job_123", "View Job"),
            category = NotificationCategory.JOBS
        ),
        Notification(
            id = "2",
            type = NotificationType.APPLICATION_UPDATE,
            title = "Application Status Update",
            message = "Your application for Junior Developer role has been reviewed",
            timestamp = baseTime - 1800_000, // 30 minutes ago
            actionData = NotificationActionData("view_application", "app_456"),
            category = NotificationCategory.APPLICATIONS
        ),
        Notification(
            id = "3",
            type = NotificationType.WORKSHOP_REMINDER,
            title = "Workshop Tomorrow",
            message = "JavaScript Fundamentals workshop starts at 10:00 AM",
            timestamp = baseTime - 3600_000, // 1 hour ago
            actionData = NotificationActionData("view_workshop", "workshop_789"),
            category = NotificationCategory.LEARNING
        ),
        Notification(
            id = "4",
            type = NotificationType.SKILL_VERIFICATION,
            title = "Skill Assessment Complete",
            message = "Your JavaScript assessment has been graded. View your results!",
            timestamp = baseTime - 7200_000, // 2 hours ago
            isRead = true,
            actionData = NotificationActionData("view_assessment", "assessment_101"),
            category = NotificationCategory.LEARNING
        ),
        Notification(
            id = "5",
            type = NotificationType.ACHIEVEMENT,
            title = "Achievement Unlocked!",
            message = "You've completed your first skill assessment",
            timestamp = baseTime - 86400_000, // 1 day ago
            actionData = NotificationActionData("view_achievement", "achievement_1"),
            category = NotificationCategory.SYSTEM
        )
    )
}