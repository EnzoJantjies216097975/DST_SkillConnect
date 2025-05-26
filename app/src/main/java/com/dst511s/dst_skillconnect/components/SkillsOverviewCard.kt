package com.dst511s.dst_skillconnect.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun SkillsOverviewCard(
    totalRequired: Int,
    matching: Int,
    missing: Int
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SkillMetric(
                value = matching,
                label = "Matching",
                color = Color(0xFF4CAF50),
                icon = Icons.Default.CheckCircle
            )

            SkillMetric(
                value = missing,
                label = "Missing",
                color = Color(0xFFF44336),
                icon = Icons.Default.Cancel
            )

            SkillMetric(
                value = totalRequired,
                label = "Total Required",
                color = MaterialTheme.colorScheme.primary,
                icon = Icons.Default.Timeline
            )
        }
    }
}