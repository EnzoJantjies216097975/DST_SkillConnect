package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PerformanceMetric(
    value: String,
    label: String,
    trend: String,
    trendColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            if (trend.isNotEmpty()) {
                Text(
                    text = trend,
                    style = MaterialTheme.typography.titleMedium,
                    color = trendColor,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}
