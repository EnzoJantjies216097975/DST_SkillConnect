package com.dst511s.dst_skillconnect.unsorted

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayLesson
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.LearningModule
import com.dst511s.dst_skillconnect.unsorted.data.LearningPath
import com.dst511s.dst_skillconnect.unsorted.data.Lesson
import com.dst511s.dst_skillconnect.unsorted.enume.PriceType
import com.dst511s.dst_skillconnect.unsorted.tka.StatItem
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningPathDetailScreen(
    pathId: String,
    onNavigateBack: () -> Unit,
    onEnrollClick: () -> Unit,
    onStartLesstron: (String) -> Unit,
    onModuleClick: (String) -> Unit
) {
    var path by remember { mutableStateOf<LearningPath?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableStateOf(0) }

    LaunchedEffect(pathId) {
        delay(1000)
        path = generateMockLearningPath(pathId)
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(path?.title ?: "Learning Path") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Share path */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                }
            )
        },
        bottomBar = {
            path?.let { pathData ->
                if (!pathData.isEnrolled) {
                    BottomAppBar {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                if (pathData.price.type == PriceType.FREE) {
                                    Text(
                                        text = "Free",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                } else {
                                    Text(
                                        text = "${pathData.price.currency}${pathData.price.amount}",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold
                                    )

                                    pathData.price.originalPrice?.let { originalPrice ->
                                        Text(
                                            text = "${pathData.price.currency}$originalPrice",
                                            style = MaterialTheme.typography.bodyMedium,
                                            textDecoration = TextDecoration.LineThrough,
                                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                        )
                                    }
                                }
                            }

                            Button(
                                onClick = onEnrollClick,
                                modifier = Modifier.height(48.dp)
                            ) {
                                Text(
                                    if (pathData.price.type == PriceType.FREE) "Enroll Free" else "Enroll Now"
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingPathDetail(modifier = Modifier.padding(paddingValues))
        } else {
            path?.let { pathData ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    // Path header
                    item {
                        PathDetailHeader(path = pathData)
                    }

                    // Path stats
                    item {
                        PathStatsSection(path = pathData)
                    }

                    // Tab navigation
                    item {
                        PathDetailTabRow(
                            selectedTabIndex = selectedTab,
                            onTabSelected = { selectedTab = it }
                        )
                    }

                    // Tab content
                    when (selectedTab) {
                        0 -> { // Overview
                            item {
                                PathOverviewContent(path = pathData)
                            }
                        }
                        1 -> { // Curriculum
                            items(pathData.modules) { module ->
                                ModuleCard(
                                    module = module,
                                    onModuleClick = { onModuleClick(module.id) },
                                    onLessonClick = onStartLesstron
                                )
                            }
                        }
                        2 -> { // Reviews
                            item {
                                PathReviewsSection(path = pathData)
                            }
                        }
                        3 -> { // Author
                            item {
                                AuthorSection(author = pathData.author)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingPathDetail(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        Text("Loading path details...")
    }
}

@Composable
fun PathDetailHeader(path: LearningPath) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = path.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Target Role: ${path.targetRole}",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = path.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )

        if (path.isEnrolled && path.progress > 0) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Your Progress: ${(path.progress * 100).toInt()}%",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { path.progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun PathStatsSection(path: LearningPath) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem(
                value = path.totalLessons.toString(),
                label = "Lessons",
                icon = Icons.Default.PlayLesson
            )

            StatItem(
                value = path.estimatedDuration,
                label = "Duration",
                icon = Icons.Default.Schedule
            )

            StatItem(
                value = path.rating.toString(),
                label = "Rating",
                icon = Icons.Default.Star
            )

            StatItem(
                value = "${path.reviewCount}",
                label = "Reviews",
                icon = Icons.Default.RateReview
            )
        }
    }
}

@Composable
fun PathDetailTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf("Overview", "Curriculum", "Reviews", "Author")

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = { Text(title) }
            )
        }
    }
}

@Composable
fun PathOverviewContent(path: LearningPath) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Skills you'll learn
        Text(
            text = "Skills You'll Learn",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(path.skills) { skill ->
                AssistChip(
                    onClick = { },
                    label = { Text(skill) }
                )
            }
        }

        // Prerequisites
        if (path.prerequisites.isNotEmpty()) {
            Text(
                text = "Prerequisites",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            path.prerequisites.forEach { prerequisite ->
                Text(
                    text = "• $prerequisite",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            }
        }

        // Certificate info
        path.certificate?.let { certificate ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Certificate of Completion",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = certificate.title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = "Issued by ${certificate.issuer}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )

                    if (certificate.isAccredited) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "✓ Accredited Certificate",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ModuleCard(
    module: LearningModule,
    onModuleClick: () -> Unit,
    onLessonClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Module ${module.order}: ${module.title}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                if (module.isCompleted) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Completed",
                        tint = Color.Green,
                        modifier = Modifier.size(20.dp)
                    )
                } else if (!module.isUnlocked) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Locked",
                        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = module.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${module.lessons.size} lessons • ${module.estimatedTime} min",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Show lessons if module is expanded
            module.lessons.take(3).forEach { lesson ->
                LessonItem(
                    lesson = lesson,
                    onClick = { onLessonClick(lesson.id) }
                )
            }

            if (module.lessons.size > 3) {
                TextButton(
                    onClick = onModuleClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("View all ${module.lessons.size} lessons")
                }
            }
        }
    }
}

@Composable
fun LessonItem(
    lesson: Lesson,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = getLessonTypeIcon(lesson.type),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = if (lesson.isCompleted) Color.Green else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = lesson.title,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
            color = if (lesson.isCompleted) {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )

        Text(
            text = "${lesson.duration} min",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}