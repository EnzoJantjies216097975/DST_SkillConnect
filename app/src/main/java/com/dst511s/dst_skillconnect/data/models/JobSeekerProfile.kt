package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JobSeekerProfile(
    val userId: String = "",
    val title: String = "",
    val skills: List<Skill> = emptyList(),
    val education: List<Education> = emptyList(),
    val experience: List<Experience> = emptyList(),
    val projects: List<Project> = emptyList(),
    val certificates: List<Certificate> = emptyList(),
    val jobPreferences: JobPreferences = JobPreferences()
) : Parcelable
