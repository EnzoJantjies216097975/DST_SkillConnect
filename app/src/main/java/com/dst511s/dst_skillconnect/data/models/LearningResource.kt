package com.dst511s.dst_skillconnect.data.models

data class LearningResource(
    val title: String,
    val type: ResourceType,
    val provider: String,
    val url: String,
    val duration: String,
    val cost: String,
    val rating: Float
)