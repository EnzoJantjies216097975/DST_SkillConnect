package com.dst511s.dst_skillconnect.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JobApplication(
    val id: String = "",
    val jobId: String = "",
    val applicantId: String = "",
    val coverLetter: String = "",
    val highlightedSkills: List<String> = emptyList(),
    val highlightedProjects: List<String> = emptyList(),
    val customAnswers: Map<String, String> = emptyMap(),
    val status: ApplicationStatus = ApplicationStatus.SUBMITTED,
    val notes: List<ApplicationNote> = emptyList(),
    val submittedAt: Long = 0,
    val lastUpdated: Long = 0
) : Parcelable
