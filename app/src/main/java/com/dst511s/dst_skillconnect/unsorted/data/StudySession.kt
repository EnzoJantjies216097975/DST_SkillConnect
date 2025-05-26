package com.dst511s.dst_skillconnect.unsorted.data

data class StudySession(
    val id: String,
    val pathId: String,
    val startTime: Long,
    val endTime: Long?,
    val lessonsCompleted: List<String>,
    val timeSpent: Int,
    val focusScore: Float // 0-1 based on session quality
)