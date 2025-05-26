package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.core.data.models.job.JobListing
import com.dst511s.dst_skillconnect.unsorted.enume.CompanySize

data class CompanyProfile(
    val id: String,
    val name: String,
    val tagline: String,
    val description: String,
    val industry: String,
    val size: CompanySize,
    val foundedYear: Int,
    val headquarters: String,
    val website: String,
    val logoUrl: String?,
    val coverImageUrl: String?,
    val socialLinks: Map<String, String>,
    val benefits: List<CompanyBenefit>,
    val workCulture: WorkCulture,
    val reviews: CompanyReviews,
    val openPositions: List<JobListing>,
    val employees: List<CompanyEmployee>,
    val locations: List<CompanyLocation>,
    val technologies: List<String>,
    val achievements: List<CompanyAchievement>,
    val isFollowing: Boolean = false
)