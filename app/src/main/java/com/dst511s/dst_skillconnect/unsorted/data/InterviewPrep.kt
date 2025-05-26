package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewDifficulty

data class InterviewPrep(
    val id: String,
    val title: String,
    val jobRole: String,
    val difficulty: InterviewDifficulty,
    val duration: Int, // in minutes
    val questionCount: Int,
    val categories: List<InterviewCategory>,
    val completedSessions: Int = 0,
    val averageScore: Float = 0f,
    val lastAttempt: Long? = null
)