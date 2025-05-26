package com.dst511s.dst_skillconnect.unsorted.data

data class ProfileAnalytics(
    val profileViews: ProfileViewsData,
    val skillProgress: List<SkillProgressData>,
    val jobApplications: JobApplicationAnalytics,
    val profileCompletion: ProfileCompletionData,
    val marketInsights: MarketInsightsData,
    val recommendations: List<ProfileRecommendation>
)