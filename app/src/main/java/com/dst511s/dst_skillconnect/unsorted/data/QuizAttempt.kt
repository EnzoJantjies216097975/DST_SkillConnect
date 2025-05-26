package com.dst511s.dst_skillconnect.unsorted.data

data class QuizAttempt(
    val id: String,
    val score: Int,
    val answers: Map<String, String>,
    val timestamp: Long,
    val timeSpent: Int // in seconds
)