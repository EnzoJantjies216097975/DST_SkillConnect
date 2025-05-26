package com.dst511s.dst_skillconnect.unsorted.data

data class Quiz(
    val id: String,
    val title: String,
    val questions: List<QuizQuestion>,
    val passingScore: Int,
    val attempts: List<QuizAttempt>,
    val bestScore: Int?
)