package com.dst511s.dst_skillconnect.data.models

data class UserSkill(
    val name: String,
    val level: SkillLevel,
    val isVerified: Boolean,
    val lastUpdated: Long
)