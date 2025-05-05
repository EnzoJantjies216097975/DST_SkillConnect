package com.dst511s.dst_skillconnect.data.models

data class SkillQuestion(
    val id: String,
    val questionText: String,
    val options: List<String>,
    val correctAnswer: Int
)
