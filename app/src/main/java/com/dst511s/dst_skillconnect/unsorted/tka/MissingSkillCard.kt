package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.material.icons.Icons
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.SkillRecommendation
import com.dst511s.dst_skillconnect.unsorted.data.SkillRequirement
import com.dst511s.dst_skillconnect.unsorted.enume.SkillImportance

@Composable
fun MissingSkillCard(
    skill: SkillRequirement,
    recommendation: SkillRecommendation?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when (skill.importance) {
                SkillImportance.ESSENTIAL -> Color(0xFFF44336).copy(alpha = 0.1f)
                SkillImportance.PREFERRED -> Color(0xFFFF9800).copy(alpha = 0.1f)
                SkillImportance.NICE_TO_HAVE -> Color(0xFF9E9E9E).copy(alpha = 0.1f)
            }
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = when (skill.importance) {
                        SkillImportance.ESSENTIAL -> Icons.Default.PriorityHigh
                        SkillImportance.PREFERRED -> Icons.Default.Star
                        SkillImportance.NICE_TO_HAVE -> Icons.Default.StarBorder
                    },
                    contentDescription = null,
                    tint = when (skill.importance) {
                        SkillImportance.ESSENTIAL -> Color(0xFFF44336)
                        SkillImportance.PREFERRED -> Color(0xFFFF9800)
                        SkillImportance.NICE_TO_HAVE -> Color(0xFF9E9E9E)
                    },
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = skill.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row {
                        Text(
                            text = "${skill.level.name.lowercase().capitalize()} • ",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )

                        Text(
                            text = skill.importance.name.replace("_", " ").lowercase().capitalize(),
                            style = MaterialTheme.typography.bodyMedium,
                            color = when (skill.importance) {
                                SkillImportance.ESSENTIAL -> Color(0xFFF44336)
                                SkillImportance.PREFERRED -> Color(0xFFFF9800)
                                SkillImportance.NICE_TO_HAVE -> Color(0xFF9E9E9E)
                            },
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            recommendation?.let { rec ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Estimated learning time: ${rec.estimatedTimeToLearn}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}