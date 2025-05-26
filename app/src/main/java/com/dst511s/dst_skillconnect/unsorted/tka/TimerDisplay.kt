package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TimerDisplay(timeRemaining: Int) {
    val minutes = timeRemaining / 60
    val seconds = timeRemaining % 60
    val color = when {
        timeRemaining > 60 -> MaterialTheme.colorScheme.primary
        timeRemaining > 30 -> Color(0xFFFF9800)
        else -> Color(0xFFF44336)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Schedule,
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = color
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = String.format("%02d:%02d", minutes, seconds),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}

