package com.dst511s.dst_skillconnect.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SkillsGapAnalysisScreen(
    jobId: String,
    userId: String,
    onNavigateBack: () -> Unit,
    onStartLearning: (String) -> Unit
) {
    var analysisState by remember { mutableStateOf<SkillGapAnalysis?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(jobId, userId) {
        // Simulate loading analysis
        delay(1500)
        analysisState = generateMockAnalysis()
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Skills Gap Analysis") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingAnalysisScreen(modifier = Modifier.padding(paddingValues))
        } else {
            analysisState?.let { analysis ->
                SkillsGapContent(
                    analysis = analysis,
                    onStartLearning = onStartLearning,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}