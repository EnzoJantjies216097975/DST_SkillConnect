package com.dst511s.dst_skillconnect.unsorted.data

data class LearningModule(
    val id: String,
    val title: String,
    val description: String,
    val order: Int,
    val estimatedTime: Int, // in minutes
    val lessons: List<Lesson>,
    val isCompleted: Boolean,
    val isUnlocked: Boolean,
    val quiz: Quiz?
)