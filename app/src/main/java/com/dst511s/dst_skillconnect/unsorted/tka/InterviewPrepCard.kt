package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.InterviewPrep


@Composable
fun InterviewPrepCard(
    prep: InterviewPrep,
    onStartClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = prep.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = prep.jobRole,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                DifficultyChip(difficulty = prep.difficulty)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Progress indicator
            if (prep.completedSessions > 0) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Progress",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )

                    Text(
                        text = "${prep.completedSessions} sessions • ${(prep.averageScore * 20).toInt()}% avg",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                LinearProgressIndicator(
                    progress = { prep.averageScore },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            // Session details
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoChip(
                    icon = Icons.Default.Schedule,
                    text = "${prep.duration} min"
                )

                InfoChip(
                    icon = Icons.Default.Quiz,
                    text = "${prep.questionCount} questions"
                )

                InfoChip(
                    icon = Icons.Default.Category,
                    text = "${prep.categories.size} areas"
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onStartClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (prep.completedSessions > 0) "Continue Practice" else "Start Practice")
            }
        }
    }
}
