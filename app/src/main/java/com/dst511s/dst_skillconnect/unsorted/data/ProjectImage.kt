package com.dst511s.dst_skillconnect.unsorted.data

data class ProjectImage(
    val id: String,
    val url: String,
    val caption: String?,
    val isMain: Boolean = false,
    val order: Int
)