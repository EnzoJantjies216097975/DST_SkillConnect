package com.dst511s.dst_skillconnect.unsorted.data

data class LearningProgress(
    val pathId: String,
    val userId: String,
    val currentModule: String?,
    val currentLesson: String?,
    val completionPercentage: Float,
    val timeSpent: Int, // in minutes
    val streak: Int, // consecutive days
    val lastStudyDate: Long,
    val averageSessionDuration: Int,
    val achievements: List<LearningAchievement>
)