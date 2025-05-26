package com.dst511s.dst_skillconnect.data.models

data class SkillRequirement(
    val name: String,
    val level: SkillLevel,
    val importance: SkillImportance,
    val category: String
)