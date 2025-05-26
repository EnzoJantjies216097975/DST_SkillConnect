package com.dst511s.dst_skillconnect.features.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.common.components.layout.HomeSection
import com.dst511s.dst_skillconnect.unsorted.data.Activity
import com.dst511s.dst_skillconnect.core.data.models.job.Job
import com.dst511s.dst_skillconnect.features.home.components.ActivityItem
import com.dst511s.dst_skillconnect.features.home.components.HomeJobCard
import com.dst511s.dst_skillconnect.features.home.components.HomeWorkshopCard
import com.dst511s.dst_skillconnect.features.profile.components.SkillDevelopmentSection
import com.dst511s.dst_skillconnect.features.home.components.WelcomeSection
import com.dst511s.dst_skillconnect.unsorted.enume.ActivityType
import com.dst511s.dst_skillconnect.core.data.models.workshop.Workshop
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToJobs: () -> Unit,
    onNavigateToWorkshops: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("SkillConnect")
                },
                actions = {
                    IconButton(onClick = { /* Open notifications */ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                    IconButton(onClick = { /* Open search */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        },
        bottomBar = {
            // This is a placeholder - in a real app, you would use the actual NavController
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { /* Already on home */ }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home",
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Home",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    IconButton(onClick = onNavigateToJobs) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Work,
                                contentDescription = "Jobs"
                            )
                            Text(
                                text = "Jobs",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                    IconButton(onClick = onNavigateToWorkshops) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.School,
                                contentDescription = "Learn"
                            )
                            Text(
                                text = "Learn",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                    IconButton(onClick = { /* Navigate to messages */ }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Chat,
                                contentDescription = "Messages"
                            )
                            Text(
                                text = "Messages",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                    IconButton(onClick = onNavigateToProfile) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile"
                            )
                            Text(
                                text = "Profile",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Welcome section
            item {
                WelcomeSection(
                    userName = "Tendai",
                    profileProgress = 65
                )
            }

            // Job matches section
            item {
                HomeSection(
                    title = "Job Matches",
                    icon = Icons.Default.Work,
                    onViewAll = onNavigateToJobs
                ) {
                    JobMatchesRow()
                }
            }

            // Recommended workshops section
            item {
                HomeSection(
                    title = "Recommended Workshops",
                    icon = Icons.Default.School,
                    onViewAll = onNavigateToWorkshops
                ) {
                    WorkshopsRow()
                }
            }

            // Skill development section
            item {
                HomeSection(
                    title = "Skill Development",
                    icon = Icons.AutoMirrored.Filled.TrendingUp,
                    onViewAll = { /* Navigate to skills */ }
                ) {
                    SkillDevelopmentSection()
                }
            }

            // Recent activities section
            item {
                HomeSection(
                    title = "Recent Activities",
                    icon = Icons.Default.History,
                    onViewAll = { /* Navigate to activities */ }
                ) {
                    RecentActivitiesSection()
                }
            }

            // Bottom spacing
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

//@Composable
//fun WelcomeSection(
//    userName: String,
//    profileProgress: Int
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                // Profile picture
//                Box(
//                    modifier = Modifier
//                        .size(48.dp)
//                        .clip(CircleShape)
//                        .background(MaterialTheme.colorScheme.primary),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = userName.take(1),
//                        style = MaterialTheme.typography.titleLarge,
//                        color = Color.White
//                    )
//                }
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//                Column {
//                    Text(
//                        text = "Welcome back,",
//                        style = MaterialTheme.typography.bodyMedium,
//                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
//                    )
//
//                    Text(
//                        text = userName,
//                        style = MaterialTheme.typography.headlineSmall,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Profile completion
//            Column {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = "Profile Completion",
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//
//                    Text(
//                        text = "$profileProgress%",
//                        style = MaterialTheme.typography.bodyMedium,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                LinearProgressIndicator(
//                    progress = { profileProgress / 100f },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(8.dp)
//                        .clip(RoundedCornerShape(4.dp)),
//                    color = MaterialTheme.colorScheme.primary,
//                    trackColor = MaterialTheme.colorScheme.surfaceVariant
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Text(
//                    text = "Complete your profile to increase your visibility to employers",
//                    style = MaterialTheme.typography.bodySmall,
//                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
//                )
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Quick actions
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                QuickActionButton(
//                    icon = Icons.Default.Search,
//                    label = "Find Jobs",
//                    onClick = { /* Navigate to jobs */ }
//                )
//
//                QuickActionButton(
//                    icon = Icons.Default.Add,
//                    label = "Add Skills",
//                    onClick = { /* Navigate to skills */ }
//                )
//
//                QuickActionButton(
//                    icon = Icons.Default.School,
//                    label = "Workshops",
//                    onClick = { /* Navigate to workshops */ }
//                )
//            }
//        }
//    }
//}

@Composable
fun WorkshopsRow() {
    val workshops = remember {
        listOf(
            Workshop(
                id = "1",
                title = "Advanced JavaScript Workshop",
                description = "Learn modern JS techniques and frameworks",
                date = "May 15, 2025",
                time = "10:00 AM - 12:00 PM",
                location = "Online",
                isOnline = true,
                icon = Icons.Default.Code,
                iconBackgroundColor = Color(0xFF3866F2),
                isRegistered = false
            ),
            Workshop(
                id = "2",
                title = "Resume Building Masterclass",
                description = "Create a standout CV for the digital age",
                date = "May 20, 2025",
                time = "2:00 PM - 4:00 PM",
                location = "Windhoek Innovation Hub",
                isOnline = false,
                icon = Icons.Default.Description,
                iconBackgroundColor = Color(0xFF9C27B0),
                isRegistered = true
            ),
            Workshop(
                id = "3",
                title = "Tech Interview Preparation",
                description = "Practice common interview questions and scenarios",
                date = "June 5, 2025",
                time = "3:00 PM - 5:00 PM",
                location = "Online",
                isOnline = true,
                icon = Icons.Default.People,
                iconBackgroundColor = Color(0xFF4CAF50),
                isRegistered = false
            )
        )
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(workshops) { workshop ->
            HomeWorkshopCard(workshop = workshop)
        }
    }
}

@Composable
fun JobMatchesRow() {
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
            )
        )
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(jobs) { job ->
            HomeJobCard(job = job)
        }
    }
}

@Composable
fun RecentActivitiesSection() {
    val activities = remember {
        listOf(
            Activity(
                title = "Applied for Junior Web Developer",
                company = "TechCorp Solutions",
                time = "2 days ago",
                type = ActivityType.APPLICATION,
                status = "Under Review"
            ),
            Activity(
                title = "JavaScript Skill Assessment",
                company = "SkillConnect",
                time = "1 week ago",
                type = ActivityType.ASSESSMENT,
                status = "Completed"
            ),
            Activity(
                title = "Resume Building Workshop",
                company = "Career Services",
                time = "2 weeks ago",
                type = ActivityType.WORKSHOP,
                status = "Attended"
            )
        )
    }

    Column {
        activities.forEach { activity ->
            ActivityItem(activity = activity)
            if (activities.indexOf(activity) < activities.size - 1) {
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DST_SkillConnectTheme {
        HomeScreen(
            onNavigateToJobs = {},
            onNavigateToWorkshops = {},
            onNavigateToProfile = {}
        )
    }
}