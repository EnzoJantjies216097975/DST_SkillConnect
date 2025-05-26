package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.ApplicationStatus

data class JobApplicationAnalytics(
    val totalApplications: Int,
    val applicationsThisMonth: Int,
    val responseRate: Float,
    val interviewRate: Float,
    val offerRate: Float,
    val applicationsByStatus: Map<ApplicationStatus, Int>,
    val averageResponseTime: Int, // in days
    val topAppliedIndustries: List<IndustryData>,
    val applicationTrend: List<MonthlyApplicationData>
)