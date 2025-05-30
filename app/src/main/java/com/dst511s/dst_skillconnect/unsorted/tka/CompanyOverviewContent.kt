package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.CompanyProfile

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CompanyOverviewContent(company: CompanyProfile) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // About Section
        Text(
            text = "About ${company.name}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = company.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )

        // Technologies
        if (company.technologies.isNotEmpty()) {
            Text(
                text = "Technologies We Use",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                company.technologies.forEach { tech ->
                    AssistChip(
                        onClick = { },
                        label = { Text(tech) }
                    )
                }
            }
        }

        // Benefits
        Text(
            text = "Benefits & Perks",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        company.benefits.groupBy { it.category }.forEach { (category, benefits) ->
            Text(
                text = category.name.replace("_", " ").lowercase()
                    .split(" ").joinToString(" ") { it.capitalize() },
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary
            )

            benefits.forEach { benefit ->
                BenefitItem(benefit = benefit)
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        // Locations
        if (company.locations.isNotEmpty()) {
            Text(
                text = "Our Locations",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            company.locations.forEach { location ->
                LocationItem(location = location)
            }
        }

        // Achievements
        if (company.achievements.isNotEmpty()) {
            Text(
                text = "Recent Achievements",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            company.achievements.forEach { achievement ->
                AchievementItem(achievement = achievement)
            }
        }
    }
}