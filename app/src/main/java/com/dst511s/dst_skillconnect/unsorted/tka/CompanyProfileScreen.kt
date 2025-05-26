package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.Modifier
import com.dst511s.dst_skillconnect.unsorted.data.CompanyProfile
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyProfileScreen(
    companyId: String,
    onNavigateBack: () -> Unit,
    onJobClick: (String) -> Unit,
    onFollowToggle: () -> Unit
) {
    var company by remember { mutableStateOf<CompanyProfile?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableStateOf(0) }

    LaunchedEffect(companyId) {
        // Simulate loading
        delay(1000)
        company = generateMockCompanyProfile(companyId)
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(company?.name ?: "Company Profile") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    company?.let {
                        IconButton(onClick = { /* Share company profile */ }) {
                            Icon(Icons.Default.Share, contentDescription = "Share")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingCompanyProfile(modifier = Modifier.padding(paddingValues))
        } else {
            company?.let { companyProfile ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    // Company Header
                    item {
                        CompanyHeader(
                            company = companyProfile,
                            onFollowToggle = onFollowToggle
                        )
                    }

                    // Tab Navigation
                    item {
                        CompanyTabRow(
                            selectedTabIndex = selectedTab,
                            onTabSelected = { selectedTab = it }
                        )
                    }

                    // Tab Content
                    when (selectedTab) {
                        0 -> { // Overview
                            items(1) {
                                CompanyOverviewContent(company = companyProfile)
                            }
                        }
                        1 -> { // Jobs
                            items(companyProfile.openPositions) { job ->
                                CompanyJobCard(
                                    job = job,
                                    onClick = { onJobClick(job.id) }
                                )
                            }
                        }
                        2 -> { // Reviews
                            items(1) {
                                CompanyReviewsContent(reviews = companyProfile.reviews)
                            }
                        }
                        3 -> { // Culture
                            items(1) {
                                CompanyCultureContent(culture = companyProfile.workCulture)
                            }
                        }
                    }
                }
            }
        }
    }
}
