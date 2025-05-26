package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel

data class SkillShowcase(
    val skillId: String,
    val name: String,
    val level: SkillLevel,
    val yearsOfExperience: Float,
    val projects: List<String>, // Project IDs where this skill was used
    val certifications: List<String>,
    val isVerified: Boolean,
    val endorsements: List<SkillEndorsement>
)