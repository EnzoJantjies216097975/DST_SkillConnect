package com.dst511s.dst_skillconnect.components

@Composable
fun LearningRecommendationCard(
    recommendation: SkillRecommendation,
    onStartLearning: (String) -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = recommendation.skill,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Target: ${recommendation.targetLevel.name.lowercase().capitalize()}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )

                    Text(
                        text = recommendation.estimatedTimeToLearn,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Button(
                    onClick = { onStartLearning(recommendation.skill) },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("Start Learning")
                }
            }

            if (recommendation.learningResources.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Recommended Resources:",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                recommendation.learningResources.take(2).forEach { resource ->
                    LearningResourceItem(resource = resource)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}