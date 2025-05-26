package com.dst511s.dst_skillconnect.data.models

data class DiversityStats(
    val genderBalance: Map<String, Float>,
    val ageDistribution: Map<String, Float>,
    val inclusionScore: Float
)