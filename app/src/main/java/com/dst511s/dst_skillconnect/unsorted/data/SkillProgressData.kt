package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.MarketDemand
import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel
import com.dst511s.dst_skillconnect.unsorted.enume.SkillTrend
import com.dst511s.dst_skillconnect.unsorted.enume.VerificationStatus

data class SkillProgressData(
    val skillName: String,
    val currentLevel: SkillLevel,
    val progressPercentage: Float,
    val trend: SkillTrend,
    val lastAssessmentDate: Long?,
    val marketDemand: MarketDemand,
    val verificationStatus: VerificationStatus
)