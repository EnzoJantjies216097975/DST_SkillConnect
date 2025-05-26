package com.dst511s.dst_skillconnect.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.Activity
import com.dst511s.dst_skillconnect.unsorted.enume.ActivityType

@Composable
fun ActivityItem(activity: Activity) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Activity icon
        val (icon, iconBackground) = when (activity.type) {
            ActivityType.APPLICATION -> Pair(Icons.Default.Work, MaterialTheme.colorScheme.primary)
            ActivityType.ASSESSMENT -> Pair(Icons.AutoMirrored.Filled.Assignment, MaterialTheme.colorScheme.secondary)
            ActivityType.WORKSHOP -> Pair(Icons.Default.School, MaterialTheme.colorScheme.tertiary)
            ActivityType.VIEW -> Pair(Icons.Default.Visibility, MaterialTheme.colorScheme.primary.copy(alpha = 0.7f))
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(iconBackground.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = iconBackground
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Activity details
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = activity.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = activity.company,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )

                Text(
                    text = " • ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )

                Text(
                    text = activity.time,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }

        // Status chip
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = when (activity.status) {
                "Under Review" -> MaterialTheme.colorScheme.tertiary.copy(alpha = 0.2f)
                "Completed" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                "Attended" -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        ) {
            Text(
                text = activity.status,
                style = MaterialTheme.typography.bodySmall,
                color = when (activity.status) {
                    "Under Review" -> MaterialTheme.colorScheme.tertiary
                    "Completed" -> MaterialTheme.colorScheme.primary
                    "Attended" -> MaterialTheme.colorScheme.secondary
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}