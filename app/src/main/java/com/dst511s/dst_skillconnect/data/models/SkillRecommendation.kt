package com.dst511s.dst_skillconnect.data.models

data class SkillRecommendation(
    val skill: String,
    val currentLevel: SkillLevel?,
    val targetLevel: SkillLevel,
    val learningResources: List<LearningResource>,
    val estimatedTimeToLearn: String,
    val priority: SkillImportance
)