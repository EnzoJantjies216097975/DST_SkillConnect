package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.CareerGoal
import com.dst511s.dst_skillconnect.unsorted.CareerInsight
import com.dst511s.dst_skillconnect.unsorted.CareerMilestone
import com.dst511s.dst_skillconnect.unsorted.CareerPhase
import com.dst511s.dst_skillconnect.unsorted.CareerRoadmap
import com.dst511s.dst_skillconnect.unsorted.GapSize
import com.dst511s.dst_skillconnect.unsorted.GoalCategory
import com.dst511s.dst_skillconnect.unsorted.InsightPriority
import com.dst511s.dst_skillconnect.unsorted.InsightType
import com.dst511s.dst_skillconnect.unsorted.MilestoneCategory
import com.dst511s.dst_skillconnect.unsorted.MilestonePriority
import com.dst511s.dst_skillconnect.unsorted.RoadmapProgress
import com.dst511s.dst_skillconnect.unsorted.SkillGap
import com.dst511s.dst_skillconnect.unsorted.SkillPriority
import com.dst511s.dst_skillconnect.unsorted.SkillTarget
import com.dst511s.dst_skillconnect.unsorted.SkillsRoadmap
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CareerRoadmapScreen(
    userId: String,
    onNavigateBack: () -> Unit,
    onCreateRoadmap: () -> Unit,
    onGoalClick: (String) -> Unit,
    onMilestoneClick: (String) -> Unit
) {
    var roadmap by remember { mutableStateOf<CareerRoadmap?>(null) }
    var insights by remember { mutableStateOf<List<CareerInsight>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableStateOf(0) }

    LaunchedEffect(userId) {
        delay(1000)
        roadmap = generateMockCareerRoadmap(userId)
        insights = generateMockInsights()
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Career Roadmap") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Settings */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            if (roadmap == null) {
                FloatingActionButton(
                    onClick = onCreateRoadmap,
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Create Roadmap")
                }
            }
        }
    ) { paddingValues ->
        if (isLoading) {
            LoadingRoadmap(modifier = Modifier.padding(paddingValues))
        } else if (roadmap == null) {
            EmptyRoadmapState(
                onCreateRoadmap = onCreateRoadmap,
                modifier = Modifier.padding(paddingValues)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Roadmap header
                item {
                    RoadmapHeader(roadmap = roadmap!!)
                }

                // Progress overview
                item {
                    ProgressOverviewCard(progress = roadmap!!.progress)
                }

                // Insights section
                if (insights.isNotEmpty()) {
                    item {
                        InsightsSection(insights = insights.take(3))
                    }
                }

                // Tab navigation
                item {
                    RoadmapTabRow(
                        selectedTabIndex = selectedTab,
                        onTabSelected = { selectedTab = it }
                    )
                }

                // Tab content
                when (selectedTab) {
                    0 -> { // Timeline
                        items(roadmap!!.timeline.phases) { phase ->
                            PhaseCard(phase = phase)
                        }
                    }
                    1 -> { // Goals
                        items(roadmap!!.goals) { goal ->
                            GoalCard(
                                goal = goal,
                                onClick = { onGoalClick(goal.id) }
                            )
                        }
                    }
                    2 -> { // Skills
                        item {
                            SkillsRoadmapSection(skillsRoadmap = roadmap!!.skills)
                        }
                    }
                    3 -> { // Milestones
                        items(roadmap!!.milestones) { milestone ->
                            MilestoneCard(
                                milestone = milestone,
                                onClick = { onMilestoneClick(milestone.id) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingRoadmap(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        Text("Loading your career roadmap...")
    }
}

@Composable
fun EmptyRoadmapState(
    onCreateRoadmap: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Map,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Create Your Career Roadmap",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Plan your career journey with personalized milestones, goals, and skill development paths.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onCreateRoadmap,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Create Roadmap")
        }
    }
}

@Composable
fun RoadmapHeader(roadmap: CareerRoadmap) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = roadmap.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "From:",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                    Text(
                        text = roadmap.currentRole,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "To:",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                    Text(
                        text = roadmap.targetRole,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Timeline: ${roadmap.timeline.estimatedDuration} months",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "${(roadmap.progress.overallProgress * 100).toInt()}% Complete",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { roadmap.progress.overallProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun ProgressOverviewCard(progress: RoadmapProgress) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Progress Overview",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ProgressMetric(
                    value = "${progress.milestonesCompleted}/${progress.totalMilestones}",
                    label = "Milestones",
                    icon = Icons.Default.Flag,
                    progress = progress.milestonesCompleted.toFloat() / progress.totalMilestones
                )

                ProgressMetric(
                    value = "${progress.goalsCompleted}/${progress.totalGoals}",
                    label = "Goals",
                    icon = Icons.AutoMirrored.Filled.Target,
                    progress = progress.goalsCompleted.toFloat() / progress.totalGoals
                )

                ProgressMetric(
                    value = "${(progress.skillsProgress * 100).toInt()}%",
                    label = "Skills",
                    icon = Icons.Default.TrendingUp,
                    progress = progress.skillsProgress
                )
            }
        }
    }
}

@Composable
fun ProgressMetric(
    value: String,
    label: String,
    icon: ImageVector,
    progress: Float
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(48.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 4.dp
            )

            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

@Composable
fun InsightsSection(insights: List<CareerInsight>) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Career Insights",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            TextButton(onClick = { /* View all insights */ }) {
                Text("View All")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        insights.forEach { insight ->
            InsightCard(insight = insight)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun InsightCard(insight: CareerInsight) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = when (insight.priority) {
                InsightPriority.URGENT -> MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
                InsightPriority.HIGH -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = getInsightIcon(insight.type),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = when (insight.priority) {
                    InsightPriority.URGENT -> MaterialTheme.colorScheme.error
                    InsightPriority.HIGH -> MaterialTheme.colorScheme.primary
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = insight.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = insight.message,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            }

            if (insight.actionable) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun RoadmapTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf("Timeline", "Goals", "Skills", "Milestones")

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
fun PhaseCard(phase: CareerPhase) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (phase.isCompleted) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        )
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
                    text = "Phase ${phase.order}: ${phase.title}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                if (phase.isCompleted) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Completed",
                        tint = Color.Green,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = phase.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Duration: ${phase.duration} months",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            if (phase.objectives.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Key Objectives:",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )

                phase.objectives.take(3).forEach { objective ->
                    Text(
                        text = "• $objective",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 8.dp),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                }
            }
        }
    }
}

