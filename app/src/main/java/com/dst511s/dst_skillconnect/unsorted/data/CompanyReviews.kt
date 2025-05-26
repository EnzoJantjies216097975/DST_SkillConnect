package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.ReviewCategory

data class CompanyReviews(
    val overallRating: Float,
    val totalReviews: Int,
    val ratings: Map<ReviewCategory, Float>,
    val recentReviews: List<CompanyReview>
)