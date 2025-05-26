package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.data.InterviewPrep
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewDifficulty

private fun generateMockInterviewPreps(): List<InterviewPrep> {
    return listOf(
        InterviewPrep(
            id = "prep_1",
            title = "Frontend Developer Interview",
            jobRole = "Frontend Developer",
            difficulty = InterviewDifficulty.INTERMEDIATE,
            duration = 45,
            questionCount = 15,
            categories = listOf(InterviewCategory.TECHNICAL, InterviewCategory.BEHAVIORAL),
            completedSessions = 3,
            averageScore = 0.78f,
            lastAttempt = System.currentTimeMillis() - 86400000
        ),
        InterviewPrep(
            id = "prep_2",
            title = "Behavioral Questions",
            jobRole = "Software Developer",
            difficulty = InterviewDifficulty.BEGINNER,
            duration = 30,
            questionCount = 10,
            categories = listOf(InterviewCategory.BEHAVIORAL, InterviewCategory.SITUATIONAL),
            completedSessions = 1,
            averageScore = 0.65f,
            lastAttempt = System.currentTimeMillis() - 172800000
        ),
        InterviewPrep(
            id = "prep_3",
            title = "System Design Interview",
            jobRole = "Senior Developer",
            difficulty = InterviewDifficulty.ADVANCED,
            duration = 60,
            questionCount = 8,
            categories = listOf(InterviewCategory.SYSTEM_DESIGN, InterviewCategory.TECHNICAL),
            completedSessions = 0,
            averageScore = 0f,
            lastAttempt = null
        ),
        InterviewPrep(
            id = "prep_4",
            title = "Startup Interview Prep",
            jobRole = "Full Stack Developer",
            difficulty = InterviewDifficulty.INTERMEDIATE,
            duration = 40,
            questionCount = 12,
            categories = listOf(InterviewCategory.COMPANY_SPECIFIC, InterviewCategory.TECHNICAL),
            completedSessions = 2,
            averageScore = 0.82f,
            lastAttempt = System.currentTimeMillis() - 43200000
        )
    )
}