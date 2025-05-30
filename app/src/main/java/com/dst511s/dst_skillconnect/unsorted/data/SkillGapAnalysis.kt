package com.dst511s.dst_skillconnect.unsorted.data

data class SkillGapAnalysis(
    val jobTitle: String,
    val company: String,
    val requiredSkills: List<SkillRequirement>,
    val matchingSkills: List<UserSkill>,
    val missingSkills: List<SkillRequirement>,
    val overallMatchPercentage: Int,
    val recommendations: List<SkillRecommendation>
)