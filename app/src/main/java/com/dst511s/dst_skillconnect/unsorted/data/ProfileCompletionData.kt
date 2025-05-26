package com.dst511s.dst_skillconnect.unsorted.data

data class ProfileCompletionData(
    val overallCompletion: Int,
    val sectionCompletion: Map<String, Int>,
    val missingItems: List<String>,
    val impactScore: Int // How completion affects visibility
)