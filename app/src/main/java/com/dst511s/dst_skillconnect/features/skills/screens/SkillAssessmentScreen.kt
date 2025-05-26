package com.dst511s.dst_skillconnect.features.skills.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dst511s.dst_skillconnect.unsorted.data.SkillAssessment
import com.dst511s.dst_skillconnect.unsorted.data.SkillQuestion
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkillAssessmentScreen(
    skillId: String,
    onNavigateBack: () -> Unit,
    onAssessmentComplete: () -> Unit
) {
    // For prototype, we use hardcoded skill assessment data
    // In a real app, this would be fetched from a repository
    val assessment = remember {
        SkillAssessment(
            skillId = skillId,
            skillName = skillId,
            totalQuestions = 10,
            estimatedDuration = "15-20 minutes",
            description = "This assessment will evaluate your knowledge and proficiency in $skillId. Upon successful completion, you'll receive a verified badge that will be visible to employers.",
            questions = listOf(
                SkillQuestion(
                    id = "q1",
                    questionText = "Which of the following is NOT a valid way to declare a variable in JavaScript?",
                    options = listOf(
                        "var x = 5;",
                        "let x = 5;",
                        "const x = 5;",
                        "integer x = 5;"
                    ),
                    correctAnswer = 3
                ),
                SkillQuestion(
                    id = "q2",
                    questionText = "What will be the output of the following code?\n\nconst arr = [1, 2, 3];\nconst [a, b, c, d] = arr;\nconsole.log(d);",
                    options = listOf(
                        "undefined",
                        "null",
                        "ReferenceError",
                        "0"
                    ),
                    correctAnswer = 0
                ),
                SkillQuestion(
                    id = "q3",
                    questionText = "Which of these is an arrow function?",
                    options = listOf(
                        "function(a, b) { return a + b; }",
                        "const sum = function(a, b) { return a + b; }",
                        "const sum = (a, b) => a + b;",
                        "const sum = (a, b) => { a + b }"
                    ),
                    correctAnswer = 2
                )
            )
        )
    }

    var currentQuestionIndex by remember { mutableStateOf(-1) } // -1 for intro screen
    var selectedAnswers by remember { mutableStateOf(HashMap<String, Int>()) }
    var isAssessmentComplete by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${assessment.skillName} Assessment") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isAssessmentComplete) {
            AssessmentCompleteScreen(
                skillName = assessment.skillName,
                onContinue = onAssessmentComplete,
                modifier = Modifier.padding(paddingValues)
            )
        } else if (currentQuestionIndex == -1) {
            // Introduction screen
            AssessmentIntroScreen(
                assessment = assessment,
                onStartAssessment = { currentQuestionIndex = 0 },
                modifier = Modifier.padding(paddingValues)
            )
        } else {
            // Question screen
            QuestionScreen(
                question = assessment.questions[currentQuestionIndex],
                questionNumber = currentQuestionIndex + 1,
                totalQuestions = assessment.questions.size,
                selectedAnswer = selectedAnswers[assessment.questions[currentQuestionIndex].id],
                onAnswerSelected = { answerId ->
                    selectedAnswers[assessment.questions[currentQuestionIndex].id] = answerId
                },
                onNextQuestion = {
                    if (currentQuestionIndex < assessment.questions.size - 1) {
                        currentQuestionIndex++
                    } else {
                        // Assessment complete
                        isAssessmentComplete = true
                    }
                },
                onPreviousQuestion = {
                    if (currentQuestionIndex > 0) {
                        currentQuestionIndex--
                    }
                },
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SkillAssessmentScreenPreview() {
    DST_SkillConnectTheme {
        SkillAssessmentScreen(
            skillId = "JavaScript",  // Sample skill ID
            onNavigateBack = {},
            onAssessmentComplete = {}
        )
    }
}