package com.dst511s.dst_skillconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.components.AssessmentInfoRow
import com.dst511s.dst_skillconnect.components.BulletPoint
import com.dst511s.dst_skillconnect.data.models.SkillAssessment
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme

@Composable
fun AssessmentIntroScreen(
    assessment: SkillAssessment,
    onStartAssessment: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Skill icon
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Code,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "${assessment.skillName} Skill Assessment",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = assessment.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Assessment details
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                AssessmentInfoRow(
                    icon = Icons.Default.Quiz,
                    label = "Total Questions",
                    value = assessment.totalQuestions.toString()
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                )

                AssessmentInfoRow(
                    icon = Icons.Default.Timer,
                    label = "Estimated Time",
                    value = assessment.estimatedDuration
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                )

                AssessmentInfoRow(
                    icon = Icons.Default.Verified,
                    label = "Verification",
                    value = "Badge on completion"
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Guidelines
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Guidelines",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            BulletPoint(text = "Answer all questions to the best of your ability")
            BulletPoint(text = "You can navigate between questions")
            BulletPoint(text = "Ensure you have a stable internet connection")
            BulletPoint(text = "Do not use external resources during the assessment")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Start button
        Button(
            onClick = onStartAssessment,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Start Assessment",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AssessmentIntroScreenPreview() {
    DST_SkillConnectTheme {
        AssessmentIntroScreen(
            assessment = SkillAssessment(
                skillId = "javascript",
                skillName = "JavaScript",
                totalQuestions = 10,
                estimatedDuration = "15-20 minutes",
                description = "This assessment will evaluate your knowledge and proficiency in JavaScript.",
                questions = emptyList()
            ),
            onStartAssessment = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}