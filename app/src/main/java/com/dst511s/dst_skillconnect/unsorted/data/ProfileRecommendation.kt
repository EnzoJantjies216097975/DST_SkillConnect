package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.RecommendationPriority
import com.dst511s.dst_skillconnect.unsorted.enume.RecommendationType

data class ProfileRecommendation(
    val type: RecommendationType,
    val title: String,
    val description: String,
    val priority: RecommendationPriority,
    val actionText: String,
    val potentialImpact: String,
    val actionData: String?
)