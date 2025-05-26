package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.height
import androidx.compose.material3.AssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory

@Composable
fun CategoryChip(category: InterviewCategory) {
    AssistChip(
        onClick = { },
        label = {
            Text(
                text = category.name.replace("_", " ").lowercase().capitalize(),
                style = MaterialTheme.typography.labelSmall
            )
        },
        modifier = Modifier.height(24.dp)
    )
}