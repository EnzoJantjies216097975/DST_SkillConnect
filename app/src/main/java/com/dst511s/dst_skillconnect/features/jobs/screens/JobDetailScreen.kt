package com.dst511s.dst_skillconnect.features.jobs.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.core.data.models.job.JobDetail
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme
import com.dst511s.dst_skillconnect.features.jobs.components.JobHeader
import com.dst511s.dst_skillconnect.features.jobs.components.JobSection
import com.dst511s.dst_skillconnect.features.jobs.components.MatchPercentage
import com.dst511s.dst_skillconnect.features.jobs.components.SkillMatchChip
import com.dst511s.dst_skillconnect.common.components.layout.BulletList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDetailScreen(
    jobId: String,
    onNavigateBack: () -> Unit,
    onApplyClick: () -> Unit
) {
    // For prototype, we use hardcoded job data
    // In a real app, this would be fetched from a repository
    val job = remember {
        when (jobId) {
            "1" -> JobDetail(
                id = "1",
                title = "Junior Web Developer",
                company = "TechCorp Solutions",
                location = "Windhoek",
                jobType = "Full-time",
                matchPercentage = 85,
                companyLogoUrl = null,
                postedTimeAgo = "2 days ago",
                description = "We are looking for a passionate Junior Web Developer to join our growing team. You will be responsible for building and maintaining web applications, collaborating with the design team, and implementing responsive designs.",
                responsibilities = listOf(
                    "Develop and maintain web applications using HTML, CSS, and JavaScript",
                    "Collaborate with designers to implement responsive UI designs",
                    "Write clean, maintainable, and efficient code",
                    "Troubleshoot and fix bugs in existing applications",
                    "Participate in code reviews and team meetings"
                ),
                requirements = listOf(
                    "Proficiency in HTML, CSS, and JavaScript",
                    "Basic knowledge of React or similar frontend frameworks",
                    "Understanding of responsive design principles",
                    "Good problem-solving skills",
                    "Ability to work in a team environment"
                ),
                requiredSkills = listOf(
                    Pair("JavaScript", true),
                    Pair("HTML/CSS", true),
                    Pair("React", false),
                    Pair("Git", true),
                    Pair("Responsive Design", true)
                ),
                salary = "N$15,000 - N$20,000 monthly",
                benefits = listOf(
                    "Health insurance",
                    "Flexible working hours",
                    "Professional development opportunities",
                    "Casual dress code",
                    "Team building events"
                )
            )
            else -> JobDetail(
                id = jobId,
                title = "Unknown Job",
                company = "Unknown Company",
                location = "Unknown Location",
                jobType = "Unknown Type",
                matchPercentage = 0,
                companyLogoUrl = null,
                postedTimeAgo = "Unknown time",
                description = "Job details not found",
                responsibilities = emptyList(),
                requirements = emptyList(),
                requiredSkills = emptyList(),
                salary = "Unknown",
                benefits = emptyList()
            )
        }
    }

    var isJobSaved by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Job Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { isJobSaved = !isJobSaved }) {
                        Icon(
                            imageVector = if (isJobSaved) Icons.Default.Bookmark else Icons.Outlined.Bookmark,
                            contentDescription = if (isJobSaved) "Unsave Job" else "Save Job"
                        )
                    }
                    IconButton(onClick = { /* Share job */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = "Share"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {},
                floatingActionButton = {
                    Button(
                        onClick = onApplyClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .height(56.dp),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Text(
                            text = "Apply Now",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            // Job header
            item {
                JobHeader(job = job)
            }

            // Match percentage
            item {
                MatchPercentage(matchPercentage = job.matchPercentage)
            }

            // Description
            item {
                JobSection(title = "Description") {
                    Text(
                        text = job.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                }
            }

            // Responsibilities
            item {
                JobSection(title = "Responsibilities") {
                    BulletList(items = job.responsibilities)
                }
            }

            // Requirements
            item {
                JobSection(title = "Requirements") {
                    BulletList(items = job.requirements)
                }
            }

            // Required Skills
            item {
                JobSection(title = "Required Skills") {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        job.requiredSkills.take(3).forEach { (skill, isMatched) ->
                            SkillMatchChip(
                                skill = skill,
                                isMatched = isMatched
                            )
                        }
                    }

                    if (job.requiredSkills.size > 3) {
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            job.requiredSkills.drop(3).forEach { (skill, isMatched) ->
                                SkillMatchChip(
                                    skill = skill,
                                    isMatched = isMatched
                                )
                            }
                        }
                    }
                }
            }

            // Salary
            item {
                JobSection(title = "Salary") {
                    Text(
                        text = job.salary,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                }
            }

            // Benefits
            item {
                JobSection(title = "Benefits") {
                    BulletList(items = job.benefits)
                }
            }

            // Similar Jobs
            item {
                JobSection(title = "Similar Jobs") {
                    Text(
                        text = "Looking for more opportunities? Check out these similar positions.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // This would typically be a horizontal scrollable list of job cards
                    Text(
                        text = "More similar jobs will appear here",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Bottom padding for floating action button
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JobDetailScreenPreview() {
    DST_SkillConnectTheme {
        JobDetailScreen(
            jobId = "1",  // Sample job ID
            onNavigateBack = {},
            onApplyClick = {}
        )
    }
}