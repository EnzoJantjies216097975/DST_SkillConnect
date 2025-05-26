package com.dst511s.dst_skillconnect.core.data.models.profile

import android.os.Parcelable
import com.dst511s.dst_skillconnect.unsorted.data.JobPreferences
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
