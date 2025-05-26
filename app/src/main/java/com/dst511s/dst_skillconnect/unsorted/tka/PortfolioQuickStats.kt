package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.PortfolioAnalytics

@Composable
fun PortfolioQuickStats(analytics: PortfolioAnalytics) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem(
                value = analytics.totalViews.toString(),
                label = "Views",
                icon = Icons.Default.Visibility
            )

            StatItem(
                value = analytics.uniqueVisitors.toString(),
                label = "Visitors",
                icon = Icons.Default.Person
            )

            StatItem(
                value = "${analytics.averageTimeOnSite / 60}m",
                label = "Avg. Time",
                icon = Icons.Default.Schedule
            )

            StatItem(
                value = analytics.downloadCount.toString(),
                label = "Downloads",
                icon = Icons.Default.Download
            )
        }
    }
}