package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.dst511s.dst_skillconnect.unsorted.data.ProfileAnalytics

@Composable
fun ProfilePerformanceCard(analytics: ProfileAnalytics) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Profile Performance",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                PerformanceMetric(
                    value = analytics.profileViews.totalViews.toString(),
                    label = "Total Views",
                    trend = if (analytics.profileViews.viewsThisWeek > analytics.profileViews.viewsLastWeek) "↑" else "↓",
                    trendColor = if (analytics.profileViews.viewsThisWeek > analytics.profileViews.viewsLastWeek) Color.Green else Color.Red
                )

                PerformanceMetric(
                    value = "${analytics.jobApplications.responseRate.toInt()}%",
                    label = "Response Rate",
                    trend = "↑",
                    trendColor = Color.Green
                )

                PerformanceMetric(
                    value = "${analytics.profileCompletion.overallCompletion}%",
                    label = "Profile Complete",
                    trend = "",
                    trendColor = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}