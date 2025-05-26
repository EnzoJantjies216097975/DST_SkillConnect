package com.dst511s.dst_skillconnect.core.data.models.job

data class Job(
    val id: String,
    val title: String,
    val company: String,
    val location: String,
    val jobType: String,
    val matchPercentage: Int,
    val companyLogoUrl: String?,
    val postedTimeAgo: String,
    val isNew: Boolean
)
