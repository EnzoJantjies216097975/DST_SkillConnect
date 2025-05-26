package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.ProfileAnalytics
import com.dst511s.dst_skillconnect.unsorted.data.ProfileRecommendation
import com.dst511s.dst_skillconnect.unsorted.enume.TimeRange

@Composable
fun AnalyticsDashboardContent(
    analytics: ProfileAnalytics,
    selectedTimeRange: TimeRange,
    onTimeRangeChange: (TimeRange) -> Unit,
    onRecommendationAction: (ProfileRecommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Time Range Selector
        item {
            TimeRangeSelector(
                selectedRange = selectedTimeRange,
                onRangeSelected = onTimeRangeChange
            )
        }

        // Profile Performance Overview
        item {
            ProfilePerformanceCard(analytics = analytics)
        }

        // Profile Views Chart
        item {
            ProfileViewsChart(viewsData = analytics.profileViews)
        }

        // Skills Progress Section
        item {
            SkillsProgressSection(skillsData = analytics.skillProgress)
        }

        // Job Applications Analytics
        item {
            JobApplicationsCard(applicationsData = analytics.jobApplications)
        }

        // Market Insights
        item {
            MarketInsightsCard(marketData = analytics.marketInsights)
        }

        // Profile Completion
        item {
            ProfileCompletionCard(completionData = analytics.profileCompletion)
        }

        // Recommendations
        item {
            RecommendationsSection(
                recommendations = analytics.recommendations,
                onRecommendationAction = onRecommendationAction
            )
        }
    }
}