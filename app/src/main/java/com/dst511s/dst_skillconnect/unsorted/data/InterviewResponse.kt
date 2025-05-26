package com.dst511s.dst_skillconnect.unsorted.data

data class InterviewResponse(
    val questionId: String,
    val response: String,
    val videoRecordingUrl: String? = null,
    val audioRecordingUrl: String? = null,
    val responseTime: Int, // in seconds
    val score: Float = 0f,
    val aiRating: AIRating? = null
)