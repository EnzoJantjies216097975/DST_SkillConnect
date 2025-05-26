package com.dst511s.dst_skillconnect.unsorted.data

data class SkillQuestion(
    val id: String,
    val questionText: String,
    val options: List<String>,
    val correctAnswer: Int
)
