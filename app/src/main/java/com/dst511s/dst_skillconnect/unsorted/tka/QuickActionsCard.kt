package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun QuickActionsCard(
    onRandomPractice: () -> Unit,
    onMockInterview: () -> Unit,
    onTipsAndTricks: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                QuickActionButton(
                    icon = Icons.Default.Shuffle,
                    label = "Random Practice",
                    onClick = onRandomPractice
                )

                QuickActionButton(
                    icon = Icons.Default.RecordVoiceOver,
                    label = "Mock Interview",
                    onClick = onMockInterview
                )

                QuickActionButton(
                    icon = Icons.Default.Lightbulb,
                    label = "Tips & Tricks",
                    onClick = onTipsAndTricks
                )
            }
        }
    }
}