package com.dst511s.dst_skillconnect.unsorted

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.LearningPath
import com.dst511s.dst_skillconnect.unsorted.enume.LearningCategory
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningPathsScreen(
    onNavigateBack: () -> Unit,
    onPathClick: (String) -> Unit,
    onCreateCustomPath: () -> Unit
) {
    var learningPaths by remember { mutableStateOf<List<LearningPath>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedCategory by remember { mutableStateOf<LearningCategory?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var showFilters by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        learningPaths = generateMockLearningPaths()
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Learning Paths") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showFilters = true }) {
                        Icon(Icons.Default.FilterList, contentDescription = "Filters")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onCreateCustomPath,
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Create Custom Path")
            }
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingLearningPaths(modifier = Modifier.padding(paddingValues))
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Search and Filter
                LearningPathSearchAndFilter(
                    searchQuery = searchQuery,
                    onSearchQueryChange = { searchQuery = it },
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )

                // My Learning Progress
                MyLearningProgressSection(
                    enrolledPaths = learningPaths.filter { it.isEnrolled },
                    onPathClick = onPathClick
                )

                // Recommended Paths
                RecommendedPathsSection(
                    paths = learningPaths.filter { !it.isEnrolled }.take(3),
                    onPathClick = onPathClick
                )

                // All Paths
                val filteredPaths = filterLearningPaths(learningPaths, searchQuery, selectedCategory)

                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Text(
                            text = "All Learning Paths",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    items(filteredPaths) { path ->
                        LearningPathCard(
                            path = path,
                            onClick = { onPathClick(path.id) }
                        )
                    }
                }
            }
        }
    }

    // Filters Bottom Sheet
    if (showFilters) {
        LearningPathFiltersBottomSheet(
            onDismiss = { showFilters = false }
        )
    }
}

