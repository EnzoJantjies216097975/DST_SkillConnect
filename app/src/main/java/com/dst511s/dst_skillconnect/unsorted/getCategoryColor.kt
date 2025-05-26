package com.dst511s.dst_skillconnect.unsorted

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.dst511s.dst_skillconnect.unsorted.data.LearningPath
import com.dst511s.dst_skillconnect.unsorted.enume.LearningCategory
import com.dst511s.dst_skillconnect.unsorted.enume.LessonType

fun getCategoryColor(category: LearningCategory): androidx.compose.ui.graphics.Color {
    return when (category) {
        LearningCategory.PROGRAMMING -> Color(0xFF2196F3)
        LearningCategory.DESIGN -> Color(0xFF9C27B0)
        LearningCategory.DATA_SCIENCE -> Color(0xFF4CAF50)
        LearningCategory.MARKETING -> Color(0xFFFF9800)
        LearningCategory.BUSINESS -> Color(0xFF795548)
        LearningCategory.SOFT_SKILLS -> Color(0xFF607D8B)
        LearningCategory.CYBERSECURITY -> Color(0xFFF44336)
    }
}

fun getCategoryIcon(category: LearningCategory): ImageVector {
    return when (category) {
        LearningCategory.PROGRAMMING -> Icons.Default.Code
        LearningCategory.DESIGN -> Icons.Default.Palette
        LearningCategory.DATA_SCIENCE -> Icons.Default.Analytics
        LearningCategory.MARKETING -> Icons.Default.Campaign
        LearningCategory.BUSINESS -> Icons.Default.Business
        LearningCategory.SOFT_SKILLS -> Icons.Default.People
        LearningCategory.CYBERSECURITY -> Icons.Default.Security
    }
}

fun getLessonTypeIcon(type: LessonType): ImageVector {
    return when (type) {
        LessonType.VIDEO -> Icons.Default.PlayCircle
        LessonType.TEXT -> Icons.Default.Article
        LessonType.INTERACTIVE -> Icons.Default.TouchApp
        LessonType.QUIZ -> Icons.Default.Quiz
        LessonType.PROJECT -> Icons.Default.Assignment
        LessonType.ASSIGNMENT -> Icons.Default.Task
    }
}

fun filterLearningPaths(
    paths: List<LearningPath>,
    searchQuery: String,
    category: LearningCategory?
): List<LearningPath> {
    var filtered = paths

    if (searchQuery.isNotEmpty()) {
        filtered = filtered.filter { path ->
            path.title.contains(searchQuery, ignoreCase = true) ||
                    path.description.contains(searchQuery, ignoreCase = true) ||
                    path.targetRole.contains(searchQuery, ignoreCase = true) ||
                    path.skills.any { it.contains(searchQuery, ignoreCase = true) }
        }
    }

    if (category != null) {
        filtered = filtered.filter { it.category == category }
    }

    return filtered.sortedByDescending { it.rating }
}