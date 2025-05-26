package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.AchievementType

data class CompanyAchievement(
    val title: String,
    val description: String,
    val year: Int,
    val type: AchievementType
)