package com.dst511s.dst_skillconnect.unsorted.data

data class MarketInsightsData(
    val salaryRange: SalaryRangeData,
    val demandForYourSkills: Float,
    val competitivePosition: CompetitivePosition,
    val trendingSkills: List<TrendingSkill>,
    val topCompaniesHiring: List<CompanyHiringData>
)