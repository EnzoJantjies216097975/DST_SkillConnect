package com.dst511s.dst_skillconnect.core.data.models.job

data class JobDetail(
    val id: String,
    val title: String,
    val company: String,
    val location: String,
    val jobType: String,
    val matchPercentage: Int,
    val companyLogoUrl: String?,
    val postedTimeAgo: String,
    val description: String,
    val responsibilities: List<String>,
    val requirements: List<String>,
    val requiredSkills: List<Pair<String, Boolean>>, // Skill name and whether the user has it
    val salary: String,
    val benefits: List<String>
)
