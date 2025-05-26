package com.dst511s.dst_skillconnect.features.jobs.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.core.data.models.job.Job
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme
import com.dst511s.dst_skillconnect.common.components.cards.JobCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobsScreen(
    onJobClick: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val jobs = remember {
        listOf(
            Job(
                id = "1",
                title = "Junior Web Developer",
                company = "TechCorp Solutions",
                location = "Windhoek",
                jobType = "Full-time",
                matchPercentage = 85,
                companyLogoUrl = null,
                postedTimeAgo = "2 days ago",
                isNew = true
            ),
            Job(
                id = "2",
                title = "UI/UX Design Assistant",
                company = "Creative Designs Inc.",
                location = "Remote",
                jobType = "Contract",
                matchPercentage = 70,
                companyLogoUrl = null,
                postedTimeAgo = "1 week ago",
                isNew = false
            ),
            Job(
                id = "3",
                title = "IT Support Specialist",
                company = "National Bank of Namibia",
                location = "Windhoek",
                jobType = "Full-time",
                matchPercentage = 60,
                companyLogoUrl = null,
                postedTimeAgo = "3 days ago",
                isNew = false
            ),
            Job(
                id = "4",
                title = "Junior Mobile Developer",
                company = "AppWorks Tech",
                location = "Hybrid",
                jobType = "Full-time",
                matchPercentage = 78,
                companyLogoUrl = null,
                postedTimeAgo = "Just now",
                isNew = true
            ),
            Job(
                id = "5",
                title = "Data Entry Specialist",
                company = "Business Solutions Ltd",
                location = "Windhoek",
                jobType = "Part-time",
                matchPercentage = 55,
                companyLogoUrl = null,
                postedTimeAgo = "1 week ago",
                isNew = false
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Job Opportunities") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Open filters */ }) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filter"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search jobs, skills, companies...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(24.dp),
                singleLine = true
            )

            // Filter chips
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                SegmentedButton(
                    selected = true,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 0, count = 4),
                    label = { Text("All") }
                )

                SegmentedButton(
                    selected = false,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 1, count = 4),
                    label = { Text("Remote") }
                )

                SegmentedButton(
                    selected = false,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 2, count = 4),
                    label = { Text("Full-time") }
                )

                SegmentedButton(
                    selected = false,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 3, count = 4),
                    label = { Text("New") }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Job list
            LazyColumn {
                items(jobs) { job ->
                    JobCard(
                        job = job,
                        onClick = { onJobClick(job.id) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JobsScreenPreview() {
    DST_SkillConnectTheme {
        JobsScreen(
            onJobClick = {},
            onNavigateBack = {}
        )
    }
}