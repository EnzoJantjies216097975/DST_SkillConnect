package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.ProfileViewsData

@Composable
fun ProfileViewsChart(viewsData: ProfileViewsData) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Profile Views Trend",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Simple chart representation
            viewsData.dailyViews.takeLast(7).forEach { dayData ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = dayData.date,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.width(60.dp)
                    )

                    LinearProgressIndicator(
                        progress = { (dayData.views / 50f).coerceAtMost(1f) },
                        modifier = Modifier
                            .weight(1f)
                            .height(8.dp)
                            .padding(horizontal = 8.dp),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = dayData.views.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.width(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // View sources
            Text(
                text = "Top Viewing Sources",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            viewsData.topViewingSources.forEach { source ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = source.source,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "${source.views} (${source.percentage.toInt()}%)",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}