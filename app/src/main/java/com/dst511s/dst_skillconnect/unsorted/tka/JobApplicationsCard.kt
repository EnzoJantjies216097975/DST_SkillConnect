package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.JobApplicationAnalytics

@Composable
fun JobApplicationsCard(applicationsData: JobApplicationAnalytics) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Application Analytics",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Key metrics
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MetricColumn(
                    value = applicationsData.totalApplications.toString(),
                    label = "Total Applied"
                )

                MetricColumn(
                    value = "${applicationsData.responseRate.toInt()}%",
                    label = "Response Rate"
                )

                MetricColumn(
                    value = "${applicationsData.interviewRate.toInt()}%",
                    label = "Interview Rate"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Application funnel
            Text(
                text = "Application Funnel",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            ApplicationFunnelChart(applicationsData = applicationsData)

            Spacer(modifier = Modifier.height(16.dp))

            // Top industries
            Text(
                text = "Top Applied Industries",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            applicationsData.topAppliedIndustries.take(3).forEach { industry ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = industry.industry,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "${industry.applications} apps (${industry.successRate.toInt()}% success)",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}