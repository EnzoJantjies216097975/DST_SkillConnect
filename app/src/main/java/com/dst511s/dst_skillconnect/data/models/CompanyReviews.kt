package com.dst511s.dst_skillconnect.data.models

data class CompanyReviews(
    val overallRating: Float,
    val totalReviews: Int,
    val ratings: Map<ReviewCategory, Float>,
    val recentReviews: List<CompanyReview>
)