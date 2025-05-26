package com.dst511s.dst_skillconnect.unsorted.data

data class CompanyReview(
    val id: String,
    val rating: Float,
    val title: String,
    val content: String,
    val pros: List<String>,
    val cons: List<String>,
    val jobTitle: String,
    val department: String,
    val employmentStatus: String, // Current/Former
    val reviewDate: Long,
    val isVerified: Boolean,
    val helpfulCount: Int
)