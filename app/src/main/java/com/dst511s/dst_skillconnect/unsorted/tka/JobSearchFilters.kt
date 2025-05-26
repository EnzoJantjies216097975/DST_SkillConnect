package com.dst511s.dst_skillconnect.unsorted.tka

import com.dst511s.dst_skillconnect.core.data.models.job.EmploymentType
import com.dst511s.dst_skillconnect.unsorted.enume.RemotePreference

data class JobSearchFilters(
    val query: String = "",
    val location: String = "",
    val jobTypes: List<EmploymentType> = emptyList(),
    val salaryMin: Double? = null,
    val salaryMax: Double? = null,
    val experience: ExperienceLevel? = null,
    val skills: List<String> = emptyList(),
    val companies: List<String> = emptyList(),
    val datePosted: DatePosted = DatePosted.ANY_TIME,
    val remoteType: RemotePreference = RemotePreference.NO_PREFERENCE,
    val sortBy: SortBy = SortBy.RELEVANCE
)

enum class ExperienceLevel {
    ENTRY_LEVEL, MID_LEVEL, SENIOR_LEVEL, EXECUTIVE
}

enum class DatePosted {
    ANY_TIME, PAST_24_HOURS, PAST_WEEK, PAST_MONTH
}

enum class SortBy {
    RELEVANCE, DATE_POSTED, SALARY_HIGH_TO_LOW, SALARY_LOW_TO_HIGH, COMPANY_NAME
}