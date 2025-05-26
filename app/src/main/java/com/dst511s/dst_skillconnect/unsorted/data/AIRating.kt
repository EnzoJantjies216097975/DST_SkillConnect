package com.dst511s.dst_skillconnect.unsorted.data

data class AIRating(
    val clarity: Float,
    val relevance: Float,
    val completeness: Float,
    val confidence: Float,
    val suggestions: List<String>
)