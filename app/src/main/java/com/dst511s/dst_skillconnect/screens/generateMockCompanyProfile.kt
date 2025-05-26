package com.dst511s.dst_skillconnect.screens

import com.dst511s.dst_skillconnect.data.models.AchievementType
import com.dst511s.dst_skillconnect.data.models.CompanyAchievement
import com.dst511s.dst_skillconnect.data.models.CompanyBenefit
import com.dst511s.dst_skillconnect.data.models.CompanyLocation
import com.dst511s.dst_skillconnect.data.models.CompanyProfile
import com.dst511s.dst_skillconnect.data.models.CompanyReviews
import com.dst511s.dst_skillconnect.data.models.CompanySize
import com.dst511s.dst_skillconnect.data.models.DiversityStats
import com.dst511s.dst_skillconnect.data.models.EmploymentType
import com.dst511s.dst_skillconnect.data.models.JobListing
import com.dst511s.dst_skillconnect.data.models.RemotePolicy
import com.dst511s.dst_skillconnect.data.models.ReviewCategory
import com.dst511s.dst_skillconnect.data.models.WorkCulture

private fun generateMockCompanyProfile(companyId: String): CompanyProfile {
    return CompanyProfile(
        id = companyId,
        name = "TechCorp Solutions",
        tagline = "Building the future through innovation",
        description = "TechCorp Solutions is a leading technology company specializing in software development, cloud solutions, and digital transformation. We help businesses worldwide leverage technology to achieve their goals and drive growth.",
        industry = "Technology",
        size = CompanySize.MEDIUM,
        foundedYear = 2015,
        headquarters = "Windhoek, Namibia",
        website = "https://techcorp.na",
        logoUrl = null,
        coverImageUrl = null,
        socialLinks = mapOf(
            "linkedin" to "linkedin.com/company/techcorp",
            "twitter" to "twitter.com/techcorp"
        ),
        benefits = listOf(
            CompanyBenefit(BenefitCategory.HEALTH, "Health Insurance", "Comprehensive medical coverage", "health"),
            CompanyBenefit(BenefitCategory.FINANCIAL, "Competitive Salary", "Market-competitive compensation", "money"),
            CompanyBenefit(BenefitCategory.WORK_LIFE_BALANCE, "Flexible Hours", "Work when you're most productive", "balance"),
            CompanyBenefit(BenefitCategory.PROFESSIONAL_DEVELOPMENT, "Learning Budget", "N$5000 annual learning allowance", "education")
        ),
        workCulture = WorkCulture(
            values = listOf("Innovation", "Collaboration", "Excellence", "Integrity"),
            workEnvironment = "Modern office with collaborative spaces",
            diversityAndInclusion = DiversityStats(
                genderBalance = mapOf("Male" to 0.6f, "Female" to 0.4f),
                ageDistribution = mapOf("20-30" to 0.4f, "30-40" to 0.4f, "40+" to 0.2f),
                inclusionScore = 4.2f
            ),
            workLifeBalance = 4.3f,
            learningOpportunities = 4.5f,
            careerGrowth = 4.1f,
            compensation = 4.0f,
            workFromHome = RemotePolicy.HYBRID
        ),
        reviews = CompanyReviews(
            overallRating = 4.2f,
            totalReviews = 156,
            ratings = mapOf(
                ReviewCategory.WORK_LIFE_BALANCE to 4.3f,
                ReviewCategory.COMPENSATION to 4.0f,
                ReviewCategory.CAREER_OPPORTUNITIES to 4.1f,
                ReviewCategory.COMPANY_CULTURE to 4.4f,
                ReviewCategory.MANAGEMENT to 3.9f
            ),
            recentReviews = emptyList()
        ),
        openPositions = listOf(
            JobListing(
                id = "1",
                title = "Senior Frontend Developer",
                employmentType = EmploymentType.FULL_TIME,
                location = "Windhoek",
                salaryMin = 25000.0,
                salaryMax = 35000.0
            )
        ),
        employees = emptyList(),
        locations = listOf(
            CompanyLocation(
                city = "Windhoek",
                country = "Namibia",
                address = "123 Tech Street, Windhoek",
                isHeadquarters = true,
                employeeCount = 85
            )
        ),
        technologies = listOf("React", "TypeScript", "Node.js", "AWS", "Docker", "Kubernetes"),
        achievements = listOf(
            CompanyAchievement(
                title = "Best Tech Employer 2024",
                description = "Recognized for outstanding employee satisfaction",
                year = 2024,
                type = AchievementType.AWARD
            ),
            CompanyAchievement(
                title = "ISO 27001 Certified",
                description = "Information security management certification",
                year = 2023,
                type = AchievementType.CERTIFICATION
            )
        ),
        isFollowing = false
    )
}