@Composable
fun GoalCard(
    goal: CareerGoal,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() }
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
                    text = goal.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                GoalCategoryChip(category = goal.category)
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = goal.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Progress bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Progress",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )

                Text(
                    text = "${(goal.progress * 100).toInt()}%",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            LinearProgressIndicator(
                progress = { goal.progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Target date
            Text(
                text = "Target: ${SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(goal.targetDate))}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            // Sub-goals completion
            if (goal.subGoals.isNotEmpty()) {
                val completedSubGoals = goal.subGoals.count { it.isCompleted }
                Text(
                    text = "$completedSubGoals of ${goal.subGoals.size} sub-goals completed",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
fun GoalCategoryChip(category: GoalCategory) {
    val (color, text) = when (category) {
        GoalCategory.SKILL_DEVELOPMENT -> Color(0xFF4CAF50) to "Skills"
        GoalCategory.CAREER_ADVANCEMENT -> Color(0xFF2196F3) to "Career"
        GoalCategory.SALARY_INCREASE -> Color(0xFFFF9800) to "Salary"
        GoalCategory.NETWORKING -> Color(0xFF9C27B0) to "Network"
        GoalCategory.EDUCATION -> Color(0xFF795548) to "Education"
        GoalCategory.SIDE_PROJECT -> Color(0xFF607D8B) to "Project"
        GoalCategory.PERSONAL_BRAND -> Color(0xFFF44336) to "Brand"
    }

    AssistChip(
        onClick = { },
        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                color = color
            )
        },
        border = AssistChipDefaults.assistChipBorder(borderColor = color),
        modifier = Modifier.height(24.dp)
    )
}

@Composable
fun SkillsRoadmapSection(skillsRoadmap: SkillsRoadmap) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Skills progress
        Text(
            text = "Skill Development Progress",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        skillsRoadmap.targetSkills.forEach { skillTarget ->
            SkillTargetCard(skillTarget = skillTarget)
        }

        // Skill gaps
        if (skillsRoadmap.skillGaps.isNotEmpty()) {
            Text(
                text = "Skill Gaps to Address",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            skillsRoadmap.skillGaps.take(3).forEach { gap ->
                SkillGapCard(skillGap = gap)
            }
        }
    }
}

@Composable
fun SkillTargetCard(skillTarget: SkillTarget) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = skillTarget.skillName,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )

                SkillPriorityChip(priority = skillTarget.priority)
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${skillTarget.currentLevel.name} → ${skillTarget.targetLevel.name}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )

                Text(
                    text = "${skillTarget.estimatedTimeToAchieve} months",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { skillTarget.progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = when (skillTarget.priority) {
                    SkillPriority.ESSENTIAL -> Color(0xFFF44336)
                    SkillPriority.IMPORTANT -> Color(0xFFFF9800)
                    SkillPriority.NICE_TO_HAVE -> Color(0xFF4CAF50)
                }
            )
        }
    }
}

