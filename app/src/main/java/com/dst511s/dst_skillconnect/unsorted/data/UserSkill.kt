package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel

data class UserSkill(
    val name: String,
    val level: SkillLevel,
    val isVerified: Boolean,
    val lastUpdated: Long
)