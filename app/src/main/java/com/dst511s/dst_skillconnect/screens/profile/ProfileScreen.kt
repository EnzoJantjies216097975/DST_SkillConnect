package com.dst511s.dst_skillconnect.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.components.ExperienceContent
import com.dst511s.dst_skillconnect.components.ProfileHeader
import com.dst511s.dst_skillconnect.components.ProfileSection
import com.dst511s.dst_skillconnect.components.ProjectsContent
import com.dst511s.dst_skillconnect.components.RecommendationItem
import com.dst511s.dst_skillconnect.components.SkillsContent
import com.dst511s.dst_skillconnect.data.models.Experience
import com.dst511s.dst_skillconnect.data.models.Project
import com.dst511s.dst_skillconnect.data.models.Skill

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onNavigateBack: () -> Unit,
    onSkillAssessmentClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Open settings */ }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Header
            item {
                ProfileHeader(
                    name = "Tendai Moyo",
                    title = "Computer Science Graduate",
                    location = "Windhoek, Namibia",
                    profileImageUrl = null,
                    profileCompletion = 65
                )
            }

            // Skills Section
            item {
                ProfileSection(
                    title = "Skills",
                    actionIcon = Icons.Outlined.Add,
                    onActionClick = { /* Add skill */ }
                ) {
                    SkillsContent(
                        skills = listOf(
                            Skill("JavaScript", "Intermediate", true),
                            Skill("HTML/CSS", "Advanced", false),
                            Skill("Python", "Intermediate", false),
                            Skill("React", "Beginner", false),
                            Skill("UI/UX Design", "Intermediate", false)
                        ),
                        onSkillClick = { skill ->
                            if (!skill.isVerified) {
                                onSkillAssessmentClick(skill.name)
                            }
                        }
                    )
                }
            }

            // Experience Section
            item {
                ProfileSection(
                    title = "Experience",
                    actionIcon = Icons.Outlined.Add,
                    onActionClick = { /* Add experience */ }
                ) {
                    ExperienceContent(
                        experiences = listOf(
                            Experience(
                                role = "Web Development Intern",
                                company = "TechStartup Namibia",
                                period = "Jan 2024 - Mar 2024",
                                isCurrentRole = false
                            ),
                            Experience(
                                role = "Volunteer IT Support",
                                company = "Community Center",
                                period = "Oct 2023 - Dec 2023",
                                isCurrentRole = false
                            )
                        )
                    )
                }
            }

            // Projects Section
            item {
                ProfileSection(
                    title = "Projects",
                    actionIcon = Icons.Outlined.Add,
                    onActionClick = { /* Add project */ }
                ) {
                    ProjectsContent(
                        projects = listOf(
                            Project(
                                title = "E-commerce Website",
                                description = "Built a responsive e-commerce site with JavaScript, HTML and CSS",
                                imageUrl = null
                            ),
                            Project(
                                title = "Weather Data Visualization",
                                description = "Created interactive weather data visualizations using Python",
                                imageUrl = null
                            )
                        )
                    )
                }
            }

            // Recommendations Section
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Recommendations",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        RecommendationItem(
                            icon = Icons.Default.School,
                            title = "Verify JavaScript Skills",
                            description = "Take a quick assessment to verify your JavaScript skills and stand out to employers.",
                            actionText = "Take Assessment",
                            onClick = { onSkillAssessmentClick("JavaScript") }
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        RecommendationItem(
                            icon = Icons.Default.Book,
                            title = "React Workshop",
                            description = "Join an upcoming React workshop to improve your front-end development skills.",
                            actionText = "View Details",
                            onClick = { /* Navigate to workshop */ }
                        )
                    }
                }
            }

            // Bottom spacing
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}