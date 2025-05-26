package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory

data class InterviewFeedback(
    val strengths: List<String>,
    val areasForImprovement: List<String>,
    val overallRating: Float,
    val categoryScores: Map<InterviewCategory, Float>,
    val recommendations: List<String>,
    val nextSteps: List<String>
)