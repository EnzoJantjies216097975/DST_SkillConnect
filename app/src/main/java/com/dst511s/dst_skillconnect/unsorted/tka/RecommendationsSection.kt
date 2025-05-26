package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.dst511s.dst_skillconnect.unsorted.data.ProfileRecommendation

@Composable
fun RecommendationsSection(
    recommendations: List<ProfileRecommendation>,
    onRecommendationAction: (ProfileRecommendation) -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Recommendations",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            recommendations.forEach { recommendation ->
                RecommendationCard(
                    recommendation = recommendation,
                    onAction = { onRecommendationAction(recommendation) }
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
