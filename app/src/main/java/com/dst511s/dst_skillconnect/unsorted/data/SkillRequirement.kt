package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.SkillImportance
import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel

data class SkillRequirement(
    val name: String,
    val level: SkillLevel,
    val importance: SkillImportance,
    val category: String
)