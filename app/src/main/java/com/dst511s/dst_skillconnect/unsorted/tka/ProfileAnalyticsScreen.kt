package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.dst511s.dst_skillconnect.unsorted.data.ProfileAnalytics
import com.dst511s.dst_skillconnect.unsorted.data.ProfileRecommendation
import com.dst511s.dst_skillconnect.unsorted.enume.TimeRange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileAnalyticsScreen(
    userId: String,
    onNavigateBack: () -> Unit,
    onRecommendationAction: (ProfileRecommendation) -> Unit
) {
    var analytics by remember { mutableStateOf<ProfileAnalytics?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedTimeRange by remember { mutableStateOf(TimeRange.LAST_30_DAYS) }

    LaunchedEffect(userId, selectedTimeRange) {
        isLoading = true
        delay(1500) // Simulate loading
        analytics = generateMockAnalytics()
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile Analytics") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Export analytics */ }) {
                        Icon(Icons.Default.FileDownload, contentDescription = "Export")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingAnalyticsScreen(modifier = Modifier.padding(paddingValues))
        } else {
            analytics?.let { data ->
                AnalyticsDashboardContent(
                    analytics = data,
                    selectedTimeRange = selectedTimeRange,
                    onTimeRangeChange = { selectedTimeRange = it },
                    onRecommendationAction = onRecommendationAction,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}