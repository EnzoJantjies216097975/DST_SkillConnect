package com.dst511s.dst_skillconnect.unsorted.data

data class PortfolioAnalytics(
    val totalViews: Int,
    val uniqueVisitors: Int,
    val averageTimeOnSite: Int, // in seconds
    val topReferrers: List<ReferrerData>,
    val projectViews: Map<String, Int>,
    val skillsViewed: Map<String, Int>,
    val downloadCount: Int, // for resume downloads
    val contactFormSubmissions: Int
)