package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.height
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewDifficulty

@Composable
fun DifficultyChip(difficulty: InterviewDifficulty) {
    val (color, text) = when (difficulty) {
        InterviewDifficulty.BEGINNER -> Color(0xFF4CAF50) to "Beginner"
        InterviewDifficulty.INTERMEDIATE -> Color(0xFF2196F3) to "Intermediate"
        InterviewDifficulty.ADVANCED -> Color(0xFFFF9800) to "Advanced"
        InterviewDifficulty.EXPERT -> Color(0xFFF44336) to "Expert"
    }

    AssistChip(
        onClick = { },
        label = {
            Text(
                text = text,
                color = color,
                style = MaterialTheme.typography.labelSmall
            )
        },
        border = AssistChipDefaults.assistChipBorder(borderColor = color),
        modifier = Modifier.height(24.dp)
    )
}