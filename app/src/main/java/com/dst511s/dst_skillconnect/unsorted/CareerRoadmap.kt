package com.dst511s.dst_skillconnect.unsorted

import com.dst511s.dst_skillconnect.unsorted.data.LearningResource
import com.dst511s.dst_skillconnect.unsorted.data.SkillAssessment
import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel

data class CareerRoadmap(
    val id: String,
    val userId: String,
    val title: String,
    val currentRole: String,
    val targetRole: String,
    val industry: String,
    val timeline: RoadmapTimeline,
    val milestones: List<CareerMilestone>,
    val skills: SkillsRoadmap,
    val experiences: ExperienceRoadmap,
    val goals: List<CareerGoal>,
    val progress: RoadmapProgress,
    val isActive: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)

data class RoadmapTimeline(
    val startDate: Long,
    val targetDate: Long,
    val estimatedDuration: Int, // in months
    val phases: List<CareerPhase>
)

data class CareerPhase(
    val id: String,
    val title: String,
    val description: String,
    val duration: Int, // in months
    val order: Int,
    val objectives: List<String>,
    val requiredSkills: List<String>,
    val suggestedActions: List<String>,
    val isCompleted: Boolean,
    val completedAt: Long?
)

data class CareerMilestone(
    val id: String,
    val title: String,
    val description: String,
    val category: MilestoneCategory,
    val targetDate: Long,
    val isCompleted: Boolean,
    val completedAt: Long?,
    val requirements: List<String>,
    val rewards: List<String>,
    val priority: MilestonePriority
)

enum class MilestoneCategory {
    SKILL_DEVELOPMENT, CERTIFICATION, EXPERIENCE, NETWORKING, EDUCATION, PROMOTION
}

enum class MilestonePriority {
    LOW, MEDIUM, HIGH, CRITICAL
}

data class SkillsRoadmap(
    val currentSkills: List<SkillAssessment>,
    val targetSkills: List<SkillTarget>,
    val skillGaps: List<SkillGap>,
    val learningPaths: List<String> // Learning path IDs
)

data class SkillTarget(
    val skillName: String,
    val currentLevel: SkillLevel,
    val targetLevel: SkillLevel,
    val priority: SkillPriority,
    val estimatedTimeToAchieve: Int, // in months
    val learningResources: List<LearningResource>,
    val progress: Float // 0.0 to 1.0
)

enum class SkillPriority {
    ESSENTIAL, IMPORTANT, NICE_TO_HAVE
}

data class SkillGap(
    val skillName: String,
    val requiredLevel: SkillLevel,
    val currentLevel: SkillLevel?,
    val gapSize: GapSize,
    val recommendedActions: List<String>
)

enum class GapSize {
    SMALL, MEDIUM, LARGE, CRITICAL
}

data class ExperienceRoadmap(
    val currentExperience: List<ExperienceItem>,
    val targetExperiences: List<ExperienceTarget>,
    val experienceGaps: List<String>
)

data class ExperienceTarget(
    val type: ExperienceType,
    val description: String,
    val timeframe: String,
    val importance: ImportanceLevel,
    val suggestedOpportunities: List<String>
)

enum class ExperienceType {
    PROJECT_LEADERSHIP, TEAM_MANAGEMENT, CLIENT_FACING, TECHNICAL_EXPERTISE,
    CROSS_FUNCTIONAL, MENTORING, PUBLIC_SPEAKING, STRATEGIC_PLANNING
}

enum class ImportanceLevel {
    LOW, MEDIUM, HIGH, CRITICAL
}

data class CareerGoal(
    val id: String,
    val title: String,
    val description: String,
    val category: GoalCategory,
    val type: GoalType,
    val targetValue: String?,
    val currentValue: String?,
    val targetDate: Long,
    val progress: Float,
    val isCompleted: Boolean,
    val completedAt: Long?,
    val subGoals: List<SubGoal>,
    val trackingMetrics: List<GoalMetric>
)

enum class GoalCategory {
    SKILL_DEVELOPMENT, CAREER_ADVANCEMENT, SALARY_INCREASE, NETWORKING,
    EDUCATION, SIDE_PROJECT, PERSONAL_BRAND
}

enum class GoalType {
    BINARY, NUMERIC, MILESTONE, HABIT
}

data class SubGoal(
    val id: String,
    val title: String,
    val isCompleted: Boolean,
    val completedAt: Long?,
    val dueDate: Long?
)

data class GoalMetric(
    val name: String,
    val currentValue: Float,
    val targetValue: Float,
    val unit: String
)

data class RoadmapProgress(
    val overallProgress: Float, // 0.0 to 1.0
    val milestonesCompleted: Int,
    val totalMilestones: Int,
    val goalsCompleted: Int,
    val totalGoals: Int,
    val skillsProgress: Float,
    val experienceProgress: Float,
    val phaseProgress: Map<String, Float>,
    val weeklyProgress: List<WeeklyProgress>
)

data class WeeklyProgress(
    val weekStart: Long,
    val activitiesCompleted: Int,
    val skillsImproved: Int,
    val goalsAdvanced: Int,
    val totalScore: Float
)

data class CareerInsight(
    val id: String,
    val type: InsightType,
    val title: String,
    val message: String,
    val actionable: Boolean,
    val suggestedActions: List<String>,
    val priority: InsightPriority,
    val timestamp: Long
)

enum class InsightType {
    SKILL_GAP, OPPORTUNITY, WARNING, ACHIEVEMENT, MARKET_TREND, RECOMMENDATION
}

enum class InsightPriority {
    LOW, MEDIUM, HIGH, URGENT
}