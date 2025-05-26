package com.dst511s.dst_skillconnect.unsorted.data

data class InterviewSession(
    val id: String,
    val prepId: String,
    val startTime: Long,
    val endTime: Long?,
    val questions: List<InterviewQuestion>,
    val responses: List<InterviewResponse>,
    val overallScore: Float = 0f,
    val feedback: InterviewFeedback? = null,
    val isCompleted: Boolean = false
)