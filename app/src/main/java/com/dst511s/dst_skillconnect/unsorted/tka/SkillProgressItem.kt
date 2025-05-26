package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.SkillProgressData
import com.dst511s.dst_skillconnect.unsorted.enume.SkillTrend
import com.dst511s.dst_skillconnect.unsorted.enume.VerificationStatus

@Composable
fun SkillProgressItem(skill: SkillProgressData) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = skill.skillName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Verification badge
                if (skill.verificationStatus == VerificationStatus.VERIFIED) {
                    Icon(
                        imageVector = Icons.Default.Verified,
                        contentDescription = "Verified",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                // Market demand indicator
                MarketDemandChip(demand = skill.marketDemand)
            }

            // Trend indicator
            TrendIndicator(trend = skill.trend)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = skill.currentLevel.name.lowercase().capitalize(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )

            Text(
                text = "${(skill.progressPercentage * 100).toInt()}%",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        LinearProgressIndicator(
            progress = { skill.progressPercentage },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = when (skill.trend) {
                SkillTrend.IMPROVING -> Color.Green
                SkillTrend.STABLE -> MaterialTheme.colorScheme.primary
                SkillTrend.DECLINING -> Color.Orange
                SkillTrend.NEW -> Color.Blue
            }
        )
    }
}