package com.dst511s.dst_skillconnect.unsorted

import com.dst511s.dst_skillconnect.unsorted.data.CertificateInfo
import com.dst511s.dst_skillconnect.unsorted.data.LearningPath
import com.dst511s.dst_skillconnect.unsorted.data.PathAuthor
import com.dst511s.dst_skillconnect.unsorted.data.PathPrice
import com.dst511s.dst_skillconnect.unsorted.enume.LearningCategory
import com.dst511s.dst_skillconnect.unsorted.enume.PathDifficulty
import com.dst511s.dst_skillconnect.unsorted.enume.PriceType


fun generateMockLearningPaths(): List<LearningPath> {
    return listOf(
        LearningPath(
            id = "path_1",
            title = "Complete Frontend Developer",
            description = "Master modern frontend development with React, TypeScript, and modern tools",
            targetRole = "Frontend Developer",
            difficulty = PathDifficulty.INTERMEDIATE,
            estimatedDuration = "12 weeks",
            totalLessons = 45,
            completedLessons = 18,
            skills = listOf("React", "TypeScript", "CSS", "JavaScript", "HTML"),
            prerequisites = listOf("Basic HTML/CSS", "JavaScript fundamentals"),
            modules = emptyList(),
            progress = 0.4f,
            isEnrolled = true,
            enrollmentDate = System.currentTimeMillis() - 1209600000,
            lastAccessed = System.currentTimeMillis() - 86400000,
            category = LearningCategory.PROGRAMMING,
            rating = 4.8f,
            reviewCount = 1247,
            author = PathAuthor(
                id = "author_1",
                name = "Sarah Johnson",
                title = "Senior Frontend Engineer",
                company = "Google",
                avatar = null,
                bio = "10+ years of frontend development experience",
                rating = 4.9f,
                studentCount = 25000
            ),
            price = PathPrice(PriceType.FREE, 0.0, "USD", null, null),
            certificate = CertificateInfo(
                title = "Frontend Developer Certificate",
                issuer = "SkillConnect",
                isAccredited = true,
                validityPeriod = null,
                requirements = listOf("Complete all modules", "Pass final project")
            )
        ),
        LearningPath(
            id = "path_2",
            title = "Data Science Fundamentals",
            description = "Learn the essentials of data science with Python, statistics, and machine learning",
            targetRole = "Data Scientist",
            difficulty = PathDifficulty.BEGINNER,
            estimatedDuration = "16 weeks",
            totalLessons = 60,
            completedLessons = 0,
            skills = listOf("Python", "Pandas", "NumPy", "Statistics", "Machine Learning"),
            prerequisites = listOf("Basic programming knowledge", "High school mathematics"),
            modules = emptyList(),
            progress = 0f,
            isEnrolled = false,
            enrollmentDate = null,
            lastAccessed = null,
            category = LearningCategory.DATA_SCIENCE,
            rating = 4.7f,
            reviewCount = 892,
            author = PathAuthor(
                id = "author_2",
                name = "Dr. Michael Chen",
                title = "Data Science Lead",
                company = "Microsoft",
                avatar = null,
                bio = "PhD in Statistics, 8+ years in data science",
                rating = 4.8f,
                studentCount = 15000
            ),
            price = PathPrice(PriceType.ONE_TIME, 299.0, "USD", 399.0, 25),
            certificate = null
        )
    )
}

fun generateMockLearningPath(pathId: String): LearningPath {
    return generateMockLearningPaths().first { it.id == pathId }
}