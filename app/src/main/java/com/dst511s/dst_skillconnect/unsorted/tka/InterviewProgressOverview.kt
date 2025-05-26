package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.InterviewPrep

@Composable
fun InterviewProgressOverview(interviewPreps: List<InterviewPrep>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Your Progress",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ProgressMetric(
                    value = interviewPreps.sumOf { it.completedSessions }.toString(),
                    label = "Sessions Completed",
                    icon = Icons.Default.Check
                )

                ProgressMetric(
                    value = "${(interviewPreps.map { it.averageScore }.average() * 20).toInt()}%",
                    label = "Average Score",
                    icon = Icons.Default.TrendingUp
                )

                ProgressMetric(
                    value = "${interviewPreps.count { it.lastAttempt != null }}",
                    label = "Areas Practiced",
                    icon = Icons.Default.Category
                )
            }
        }
    }
}