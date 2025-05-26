package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.dst511s.dst_skillconnect.unsorted.data.TrendingSkill

@Composable
fun TrendingSkillItem(skill: TrendingSkill) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = skill.skill,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "+${skill.growthRate.toInt()}%",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Green
            )

            Spacer(modifier = Modifier.width(8.dp))

            MarketDemandChip(demand = skill.demandLevel)
        }
    }
}
