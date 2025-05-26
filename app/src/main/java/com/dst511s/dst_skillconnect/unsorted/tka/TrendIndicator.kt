package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.dst511s.dst_skillconnect.unsorted.enume.SkillTrend

@Composable
fun TrendIndicator(trend: SkillTrend) {
    val (icon, color) = when (trend) {
        SkillTrend.IMPROVING -> "↗️" to Color.Green
        SkillTrend.STABLE -> "➡️" to Color.Gray
        SkillTrend.DECLINING -> "↘️" to Color.Red
        SkillTrend.NEW -> "🆕" to Color.Blue
    }

    Text(
        text = icon,
        style = MaterialTheme.typography.bodySmall
    )
}