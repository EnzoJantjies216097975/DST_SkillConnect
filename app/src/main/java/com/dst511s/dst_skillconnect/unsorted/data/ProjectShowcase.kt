package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.ProjectCategory

data class ProjectShowcase(
    val id: String,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val category: ProjectCategory,
    val tags: List<String>,
    val technologiesUsed: List<String>,
    val images: List<ProjectImage>,
    val liveUrl: String?,
    val githubUrl: String?,
    val demoVideo: String?,
    val challenges: String?,
    val solutions: String?,
    val results: String?,
    val duration: String?,
    val teamSize: Int?,
    val myRole: String?,
    val featured: Boolean,
    val dateCompleted: Long,
    val likes: Int = 0,
    val views: Int = 0,
    val comments: List<ProjectComment> = emptyList()
)