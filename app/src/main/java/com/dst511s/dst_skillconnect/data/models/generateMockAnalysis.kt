package com.dst511s.dst_skillconnect.data.models

private fun generateMockAnalysis(): SkillGapAnalysis {
    return SkillGapAnalysis(
        jobTitle = "Senior Frontend Developer",
        company = "TechCorp Solutions",
        requiredSkills = listOf(
            SkillRequirement("JavaScript", SkillLevel.ADVANCED, SkillImportance.ESSENTIAL, "Programming"),
            SkillRequirement("React", SkillLevel.ADVANCED, SkillImportance.ESSENTIAL, "Frontend"),
            SkillRequirement("TypeScript", SkillLevel.INTERMEDIATE, SkillImportance.PREFERRED, "Programming"),
            SkillRequirement("Node.js", SkillLevel.INTERMEDIATE, SkillImportance.PREFERRED, "Backend"),
            SkillRequirement("GraphQL", SkillLevel.BEGINNER, SkillImportance.NICE_TO_HAVE, "API")
        ),
        matchingSkills = listOf(
            UserSkill("JavaScript", SkillLevel.INTERMEDIATE, true, System.currentTimeMillis()),
            UserSkill("HTML/CSS", SkillLevel.ADVANCED, false, System.currentTimeMillis())
        ),
        missingSkills = listOf(
            SkillRequirement("React", SkillLevel.ADVANCED, SkillImportance.ESSENTIAL, "Frontend"),
            SkillRequirement("TypeScript", SkillLevel.INTERMEDIATE, SkillImportance.PREFERRED, "Programming"),
            SkillRequirement("Node.js", SkillLevel.INTERMEDIATE, SkillImportance.PREFERRED, "Backend")
        ),
        overallMatchPercentage = 40,
        recommendations = listOf(
            SkillRecommendation(
                skill = "React",
                currentLevel = null,
                targetLevel = SkillLevel.ADVANCED,
                learningResources = listOf(
                    LearningResource(
                        title = "Complete React Developer Course",
                        type = ResourceType.COURSE,
                        provider = "Udemy",
                        url = "",
                        duration = "40 hours",
                        cost = "N$500",
                        rating = 4.8f
                    ),
                    LearningResource(
                        title = "React Bootcamp",
                        type = ResourceType.BOOTCAMP,
                        provider = "Codecademy",
                        url = "",
                        duration = "3 months",
                        cost = "N$2000",
                        rating = 4.7f
                    )
                ),
                estimatedTimeToLearn = "3-4 months",
                priority = SkillImportance.ESSENTIAL
            ),
            SkillRecommendation(
                skill = "TypeScript",
                currentLevel = null,
                targetLevel = SkillLevel.INTERMEDIATE,
                learningResources = listOf(
                    LearningResource(
                        title = "TypeScript Fundamentals",
                        type = ResourceType.COURSE,
                        provider = "Pluralsight",
                        url = "",
                        duration = "15 hours",
                        cost = "N$300",
                        rating = 4.6f
                    )
                ),
                estimatedTimeToLearn = "1-2 months",
                priority = SkillImportance.PREFERRED
            )
        )
    )
}