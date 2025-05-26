package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.enume.LayoutStyle
import com.dst511s.dst_skillconnect.unsorted.data.Portfolio
import com.dst511s.dst_skillconnect.unsorted.data.PortfolioAnalytics
import com.dst511s.dst_skillconnect.unsorted.data.PortfolioTheme
import com.dst511s.dst_skillconnect.unsorted.enume.ProjectCategory
import com.dst511s.dst_skillconnect.unsorted.data.ProjectShowcase
import com.dst511s.dst_skillconnect.unsorted.data.ReferrerData
import com.dst511s.dst_skillconnect.unsorted.data.SkillEndorsement
import com.dst511s.dst_skillconnect.unsorted.data.SkillShowcase
import com.dst511s.dst_skillconnect.unsorted.data.Testimonial
import com.dst511s.dst_skillconnect.unsorted.enume.TestimonialRelationship
import com.dst511s.dst_skillconnect.unsorted.enume.SkillLevel

fun generateMockPortfolio(userId: String): Portfolio {
    return Portfolio(
        id = "portfolio_$userId",
        userId = userId,
        title = "Tendai Moyo",
        subtitle = "Full Stack Developer & UI/UX Designer",
        bio = "Passionate developer with 3+ years of experience creating beautiful, functional web applications. I love turning ideas into reality through clean code and intuitive design.",
        avatar = null,
        coverImage = null,
        projects = listOf(
            ProjectShowcase(
                id = "project_1",
                title = "E-Commerce Platform",
                shortDescription = "Modern e-commerce solution with React and Node.js",
                fullDescription = "A comprehensive e-commerce platform built with modern web technologies...",
                category = ProjectCategory.WEB_DEVELOPMENT,
                tags = listOf("e-commerce", "react", "nodejs", "mongodb"),
                technologiesUsed = listOf("React", "Node.js", "MongoDB", "Stripe"),
                images = emptyList(),
                liveUrl = "https://example.com",
                githubUrl = "https://github.com/user/project",
                featured = true,
                dateCompleted = System.currentTimeMillis() - 86400000,
                views = 245,
                likes = 18
            ),
            ProjectShowcase(
                id = "project_2",
                title = "Task Management App",
                shortDescription = "Collaborative task management with real-time updates",
                fullDescription = "A task management application with real-time collaboration features...",
                category = ProjectCategory.WEB_DEVELOPMENT,
                tags = listOf("productivity", "collaboration", "react", "firebase"),
                technologiesUsed = listOf("React", "Firebase", "Material-UI"),
                images = emptyList(),
                liveUrl = "https://taskapp.example.com",
                githubUrl = "https://github.com/user/taskapp",
                featured = false,
                dateCompleted = System.currentTimeMillis() - 172800000,
                views = 156,
                likes = 12
            )
        ),
        skills = listOf(
            SkillShowcase(
                skillId = "javascript",
                name = "JavaScript",
                level = SkillLevel.ADVANCED,
                yearsOfExperience = 3.5f,
                projects = listOf("project_1", "project_2"),
                certifications = emptyList(),
                isVerified = true,
                endorsements = listOf(
                    SkillEndorsement(
                        endorserId = "colleague_1",
                        endorserName = "Sarah Johnson",
                        endorserTitle = "Senior Developer",
                        message = "Excellent JavaScript skills",
                        timestamp = System.currentTimeMillis()
                    )
                )
            ),
            SkillShowcase(
                skillId = "react",
                name = "React",
                level = SkillLevel.INTERMEDIATE,
                yearsOfExperience = 2.0f,
                projects = listOf("project_1", "project_2"),
                certifications = emptyList(),
                isVerified = true,
                endorsements = emptyList()
            )
        ),
        testimonials = listOf(
            Testimonial(
                id = "testimonial_1",
                authorId = "client_1",
                authorName = "Michael Chen",
                authorTitle = "Product Manager",
                authorCompany = "StartupCorp",
                authorAvatar = null,
                content = "Tendai delivered exceptional work on our e-commerce platform. His attention to detail and technical expertise exceeded our expectations.",
                rating = 5,
                relationship = TestimonialRelationship.CLIENT,
                timestamp = System.currentTimeMillis(),
                isVerified = true
            )
        ),
        socialLinks = mapOf(
            "GitHub" to "https://github.com/tendai",
            "LinkedIn" to "https://linkedin.com/in/tendai",
            "Website" to "https://tendai.dev"
        ),
        customSections = emptyList(),
        theme = PortfolioTheme(
            primaryColor = "#6366F1",
            secondaryColor = "#8B5CF6",
            backgroundColor = "#FFFFFF",
            textColor = "#1F2937",
            fontFamily = "Inter",
            layout = LayoutStyle.MODERN
        ),
        isPublic = true,
        customDomain = null,
        analytics = PortfolioAnalytics(
            totalViews = 1250,
            uniqueVisitors = 890,
            averageTimeOnSite = 185,
            topReferrers = listOf(
                ReferrerData("LinkedIn", 450, 36f),
                ReferrerData("GitHub", 320, 26f),
                ReferrerData("Google", 280, 22f),
                ReferrerData("Direct", 200, 16f)
            ),
            projectViews = mapOf(
                "project_1" to 245,
                "project_2" to 156
            ),
            skillsViewed = mapOf(
                "javascript" to 180,
                "react" to 165
            ),
            downloadCount = 47,
            contactFormSubmissions = 12
        )
    )
}