package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.SkillImportance
import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel

data class SkillRecommendation(
    val skill: String,
    val currentLevel: SkillLevel?,
    val targetLevel: SkillLevel,
    val learningResources: List<LearningResource>,
    val estimatedTimeToLearn: String,
    val priority: SkillImportance
)