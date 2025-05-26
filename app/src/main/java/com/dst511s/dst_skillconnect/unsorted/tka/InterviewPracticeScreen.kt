package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.InterviewResponse
import com.dst511s.dst_skillconnect.unsorted.data.InterviewSession
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterviewPracticeScreen(
    prepId: String,
    onNavigateBack: () -> Unit,
    onSessionComplete: (InterviewSession) -> Unit
) {
    var session by remember { mutableStateOf<InterviewSession?>(null) }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var currentResponse by remember { mutableStateOf("") }
    var timeRemaining by remember { mutableStateOf(0) }
    var isRecording by remember { mutableStateOf(false) }
    var showTimer by remember { mutableStateOf(true) }

    LaunchedEffect(prepId) {
        // Initialize session
        val questions = generateMockInterviewQuestions()
        session = InterviewSession(
            id = "session_${System.currentTimeMillis()}",
            prepId = prepId,
            startTime = System.currentTimeMillis(),
            endTime = null,
            questions = questions,
            responses = emptyList()
        )
        timeRemaining = questions.firstOrNull()?.timeLimit ?: 300
    }

    // Timer effect
    LaunchedEffect(timeRemaining, currentQuestionIndex) {
        if (timeRemaining > 0 && session != null) {
            delay(1000)
            timeRemaining--
        } else if (timeRemaining <= 0) {
            // Auto-advance to next question
            handleNextQuestion()
        }
    }

    fun handleNextQuestion() {
        session?.let { currentSession ->
            val currentQuestion = currentSession.questions[currentQuestionIndex]
            val response = InterviewResponse(
                questionId = currentQuestion.id,
                response = currentResponse.trim(),
                responseTime = currentQuestion.timeLimit - timeRemaining
            )

            val updatedResponses = currentSession.responses + response
            session = currentSession.copy(responses = updatedResponses)

            if (currentQuestionIndex < currentSession.questions.size - 1) {
                currentQuestionIndex++
                currentResponse = ""
                timeRemaining = currentSession.questions[currentQuestionIndex].timeLimit
            } else {
                // Session complete
                val completedSession = currentSession.copy(
                    endTime = System.currentTimeMillis(),
                    responses = updatedResponses,
                    isCompleted = true
                )
                onSessionComplete(completedSession)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Interview Practice")
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showTimer = !showTimer }) {
                        Icon(
                            imageVector = if (showTimer) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (showTimer) "Hide timer" else "Show timer"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        session?.let { currentSession ->
            val currentQuestion = currentSession.questions[currentQuestionIndex]

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Progress indicator
                LinearProgressIndicator(
                    progress = { (currentQuestionIndex + 1).toFloat() / currentSession.questions.size },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Question ${currentQuestionIndex + 1} of ${currentSession.questions.size}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )

                    if (showTimer) {
                        TimerDisplay(timeRemaining = timeRemaining)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Question card
                InterviewQuestionCard(
                    question = currentQuestion,
                    questionNumber = currentQuestionIndex + 1
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Response area
                ResponseArea(
                    response = currentResponse,
                    onResponseChange = { currentResponse = it },
                    isRecording = isRecording,
                    onToggleRecording = { isRecording = !isRecording },
                    questionType = currentQuestion.type
                )

                Spacer(modifier = Modifier.weight(1f))

                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedButton(
                        onClick = { /* Skip question */ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Skip")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = { handleNextQuestion() },
                        modifier = Modifier.weight(1f),
                        enabled = currentResponse.trim().isNotEmpty() || isRecording
                    ) {
                        Text(
                            if (currentQuestionIndex == currentSession.questions.size - 1) "Finish" else "Next"
                        )
                    }
                }
            }
        }
    }
}