package com.dst511s.dst_skillconnect.unsorted.data

data class ProjectComment(
    val id: String,
    val authorId: String,
    val authorName: String,
    val authorAvatar: String?,
    val content: String,
    val timestamp: Long,
    val likes: Int = 0
)