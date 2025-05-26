package com.dst511s.dst_skillconnect.data.models

data class WorkCulture(
    val values: List<String>,
    val workEnvironment: String,
    val diversityAndInclusion: DiversityStats,
    val workLifeBalance: Float, // 1-5 rating
    val learningOpportunities: Float,
    val careerGrowth: Float,
    val compensation: Float,
    val workFromHome: RemotePolicy
)