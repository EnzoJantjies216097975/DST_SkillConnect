package com.dst511s.dst_skillconnect.unsorted.data

data class ProfileViewsData(
    val totalViews: Int,
    val viewsThisWeek: Int,
    val viewsLastWeek: Int,
    val dailyViews: List<DailyViewData>,
    val viewerTypes: Map<String, Int>, // Recruiters, Companies, etc.
    val topViewingSources: List<ViewSource>
)