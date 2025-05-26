package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.SkillGapAnalysis

@Composable
fun LoadingAnalysisScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            strokeWidth = 6.dp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Analyzing your skills...",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "This may take a moment",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

@Composable
fun SkillsGapContent(
    analysis: SkillGapAnalysis,
    onStartLearning: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Job Header
        item {
            JobAnalysisHeader(
                jobTitle = analysis.jobTitle,
                company = analysis.company,
                matchPercentage = analysis.overallMatchPercentage
            )
        }

        // Skills Overview
        item {
            SkillsOverviewCard(
                totalRequired = analysis.requiredSkills.size,
                matching = analysis.matchingSkills.size,
                missing = analysis.missingSkills.size
            )
        }

        // Matching Skills
        if (analysis.matchingSkills.isNotEmpty()) {
            item {
                Text(
                    text = "Your Matching Skills",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            items(analysis.matchingSkills) { skill ->
                MatchingSkillCard(skill = skill)
            }
        }

        // Missing Skills
        if (analysis.missingSkills.isNotEmpty()) {
            item {
                Text(
                    text = "Skills to Develop",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            items(analysis.missingSkills) { skill ->
                MissingSkillCard(
                    skill = skill,
                    recommendation = analysis.recommendations.find { it.skill == skill.name }
                )
            }
        }

        // Learning Recommendations
        item {
            Text(
                text = "Recommended Learning Path",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        items(analysis.recommendations) { recommendation ->
            LearningRecommendationCard(
                recommendation = recommendation,
                onStartLearning = onStartLearning
            )
        }
    }
}

@Composable
fun JobAnalysisHeader(
    jobTitle: String,
    company: String,
    matchPercentage: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = jobTitle,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = company,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Skills Match",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "$matchPercentage%",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = when {
                        matchPercentage >= 80 -> Color(0xFF4CAF50)
                        matchPercentage >= 60 -> Color(0xFFFF9800)
                        else -> Color(0xFFF44336)
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { matchPercentage / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = when {
                    matchPercentage >= 80 -> Color(0xFF4CAF50)
                    matchPercentage >= 60 -> Color(0xFFFF9800)
                    else -> Color(0xFFF44336)
                }
            )
        }
    }
}