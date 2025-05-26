package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.AchievementType

data class LearningAchievement(
    val id: String,
    val title: String,
    val description: String,
    val icon: String,
    val unlockedAt: Long,
    val type: AchievementType
)

enum class AchievementType {
    COMPLETION, STREAK, SPEED, MASTERY, ENGAGEMENT
}