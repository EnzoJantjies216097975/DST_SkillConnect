package com.dst511s.dst_skillconnect.data.models

import androidx.compose.ui.graphics.vector.ImageVector

data class SearchSuggestion(
    val text: String,
    val type: SuggestionType,
    val icon: ImageVector
)

enum class SuggestionType {
    JOB_TITLE, COMPANY, SKILL, LOCATION
}