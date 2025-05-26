package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.MarketDemand

data class TrendingSkill(
    val skill: String,
    val growthRate: Float,
    val avgSalaryImpact: Double,
    val demandLevel: MarketDemand
)