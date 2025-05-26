package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.data.CompanyHiringData
import com.dst511s.dst_skillconnect.unsorted.data.CompetitivePosition
import com.dst511s.dst_skillconnect.unsorted.data.DailyViewData
import com.dst511s.dst_skillconnect.unsorted.data.IndustryData
import com.dst511s.dst_skillconnect.unsorted.data.JobApplicationAnalytics
import com.dst511s.dst_skillconnect.unsorted.data.MarketInsightsData
import com.dst511s.dst_skillconnect.unsorted.data.MonthlyApplicationData
import com.dst511s.dst_skillconnect.unsorted.data.ProfileAnalytics
import com.dst511s.dst_skillconnect.unsorted.data.ProfileCompletionData
import com.dst511s.dst_skillconnect.unsorted.data.ProfileRecommendation
import com.dst511s.dst_skillconnect.unsorted.data.ProfileViewsData
import com.dst511s.dst_skillconnect.unsorted.data.SalaryRangeData
import com.dst511s.dst_skillconnect.unsorted.data.SkillProgressData
import com.dst511s.dst_skillconnect.unsorted.data.TrendingSkill
import com.dst511s.dst_skillconnect.unsorted.data.ViewSource
import com.dst511s.dst_skillconnect.unsorted.enume.ApplicationStatus
import com.dst511s.dst_skillconnect.unsorted.enume.MarketDemand
import com.dst511s.dst_skillconnect.unsorted.enume.RecommendationPriority
import com.dst511s.dst_skillconnect.unsorted.enume.RecommendationType
import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel
import com.dst511s.dst_skillconnect.unsorted.enume.SkillTrend
import com.dst511s.dst_skillconnect.unsorted.enume.VerificationStatus

private fun generateMockAnalytics(): ProfileAnalytics {
    return ProfileAnalytics(
        profileViews = ProfileViewsData(
            totalViews = 234,
            viewsThisWeek = 45,
            viewsLastWeek = 38,
            dailyViews = listOf(
                DailyViewData("Mon", 8),
                DailyViewData("Tue", 12),
                DailyViewData("Wed", 6),
                DailyViewData("Thu", 15),
                DailyViewData("Fri", 20),
                DailyViewData("Sat", 9),
                DailyViewData("Sun", 5)
            ),
            viewerTypes = mapOf(
                "Recruiters" to 45,
                "Companies" to 30,
                "Job Seekers" to 25
            ),
            topViewingSources = listOf(
                ViewSource("LinkedIn", 89, 38f),
                ViewSource("Company Websites", 67, 29f),
                ViewSource("Job Boards", 45, 19f),
                ViewSource("Direct Search", 33, 14f)
            )
        ),
        skillProgress = listOf(
            SkillProgressData("JavaScript", SkillLevel.INTERMEDIATE, 0.75f, SkillTrend.IMPROVING, System.currentTimeMillis(), MarketDemand.VERY_HIGH, VerificationStatus.VERIFIED),
            SkillProgressData("React", SkillLevel.BEGINNER, 0.45f, SkillTrend.NEW, null, MarketDemand.HIGH, VerificationStatus.NOT_VERIFIED),
            SkillProgressData("Python", SkillLevel.INTERMEDIATE, 0.65f, SkillTrend.STABLE, System.currentTimeMillis(), MarketDemand.HIGH, VerificationStatus.VERIFIED),
            SkillProgressData("HTML/CSS", SkillLevel.ADVANCED, 0.90f, SkillTrend.STABLE, System.currentTimeMillis(), MarketDemand.MODERATE, VerificationStatus.VERIFIED)
        ),
        jobApplications = JobApplicationAnalytics(
            totalApplications = 28,
            applicationsThisMonth = 12,
            responseRate = 32f,
            interviewRate = 18f,
            offerRate = 7f,
            applicationsByStatus = mapOf(
                ApplicationStatus.SUBMITTED to 15,
                ApplicationStatus.REVIEWED to 8,
                ApplicationStatus.INTERVIEW to 3,
                ApplicationStatus.OFFERED to 2
            ),
            averageResponseTime = 5,
            topAppliedIndustries = listOf(
                IndustryData("Technology", 18, 35f),
                IndustryData("Finance", 6, 25f),
                IndustryData("Healthcare", 4, 50f)
            ),
            applicationTrend = listOf(
                MonthlyApplicationData("Jan", 8, 3),
                MonthlyApplicationData("Feb", 12, 4),
                MonthlyApplicationData("Mar", 8, 2)
            )
        ),
        profileCompletion = ProfileCompletionData(
            overallCompletion = 78,
            sectionCompletion = mapOf(
                "Basic Info" to 100,
                "Skills" to 85,
                "Experience" to 60,
                "Projects" to 75,
                "Education" to 90
            ),
            missingItems = listOf(
                "Professional summary",
                "Additional work experience",
                "Portfolio links"
            ),
            impactScore = 85
        ),
        marketInsights = MarketInsightsData(
            salaryRange = SalaryRangeData(
                minSalary = 15000.0,
                maxSalary = 35000.0,
                averageSalary = 25000.0,
                yourTargetSalary = 28000.0
            ),
            demandForYourSkills = 78f,
            competitivePosition = CompetitivePosition(
                percentile = 65,
                strengthAreas = listOf("JavaScript", "Problem Solving", "Team Collaboration"),
                improvementAreas = listOf("React", "System Design", "Leadership")
            ),
            trendingSkills = listOf(
                TrendingSkill("TypeScript", 45f, 5000.0, MarketDemand.VERY_HIGH),
                TrendingSkill("AWS", 38f, 8000.0, MarketDemand.HIGH),
                TrendingSkill("Docker", 32f, 4000.0, MarketDemand.HIGH)
            ),
            topCompaniesHiring = listOf(
                CompanyHiringData("TechCorp", 15, 8, 28000.0),
                CompanyHiringData("FinanceApp", 8, 3, 32000.0)
            )
        ),
        recommendations = listOf(
            ProfileRecommendation(
                type = RecommendationType.SKILL_DEVELOPMENT,
                title = "Learn React",
                description = "React is in high demand and matches many jobs you're interested in",
                priority = RecommendationPriority.HIGH,
                actionText = "Start Learning",
                potentialImpact = "+25% job matches",
                actionData = "skill_react"
            ),
            ProfileRecommendation(
                type = RecommendationType.PROFILE_OPTIMIZATION,
                title = "Add Professional Summary",
                description = "Profiles with summaries get 40% more views",
                priority = RecommendationPriority.MEDIUM,
                actionText = "Add Summary",
                potentialImpact = "+40% profile views",
                actionData = "add_summary"
            ),
            ProfileRecommendation(
                type = RecommendationType.APPLICATION_STRATEGY,
                title = "Apply to More Startups",
                description = "Your skills align well with startup opportunities",
                priority = RecommendationPriority.MEDIUM,
                actionText = "Find Startups",
                potentialImpact = "+50% response rate",
                actionData = "search_startups"
            )
        )
    )
}