package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.Portfolio
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(
    userId: String,
    onNavigateBack: () -> Unit,
    onEditPortfolio: () -> Unit,
    onProjectClick: (String) -> Unit,
    onSharePortfolio: () -> Unit
) {
    var portfolio by remember { mutableStateOf<Portfolio?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableStateOf(0) }

    LaunchedEffect(userId) {
        delay(1000)
        portfolio = generateMockPortfolio(userId)
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Portfolio") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onSharePortfolio) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                    IconButton(onClick = onEditPortfolio) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingPortfolio(modifier = Modifier.padding(paddingValues))
        } else {
            portfolio?.let { portfolioData ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    // Portfolio Header
                    item {
                        PortfolioHeader(
                            portfolio = portfolioData,
                            onEditClick = onEditPortfolio
                        )
                    }

                    // Quick Stats
                    item {
                        PortfolioQuickStats(analytics = portfolioData.analytics)
                    }

                    // Tab Navigation
                    item {
                        PortfolioTabRow(
                            selectedTabIndex = selectedTab,
                            onTabSelected = { selectedTab = it }
                        )
                    }

                    // Tab Content
                    when (selectedTab) {
                        0 -> { // Projects
                            item {
                                FeaturedProjectsSection(
                                    projects = portfolioData.projects.filter { it.featured },
                                    onProjectClick = onProjectClick
                                )
                            }

                            items(portfolioData.projects.sortedByDescending { it.dateCompleted }) { project ->
                                ProjectShowcaseCard(
                                    project = project,
                                    onClick = { onProjectClick(project.id) }
                                )
                            }
                        }
                        1 -> { // Skills
                            items(portfolioData.skills) { skill ->
                                SkillShowcaseCard(skill = skill)
                            }
                        }
                        2 -> { // Testimonials
                            items(portfolioData.testimonials) { testimonial ->
                                TestimonialCard(testimonial = testimonial)
                            }
                        }
                        3 -> { // Analytics
                            item {
                                PortfolioAnalyticsSection(analytics = portfolioData.analytics)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingPortfolio(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        Text("Loading your portfolio...")
    }
}