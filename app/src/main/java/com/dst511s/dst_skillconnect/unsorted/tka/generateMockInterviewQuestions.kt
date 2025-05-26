package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.unsorted.data.InterviewQuestion
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewDifficulty
import com.dst511s.dst_skillconnect.unsorted.enume.QuestionType

fun generateMockInterviewQuestions(): List<InterviewQuestion> {
    return listOf(
        InterviewQuestion(
            id = "q1",
            question = "Tell me about yourself and why you're interested in this position.",
            category = InterviewCategory.BEHAVIORAL,
            difficulty = InterviewDifficulty.BEGINNER,
            type = QuestionType.OPEN_ENDED,
            timeLimit = 120,
            sampleAnswer = "I'm a passionate frontend developer with 2 years of experience...",
            tips = listOf("Keep it concise and relevant to the job", "Focus on your professional journey", "End with why you want this specific role")
        ),
        InterviewQuestion(
            id = "q2",
            question = "Explain the difference between let, const, and var in JavaScript.",
            category = InterviewCategory.TECHNICAL,
            difficulty = InterviewDifficulty.INTERMEDIATE,
            type = QuestionType.OPEN_ENDED,
            timeLimit = 180,
            sampleAnswer = "var is function-scoped, let and const are block-scoped...",
            tips = listOf("Mention scope differences", "Discuss hoisting behavior", "Give examples")
        ),
        InterviewQuestion(
            id = "q3",
            question = "Describe a challenging project you worked on and how you overcame the difficulties.",
            category = InterviewCategory.SITUATIONAL,
            difficulty = InterviewDifficulty.INTERMEDIATE,
            type = QuestionType.OPEN_ENDED,
            timeLimit = 240,
            sampleAnswer = "I worked on a project where we had tight deadlines...",
            tips = listOf("Use the STAR method", "Focus on your problem-solving approach", "Highlight what you learned")
        )
    )
}