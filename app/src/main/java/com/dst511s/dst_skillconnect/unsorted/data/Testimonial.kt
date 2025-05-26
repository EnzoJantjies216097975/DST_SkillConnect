package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.TestimonialRelationship

data class Testimonial(
    val id: String,
    val authorId: String,
    val authorName: String,
    val authorTitle: String,
    val authorCompany: String?,
    val authorAvatar: String?,
    val content: String,
    val rating: Int, // 1-5 stars
    val relationship: TestimonialRelationship,
    val timestamp: Long,
    val isVerified: Boolean
)