package com.dst511s.dst_skillconnect.unsorted

import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel

private fun generateMockCareerRoadmap(userId: String): CareerRoadmap {
    return CareerRoadmap(
        id = "roadmap_$userId",
        userId = userId,
        title = "Frontend Developer Career Path",
        currentRole = "Junior Developer",
        targetRole = "Senior Frontend Engineer",
        industry = "Technology",
        timeline = RoadmapTimeline(
            startDate = System.currentTimeMillis(),
            targetDate = System.currentTimeMillis() + (18L * 30 * 24 * 60 * 60 * 1000), // 18 months
            estimatedDuration = 18,
            phases = listOf(
                CareerPhase(
                    id = "phase_1",
                    title = "Foundation Building",
                    description = "Build strong fundamentals in web development",
                    duration = 6,
                    order = 1,
                    objectives = listOf(
                        "Master React and TypeScript",
                        "Complete 3 portfolio projects",
                        "Obtain first certification"
                    ),
                    requiredSkills = listOf("React", "TypeScript", "Git"),
                    suggestedActions = listOf("Take online courses", "Build projects", "Join communities"),
                    isCompleted = false,
                    completedAt = null
                ),
                CareerPhase(
                    id = "phase_2",
                    title = "Specialization",
                    description = "Develop expertise in chosen areas",
                    duration = 8,
                    order = 2,
                    objectives = listOf(
                        "Lead a team project",
                        "Mentor junior developers",
                        "Contribute to open source"
                    ),
                    requiredSkills = listOf("Leadership", "System Design", "Performance Optimization"),
                    suggestedActions = listOf("Take leadership roles", "Write technical blog posts"),
                    isCompleted = false,
                    completedAt = null
                ),
                CareerPhase(
                    id = "phase_3",
                    title = "Senior Level Transition",
                    description = "Transition to senior role responsibilities",
                    duration = 4,
                    order = 3,
                    objectives = listOf(
                        "Achieve target salary range",
                        "Secure senior position",
                        "Establish thought leadership"
                    ),
                    requiredSkills = listOf("Architecture", "Strategic Thinking", "Team Leadership"),
                    suggestedActions = listOf("Interview for senior roles", "Speak at conferences"),
                    isCompleted = false,
                    completedAt = null
                )
            )
        ),
        milestones = listOf(
            CareerMilestone(
                id = "milestone_1",
                title = "Complete React Certification",
                description = "Obtain official React certification from Meta",
                category = MilestoneCategory.CERTIFICATION,
                targetDate = System.currentTimeMillis() + (3L * 30 * 24 * 60 * 60 * 1000),
                isCompleted = false,
                completedAt = null,
                requirements = listOf("Pass certification exam", "Build capstone project"),
                rewards = listOf("LinkedIn badge", "Certificate", "Skill verification"),
                priority = MilestonePriority.HIGH
            )
        ),
        skills = SkillsRoadmap(
            currentSkills = emptyList(),
            targetSkills = listOf(
                SkillTarget(
                    skillName = "React",
                    currentLevel = SkillLevel.INTERMEDIATE,
                    targetLevel = SkillLevel.ADVANCED,
                    priority = SkillPriority.ESSENTIAL,
                    estimatedTimeToAchieve = 4,
                    learningResources = emptyList(),
                    progress = 0.6f
                ),
                SkillTarget(
                    skillName = "TypeScript",
                    currentLevel = SkillLevel.BEGINNER,
                    targetLevel = SkillLevel.INTERMEDIATE,
                    priority = SkillPriority.IMPORTANT,
                    estimatedTimeToAchieve = 3,
                    learningResources = emptyList(),
                    progress = 0.3f
                )
            ),
            skillGaps = listOf(
                SkillGap(
                    skillName = "System Design",
                    requiredLevel = SkillLevel.INTERMEDIATE,
                    currentLevel = null,
                    gapSize = GapSize.LARGE,
                    recommendedActions = listOf("Take system design course", "Practice design exercises")
                )
            ),
            learningPaths = emptyList()
        ),
        experiences = ExperienceRoadmap(
            currentExperience = emptyList(),
            targetExperiences = emptyList(),
            experienceGaps = emptyList()
        ),
        goals = listOf(
            CareerGoal(
                id = "goal_1",
                title = "Increase Salary by 40%",
                description = "Achieve target salary of N$35,000 within 18 months",
                category = GoalCategory.SALARY_INCREASE,
                type = GoalType.NUMERIC,
                targetValue = "35000",
                currentValue = "25000",
                targetDate = System.currentTimeMillis() + (18L * 30 * 24 * 60 * 60 * 1000),
                progress = 0.3f,
                isCompleted = false,
                completedAt = null,
                subGoals = listOf(
                    SubGoal(
                        id = "subgoal_1",
                        title = "Complete advanced React course",
                        isCompleted = true,
                        completedAt = System.currentTimeMillis() - 86400000,
                        dueDate = System.currentTimeMillis() + 86400000
                    ),
                    SubGoal(
                        id = "subgoal_2",
                        title = "Build 2 portfolio projects",
                        isCompleted = false,
                        completedAt = null,
                        dueDate = System.currentTimeMillis() + (2L * 30 * 24 * 60 * 60 * 1000)
                    )
                ),
                trackingMetrics = listOf(
                    GoalMetric(
                        name = "Current Salary",
                        currentValue = 25000f,
                        targetValue = 35000f,
                        unit = "NAD"
                    )
                )
            )
        ),
        progress = RoadmapProgress(
            overallProgress = 0.25f,
            milestonesCompleted = 0,
            totalMilestones = 1,
            goalsCompleted = 0,
            totalGoals = 1,
            skillsProgress = 0.45f,
            experienceProgress = 0.1f,
            phaseProgress = mapOf(
                "phase_1" to 0.4f,
                "phase_2" to 0.0f,
                "phase_3" to 0.0f
            ),
            weeklyProgress = emptyList()
        ),
        isActive = true,
        createdAt = System.currentTimeMillis() - (7L * 24 * 60 * 60 * 1000),
        updatedAt = System.currentTimeMillis()
    )
}

private fun generateMockInsights(): List<CareerInsight> {
    return listOf(
        CareerInsight(
            id = "insight_1",
            type = InsightType.SKILL_GAP,
            title = "Critical Skill Gap Identified",
            message = "System Design skills are highly valued for senior roles but missing from your profile",
            actionable = true,
            suggestedActions = listOf("Take system design course", "Practice design interviews"),
            priority = InsightPriority.HIGH,
            timestamp = System.currentTimeMillis()
        ),
        CareerInsight(
            id = "insight_2",
            type = InsightType.OPPORTUNITY,
            title = "Market Opportunity",
            message = "Frontend Engineer salaries increased by 15% in your area this quarter",
            actionable = false,
            suggestedActions = emptyList(),
            priority = InsightPriority.MEDIUM,
            timestamp = System.currentTimeMillis()
        ),
        CareerInsight(
            id = "insight_3",
            type = InsightType.RECOMMENDATION,
            title = "Network Expansion",
            message = "Consider attending tech meetups to expand your professional network",
            actionable = true,
            suggestedActions = listOf("Join local tech meetups", "Connect with industry professionals"),
            priority = InsightPriority.MEDIUM,
            timestamp = System.currentTimeMillis()
        )
    )
}