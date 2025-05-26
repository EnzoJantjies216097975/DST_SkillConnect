package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.QuestionType

data class QuizQuestion(
    val id: String,
    val question: String,
    val type: QuestionType,
    val options: List<String>,
    val correctAnswer: String,
    val explanation: String
)