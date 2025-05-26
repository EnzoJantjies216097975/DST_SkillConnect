package com.dst511s.dst_skillconnect.features.skills.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.features.skills.components.AnswerOption
import com.dst511s.dst_skillconnect.unsorted.data.SkillQuestion
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme

@Composable
fun QuestionScreen(
    question: SkillQuestion,
    questionNumber: Int,
    totalQuestions: Int,
    selectedAnswer: Int?,
    onAnswerSelected: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onPreviousQuestion: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Progress indicator
        LinearProgressIndicator(
            progress = { questionNumber.toFloat() / totalQuestions },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Question $questionNumber of $totalQuestions",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Question text
        Text(
            text = question.questionText,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Answer options
        LazyColumn {
            items(question.options.size) { index ->
                AnswerOption(
                    text = question.options[index],
                    isSelected = selectedAnswer == index,
                    onSelect = { onAnswerSelected(index) },
                    optionLetter = ('A' + index).toString()
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Navigation buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = onPreviousQuestion,
                modifier = Modifier.width(120.dp),
                enabled = questionNumber > 1
            ) {
                Text(text = "Previous")
            }

            Button(
                onClick = onNextQuestion,
                modifier = Modifier.width(120.dp),
                enabled = selectedAnswer != null
            ) {
                Text(text = if (questionNumber == totalQuestions) "Finish" else "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionScreenPreview() {
    DST_SkillConnectTheme {
        QuestionScreen(
            question = SkillQuestion(
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
            questionNumber = 1,
            totalQuestions = 10,
            selectedAnswer = null,
            onAnswerSelected = {},
            onNextQuestion = {},
            onPreviousQuestion = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}