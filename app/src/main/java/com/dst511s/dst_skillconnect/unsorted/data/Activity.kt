package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.ActivityType

data class Activity(
    val title: String,
    val company: String,
    val time: String,
    val type: ActivityType,
    val status: String
)
