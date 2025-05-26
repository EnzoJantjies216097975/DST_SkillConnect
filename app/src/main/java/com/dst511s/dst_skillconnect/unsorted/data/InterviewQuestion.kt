package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewDifficulty
import com.dst511s.dst_skillconnect.unsorted.enume.QuestionType

data class InterviewQuestion(
    val id: String,
    val question: String,
    val category: InterviewCategory,
    val difficulty: InterviewDifficulty,
    val type: QuestionType,
    val timeLimit: Int, // in seconds
    val sampleAnswer: String,
    val tips: List<String>,
    val followUpQuestions: List<String> = emptyList(),
    val isVideoRequired: Boolean = false
)