@Composable
fun SkillPriorityChip(priority: SkillPriority) {
    val (color, text) = when (priority) {
        SkillPriority.ESSENTIAL -> Color(0xFFF44336) to "Essential"
        SkillPriority.IMPORTANT -> Color(0xFFFF9800) to "Important"
        SkillPriority.NICE_TO_HAVE -> Color(0xFF4CAF50) to "Nice to Have"
    }

    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = color,
        modifier = Modifier
            .background(
                color.copy(alpha = 0.1f),
                RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}

@Composable
fun SkillGapCard(skillGap: SkillGap) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = when (skillGap.gapSize) {
                GapSize.CRITICAL -> MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
                GapSize.LARGE -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = skillGap.skillName,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )

                GapSizeChip(gapSize = skillGap.gapSize)
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Required: ${skillGap.requiredLevel.name}${skillGap.currentLevel?.let { " | Current: ${it.name}" } ?: " | Not acquired"}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )

            if (skillGap.recommendedActions.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Recommended: ${skillGap.recommendedActions.first()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun GapSizeChip(gapSize: GapSize) {
    val (color, text) = when (gapSize) {
        GapSize.CRITICAL -> Color(0xFFF44336) to "Critical"
        GapSize.LARGE -> Color(0xFFFF9800) to "Large"
        GapSize.MEDIUM -> Color(0xFF2196F3) to "Medium"
        GapSize.SMALL -> Color(0xFF4CAF50) to "Small"
    }

    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = color,
        modifier = Modifier
            .background(
                color.copy(alpha = 0.1f),
                RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}

@Composable
fun MilestoneCard(
    milestone: CareerMilestone,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (milestone.isCompleted) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        )
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
                    text = milestone.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Row {
                    MilestonePriorityChip(priority = milestone.priority)

                    if (milestone.isCompleted) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Completed",
                            tint = Color.Green,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = milestone.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MilestoneCategoryChip(category = milestone.category)

                Text(
                    text = "Due: ${SimpleDateFormat("MMM dd", Locale.getDefault()).format(Date(milestone.targetDate))}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
fun MilestonePriorityChip(priority: MilestonePriority) {
    val (color, text) = when (priority) {
        MilestonePriority.CRITICAL -> Color(0xFFF44336) to "Critical"
        MilestonePriority.HIGH -> Color(0xFFFF9800) to "High"
        MilestonePriority.MEDIUM -> Color(0xFF2196F3) to "Medium"
        MilestonePriority.LOW -> Color(0xFF4CAF50) to "Low"
    }

    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = color,
        modifier = Modifier
            .background(
                color.copy(alpha = 0.1f),
                RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}

@Composable
fun MilestoneCategoryChip(category: MilestoneCategory) {
    val text = when (category) {
        MilestoneCategory.SKILL_DEVELOPMENT -> "Skill"
        MilestoneCategory.CERTIFICATION -> "Cert"
        MilestoneCategory.EXPERIENCE -> "Experience"
        MilestoneCategory.NETWORKING -> "Network"
        MilestoneCategory.EDUCATION -> "Education"
        MilestoneCategory.PROMOTION -> "Promotion"
    }

    AssistChip(
        onClick = { },
        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall
            )
        },
        modifier = Modifier.height(24.dp)
    )
}

// Utility Functions
private fun getInsightIcon(type: InsightType): ImageVector {
    return when (type) {
        InsightType.SKILL_GAP -> Icons.Default.TrendingDown
        InsightType.OPPORTUNITY -> Icons.Default.TrendingUp
        InsightType.WARNING -> Icons.Default.Warning
        InsightType.ACHIEVEMENT -> Icons.Default.EmojiEvents
        InsightType.MARKET_TREND -> Icons.Default.ShowChart
        InsightType.RECOMMENDATION -> Icons.Default.Lightbulb
    }
}