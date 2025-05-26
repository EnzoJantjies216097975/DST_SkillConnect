package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.JobApplicationAnalytics

@Composable
fun ApplicationFunnelChart(applicationsData: JobApplicationAnalytics) {
    val steps = listOf(
        "Applied" to applicationsData.totalApplications,
        "Viewed" to (applicationsData.totalApplications * applicationsData.responseRate / 100).toInt(),
        "Interview" to (applicationsData.totalApplications * applicationsData.interviewRate / 100).toInt(),
        "Offer" to (applicationsData.totalApplications * applicationsData.offerRate / 100).toInt()
    )

    Column {
        steps.forEachIndexed { index, (step, count) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = step,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.width(80.dp)
                )

                LinearProgressIndicator(
                    progress = { (count.toFloat() / applicationsData.totalApplications) },
                    modifier = Modifier
                        .weight(1f)
                        .height(12.dp)
                        .padding(horizontal = 8.dp),
                    color = when (index) {
                        0 -> Color(0xFF2196F3)
                        1 -> Color(0xFF4CAF50)
                        2 -> Color(0xFFFF9800)
                        3 -> Color(0xFF9C27B0)
                        else -> MaterialTheme.colorScheme.primary
                    }
                )

                Text(
                    text = count.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.width(40.dp)
                )
            }

            if (index < steps.size - 1) {
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}