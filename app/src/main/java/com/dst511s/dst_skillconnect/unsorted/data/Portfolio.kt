package com.dst511s.dst_skillconnect.unsorted.data

data class Portfolio(
    val id: String,
    val userId: String,
    val title: String,
    val subtitle: String?,
    val bio: String,
    val avatar: String?,
    val coverImage: String?,
    val projects: List<ProjectShowcase>,
    val skills: List<SkillShowcase>,
    val testimonials: List<Testimonial>,
    val socialLinks: Map<String, String>,
    val customSections: List<CustomSection>,
    val theme: PortfolioTheme,
    val isPublic: Boolean,
    val customDomain: String?,
    val analytics: PortfolioAnalytics
)