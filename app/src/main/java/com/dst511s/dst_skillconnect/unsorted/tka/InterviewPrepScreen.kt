package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.InterviewPrep
import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterviewPrepScreen(
    onNavigateBack: () -> Unit,
    onStartPrep: (String) -> Unit,
    onViewTips: () -> Unit
) {
    var interviewPreps by remember { mutableStateOf<List<InterviewPrep>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedCategory by remember { mutableStateOf<InterviewCategory?>(null) }

    LaunchedEffect(Unit) {
        delay(1000)
        interviewPreps = generateMockInterviewPreps()
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Interview Preparation") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onViewTips) {
                        Icon(Icons.Default.Lightbulb, contentDescription = "Tips")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingInterviewPrep(modifier = Modifier.padding(paddingValues))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Progress Overview
                item {
                    InterviewProgressOverview(interviewPreps = interviewPreps)
                }

                // Category Filter
                item {
                    InterviewCategoryFilter(
                        selectedCategory = selectedCategory,
                        onCategorySelected = { selectedCategory = it }
                    )
                }

                // Quick Actions
                item {
                    QuickActionsCard(
                        onRandomPractice = { /* Start random practice */ },
                        onMockInterview = { /* Start mock interview */ },
                        onTipsAndTricks = onViewTips
                    )
                }

                // Interview Prep Sessions
                item {
                    Text(
                        text = "Practice Sessions",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                val filteredPreps = if (selectedCategory != null) {
                    interviewPreps.filter { it.categories.contains(selectedCategory) }
                } else {
                    interviewPreps
                }

                items(filteredPreps) { prep ->
                    InterviewPrepCard(
                        prep = prep,
                        onStartClick = { onStartPrep(prep.id) }
                    )
                }
            }
        }
    }
}