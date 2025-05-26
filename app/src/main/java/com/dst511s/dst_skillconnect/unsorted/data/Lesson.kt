package com.dst511s.dst_skillconnect.unsorted.data

data class Lesson(
    val id: String,
    val title: String,
    val type: LessonType,
    val content: String,
    val duration: Int, // in minutes
    val resources: List<LearningResource>,
    val isCompleted: Boolean,
    val completedAt: Long?,
    val notes: String?,
    val bookmarked: Boolean
)